package com.example.aon_attapon.mvcstructure.activity;

import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.aon_attapon.mvcstructure.R;
import com.example.aon_attapon.mvcstructure.fragment.MainFragment;
import com.example.aon_attapon.mvcstructure.util.ScreenUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int screenWidth = ScreenUtils.getInstance().getScreenWidth();
        int screenHeight = ScreenUtils.getInstance().getScreenHeight();

        Toast.makeText(MainActivity.this, "Width: " + screenWidth + ", Height: " + screenHeight, Toast.LENGTH_LONG).show();

        //Separate by android version
        if (Build.VERSION.SDK_INT >= 21) {
            //Run on android 21+
        } else {
            //Run on android 1-20
        }

        if (savedInstanceState == null) {
            //First created
            //Place fragement here
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentContainer, MainFragment.newInstace(123), "MainFragment")
                    .commit();
        }
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        if (savedInstanceState == null) {
            MainFragment fragment = (MainFragment) getSupportFragmentManager().findFragmentByTag("MainFragment");
            fragment.setTvHelloText("Woo Hoooooo");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_fragment,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_second_fragment:
                Toast.makeText(MainActivity.this, "Second Fragment", Toast.LENGTH_LONG).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
