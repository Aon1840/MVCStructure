package com.example.aon_attapon.mvcstructure.activity;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

        Toast.makeText(MainActivity.this,"Width: "+screenWidth+", Height: "+screenHeight,Toast.LENGTH_LONG).show();

        //Separate by android version
        if(Build.VERSION.SDK_INT >= 21) {
            //Run on android 21+
        } else {
            //Run on android 1-20
        }

        if(savedInstanceState == null){
            //First created
            //Place fragement here
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentContainer,MainFragment.newInstace(123))
                    .commit();
        }

    }
}
