package com.example.activitytest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class NewActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new1);

        ImageButton b0 = findViewById(R.id.ib0);
        ImageButton b1 = findViewById(R.id.ib1);

        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //返回数据
                //活动之间的数据交换都通过intent实现
                Intent intent = new Intent();
                intent.putExtra("name", "第一张图片");
                //setResult用于向该活动之前的活动传递intent
                //参数1：表示返回值成功或失败  参数2：携带参数的intent
                setResult(0x11, intent);
                //销毁当前活动
                finish();
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("name", "第二张图片");
                setResult(0x11, intent);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("name", "没有选图片");
        setResult(0x11, intent);
        finish();
    }
}