package org.tensorflow.lite.examples.classification;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class snake_rescue1 extends AppCompatActivity {
    private ImageView b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snake_rescue1);

        b = (ImageView) findViewById(R.id.btn3);
        b.setOnClickListener(new View.OnClickListener() {
                                 @Override
                                 public void onClick(View view) {
                                     Intent i = new Intent(snake_rescue1.this,MapsActivity.class );
                                     startActivity(i);
                                 }
                             }
        );
        b = (ImageView) findViewById(R.id.btn2);
        b.setOnClickListener(new View.OnClickListener() {
                                 @Override
                                 public void onClick(View view) {
                                     Intent i = new Intent(snake_rescue1.this,zoo.class );
                                     startActivity(i);
                                 }
                             }
        );

    }
}