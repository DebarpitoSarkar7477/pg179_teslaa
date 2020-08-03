package com.example.testappintro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.logging.Level;

public class Bio extends AppCompatActivity {
    ImageView image1,image2,image3,image4,image5,image6,image7,image8,image9,image10;
    TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bio);
        image1=findViewById(R.id.image1);
        t1=findViewById(R.id.t1);
        image2=findViewById(R.id.image2);
        t2=findViewById(R.id.t2);
        image3=findViewById(R.id.image3);
        t3=findViewById(R.id.t3);
        image4=findViewById(R.id.image4);
        t4=findViewById(R.id.t4);
        image5=findViewById(R.id.image5);
        t5=findViewById(R.id.t5);
        image6=findViewById(R.id.image6);
        t6=findViewById(R.id.t6);
        image7=findViewById(R.id.image7);
        t7=findViewById(R.id.t7);
        image8=findViewById(R.id.image8);
        t8=findViewById(R.id.t8);
        image9=findViewById(R.id.image9);
        t9=findViewById(R.id.t9);
        image10=findViewById(R.id.image10);
        t10=findViewById(R.id.t10);
        t1.setText("Ganges River Dolphin");
        t2.setText("Smooth Coated Otter");
        t3.setText("Sarus Crane");
        t4.setText("Indian Skimmer");
        t5.setText("Salt Water Crocodile");
        t6.setText("Gharial");
        t7.setText("River Terrapin");
        t8.setText("Indian Bullfrog");
        t9.setText("Himalayan Paa Frog");
        t10.setText("Golden Mahaseer");
        image1.setImageResource(R.drawable.grd);
        image2.setImageResource(R.drawable.sco);
        image3.setImageResource(R.drawable.gsc);
        image4.setImageResource(R.drawable.gis);
        image5.setImageResource(R.drawable.swc);
        image6.setImageResource(R.drawable.gg);
        image7.setImageResource(R.drawable.grt);
        image8.setImageResource(R.drawable.gib);
        image9.setImageResource(R.drawable.hpf);
        image10.setImageResource(R.drawable.ggm);
        t1.setTypeface(null, Typeface.BOLD_ITALIC);
        t2.setTypeface(null, Typeface.BOLD_ITALIC);
        t3.setTypeface(null, Typeface.BOLD_ITALIC);
        t4.setTypeface(null, Typeface.BOLD_ITALIC);
        t5.setTypeface(null, Typeface.BOLD_ITALIC);
        t6.setTypeface(null, Typeface.BOLD_ITALIC);
        t7.setTypeface(null, Typeface.BOLD_ITALIC);
        t8.setTypeface(null, Typeface.BOLD_ITALIC);
        t9.setTypeface(null, Typeface.BOLD_ITALIC);
        t10.setTypeface(null, Typeface.BOLD_ITALIC);
        b=findViewById(R.id.b);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Bio.this,MainActivity2.class);
                startActivity(intent);
            }
        });
    }
}