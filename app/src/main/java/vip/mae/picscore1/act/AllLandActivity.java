package vip.mae.picscore1.act;

import android.support.annotation.NonNull;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.ArrayList;
import java.util.List;

import vip.mae.picscore1.R;
import vip.mae.picscore1.entity.AllLand;
import vip.mae.picscore1.global.Apis;
import vip.mae.picscore1.global.BaseActivity;

public class AllLandActivity extends BaseActivity {

    private RecyclerView rlv;
    private List<AllLand.DataBean> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_land);

        rlv = findViewById(R.id.rlv);
        rlv.setLayoutManager(new LinearLayoutManager(this));
        OkGo.<String>get(Apis.getAllLand).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                AllLand allLand = (new Gson()).fromJson(response.body(), AllLand.class);
                if (allLand.getCode() == 0){

                    data = allLand.getData();

                    rlv.setAdapter(new AllLandAdpter());

                }else {
                    showShort(allLand.getMsg());
                }

            }
        });



    }

    private class AllLandAdpter extends RecyclerView.Adapter<AllLandAdpter.ViewHolder> {

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new ViewHolder(LayoutInflater.from(getBaseContext()).inflate(R.layout.cell_list, viewGroup, false));
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {

            viewHolder.tv_name.setText(data.get(i).getName());
            viewHolder.ll_name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(PicScoreActivity.class, "id", data.get(i).getId()+"", "total", data.get(i).getCount()+"");
                }
            });
            if (data.get(i).getCount() == data.get(i).getYipingjia()){
                viewHolder.tv_process.setText("已完成评价");
            }else {
                viewHolder.tv_process.setText("已评价("+data.get(i).getYipingjia() +"/" + data.get(i).getCount() +")");
            }
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder{

            private TextView tv_name;
            private LinearLayout ll_name;
            private TextView tv_process;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                tv_name = itemView.findViewById(R.id.tv_name);
                ll_name = itemView.findViewById(R.id.ll_name);
                tv_process = itemView.findViewById(R.id.tv_process);

            }
        }
    }
}
