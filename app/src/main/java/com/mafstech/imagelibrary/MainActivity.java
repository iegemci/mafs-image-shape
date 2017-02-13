package com.mafstech.imagelibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.mafstech.mafsimageshape.Shaper;

public class MainActivity extends AppCompatActivity {

    ImageView ivOne, ivTwo, ivThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivOne = (ImageView) findViewById(R.id.ivOne);
        ivTwo = (ImageView) findViewById(R.id.ivTwo);
        ivThree = (ImageView) findViewById(R.id.ivThree);

        /**
         * This tasks are only for HDPI device. You need to convert all height and width to any other dpi as your expectation
         * */
        Shaper.shape(MainActivity.this, R.drawable.flag, R.drawable.tri, ivOne, 225, 225);
        Shaper.shape(MainActivity.this, R.drawable.flag, R.drawable.pro_pic, ivTwo, 132, 132);
        Shaper.shape(MainActivity.this, R.drawable.flag, R.drawable.shape2, ivThree, 225, 225);


    }
}
