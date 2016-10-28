package com.yuanchuangli.weshare;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.yuanchuangli.weshare.util.ToastUtils;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

import static com.yuanchuangli.weshare.R.id.edt_psw;

public class LoginActivity extends AppCompatActivity {
    private EditText edt_account;
    private EditText edt_password;
    private String account;
    private String password;
    Context context = getApplicationContext();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Init();
    }

    private void Init() {
        ViewBy();
    }

    public void ViewBy() {
        edt_account = (EditText) findViewById(R.id.edt_account);
        edt_password = (EditText) findViewById(edt_psw);
        ImageView qq = (ImageView) findViewById(R.id.ic_qq);
        ImageView sina = (ImageView) findViewById(R.id.ic_xinlang);
        ImageView weChat = (ImageView) findViewById(R.id.ic_weixin);
        ImageView more = (ImageView) findViewById(R.id.ic_more);
    }

    /**
     * 登录的点击事件
     *
     * @param source
     */
    public void login(View source) {

        account = edt_account.getText().toString().trim();
        password = edt_password.getText().toString().trim();
        BmobUser p = new BmobUser();
        p.setUsername(account);
        p.setPassword(password);
        p.login(new SaveListener<BmobUser>() {
            @Override
            public void done(BmobUser bmobUser, BmobException e) {
                if (e == null) {
                    ToastUtils.showToast(context, e.getMessage());
                    Toast.makeText(LoginActivity.this, "验证成功", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, "验证失败" + e.getMessage(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(intent);
                }
            }
        });

    }


}
