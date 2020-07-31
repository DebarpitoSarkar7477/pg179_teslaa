package com.example.testappintro;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

public class Ghatadd extends AppCompatActivity {
    EditText ed1,ed2,ed3,ed4,ed5,ed6,ed7,ed0;
    String a1,a2,a3,a4,st1,st2,str;
    Button b,b1,b2;
    RadioButton rd3,rd4,rd5,rd6,rd7,rd8,r1,r2,r3,r4;
    ImageView image1,image2;
    private int IMGR=21,IMG=13;
    Bitmap bitmap,bitmap1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ghatadd);
        r1=findViewById(R.id.r1);
        r2=findViewById(R.id.r2);
        r3=findViewById(R.id.r3);
        r4=findViewById(R.id.r4);
        ed0=findViewById(R.id.ed0);
        ed1=findViewById(R.id.ed1);
        ed2=findViewById(R.id.ed2);
        ed3=findViewById(R.id.ed3);
        ed4=findViewById(R.id.ed4);
        ed5=findViewById(R.id.ed5);
        ed6=findViewById(R.id.ed6);
        ed7=findViewById(R.id.ed7);
        rd3=findViewById(R.id.rd3);
        rd4=findViewById(R.id.rd4);
        rd5=findViewById(R.id.rd5);
        rd6=findViewById(R.id.rd6);
        rd7=findViewById(R.id.rd7);
        rd8=findViewById(R.id.rd8);
        image1=findViewById(R.id.image1);
        image2=findViewById(R.id.image2);
        b1=findViewById(R.id.up1);
        b2=findViewById(R.id.up2);
        b=findViewById(R.id.b);
        st1="";
        st2="";
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, IMGR);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, IMG);
            }
        });

       b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rd3.isChecked())
                    a1="YES";
                else if(rd4.isChecked())
                    a1="NO";
                if(rd5.isChecked())
                    a2="YES";
                else if(rd6.isChecked())
                    a2="NO";
                if(rd7.isChecked())
                    a3="YES";
                else if(rd8.isChecked())
                    a3="NO";
                if(r1.isChecked())
                    a4="Ferry Ghat";
                else if(r2.isChecked())
                    a4="Normal ghat";
                else if(r3.isChecked())
                    a4="Cremation ghat";
                else if(r4.isChecked())
                    a4="State Tourism Ghat";
                if(ed1.getText().toString().equals(""))
                    Toast.makeText(getApplicationContext(),"Mail is Empty",Toast.LENGTH_SHORT).show();
                else if(ed0.getText().toString().equals(""))
                    Toast.makeText(getApplicationContext(),"Name is Empty",Toast.LENGTH_SHORT).show();
                else if(ed2.getText().toString().equals(""))
                    Toast.makeText(getApplicationContext(),"Ghat Name is Empty",Toast.LENGTH_SHORT).show();
                else if(a1==null)
                    Toast.makeText(getApplicationContext(),"Answer1 Not Selected",Toast.LENGTH_SHORT).show();
                else if(a2==null)
                    Toast.makeText(getApplicationContext(),"Answer2 Not Selected",Toast.LENGTH_SHORT).show();
                else if(a3==null)
                    Toast.makeText(getApplicationContext(),"Answer3 Not Selected",Toast.LENGTH_SHORT).show();
                else if(a4==null)
                    Toast.makeText(getApplicationContext(),"Ghat Type Not Selected",Toast.LENGTH_SHORT).show();
                else if(ed3.getText().toString().equals(""))
                    Toast.makeText(getApplicationContext(),"River Name is Empty",Toast.LENGTH_SHORT).show();
                else if(ed4.getText().toString().equals(""))
                    Toast.makeText(getApplicationContext(),"Address is Empty",Toast.LENGTH_SHORT).show();
                else if(ed6.getText().toString().equals(""))
                    Toast.makeText(getApplicationContext(),"Answer4 is Empty",Toast.LENGTH_SHORT).show();
                else if(ed7.getText().toString().equals(""))
                    Toast.makeText(getApplicationContext(),"Answer5 is Empty",Toast.LENGTH_SHORT).show();
                else if(st1.equals(""))
                    Toast.makeText(getApplicationContext(),"Image Not Selected is Empty",Toast.LENGTH_SHORT).show();
                else if(st2.equals(""))
                    Toast.makeText(getApplicationContext(),"Image Not Selected is Empty",Toast.LENGTH_SHORT).show();
                else {
                     str=a1+";"+ed6.getText().toString()+";"+a2+";"+a3+";"+ed7.getText().toString();
                    // Intent intent=new Intent(Review.this,MainActivity2.class);
                    // startActivity(intent);
                    //Toast.makeText(getApplicationContext(), str , Toast.LENGTH_SHORT).show();
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, "http:192.168.29.117/Subject/newadd.php", new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            //Toast.makeText(getApplicationContext(), response , Toast.LENGTH_SHORT).show();
                            if (response.equals("1")) {
                                Toast.makeText(getApplicationContext(), "Successfully Submitted Data", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(Ghatadd.this,MainActivity2.class);
                                startActivity(intent);
                                Ghatadd.this.finish();

                            }
                            else{
                                Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
                            }

                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            // Toast.makeText(getApplicationContext(), String.valueOf(error.getMessage()), Toast.LENGTH_SHORT).show();
                            Toast.makeText(getApplicationContext(), "Network Problem", Toast.LENGTH_SHORT).show();
                        }
                    }) {
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> params = new Hashtable<String, String>();
                            params.put("name", ed0.getText().toString());
                            params.put("ghat", ed2.getText().toString());
                            params.put("email", ed1.getText().toString());
                            params.put("river",ed3.getText().toString());
                            params.put("add", ed4.getText().toString());
                            params.put("des", ed5.getText().toString());
                            params.put("ans", str);
                            //params.put("ans2", a2);
                            //params.put("ans3", a3);
                            //params.put("ans4", ed6.getText().toString());
                            //params.put("ans5", ed7.getText().toString());
                            params.put("type", a4);
                            params.put("up1", st1);
                            params.put("up2", st2);
                            return params;
                        }
                    };
                    RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
                    queue.add(stringRequest);
                }
            }
        });


    }
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == IMGR && resultCode == RESULT_OK && data != null) {
            Uri path = data.getData();

            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), path);
                image1.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,baos);
        byte[] imageBytes=baos.toByteArray();
        st1= Base64.encodeToString(imageBytes,Base64.DEFAULT);
        if (requestCode == IMG && resultCode == RESULT_OK && data != null) {
            Uri path = data.getData();

            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), path);
                image2.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        ByteArrayOutputStream baos1=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,baos1);
        byte[] imageBytes1=baos1.toByteArray();
        st2=Base64.encodeToString(imageBytes1,Base64.DEFAULT);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Ghatadd.this.finish();
    }
}