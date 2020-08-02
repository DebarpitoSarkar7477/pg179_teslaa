package com.example.testappintro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class Survey extends AppCompatActivity {
    EditText ed1,ed2,ed3,ed4,ed5,ed6;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);
        ed1=findViewById(R.id.t1);
        ed2=findViewById(R.id.t2);
        ed3=findViewById(R.id.e1);
        ed4=findViewById(R.id.e2);
        ed5=findViewById(R.id.e3);
        ed6=findViewById(R.id.e4);
        b=findViewById(R.id.b);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ed1.getText().toString().equals(""))
                    Toast.makeText(getApplicationContext(),"Name is Empty",Toast.LENGTH_SHORT).show();
                else if(ed2.getText().toString().equals(""))
                    Toast.makeText(getApplicationContext(),"Mail is Empty",Toast.LENGTH_SHORT).show();
                else if(ed1.getText().toString().equals(""))
                    Toast.makeText(getApplicationContext(),"Answer is Empty",Toast.LENGTH_SHORT).show();
                else if(ed1.getText().toString().equals(""))
                    Toast.makeText(getApplicationContext(),"Answer is Empty",Toast.LENGTH_SHORT).show();
                else if(ed1.getText().toString().equals(""))
                    Toast.makeText(getApplicationContext(),"Answer is Empty",Toast.LENGTH_SHORT).show();
                else if(ed1.getText().toString().equals(""))
                    Toast.makeText(getApplicationContext(),"Answer is Empty",Toast.LENGTH_SHORT).show();
                else {
                    String email = ed2.getText().toString().trim();
                    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                    if(email.matches(emailPattern)) {
                        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http:192.168.29.117/Subject/survey.php", new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                //Toast.makeText(getApplicationContext(),response,Toast.LENGTH_LONG).show();

                                if (response.equals("1")) {
                                    Toast.makeText(getApplicationContext(), "Thanks For Giving The Survey", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(Survey.this, MainActivity2.class);
                                    startActivity(intent);
                                    Survey.this.finish();

                                } else if (response.equals("2")) {
                                    Toast.makeText(getApplicationContext(), "You Have Already Submitted Once", Toast.LENGTH_SHORT).show();
                                } else
                                    Toast.makeText(getApplicationContext(), "Submition Failed", Toast.LENGTH_SHORT).show();
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
                                params.put("name", ed1.getText().toString());
                                params.put("email", ed2.getText().toString());
                                params.put("ans1", ed3.getText().toString());
                                params.put("ans2", ed4.getText().toString());
                                params.put("ans3", ed5.getText().toString());
                                params.put("ans4", ed6.getText().toString());
                                return params;
                            }
                        };
                        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                        queue.add(stringRequest);
                    }
                    else
                        Toast.makeText(getApplicationContext(),"Not a valid mail",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}