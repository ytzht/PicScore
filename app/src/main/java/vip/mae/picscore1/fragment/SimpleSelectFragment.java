package vip.mae.picscore1.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;

import com.alexvasilkov.gestures.views.GestureImageView;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import org.greenrobot.eventbus.EventBus;

import vip.mae.baseutil.BaseEvent;
import vip.mae.picscore1.R;
import vip.mae.picscore1.entity.AllPicByLandId;
import vip.mae.picscore1.entity.PicFraction;
import vip.mae.picscore1.entity.ResultData;
import vip.mae.picscore1.global.Apis;
import vip.mae.picscore1.global.BaseFragment;

public class SimpleSelectFragment extends BaseFragment {

    private static final String TAG = "=====SSFragment=====";
    private AllPicByLandId.DataBean bean;
    private GestureImageView iv_pic;
    private View view;
    private LinearLayout ll_rb;
    private int a = 0, b = 1, c = 0;
    private Button btn_submit;
    private int position;
    private String id;
    private int total;
    private TextView tv_current;


    private RadioButton rb_1, rb_2, rb_3, rb_4, rb_5, rb_6;

    public static SimpleSelectFragment getInstance(AllPicByLandId.DataBean bean, String id, int position, int total) {
        SimpleSelectFragment sf = new SimpleSelectFragment();
        sf.bean = bean;
        sf.id = id;
        sf.total = total;
        sf.position = position;
        return sf;

    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser){
            OkGo.<String>get(Apis.getPicFraction).params("picId", bean.getPicId())
                    .execute(new StringCallback() {
                        @Override
                        public void onSuccess(Response<String> response) {
                            Log.d(TAG, "onSuccess: "+response.body());
                            ll_rb.setVisibility(View.VISIBLE);
                            PicFraction data = (new Gson()).fromJson(response.body(), PicFraction.class);
                            if (data.getCode() == 0){
                                if (!data.getMsg().equals("未评分")){

                                    if (data.getData().getOption_a_point() == 0){
                                        rb_1.setChecked(false);
                                        rb_2.setChecked(true);
                                        Log.d(TAG, "onSuccess: a1");
                                    }else {
                                        rb_1.setChecked(true);
                                        rb_2.setChecked(false);
                                        Log.d(TAG, "onSuccess: a2");
                                    }

                                    if (data.getData().getOption_b_point() == 1){
                                        rb_3.setChecked(false);
                                        rb_4.setChecked(true);
                                    }else {
                                        rb_3.setChecked(true);
                                        rb_4.setChecked(false);
                                    }

                                    if (data.getData().getOption_c_point() == 0){
                                        rb_5.setChecked(false);
                                        rb_6.setChecked(true);
                                    }else {
                                        rb_5.setChecked(true);
                                        rb_6.setChecked(false);
                                    }

                                    btn_submit.setEnabled(false);

                                    rb_1.setEnabled(false);
                                    rb_2.setEnabled(false);
                                    rb_3.setEnabled(false);
                                    rb_4.setEnabled(false);
                                    rb_5.setEnabled(false);
                                    rb_6.setEnabled(false);
                                }
                            }

                            SharedPreferences memberPrefs = getActivity().getApplication().getSharedPreferences(
                                    "_ID_", Context.MODE_PRIVATE);
                            memberPrefs.edit().putInt("id"+id, position).apply();
                        }
                    });







        }
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_select, null);
        initView();

        return view;
    }

    private void initView() {

        btn_submit = view.findViewById(R.id.btn_submit);
        ll_rb = view.findViewById(R.id.ll_rb);
        ll_rb.setVisibility(View.GONE);
        iv_pic = view.findViewById(R.id.iv_pic);
        tv_current = view.findViewById(R.id.tv_current);
        rb_1 = view.findViewById(R.id.rb_1);
        rb_2 = view.findViewById(R.id.rb_2);
        rb_3 = view.findViewById(R.id.rb_3);
        rb_4 = view.findViewById(R.id.rb_4);
        rb_5 = view.findViewById(R.id.rb_5);
        rb_6 = view.findViewById(R.id.rb_6);

        Log.d(TAG, "initView: " + bean.getUrl());
        Glide.with(getActivity()).load(bean.getUrl()).into(iv_pic);
        iv_pic.getController().getSettings()
                .setMaxZoom(6f)
                .setDoubleTapZoom(2f);


        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rb_1.isChecked()) {
                    a = 2;
                }
                if (rb_3.isChecked()) {
                    b = 0;
                }
                if (rb_5.isChecked()) {
                    c = 2;
                }
                goSubmit();
            }
        });

        tv_current.setText((position + 1) + "/" + total);
    }

    private void goSubmit() {


        if(!rb_1.isChecked() && !rb_2.isChecked()){
            showShort("请回答第一题");
            return;
        }

        if(!rb_3.isChecked() && !rb_4.isChecked()){
            showShort("请回答第二题");
            return;
        }

        if(!rb_5.isChecked() && !rb_6.isChecked()){
            showShort("请回答第三题");
            return;
        }

        OkGo.<String>get(Apis.submitFraction).params("picId", bean.getPicId())
                .params("a", a)
                .params("b", b)
                .params("c", c)
                .execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                ResultData data = (new Gson()).fromJson(response.body(), ResultData.class);


                if (data.getCode() == 0){
                    btn_submit.setEnabled(false);
                    EventBus.getDefault().post(BaseEvent.event(BaseEvent.PAGE_MAX_COUNT));

                    rb_1.setEnabled(false);
                    rb_2.setEnabled(false);
                    rb_3.setEnabled(false);
                    rb_4.setEnabled(false);
                    rb_5.setEnabled(false);
                    rb_6.setEnabled(false);

                }else {
                    showShort(data.getMsg());
                }
            }
        });
    }

}
