package com.hilmansyafei.lihatjadwal;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class Splahscreen extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splahscreen);

        Thread logotimer = new Thread() {
            public void run() {
                try {
                    int logotimer = 0;
                    while (logotimer < 3000) {
                        sleep(100);
                        logotimer = logotimer + 100;
                    };
                    startActivity(new Intent(getApplicationContext(), Pilih_Menu.class));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    finish();
                }
            }
        };
        logotimer.start();
    }



}
