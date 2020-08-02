package com.example.testappintro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
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

public class listoftent extends AppCompatActivity {
    ListView listView;
    String []result;
    int i;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    String b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listoftent);
        listView=findViewById(R.id.list1);
        prefs = android.preference.PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        editor = prefs.edit();
        b= PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getString("Name","");
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http:192.168.29.117/Subject/polka.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //Toast.makeText(getApplicationContext(),response,Toast.LENGTH_LONG).show();
                int commas = 0;
                for(int i = 0; i < response.length(); i++) {
                    if(response.charAt(i) == ',')
                        commas++;
                }
                result=new String[commas];
                i=0;
                StringTokenizer tokenizer=new StringTokenizer(response,",");
                while (tokenizer.hasMoreTokens()){
                    result[i]=tokenizer.nextToken();
                    i++;
                }
                ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_list_item_1,result);
                listView.setAdapter(arrayAdapter);
                //Toast.makeText(getApplicationContext(),String.valueOf(commas),Toast.LENGTH_LONG).show();
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
                return params;
            }
        };
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        queue.add(stringRequest);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String x=adapterView.getItemAtPosition(i).toString();
                //Toast.makeText(getApplicationContext(),x,Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(listoftent.this,inditent.class);
                startActivity(intent);
                editor.putString("info3",x);
                editor.apply();
            }
        });

    }
}