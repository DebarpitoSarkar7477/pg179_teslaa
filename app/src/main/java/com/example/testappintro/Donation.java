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
    EditText e1,e2,e3,e6,e7,e8;
    Spinner e4,e5;
    Button b1;
    String[] m=new String[]{"Select Month", "01", "02"};
    String[] m1=new String[]{"Select Year", "2021", "2022"};
    String x,y,Reward;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation);
        e1=findViewById(R.id.e1);
        e2=findViewById(R.id.e2);
        e3=findViewById(R.id.e3);
        e4=findViewById(R.id.e4);
        e5=findViewById(R.id.e5);
        e6=findViewById(R.id.e6);
        e7=findViewById(R.id.e7);
        e8=findViewById(R.id.e8);
        b1=findViewById(R.id.b1);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(Donation.this, android.R.layout.simple_spinner_item,m);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        e4.setAdapter(adapter);
        ArrayAdapter<String> adapter1=new ArrayAdapter<String>(Donation.this, android.R.layout.simple_spinner_item,m1);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        e5.setAdapter(adapter1);
        e4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                x=adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        e5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                y=adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (e1.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Name is empty.", Toast.LENGTH_SHORT).show();
                } else if (e2.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Email is empty.", Toast.LENGTH_SHORT).show();
                } else if (e3.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Card Number is empty.", Toast.LENGTH_SHORT).show();
                } else if (x.equals("Select")) {
                    Toast.makeText(getApplicationContext(), "Month is not selected", Toast.LENGTH_SHORT).show();
                } else if (y.equals("Select")) {
                    Toast.makeText(getApplicationContext(), "Year is not selected", Toast.LENGTH_SHORT).show();
                }
                else if (e6.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "CVV is required", Toast.LENGTH_SHORT).show();
                }
                else if (e7.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Amount is required", Toast.LENGTH_SHORT).show();
                }
                else if (e8.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Name on Card is required", Toast.LENGTH_SHORT).show();
                }
                else{
                    float f=Float.parseFloat(e7.getText().toString());
                    if(f<=100)
                        Reward="Voucher1";
                    else if(f>100 && f<=1000)
                        Reward="Voucher2";
                    else if(f>1000 && f<=5000)
                        Reward="Voucher3";
                    else if(f>5000 && f<=10000)
                        Reward="Voucher4";
                    else if(f>10000)
                        Reward="Voucher5";
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, "http:192.168.29.117/Subject/Reward.php", new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            // Toast.makeText(getApplicationContext(),response,Toast.LENGTH_LONG).show();

                            if (response.equals("1")) {
                                Toast.makeText(getApplicationContext(), "Payment Successful. You will recieve the rewards soon..", Toast.LENGTH_SHORT).show();
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
                            params.put("amount", e7.getText().toString());
                            params.put("reward", Reward);
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