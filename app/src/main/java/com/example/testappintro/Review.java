package com.example.testappintro;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RatingBar;
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

public class Review extends AppCompatActivity {
    Button b,b1,b2;
    RadioButton r1,r2,r3,r4,r5,r6,r7,r8,r9,r10,r11,r12;
    String a1,a2,a3,a4,st1,st2,a5,a6;
    EditText ed,ed0,ed1;
    RatingBar rate1,rate2,rate3,rate4;
    float r,y1,y2,y3,y4;
    String aa,e,comp,aa1,aa2,aa3,aa4,totalrate;
    ImageView image1,image2;
    private int IMGR=21,IMG=13;
    Bitmap bitmap;
    String X;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        r1=findViewById(R.id.rd1);
        r2=findViewById(R.id.rd2);
        r3=findViewById(R.id.rd3);
        r4=findViewById(R.id.rd4);
        r5=findViewById(R.id.rd5);
        r6=findViewById(R.id.rd6);
        r7=findViewById(R.id.rd7);
        r8=findViewById(R.id.rd8);
        r9=findViewById(R.id.rd9);
        r10=findViewById(R.id.rd10);
        r11=findViewById(R.id.rd11);
        r12=findViewById(R.id.rd12);
        b=findViewById(R.id.b);
        ed=findViewById(R.id.ed);
        ed0=findViewById(R.id.ed0);
        ed1=findViewById(R.id.ed1);
        rate1=findViewById(R.id.rate1);
        rate2=findViewById(R.id.rate2);
        rate3=findViewById(R.id.rate3);
        rate4=findViewById(R.id.rate4);
        e=ed.getText().toString();
        b1=findViewById(R.id.up1);
        b2=findViewById(R.id.up2);
        image1=findViewById(R.id.image1);
        image2=findViewById(R.id.image2);
        st1="";
        st2="";
        comp= PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getString("Name","");
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
                y1=rate1.getRating();
                y2=rate2.getRating();
                y3=rate3.getRating();
                y4=rate4.getRating();
                aa=Float.toString(r);
                aa1=Float.toString(y1);
                aa2=Float.toString(y2);
                aa3=Float.toString(y3);
                aa4=Float.toString(y4);
                totalrate=aa1+";"+aa2+";"+aa3+";"+aa4;
                if(r1.isChecked())
                    a1="YES";
                else if(r2.isChecked())
                    a1="NO";
                if(r3.isChecked())
                    a2="YES";
                else if(r4.isChecked())
                    a2="NO";
                if(r5.isChecked())
                    a3="YES";
                else if(r6.isChecked())
                    a3="NO";
                if(r7.isChecked())
                    a4="YES";
                else if(r8.isChecked())
                    a4="NO";
                if(r9.isChecked())
                    a5="YES";
                else if(r10.isChecked())
                    a5="NO";
                if(r11.isChecked())
                    a6="YES";
                else if(r12.isChecked())
                    a6="NO";
                if(ed0.getText().toString().equals(""))
                    Toast.makeText(getApplicationContext(),"Name is Empty",Toast.LENGTH_SHORT).show();
                else if(ed.getText().toString().equals(""))
                    Toast.makeText(getApplicationContext(),"Mail is Empty",Toast.LENGTH_SHORT).show();
                else if(a1==null)
                    Toast.makeText(getApplicationContext(),"Answer1 Not Selected",Toast.LENGTH_SHORT).show();
                else if(a2==null)
                    Toast.makeText(getApplicationContext(),"Answer2 Not Selected",Toast.LENGTH_SHORT).show();
                else if(a3==null)
                    Toast.makeText(getApplicationContext(),"Answer3 Not Selected",Toast.LENGTH_SHORT).show();
                else if(a4==null)
                    Toast.makeText(getApplicationContext(),"Answer4 Not Selected",Toast.LENGTH_SHORT).show();
                else if(a5==null)
                    Toast.makeText(getApplicationContext(),"Answer5 Not Selected",Toast.LENGTH_SHORT).show();
                else if(a6==null)
                    Toast.makeText(getApplicationContext(),"Answer6 Not Selected",Toast.LENGTH_SHORT).show();
                else if(st1.equals(""))
                    st1="A";
                else if(st2.equals(""))
                    st2="A";
                    // Intent intent=new Intent(Review.this,MainActivity2.class);
                    // startActivity(intent);
                    //  Toast.makeText(getApplicationContext(), a1 + a2 + a3 + a4+r+e, Toast.LENGTH_SHORT).show();
                else{
                    aa=a5+";"+a6;
                if(ed1.getText().toString().equals(""))
                    X="No Comments";
                X=ed1.getText().toString();
                StringRequest stringRequest = new StringRequest(Request.Method.POST, "http:192.168.29.117/Subject/review.php", new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //Toast.makeText(getApplicationContext(),response,Toast.LENGTH_LONG).show();

                        if (response.equals("1")) {
                            Toast.makeText(getApplicationContext(), "Successfully Submitted Data", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Review.this, MainActivity2.class);
                            startActivity(intent);
                            Review.this.finish();
                        } else {
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
                        params.put("email", ed.getText().toString());
                        params.put("ghat", comp);
                        params.put("rate", aa);
                        params.put("comments", X);
                        params.put("ans1", a1);
                        params.put("ans2", a2);
                        params.put("ans3", a3);
                        params.put("ans4", a4);
                        params.put("up1", st1);
                        params.put("up2", st2);
                        params.put("tot", totalrate);
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

}