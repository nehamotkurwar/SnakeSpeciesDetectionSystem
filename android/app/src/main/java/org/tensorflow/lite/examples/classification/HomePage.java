package org.tensorflow.lite.examples.classification;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class HomePage extends AppCompatActivity {
    private ImageView b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        b = (ImageView) findViewById(R.id.animal);
        b.setOnClickListener(new View.OnClickListener() {
                                 @Override
                                 public void onClick(View view) {
                                     Intent i = new Intent(HomePage.this,ClassifierActivity.class );
                                     startActivity(i);
                                 }
                             }
        );
        b = (ImageView) findViewById(R.id.hosp1);
        b.setOnClickListener(new View.OnClickListener() {
                                 @Override
                                 public void onClick(View view) {
                                     Intent i = new Intent(HomePage.this,snake_rescue1.class );
                                     startActivity(i);
                                 }
                             }
        );
        b = (ImageView) findViewById(R.id.donate);
        b.setOnClickListener(new View.OnClickListener() {


                                 @Override
                                 public void onClick(View view) {
                                     Intent i = new Intent(HomePage.this,QrCode.class );
                                     startActivity(i);
                                 }
                             }
        );
        b = (ImageView) findViewById(R.id.info1);
        b.setOnClickListener(new View.OnClickListener() {


                                 @Override
                                 public void onClick(View view) {
                                     Intent i = new Intent(HomePage.this,SnakeInformaton.class );
                                     startActivity(i);
                                 }
                             }
        );
        b = (ImageView) findViewById(R.id.firstAid);
        b.setOnClickListener(new View.OnClickListener() {


                                 @Override
                                 public void onClick(View view) {
                                     Intent i = new Intent(HomePage.this,FirstAid.class );
                                     startActivity(i);
                                 }
                             }
        );
        b = (ImageView) findViewById(R.id.about1);
        b.setOnClickListener(new View.OnClickListener() {


                                 @Override
                                 public void onClick(View view) {
                                     Intent i = new Intent(HomePage.this,AboutUs.class );
                                     startActivity(i);
                                 }
                             }
        );
    }
}