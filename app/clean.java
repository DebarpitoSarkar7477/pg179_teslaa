package com.example.testappintro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class clean extends AppCompatActivity {
    ImageView image1,image2,image3,image4,image5,image6,image7,image8,image9,image10;
    TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clean);
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
        t1.setText("Ganga Mitra");
        t2.setText("Ganga Mitra");
        t3.setText("Pravasi Ganga Prahari");
        t4.setText("Pravasi Ganga Prahari");
        t5.setText("Ganga Vichar Manch");
        t6.setText("Ganga Vichar Manch");
        t7.setText("Ganga Parhari");
        t8.setText("Ganga Parhari");
        t9.setText("Ganga Amantran");
        t10.setText("Ganga Amantran");
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
        image1.setImageResource(R.drawable.gm1);
        image2.setImageResource(R.drawable.gm2);
        image3.setImageResource(R.drawable.pgp1);
        image4.setImageResource(R.drawable.pgp2);
        image5.setImageResource(R.drawable.gvm);
        image6.setImageResource(R.drawable.rsc);
        image7.setImageResource(R.drawable.gp1);
        image8.setImageResource(R.drawable.gp2);
        image9.setImageResource(R.drawable.nmgc1);
        image10.setImageResource(R.drawable.nmgc2);
        b=findViewById(R.id.b);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(clean.this,MainActivity2.class);
                startActivity(intent);
            }
        });
    }
}