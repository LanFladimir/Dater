package com.dev_lan.dater.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;

import com.dev_lan.dater.R;
import com.dev_lan.dater.bean.Dater;
import com.dev_lan.dater.interfaces.NewDaterCallback;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class NewDaterDialog extends AlertDialog {
    private Button alert_add_bt;
    private NewDaterCallback mNewDaterCallback;

    public NewDaterDialog(@NonNull Context context) {
        super(context, R.style.dialog_new);
        mNewDaterCallback = (NewDaterCallback) context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_addnew);
        alert_add_bt = findViewById(R.id.alert_add_bt);
        alert_add_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
                Dater dater = new Dater();
                dater.setDateTitle("date");
                dater.setDateDetail("detail");
                try {
                    dater.setDeadLine(dateFormat.parse("2018-08-08 11:16:01"));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                dater.setHasCountDown(false);
                mNewDaterCallback.newDater(dater);
                dismiss();
            }
        });
    }
}
