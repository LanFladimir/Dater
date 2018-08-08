package com.dev_lan.dater.ui.main;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.dev_lan.dater.R;
import com.dev_lan.dater.bean.Dater;
import com.dev_lan.dater.interfaces.NewDaterCallback;
import com.dev_lan.dater.ui.NewDaterDialog;

import org.litepal.LitePal;
import org.litepal.crud.LitePalSupport;

import java.util.List;

/**
 * main
 */
public class MainActivity extends AppCompatActivity implements NewDaterCallback,IView {
    private Context mContext;

    private RecyclerView mRecyclerView;
    private FloatingActionButton mFab;

    private NewDaterDialog mNewDater;

    private MainPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;

        mPresenter =new MainPresenter(this);
        initView();

    }

    private void initView() {
        mRecyclerView = findViewById(R.id.dater_recycler);
        mFab = findViewById(R.id.fab_add);

        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mNewDater = new NewDaterDialog(mContext);
                mNewDater.show();
            }
        });

        mPresenter.getDaterList();
    }
    @Override
    public void newDater(Dater dater) {
        dater.save();
    }

    @Override
    public void loadData(List<Dater> daters) {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.setAdapter(new DaterAdapter(daters));
    }
}
