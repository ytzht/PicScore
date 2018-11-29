package vip.mae.picscore1.global;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Toast;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import vip.mae.baseutil.BaseEvent;
import vip.mae.baseutil.UserService;

/**
 * Created by zht on 2017/04/07 9:04
 */

public class BaseActivity extends AppCompatActivity {

    public UserService service;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        service = UserService.service(getBaseContext());

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(BaseEvent event) {

    }

    private Toast mToast = null;

    public void showShort(final String msg) {
        if (!TextUtils.isEmpty(msg)) {

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (mToast == null) {
                        mToast = Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT);
                    } else {
                        mToast.setText(msg);
                    }
                    mToast.show();
                }
            });
        }
    }

    public void cancelToast(){
        if (mToast != null){
            mToast.cancel();
        }
    }

    public void startActivity(Class<? extends Activity> clazz) {
        Intent intent = new Intent();
        intent.setClass(this, clazz);
        startActivity(intent);
    }


    public void startActivity(Class<? extends Activity> clazz, String... data) {
        if (data.length % 2 == 1) {
            return;
        }
        Intent intent = new Intent();
        intent.setClass(this, clazz);
        for (int i = 0; i < data.length / 2; i++) {
            intent.putExtra(data[i * 2], data[i * 2 + 1]);
        }
        startActivity(intent);
    }
}
