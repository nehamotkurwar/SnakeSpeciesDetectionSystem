package org.tensorflow.lite.examples.classification;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class SnakeInformaton extends AppCompatActivity {
    private ImageView b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snake_informaton);
        b = (ImageView) findViewById(R.id.btn_emp);
        b.setOnClickListener(new View.OnClickListener() {


                                 @Override
                                 public void onClick(View view) {
                                     Intent i = new Intent(SnakeInformaton.this,SnakeInfo1.class );
                                     startActivity(i);
                                 }
                             }
        );

        b = (ImageView) findViewById(R.id.btn_info2);
        b.setOnClickListener(new View.OnClickListener() {


                                 @Override
                                 public void onClick(View view) {
                                     Intent i = new Intent(SnakeInformaton.this,SnakeInfo2.class );
                                     startActivity(i);
                                 }
                             }
        );
    }
}