package com.example.admin.testcollzip;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;
    private CollapsingToolbarLayout cl;
    RecyclerView toprv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cl = ((CollapsingToolbarLayout) findViewById(R.id.cl));
        toprv= (RecyclerView) findViewById(R.id.toprv);
        cl.setTitle("标题");
        rv= (RecyclerView) findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new BaseQuickAdapter<String>(R.layout.item1,getData()) {

            @Override
            protected void convert(BaseViewHolder baseViewHolder, String s) {
                baseViewHolder.setText(R.id.content_tv,s);
            }
        });

        toprv.setLayoutManager(new LinearLayoutManager(this));
        toprv.setAdapter(new BaseQuickAdapter<String>(R.layout.item,getData1()) {

            @Override
            protected void convert(BaseViewHolder baseViewHolder, String s) {
                baseViewHolder.setText(R.id.content_tv,s);
            }
        });
    }

    public List<String> getData(){
        List<String> data=new ArrayList<>();
        for (int i=0;i<31;i++){
            data.add("数据"+i);
        }
        return data;
    }

    public List<String> getData1(){
        List<String> data=new ArrayList<>();
        for (int i=0;i<3;i++){
            data.add("头数据"+i);
        }
        return data;
    }
}
