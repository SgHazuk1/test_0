package com.example.activitytest;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("MainActivity", this.toString());


        Button b0 = this.findViewById(R.id.button0);
        Button b1 = findViewById(R.id.button1);

        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String site0 = ((EditText) findViewById(R.id.ET0)).getText().toString();

                //获取Activity
                Intent intent = new Intent(MainActivity.this, NewActivity0.class);

                //创建数据传输的工具
                Bundle bundle = new Bundle();
                //传入数据，以键值对形式
                bundle.putCharSequence("data", site0);
                //将数据保存到intent里面
                intent.putExtras(bundle);

                //启动Activity
                if (site0 != "") {
                    startActivity(intent);
                }
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NewActivity1.class);

                //表示转移的活动具有向当前活动的返回值
                startActivityForResult(intent, 0x11);

            }
        });
    }


    //接受其它活动的返回值
    //requestCode：启动对应活动时设置的请求码
    //resultCode：其它活动返回值时设定的处理结果，一般只有RESULT_OK或RESULT_CANCELED
    //intent携带返回值
    //对应不同的requestCode和resultCode执行不同的返回值处理
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {//根据requestCode选择操作
            case 0x11:
                if (resultCode == 0x11) { //根据resultCode表示成功或失败选择操作
                   String returndata = data.getStringExtra("name");
                    Toast.makeText(this, returndata, Toast.LENGTH_SHORT).show();
                    Log.i("触发返回","触发返回");
                }
                break;
            default:
        }

    }
}
