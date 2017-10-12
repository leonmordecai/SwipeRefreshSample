package com.example.leon.swiperefreshsample;

import android.graphics.Color;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int swipeNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe1);

        final TextView text1 = (TextView) findViewById(R.id.textView1);

        text1.setText("Total Swipe = 0");

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                swipeNumber ++;
                text1.setText("Total Swipe = " + swipeNumber);

                swipeRefreshLayout.setProgressBackgroundColorSchemeColor(Color.BLUE);

                swipeRefreshLayout.setColorSchemeColors(Color.RED, Color.YELLOW, Color.BLUE);


                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }, 3000);
            }
        });
    }
}
