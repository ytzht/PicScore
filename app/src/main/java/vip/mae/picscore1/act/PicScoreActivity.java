package vip.mae.picscore1.act;

import android.content.Context;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;

import com.flyco.tablayout.SlidingTabLayout;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import vip.mae.picscore1.R;
import vip.mae.picscore1.entity.AllPicByLandId;
import vip.mae.picscore1.fragment.SimpleSelectFragment;
import vip.mae.picscore1.global.Apis;
import vip.mae.picscore1.global.BaseActivity;
import vip.mae.picscore1.utils.BaseEvent;

public class PicScoreActivity extends BaseActivity implements OnTabSelectListener {

    private static final String TAG = "=====PicScore=====";
    private ViewDataBinding binding;
    private ArrayList<Fragment> mFragments = new ArrayList<>();
    private List<AllPicByLandId.DataBean> data;
    private MyPagerAdapter mAdapter;
    private int total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pic_score);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_pic_score);
        total = Integer.parseInt(getIntent().getStringExtra("total"));
        EventBus.getDefault().register(this);
        OkGo.<String>get(Apis.getAllPicByLandId).params("landId", getIntent().getStringExtra("id")).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                AllPicByLandId landId = (new Gson()).fromJson(response.body(), AllPicByLandId.class);
                if (landId.getCode() == 0) {

                    data = landId.getData();
                    initView();
                } else {
                    showShort(landId.getMsg());
                }
            }
        });


    }

    ViewPager vp;

    private void initView() {
        for (int i = 0; i < data.size(); i++) {
            mFragments.add(SimpleSelectFragment.getInstance(data.get(i), getIntent().getStringExtra("id"), i, total));
        }


        vp = findViewById(R.id.discover_vp);
        mAdapter = new MyPagerAdapter(getSupportFragmentManager());
        vp.setAdapter(mAdapter);
        vp.setOffscreenPageLimit(1);
        SlidingTabLayout tl_discover = findViewById(R.id.tl_discover);
        tl_discover.setViewPager(vp);
        tl_discover.setOnTabSelectListener(this);

        SharedPreferences memberPrefs = getSharedPreferences(
                "_ID_", Context.MODE_PRIVATE);
        int anInt = memberPrefs.getInt("id"+getIntent().getStringExtra("id"), 0);
        vp.setCurrentItem(anInt);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onEventMainThread(BaseEvent event) {
        super.onEventMainThread(event);
        Log.d(TAG, "onEventMainThread: ");
        vp.setCurrentItem(vp.getCurrentItem() + 1);
    }

    @Override
    public void onTabSelect(int position) {

    }

    @Override
    public void onTabReselect(int position) {

    }

    private class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return (position + 1) + "";
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }
    }

}
