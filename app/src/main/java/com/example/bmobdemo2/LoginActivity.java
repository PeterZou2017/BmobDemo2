package com.example.bmobdemo2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.listener.SaveListener;

public class LoginActivity extends Activity {

    // 声明登录、取消按钮
    private Button cancelBtn,loginBtn,signBtn;
    // 声明用户名、密码输入框
    private EditText userEditText,pwdEditText;
   // private MyUser user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_system);

        Bmob.initialize(this, "1fdbebaf8a3b65ce6623ce7a52f29a5e");

        // 通过findViewById方法实例化组件
        cancelBtn = (Button)findViewById(R.id.cancelButton);
        // 通过findViewById方法实例化组件
        loginBtn = (Button)findViewById(R.id.loginButton);

        signBtn=(Button)findViewById(R.id.signup);
        // 通过findViewById方法实例化组件
        userEditText = (EditText)findViewById(R.id.userEditText);
        // 通过findViewById方法实例化组件
        pwdEditText = (EditText)findViewById(R.id.pwdEditText);

        signBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyUser user=new MyUser();

               String user1= userEditText.getText().toString();
                String pwd=pwdEditText.getText().toString();

                if((user1!=null)&&(pwd!=null)){

                    user.setUsername(user1);
                    user.setPassword(pwd);

                user.signUp(LoginActivity.this, new SaveListener() {
                    @Override
                    public void onSuccess() {

                        Toast.makeText(LoginActivity.this,"注册成功",Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onFailure(int i, String s) {

                        Toast.makeText(LoginActivity.this,"注册失败"+s,Toast.LENGTH_SHORT).show();

                    }
                });
                }else {
                    Toast.makeText(LoginActivity.this, "用户名或者密码为空，请重新输入", Toast.LENGTH_SHORT).show();
                }
            }
        });






        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MyUser user=new MyUser();
                user.setUsername(userEditText.getText().toString());
                user.setPassword(pwdEditText.getText().toString());


                    user.login(LoginActivity.this, new SaveListener() {


                        @Override
                        public void onSuccess() {

                            Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(LoginActivity.this,MainMenuActivity.class);
                            startActivity(intent);

                        }

                        @Override
                        public void onFailure(int i, String s) {

                            Toast.makeText(LoginActivity.this, "登录失败" + s, Toast.LENGTH_SHORT).show();

                        }
                    });



            }
        });





    }

}
