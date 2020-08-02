package com.example.testappintro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Base64;
import android.view.View;
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

public class inditent extends AppCompatActivity {
    String y,a,b;
    String []result;
    int i;
    TextView t1,t2,t3,t4;
    Button b2;
    String I1,I2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inditent);
        t1=findViewById(R.id.t0);
        t2=findViewById(R.id.t2);
        t3=findViewById(R.id.t4);
        t4=findViewById(R.id.t6);
        b2=findViewById(R.id.b);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(inditent.this,Description2.class);
                startActivity(intent);
            }
        });
        y= android.preference.PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getString("info3","");
        result=new String[2];
        i=0;
        StringTokenizer tokenizer=new StringTokenizer(y,"-");
        while (tokenizer.hasMoreTokens()){
            result[i]=tokenizer.nextToken();
            i++;
        }
        a=result[0];
        b= PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getString("Name","");
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http:192.168.29.117/Subject/ret3.php", new Response.Listener<String>() {
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
                t4.setText(result[3]);
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