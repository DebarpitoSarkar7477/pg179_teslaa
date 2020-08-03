package com.example.testappintro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
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

public class Donation extends AppCompatActivity {
    EditText e1,e2,e3,e4;
    Button b1;
    String Com;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation);
        e1=findViewById(R.id.e1);
        e2=findViewById(R.id.e2);
        e3=findViewById(R.id.e3);
        e4=findViewById(R.id.e4);
        b1=findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (e1.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Name is empty.", Toast.LENGTH_SHORT).show();
                } else if (e2.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Email is empty.", Toast.LENGTH_SHORT).show();
                } else if (e3.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Card Number is empty.", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(e4.getText().toString().equals(""))
                        Com="No Comments";
                    else
                        Com=e4.getText().toString();
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, "http:192.168.29.117/Subject/Reward.php", new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            // Toast.makeText(getApplicationContext(),response,Toast.LENGTH_LONG).show();

                            if (response.equals("1")) {
                                Toast.makeText(getApplicationContext(), "You will soon receive message...", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(Donation.this,MainActivity2.class);
                                startActivity(intent);
                                Donation.this.finish();

                            } else {
                                Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            // Toast.makeText(getApplicationContext(), String.valueOf(error.getMessage()), Toast.LENGTH_SHORT).show();
                            Toast.makeText(getApplicationContext(), "Network Error", Toast.LENGTH_SHORT).show();
                        }
                    }) {
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> params = new Hashtable<String, String>();
                            params.put("name", e1.getText().toString());
                            params.put("email", e2.getText().toString());
                            params.put("amount", e3.getText().toString());
                            params.put("reward", Com);
                            return params;
                        }
                    };
                    RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                    queue.add(stringRequest);
                }
            }
        });
    }

}