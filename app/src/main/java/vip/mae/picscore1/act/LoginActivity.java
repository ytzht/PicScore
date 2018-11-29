package vip.mae.picscore1.act;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import vip.mae.picscore1.R;
import vip.mae.picscore1.app.MyApplication;
import vip.mae.picscore1.databinding.ActivityLoginBinding;
import vip.mae.picscore1.entity.LoginBean;
import vip.mae.picscore1.global.Apis;
import vip.mae.picscore1.global.BaseActivity;
import vip.mae.picscore1.vm.LoginViewModel;

public class LoginActivity extends BaseActivity {

    private static final String TAG = "=====Login=====";
    private LoginViewModel viewModel;
    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        viewModel = new LoginViewModel(service.getUserName(), service.getPassword());
        binding.setViewModel(viewModel);
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

    }


    private void login() {

        if (TextUtils.isEmpty(binding.userName.getText().toString())) {
            showShort("请输入账号！");
            return;
        }

        if (TextUtils.isEmpty(binding.etPassword.getText().toString())) {
            showShort("请输入密码！");
            return;
        }

        service.setUserName(binding.userName.getText().toString());
        service.setPassword(binding.etPassword.getText().toString());
        service.setUserId(-1);
        service.setToken("-1");
        MyApplication.initOkGo(MyApplication.instance());

        OkGo.<String>get(Apis.Login).params("account", binding.userName.getText().toString())
                .params("pwd", binding.etPassword.getText().toString())
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Log.d(TAG, "onSuccess: " + response.body());

                        LoginBean bean = (new Gson()).fromJson(response.body(), LoginBean.class);
                        if (bean.getCode() == 0) {


                            service.setToken(bean.getData().getToken());
                            service.setUserId(bean.getData().getUser_id());
                            service.setUserGroup(bean.getData().getGroup());
                            service.setUserGroupName(bean.getData().getName());
                            MyApplication.initOkGo(MyApplication.instance());
                            startActivity(MainActivity.class);
                            finish();
                        } else {
                            showShort(bean.getMsg());
                        }


                    }
                });


    }

}
