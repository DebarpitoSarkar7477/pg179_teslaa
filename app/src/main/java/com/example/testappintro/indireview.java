package com.example.testappintro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Base64;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Hashtable;
import java.util.Map;
import java.util.StringTokenizer;

public class indireview extends AppCompatActivity {
    String y,a,b;
    String []result;
    int i;
    TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,tt1,tt2,tt3,tt4;
    Button b2;
    ImageView image1,image2;
    String I1,I2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indireview);
        t1=findViewById(R.id.t0);
        t2=findViewById(R.id.t2);
        t3=findViewById(R.id.t4);
        t4=findViewById(R.id.t6);
        t5=findViewById(R.id.t8);
        t6=findViewById(R.id.t10);
        t7=findViewById(R.id.t12);
        t8=findViewById(R.id.t14);
        t9=findViewById(R.id.t16);
        tt1=findViewById(R.id.tt1);
        tt2=findViewById(R.id.tt2);
        tt3=findViewById(R.id.tt3);
        tt4=findViewById(R.id.tt4);
        image1=findViewById(R.id.image1);
        image2=findViewById(R.id.image2);
        b2=findViewById(R.id.b2);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(indireview.this,Description2.class);
                startActivity(intent);
            }
        });

        y= PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getString("info3","");
        result=new String[2];
        i=0;
        StringTokenizer tokenizer=new StringTokenizer(y,"-");
        while (tokenizer.hasMoreTokens()){
            result[i]=tokenizer.nextToken();
            i++;
        }
        a=result[0];
        b= PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getString("Name","");
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http:192.168.29.117/Subject/ret1.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //Toast.makeText(getApplicationContext(),response,Toast.LENGTH_LONG).show();
                int commas = 0;
                for(int i = 0; i < response.length(); i++) {
                    if(response.charAt(i) == ';')
                        commas++;
                }
                result=new String[commas+1];
                i=0;
                StringTokenizer tokenizer=new StringTokenizer(response,";");
                while (tokenizer.hasMoreTokens()){
                    result[i]=tokenizer.nextToken();
                    i++;
                }

                t1.setText(result[0]);
                t2.setText(result[1]);
                t3.setText(result[2]);
                t4.setText(result[5]);
                t5.setText(result[6]);
                t6.setText(result[7]);
                t7.setText(result[8]);
                t8.setText(result[3]);
                t9.setText(result[4]);
                I1=result[9];
                I2=result[10];
                if(I1.equals("A")){
                }
                else{
                    byte[] decodedString = Base64.decode(I1, Base64.DEFAULT);
                    Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
                    image1.setImageBitmap(decodedByte);
                }
                if(I2.equals("A")) {
                }
                else {
                    byte[] decodedString1 = Base64.decode(I2, Base64.DEFAULT);
                    Bitmap decodedByte1 = BitmapFactory.decodeByteArray(decodedString1, 0, decodedString1.length);
                    image2.setImageBitmap(decodedByte1);
                }

                tt1.setText(result[11]);
                tt2.setText(result[12]);
                tt3.setText(result[13]);
                tt4.setText(result[14]);

                // Toast.makeText(getApplicationContext(),result[9],Toast.LENGTH_LONG).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Toast.makeText(getApplicationContext(), String.valueOf(error.getMessage()), Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), "Network Error", Toast.LENGTH_SHORT).show();
            }
        }) {
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new Hashtable<String, String>();
                params.put("ghat", b);
                params.put("email",a);
                return params;
            }
        };
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        queue.add(stringRequest);
    }
}