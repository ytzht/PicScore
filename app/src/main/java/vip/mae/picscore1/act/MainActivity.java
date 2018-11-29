package vip.mae.picscore1.act;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;

import vip.mae.picscore1.R;
import vip.mae.picscore1.databinding.ActivityMainBinding;
import vip.mae.picscore1.global.BaseActivity;

public class MainActivity extends BaseActivity {


    private static final String TAG = "=====Main=====";
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);


        binding.tvGroup.setText("组名：" + service.getUserGroup());
        binding.tvName.setText( "用户名：" + service.getUserGroupName());
        if (service.getToken().equals("-1")){
            startActivity(LoginActivity.class);
            finish();
        }


        binding.tvOutLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                service.setToken("-1");
                service.setUserId(-1);
                startActivity(LoginActivity.class);
                finish();
            }
        });



        binding.tvScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(AllLandActivity.class);
            }
        });



    }
}
