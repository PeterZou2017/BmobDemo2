package com.example.bmobdemo2.activity;

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.bmobdemo2.R;
import com.example.bmobdemo2.entity.Menu;
import com.example.bmobdemo2.entity.MenuType;
import com.example.bmobdemo2.entity.Order;
import com.example.bmobdemo2.entity.OrderDetail;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.GetListener;

public class PayActivity extends Activity {

    // 显示点餐信息WebView
    private WebView wv;
    // 查询点餐信息按钮和结算按钮
    private Button queryBtn,querydetailBtn,payBtn;
    // 订单编号
    private EditText orderIdEt;

    private Handler handler;

    private List<HashMap<String,Object>> mHashmaps;

    private HashMap<String,Object>map;

    private ArrayAdapter arrayAdapter;
    private ListView mlistview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pay);

        // wv = (WebView)findViewById(R.id.pay_webview);

        mlistview = (ListView) findViewById(R.id.listview);
        // 实例化查询按钮
        queryBtn = (Button) findViewById(R.id.pay_query_Button01);
        querydetailBtn=(Button)findViewById(R.id.pay_query_Button02);
        // 实例化结算按钮
        payBtn = (Button) findViewById(R.id.pay_Button01);
        // 实例化订单编号编辑框
        orderIdEt = (EditText) findViewById(R.id.pay_order_number_EditText01);

        // 添加查询点餐信息监听器
        queryBtn.setOnClickListener(queryListener);
      //  querydetailBtn.setOnClickListener(querydetailListener);
        // 添加结算信息监听器
      //  payBtn.setOnClickListener(payListener);

        mHashmaps = new ArrayList<HashMap<String, Object>>();
        map = new HashMap<String, Object>();


        handler = new Handler() {
            public void handleMessage(Message msg) {

                switch (msg.what) {
                    case 0: {
                        Order order = new Order();
                        order = (Order) msg.obj;
                        Toast.makeText(PayActivity.this, "11" + order.getObjectId() + order.getTableName() + order.getUser(), Toast.LENGTH_SHORT).show();

                        Log.i("11111", "11" + order.getObjectId() + "   " + order.getUser().getObjectId() + "   " + order.getTable().getObjectId() + "   " + order.getIsPay());

                        SimpleAdapter simpleAdapter = new SimpleAdapter(PayActivity.this, getdata(order), R.layout.orderlist, new String[]{"orderId", "user", "tablenum", "personNum", "isPay"},
                                new int[]{R.id.orderid, R.id.user, R.id.tablenum, R.id.personnum, R.id.ispay});
                        //getdata(order);

                        mlistview.setAdapter(simpleAdapter);
                        break;
                    }
                    case 1: {
                        List<OrderDetail> list = (List<OrderDetail>) msg.obj;
                        Log.i("22222", "22444" + list.size());
                        for (OrderDetail detail : list) {
                            String menuId = detail.getMenu().getObjectId();
                            int num = detail.getNum();
                            // String name= MENU.class.getName();
                            Log.i("22222", "22" + num);
                            // int price=getprice(menuId);

                        }
                        break;
                    }
                    default:
                        break;

                        }



                }

            };

    }

    /*

    private class MENU{

        private Integer price;
        private String name;
        private String pic;
        private String remark;

        public String getName(String menuId) {
            BmobQuery<Menu> querymenu = new BmobQuery<Menu>();
            querymenu.getObject(PayActivity.this, menuId, new GetListener<Menu>() {
                @Override
                public void onSuccess(Menu menu) {

                    String name=menu.getName();

                }

                @Override
                public void onFailure(int i, String s) {

                }
            });
            return name;
        }


    }

    */




    private List<HashMap<String,Object>> getdata(Order order) {

        String orderId = order.getObjectId();
        String user = order.getUser().getObjectId();
        String tablenum = order.getTable().getObjectId();
        int personNum = order.getPersonNum();
        Boolean isPay = order.getIsPay();

        // mHashmaps=new ArrayList<HashMap<String, Object>>();
        // map=new HashMap<String, Object>();
        map.put("orderId", orderId);
        map.put("user", user);
        map.put("tablenum", tablenum);
        map.put("personNum", personNum);
        map.put("isPay", isPay);
        mHashmaps.add(map);

        return mHashmaps;

    }



    // 查询点餐信息监听器
    View.OnClickListener queryListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {


            // 获得订单编号
            String orderId = orderIdEt.getText().toString();


            BmobQuery<OrderDetail> queryordertail = new BmobQuery<OrderDetail>();
            queryordertail.addWhereEqualTo("remark", "辣的");
            queryordertail.findObjects(PayActivity.this, new FindListener<OrderDetail>() {
                @Override
                public void onSuccess(List<OrderDetail> list) {

                    Toast.makeText(PayActivity.this, "查询2成功"+list.size(), Toast.LENGTH_SHORT).show();

                    Log.i("444","444="+list.size());

                   // Message msg=Message.obtain();
                   // msg.what=1;
                   // msg.obj=(OrderDetail)list;

                  //  handler.sendMessage(msg);

                }

                @Override
                public void onError(int i, String s) {

                }
            });


/*

            BmobQuery<Order> queryorder = new BmobQuery<Order>();
            queryorder.getObject(PayActivity.this, orderId, new GetListener<Order>() {
                @Override
                public void onSuccess(Order order) {

                    Toast.makeText(PayActivity.this, "查询成功"+order.getPersonNum(), Toast.LENGTH_SHORT).show();

                    Message msg=Message.obtain();
                    msg.what=0;
                    msg.obj=order;

                    handler.sendMessage(msg);

/*

                    try {

                       // ArrayList list = new ArrayList();

                      //  String user = order.getUser().getUsername();
                        int tablenum = order.getTable().getNum();
                        String tableId=order.getTable().getObjectId();
                        int personNum = order.getPersonNum();
                        Boolean isPay = order.getIsPay();

                      //  String[] str=new String[]{"用户名:"+user,"桌号:"+tableId,"人数:"+personNum,"是否支付"+isPay};
                        Log.i("222","str="+personNum+isPay+tableId+tablenum);
                    }catch (Exception e){
                        e.printStackTrace();
                        Log.i("11111","query order fail="+e.getMessage());
                    }
                       // Log.i("333","str="+);

                       // Log.i("1111", "user=" + user);

                       // list.add(user);
                       // list.add(tablenum);


                      //  ArrayAdapter<String> arrayAdapter = new ArrayAdapter(PayActivity.this, android.R.layout.simple_list_item_1,str);

                       // mlistview.setAdapter(arrayAdapter);


                }


                    @Override
                    public void onFailure ( int i, String s){

                        Log.i("1111", "queryorder fail=" + s);

                    }

            });



*/

              /*  BmobQuery<OrderDetail> queryordertail = new BmobQuery<OrderDetail>();
                queryordertail.addWhereEqualTo("num", "2");
                queryordertail.findObjects(PayActivity.this, new FindListener<OrderDetail>() {


                    @Override
                    public void onSuccess(List<OrderDetail> list) {

                        Toast.makeText(PayActivity.this, "查询成功2", Toast.LENGTH_SHORT).show();
                       /* int menutotal = 0;
                        for (OrderDetail orderDetail : list) {

                            String menuname = orderDetail.getMenu().getName();
                            int price = orderDetail.getMenu().getPrice();
                            int num = orderDetail.getNum();
                            int total = price * num;
                            menutotal += total;


                            map.put("菜名", menuname);
                            map.put("价格", price);
                            map.put("数量", num);
                            map.put("总价", total);

                            mHashmaps.add(map);

                        }
                    }

                    @Override
                    public void onError(int i, String s) {

                    }
                });   */



            }
        };

/*
    View.OnClickListener querydetailListener=new View.OnClickListener(){

        @Override
        public void onClick(View v) {

            // 获得订单编号
            String orderId = orderIdEt.getText().toString();

            BmobQuery<OrderDetail> queryordertail = new BmobQuery<OrderDetail>();
            queryordertail.addWhereEqualTo("orderId", "ZR25OOOY");
            queryordertail.findObjects(PayActivity.this, new FindListener<OrderDetail>() {
                @Override
                public void onSuccess(List<OrderDetail> list) {

                    Toast.makeText(PayActivity.this, "查询2成功"+list.size(), Toast.LENGTH_SHORT).show();

                    Log.i("444","444="+list.size());

                    Message msg=Message.obtain();
                    msg.what=1;
                    msg.obj=(OrderDetail)list;

                    handler.sendMessage(msg);

                }

                @Override
                public void onError(int i, String s) {

                }
            });

        }
    };

    */


    // 结算监听器
    View.OnClickListener payListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {




            // 使结算按钮失效
            payBtn.setEnabled(false);
        }
    };
}



