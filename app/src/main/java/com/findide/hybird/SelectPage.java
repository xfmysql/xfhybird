package com.findide.hybird;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SelectPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_page);

        Button btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent = new Intent(getApplicationContext(),HybirdActivity.class);
                startIntent.putExtra("url", "file:///android_asset/html1/index.html");
                startActivity(startIntent);
                Log.d("selectpage","click btn1");
            }
        });
        Button btn2 = (Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startIntent = new Intent(getApplicationContext(),HybirdActivity.class);
                startIntent.putExtra("url", "file:///android_asset/index.html");
                startActivity(startIntent);
                Log.d("selectpage","click btn2");
            }
        });
    }

}
