package com.example.bmobdemo2.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.bmobdemo2.LoginActivity;
import com.example.bmobdemo2.R;

public class MainMenuActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));
    }

    // 继承BaseAdapter
    public class ImageAdapter extends BaseAdapter {
        // 上下文
        private Context mContext;

        // 构造方法
        public ImageAdapter(Context c) {
            mContext = c;
        }

        // 组件个数
        public int getCount() {
            return mThumbIds.length;
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
            // 声明图片视图
            ImageView imageView;
            if (convertView == null) {
                // 实例化图片视图
                imageView = new ImageView(mContext);
                // 设置图片视图属性
                imageView.setLayoutParams(new GridView.LayoutParams(300, 300));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setPadding(8, 8, 8, 8);
            } else {
                imageView = (ImageView) convertView;
            }
            // 设置图片视图图片资源
            imageView.setImageResource(mThumbIds[position]);
            // 为当前视图添加监听器
            switch (position) {
                case 0:
                    // 添加点餐监听器
                   imageView.setOnClickListener(orderLinstener);
                    break;
                case 1:
                    // 并台监听器
                    imageView.setOnClickListener(unionTableLinstener);
                    break;
                case 2:
                    // 添加转台监听器
                    imageView.setOnClickListener(changeTableLinstener);
                    break;
                case 3:
                    // 添加查台监听器
                    imageView.setOnClickListener(checkTableLinstener);
                    break;
                case 4:
                    // 添加更新监听器
                   // imageView.setOnClickListener(updateLinstener);
                    break;
                case 5:
                    //添加设置监听器
                    //////////////////////////////////////////////////////??
                    break;
                case 6:
                    // 添加注销监听器
                    imageView.setOnClickListener(exitLinstener);
                    break;
                case 7:
                    // 添加结算监听器
                    imageView.setOnClickListener(payLinstener);
                    break;

                default:
                    break;
            }

            return imageView;
        }

        // 图片资源数组
        private Integer[] mThumbIds = {
                R.drawable.diancai, R.drawable.bingtai,
                R.drawable.zhuantai, R.drawable.chatai,
                R.drawable.gengxin, R.drawable.shezhi,
                R.drawable.zhuxiao, R.drawable.jietai
        };
    }

    // 更新监听器
  /*  View.OnClickListener updateLinstener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            // 启动更新Activity
            intent.setClass(MainMenuActivity.this, UpdateActivity.class);
            startActivity(intent);
        }
    };*/

    // 查台监听器
    View.OnClickListener checkTableLinstener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            try {

               // CheckTableActivity.list.clear();
                Intent intent = new Intent();
                // 启动查台Activity
                intent.setClass(MainMenuActivity.this, CheckTableActivity.class);
                startActivity(intent);

                Toast.makeText(MainMenuActivity.this, "进入查台", Toast.LENGTH_SHORT).show();

            }catch (Exception e){
                e.printStackTrace();
                Log.i("1111111","to cehcktable activity fail"+e.getMessage());
            }
        }
    };

    // 结算监听器
    View.OnClickListener payLinstener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            // 启动结算Activity
            intent.setClass(MainMenuActivity.this, PayActivity.class);
            startActivity(intent);
        }
    };

    // 订餐监听器
    View.OnClickListener orderLinstener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            // 启动订餐Activity
            intent.setClass(MainMenuActivity.this, OrderActivity.class);
            startActivity(intent);
        }
    };
    // 注销监听器
    View.OnClickListener exitLinstener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            logout();
        }
    };

    // 转台监听器
    View.OnClickListener changeTableLinstener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            changeTable();
        }
    };

    // 并台监听器
    View.OnClickListener unionTableLinstener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            unionTable();
        }
    };

    //换桌
    private void changeTable(){


    }

    //并桌
    private void unionTable(){


    }


    // 退出系统
    private void logout(){

        finish();
    }

}
