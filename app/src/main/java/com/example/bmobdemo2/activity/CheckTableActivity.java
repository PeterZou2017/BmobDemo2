package com.example.bmobdemo2.activity;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bmobdemo2.LoginActivity;
import com.example.bmobdemo2.R;
import com.example.bmobdemo2.entity.CheckTable;
import com.example.bmobdemo2.entity.Table;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.listener.FindListener;

public class CheckTableActivity extends Activity {

    // 显示餐桌状态的GridView
    private GridView gv;
    // 餐桌数量
   // private int count;
    // 保存餐桌信息的列表
    public static List list = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check_table);
       // Bmob.initialize(this, "1fdbebaf8a3b65ce6623ce7a52f29a5e");

        // 实例化
        gv = (GridView) findViewById(R.id.check_table_gridview);

        //ArrayList list = new ArrayList();

        new GetTableThread().start();

         // getTableList();

            // 为GridView绑定数据
            gv.setAdapter(new ImageAdapter(this));

    }

    /*
    // 获得餐桌信息列表，信息包括桌号和状态
    private void getTableList() {

     //   list.clear();
       //  final List arrayList=new ArrayList();
        //list=null;




       //return arrayList;

        //访问网络必须放在子线程中
       // new GetTableThread().start();


    }

*/
    //访问checktableservlet子线程
    public class GetTableThread extends Thread {

        public void run() {


          BmobQuery<Table> bmobQuery=new BmobQuery<Table>();
        bmobQuery.addQueryKeys("num,flag");
        bmobQuery.findObjects(CheckTableActivity.this, new FindListener<Table>() {


            //arrayList=null;

            @Override
            public void onSuccess(List<Table> list1) {

                //Table table=new Table();

                Toast.makeText(CheckTableActivity.this,"成功",Toast.LENGTH_SHORT).show();

                for(Table table:list1){

                    int num=table.getNum();
                    int flag=table.getFlag();

                  //  Log.i("1111","num="+num);
                   // Log.i("1111","flag="+flag);

                    CheckTable ct = new CheckTable();
                    ct.setFlag(flag);
                    ct.setNum(num);
                    list.add(ct);

                    Log.i("1111","list"+ct.getNum());
                    Log.i("1111","list"+ct.getFlag());

                   // Toast.makeText(CheckTableActivity.this,"成功2",Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onError(int i, String s) {

                Log.i("11111","查询失败"+s);

            }
        });






        }
    }

    static class ViewHolder
    {
        public ImageView imageView;
        public TextView tv;
       // public TextView info;
    }


    // 继承BaseAdapter
    public class ImageAdapter extends BaseAdapter {
        // 上下文
        private Context mContext;
       // private List list;

        // 构造方法
        public ImageAdapter(Context c) {
            mContext = c;
            //this.list=list;
        }

        // 组件个数
        public int getCount() {
            return list.size();
        }

        // 当前组件
        public Object getItem(int position) {
            return null;
        }

        // 当前组件id
        public long getItemId(int position) {
            return 0;
        }

        // 获得当前视图
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder holder=null;
            // 声明图片视图
            LayoutInflater inflater =
                    LayoutInflater.from(CheckTableActivity.this);
           // View v = null;
            ImageView imageView = null;
            TextView tv = null;
            if (convertView == null) {
                // 实例化图片视图
                holder=new ViewHolder();
                convertView= inflater.inflate(R.layout.check_table_view, null);
                // 设置图片视图属性
                convertView.setPadding(8, 8, 8, 8);
                // 获得ImageView对象
                holder.imageView = (ImageView) convertView.findViewById(R.id.check_table_ImageView01);
                // 获得TextView对象
                holder.tv = (TextView) convertView.findViewById(R.id.check_tableTextView01);
                convertView.setTag(holder);
            }else {

                holder = (ViewHolder) convertView.getTag();
               // v=(View)convertView;
            }

            // 获得ImageView对象
         //   holder.imageView = (ImageView) v.findViewById(R.id.check_table_ImageView01);
            // 获得TextView对象
          //  holder.tv = (TextView) v.findViewById(R.id.check_tableTextView01);

            // 获得CheckTable对象
            CheckTable ct = (CheckTable) list.get(position);

            System.out.println("ct num="+ct.getNum()+",ct flag="+ct.getFlag());
            Log.i("888888", "list size=" +list.size());
           // Log.i("888888", "num=" + ct.getNum());
           // Log.i("999999", "flag=" + ct.getFlag());
            if (ct.getFlag() == 1) {
                // 设置ImageView图片为 有人
               holder.imageView.setImageResource(R.drawable.youren);
            } else {
                // 设置ImageView图片为 空位
                holder.imageView.setImageResource(R.drawable.kongwei);
            }
            // 为TextView设置桌号
            holder.tv.setText("有" + ct.getNum()+ "人就餐");


            return convertView;
        }
    }
}
