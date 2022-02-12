package org.tensorflow.lite.examples.classification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class zoo extends AppCompatActivity {
    private static final int REQUEST_CALL=1;
    private TextView callText;
    private Button callbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoo);

        callText = findViewById(R.id.txt12);
        callbtn = findViewById(R.id.btn11);
        callbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CallButton();
            }
        });
    }
    private void CallButton(){
        String number = callbtn.getText().toString();
        if(number.trim().length()>0){
            if (ContextCompat.checkSelfPermission(zoo.this, Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                
            }
        }
    }
}