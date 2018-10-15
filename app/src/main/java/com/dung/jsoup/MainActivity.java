package com.dung.jsoup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private HoloscropAdapter holoscropAdapter;
    private RecyclerView rcvHolocrop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        DataCrawler dataCrawler = new DataCrawler();//this la dung cho toan doi thuong
        dataCrawler.crawlerData(new DataCrawler.OnResultCallBack() {//2 lenh nay se chay sau
            @Override
            public void onSuccess(final List<Holoscop> holoscops) {
                //Bind to view
//                LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
//                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//                rcvHolocrop.setLayoutManager(layoutManager);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        holoscropAdapter.setHoloscops(holoscops);//co notifi roi

                    }
                });


//                holoscropAdapter = new HoloscropAdapter(MainActivity.this);
//                rcvHolocrop.setAdapter(holoscropAdapter);


            }

            @Override
            public void onFailure(final Throwable throwable) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, throwable.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

    }

    private void init() {
        rcvHolocrop = findViewById(R.id.rcvHoloscop);
        rcvHolocrop.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        holoscropAdapter = new HoloscropAdapter(this);
        rcvHolocrop.setAdapter(holoscropAdapter);//luc nay dang rong
    }
}
