package com.example.testappintro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
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

public class Description2 extends AppCompatActivity {

    Button r,b;
    TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
    String comp,x;
    String []result,List1;
    Float m,p;
    int i;
    LocationManager locationManager;
    LocationListener locationListener;
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description2);
        r=findViewById(R.id.r);
        b=findViewById(R.id.b);
        t1=findViewById(R.id.t2);
        t2=findViewById(R.id.t4);
        t3=findViewById(R.id.t6);
        t4=findViewById(R.id.t8);
        t5=findViewById(R.id.t10);
        t6=findViewById(R.id.t1);
        t7=findViewById(R.id.t3);
        t8=findViewById(R.id.t5);
        t9=findViewById(R.id.t7);
        t10=findViewById(R.id.t9);
        t6.setTypeface(null, Typeface.BOLD_ITALIC);
        t7.setTypeface(null, Typeface.BOLD_ITALIC);
        t8.setTypeface(null, Typeface.BOLD_ITALIC);
        t9.setTypeface(null, Typeface.BOLD_ITALIC);
        t10.setTypeface(null, Typeface.BOLD_ITALIC);
        comp= PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getString("Name","");
        //s="xxx";
        //find loc
        final Location loc = new Location("");
        x="";
        locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                loc.setLatitude(location.getLatitude());
                loc.setLongitude(location.getLongitude());
                x=String.valueOf(loc.getLatitude());
            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {

            }
        };
        //
        //check loc
        if(comp.equals("Armenian Ferry Ghat_HWB")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Armenian_Ferry_Ghat_HWB);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Azimganj Ferry Ghat_HWB")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Azimganj_Ferry_Ghat_HWB);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Babughat_HWB")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Babughat_HWB);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Burul Ferry Ghat_HWB")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Burul_Ferry_Ghat_HWB);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Dakshineswar Ganga Ghat_HWB")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Dakshineswar_Ganga_Ghat_HWB);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Doltala Ganga Ghat_HWB")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Doltala_Ganga_Ghat_HWB);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Ferry Ghat Konnagar_HWB")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Ferry_Ghat_Konnagar_HWB);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Howrah Ferry Ghat_HWB")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Howrah_Ferry_Ghat_HWB);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Metiabruz Ferry Ghat_HWB")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Metiabruz_Ferry_Ghat_HWB);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Ramkrishnapur Ghat_HWB")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Ramkrishnapur_Ghat_HWB);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Ganga River Ghat_HWB")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Ganga_River_Ghat_HWB);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Jagannath Ghat_HWB")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Jagannath_Ghat_HWB);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Judges Ghat of Ganges_HWB")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Judges_Ghat_of_Ganges_HWB);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Kamarhati Pituri Ghat_HWB")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Kamarhati_Pituri_Ghat_HWB);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Sarbamangala Ghat_HWB")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Sarbamangala_Ghat_HWB);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Mayurpankhi Ghat_HWB")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Mayurpankhi_Ghat_HWB);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Gandhi Ghat_HWB")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Gandhi_Ghat_HWB);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("James Prinsep Ghat_HWB")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.James_Prinsep_Ghat_HWB);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Tribeni Burning Ghat_HWB")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Tribeni_Burning_Ghat_HWB);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Gandheswari Burning Ghat_HWB")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Gandheswari_Burning_Ghat_HWB);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Halisahar Hindu Crematorium_HWB")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Halisahar_Hindu_Crematorium_HWB);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Ramghat Samshan_HWB")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Ramghat_Samshan_HWB);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Ghutiabazar Burning Ghat_HWB")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Ghutiabazar_Burning_Ghat_HWB);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Shyam Babur Ghat Crematorium_HWB")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Shyam_Babur_Ghat_Crematorium_HWB);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Boraichanditala Burning Ghat_HWB")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Boraichanditala_Burning_Ghat_HWB);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Ballavpur Cremation Ghat_HWB")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Ballavpur_Cremation_Ghat_HWB);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Mahesh Jagannath Cremation Ghat_HWB")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Mahesh_Jagannath_Cremation_Ghat_HWB);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Rishra Burning Ghat_HWB")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Rishra_Burning_Ghat_HWB);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Panihati Burning Ghat HWB")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Panihati_Burning_Ghat_HWB);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Nangi Burning Ghat_HWB")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Nangi_Burning_Ghat_HWB);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Nimtala Ghat Crematorium_HWB")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Nimtala_Ghat_Crematorium_HWB);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Kashi Mitra Burning Ghat_HWB")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Kashi_Mitra_Burning_Ghat_HWB);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Belur Burning Ghat_HWB")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Belur_Burning_Ghat_HWB);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Sri Ram Krishna Maha Samshan_HWB")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Sri_Ram_Krishna_Maha_Samshan_HWB);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Bally Burning Ghat_HWB")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Bally_Burning_Ghat_HWB);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Ariadaha Burning Ghat_HWB")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Ariadaha_Burning_Ghat_HWB);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Dutta Ghat_HWB")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Dutta_Ghat_HWB);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Bhutni Ferry Ghat_GWB")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Bhutni_Ferry_Ghat_GWB);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("P.Narayanpur Lathipitta Ferry Ghat_GWB")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.P_Narayanpur_Lathipitta_Ferry_Ghat_GWB);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Panchanandapur Ferry Ghat_GWB")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Panchanandapur_Ferry_Ghat_GWB);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Gandhi Ghat_GWB")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Gandhi_Ghat_GWB);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Dhulian Ghat_GWB")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Dhulian_Ghat_GWB);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Dhulian Ferry Terminal_GWB")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Dhulian_Ferry_Terminal_GWB);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Par Lalpur Ghat_GWB")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Par_Lalpur_Ghat_GWB);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Parlalpur Ferry Ghat_GWB")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Parlalpur_Ferry_Ghat_GWB);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Shyam Ghat Mandir_YDEL")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Shyam_Ghat_Mandir_YDEL);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Shyam Ghat_YDEL")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Shyam_Ghat_YDEL);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Sur Ghat_YDEL")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Sur_Ghat_YDEL);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Ganpati Visarjan Ghat_YDEL")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Ganpati_Visarjan_Ghat_YDEL);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Dayadham Yamuna Aarti Ghat_YDEL")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Dayadham_Yamuna_Aarti_Ghat_YDEL);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Ganesh Ghat_YDEL")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Ganesh_Ghat_YDEL);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Kashmiri Ghat_YDEL")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Kashmiri_Ghat_YDEL);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Kashyap Ghat_YDEL")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Kashyap_Ghat_YDEL);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Yamuna Ghat_YDEL")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Yamuna_Ghat_YDEL);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Jamnapaar Ghat_YDEL")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Jamnapaar_Ghat_YDEL);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Vishwakrma Chatt Ghat_YDEL")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Vishwakrma_Chatt_Ghat_YDEL);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Chatth Ghat_YDEL")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Chatth_Ghat_YDEL);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Shamshaan Ghat_YDEL")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Shamshaan_Ghat_YDEL);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Nigambodh Cremation Ghat_YDEL")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Nigambodh_Cremation_Ghat_YDEL);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Shamshaan Ghat Geeta Colony_YDEL")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Shamshaan_Ghat_Geeta_Colony_YDEL);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Kalindi Kunj Samshan Ghat_YDEL")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Kalindi_Kunj_Samshan_Ghat_YDEL);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Madanpur Khadar Samshan Ghat_YDEL")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Madanpur_Khadar_Samshan_Ghat_YDEL);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Kiran Chandra Burning Ghat_MWB")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Kiran_Chandra_Burning_Ghat_MWB);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Chinakuri Shiv Mandir Ram Ghat_DWB")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Chinakuri_Shiv_Mandir_Ram_Ghat_DWB);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Telkupi Barni Ghat_DWB")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Telkupi_Barni_Ghat_DWB);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Randiha Ghat_DWB")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Randiha_Ghat_DWB);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Bhagloi Nadi Ghat_DWB")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Bhagloi_Nadi_Ghat_DWB);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Babla Tola Ghat_DWB")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Babla_Tola_Ghat_DWB);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Bali Ghat_DWB")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Bali_Ghat_DWB);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Balamhat Bali Ghat_DWB")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Balamhat_Bali_Ghat_DWB);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Srirampur Ghat_DWB")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Srirampur_Ghat_DWB);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Jiara Ghat_DWB")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Jiara_Ghat_DWB);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Khaya Ghat_DWB")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Khaya_Ghat_DWB);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Dishergarh Sashan Ghat_DWB")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Dishergarh_Sashan_Ghat_DWB);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Kalajharia Burning Ghat_DWB")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Kalajharia_Burning_Ghat_DWB);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Nimtala Sashan Ghat_DWB")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Nimtala_Sashan_Ghat_DWB);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Kanaria Samsan Ghat_DWB")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Kanaria_Samsan_Ghat_DWB);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Shilampur Ferry Ghat_DWB")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Shilampur_Ferry_Ghat_DWB);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Randiha Ferry Ghat_DWB")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Randiha_Ferry_Ghat_DWB);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Hijalna Ferry Ghat_DWB")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Hijalna_Ferry_Ghat_DWB);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Barsul Ferry Ghat_DWB")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Barsul_Ferry_Ghat_DWB);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Shumbhupur Ferry Ghat_DWB")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Shumbhupur_Ferry_Ghat_DWB);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Jamudaha Ferry Ghat_DWB")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Jamudaha_Ferry_Ghat_DWB);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Joyt Chand Ferry Ghat_DWB")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Joyt_Chand_Ferry_Ghat_DWB);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Amarpur Ferry Ghat_DWB")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Amarpur_Ferry_Ghat_DWB);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Kali Tola Ferry Ghat_DWB")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Kali_Tola_Ferry_Ghat_DWB);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Anchal Ferry Ghat_DWB")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Anchal_Ferry_Ghat_DWB);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Dehibhursut Jhanda Ferry Ghat_DWB")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Dehibhursut_Jhanda_Ferry_Ghat_DWB);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Nowpara Ferry Ghat_DWB")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Nowpara_Ferry_Ghat_DWB);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Purba Bainan Ferry Ghat_DWB")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Purba_Bainan_Ferry_Ghat_DWB);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Kulitapara Ferry Ghat_DWB")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Kulitapara_Ferry_Ghat_DWB);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Boalia Ferry Ghat_DWB")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Boalia_Ferry_Ghat_DWB);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Madhabpur Ferry Ghat_DWB")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Madhabpur_Ferry_Ghat_DWB);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Garchumuk Ferry Ghat_DWB")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Garchumuk_Ferry_Ghat_DWB);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Nishadraj Ghat_GUP")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Nishadraj_Ghat_GUP);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Raj Ghat_GUP")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Raj_Ghat_GUP);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Rani Ghat_GUP")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Rani_Ghat_GUP);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Telianala Ghat_GUP")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Telianala_Ghat_GUP);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Sakka Ghat_GUP")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Sakka_Ghat_GUP);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Trilochan Ghat_GUP")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Trilochan_Ghat_GUP);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Gaay Ghat_GUP")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Gaay_Ghat_GUP);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Sheetala Ghat_GUP")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Sheetala_Ghat_GUP);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Bundi Parkota Ghat_GUP")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Bundi_Parkota_Ghat_GUP);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Brahma Ghat_GUP")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Brahma_Ghat_GUP);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Panchganga Ghat_GUP")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Panchganga_Ghat_GUP);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Jatar Ghat_GUP")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Jatar_Ghat_GUP);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Ram Ghat_GUP")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Ram_Ghat_GUP);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Mehta Ghat_GUP")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Mehta_Ghat_GUP);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Naya Ghat_GUP")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Naya_Ghat_GUP);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Bhonsale Ghat_GUP")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Bhonsale_Ghat_GUP);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Ganga Mahal Ghat_GUP")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Ganga_Mahal_Ghat_GUP);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Sankatha Ghat_GUP")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Sankatha_Ghat_GUP);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Adarsh Ghat_GBH")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Adarsh_Ghat_GBH);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Aguani Ghat_GBH")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Aguani_Ghat_GBH);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Babupur Ganga Ghat_GBH")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Babupur_Ganga_Ghat_GBH);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Bengali Baba Ghat_GBH")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Bengali_Baba_Ghat_GBH);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Bhadra Ghat_GBH")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Bhadra_Ghat_GBH);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Digha Ghat_GBH")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Digha_Ghat_GBH);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Duli Ghat_GBH")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Duli_Ghat_GBH);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Gai Ghat_DWB")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Gai_Ghat_DWB);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Gandhi Ghat_GBH")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Gandhi_Ghat_GBH);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Jahanvi Ganga Brahmbaba Ghat_GBH")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Jahanvi_Ganga_Brahmbaba_Ghat_GBH);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Kahalgaon Ganga Ghat_GBH")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Kahalgaon_Ganga_Ghat_GBH);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Khajekalan Ghat_GBH")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Khajekalan_Ghat_GBH);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Mahavir Ghat_GBH")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Mahavir_Ghat_GBH);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Manihari Ghat_GBH")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Manihari_Ghat_GBH);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Mokama Ghat_GBH")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Mokama_Ghat_GBH);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Rasulpur Ganga Ghat_GBH")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Rasulpur_Ganga_Ghat_GBH);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Sita Ghat_GBH")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Sita_Ghat_GBH);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        else if(comp.equals("Sultanganj Ganga Ghat_GBH")){
            int n=5;
            List1=new String[n];
            List1=getResources().getStringArray(R.array.Sultanganj_Ganga_Ghat_GBH);
            m=Float.parseFloat(List1[0]);
            p=Float.parseFloat(List1[1]);
        }
        //
        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http:192.168.29.117/Subject/infoprov.php", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
                result=new String[response.length()];
                i=0;
                StringTokenizer tokenizer=new StringTokenizer(response,",");
                while (tokenizer.hasMoreTokens()){
                    result[i]=tokenizer.nextToken();
                    i++;
                }
                t1.setText(result[0]);
                t2.setText(result[1]);
                t3.setText(result[2]);
                t4.setText(result[3]);
                t5.setText(result[4]);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Toast.makeText(getApplicationContext(), String.valueOf(error.getMessage()), Toast.LENGTH_SHORT).show();
                //Toast.makeText(getApplicationContext(), "Network Error", Toast.LENGTH_SHORT).show();
            }
        }) {
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new Hashtable<String, String>();
                params.put("name", comp);
                return params;
            }
        };
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        queue.add(stringRequest);


        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(x.equals(""))
                    Toast.makeText(getApplicationContext(),"Wait",Toast.LENGTH_SHORT).show();
                else {
                    Location location=new Location("");
                    location.setLatitude(m);
                    location.setLongitude(p);
                    float dis = (location.distanceTo(loc));
                    if(dis > 1000)
                        Toast.makeText(getApplicationContext(),"Not in Range of Ghat",Toast.LENGTH_SHORT).show();
                    else {
                        Intent intent = new Intent(Description2.this, Review.class);
                        startActivity(intent);
                        Description2.this.finish();
                    }
                }
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
                Intent intent=new Intent(Description2.this,DescriptionofGhtas.class);
                startActivity(intent);
            }
        });

        if (ContextCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1);

        }
        else {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
        }
    }

}