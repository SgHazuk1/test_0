package com.example.activitytest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NewActivity0 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new0);
        Log.d("NewActivity0", this.toString());

        //接收intent
        Intent intent = this.getIntent();
        //获取intent中的bundle
        Bundle bundle = intent.getExtras();
        //获取bundle中的数据
        String name = bundle.getString("data");

        TextView t0 = findViewById(R.id.text0);
        t0.setText(name);



        Button b0 = findViewById(R.id.button0);

        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(NewActivity0.this, MainActivity.class);
//                startActivity(intent);
                finish();//关闭当前活动，回到调用该活动的活动
            }
        });
    }

    //自定义按下返回键执行的操作
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}