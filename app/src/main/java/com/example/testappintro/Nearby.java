package com.example.testappintro;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;
public class Nearby extends AppCompatActivity {
    LocationManager locationManager;
    LocationListener locationListener;
    Button b;
    String x,d,k;
    double[] Clat = {22.984437,22.942545,22.941719,22.906222,22.902447,22.878984,22.866763,22.744770,22.734207,22.720691,22.692821,22.513341,22.560666,22.593581,22.602246,22.624099,22.631224,22.647692,22.666375,26.720186,28.843088,28.664231,28.654699,28.542403,28.542923,23.686276,23.631257,23.041683,22.892601};
    double[] Clon = {88.401828,88.406009,88.414010,88.406580,88.403561,88.395524,88.378687,88.355611,88.356943,88.355369,88.366885,88.211222,88.325372,88.351870,88.362003,88.360657,88.364813,88.351169,88.358076,88.417904,77.214609,77.235788,77.264253,77.312269,77.316271,86.822020,86.960560,87.982178,87.957968};
    double []Tlat = {22.655039,22.752789,22.555350,25.322298,25.323187,25.322770,25.320658,25.320461,25.319050,25.318468,25.317081,25.316227,25.317740,25.315102,25.314591,25.314413,25.314047,25.313156,25.312896,25.312724,25.312465};
    double []Tlon = {88.357045,88.362251,88.331118,83.028875,83.030504,83.030003,83.026276,83.025836,83.023450,83.022140,83.020312,83.019459,83.018972,83.018246,83.017111,83.016814,83.016631,83.016303,83.016120,83.015925,83.015684};
    double []Flat = {22.580538,24.235386,22.362829,22.568048,22.700640,22.582535,22.551693,22.571741,25.098574,24.958514,25.098574,24.687398,24.685807,23.413877,23.371490,23.195462,23.174468,23.168474,23.158209,23.158209,22.976790,22.934297,22.926388,22.777603,22.559505,22.501030,22.447646,22.396478,22.359515,22.349102};
    double []Flon = {88.347314,88.260931,88.104890,88.341086,88.359680,88.343547,88.286091,88.335752,87.845560,87.979247,87.845560,87.955513,87.956485,87.431540,87.480437,87.912537,87.961483,87.959509,87.989426,87.989426,87.977494,87.976095,87.978065,87.987651,87.989648,87.959652,88.005190,88.045010,88.060336,88.087979};
    double []Nlat = {22.668437,22.668437,22.655912,22.587724,22.561741,22.680802,22.619424,22.897177,24.809222,24.685807,24.689459,28.744013,28.744013,28.710211,28.686037,28.676182,28.665313,28.664575,28.664443,28.664179,28.651204,28.513218,27.144215,23.679007,23.649913,23.371063,23.326720,23.297277,23.258675,23.223007,23.206577,22.915778,22.596794};
    double []Nlon = {88.351249,88.351249,88.356891,88.349784,88.335575,88.365195,88.368457,88.404181,87.918330,87.956485,87.965276,77.225492,77.225492,77.230030,77.232111,77.231906,77.237375,77.238863,77.239054,77.239474,77.266533,77.344453,83.759789,86.852829,86.876489,87.477900,87.500796,87.562162,87.597827,87.828765,87.883474,87.978569,87.982250};
    String []C={"Tribeni Burning Ghat_HWB","Gandheswari Burning Ghat_HWB","Halisahar Hindu Crematorium_HWB","Ramghat Samshan_HWB","Ghutiabazar Burning Ghat_HWB","Shyam Babur Ghat Crematorium_HWB","Boraichanditala Burning Ghat_HWB","Ballavpur Cremation Ghat_HWB","Mahesh Jagannath Cremation Ghat_HWB","Rishra Burning Ghat_HWB","Panihati Burning Ghat_HWB","Nangi Burning Ghat_HWB","Shibpur Burning Ghat_HWB","Nimtala Ghat Crematorium_HWB","Kashi Mitra Burning Ghat_HWB","Belur Burning Ghat_HWB","Sri Ram Krishna Maha Samshan_HWB","Bally Burning Ghat_HWB","Ariadaha Burning Ghat_HWB","Kiran Chandra Burning Ghat_MWB","Shamshaan Ghat_YDEL","Nigambodh Cremation Ghat_YDEL","Shamshaan Ghat Geeta Colony_YDEL","Kalindi Kunj Samshan Ghat_YDEL","Madanpur Khadar Samshan Ghat_YDEL","Dishergarh Sashan Ghat_DWB","Kalajharia Burning Ghat_DWB","Nimtala Sashan Ghat_DWB","Kanaria Samsan Ghat_DWB"};
    String []T={"Dakshineswar Ganga Ghat_HWB","Gandhi Ghat_HWB","James Prinsep Ghat_HWB","Nishadraj Ghat_GUP","Raj Ghat_GUP","Rani Ghat_GUP","Telianala Ghat_GUP","Sakka Ghat_GUP","Trilochan Ghat_GUP","Gaay Ghat_GUP","Sheetala Ghat_GUP","Bundi Parkota Ghat_GUP","Brahma Ghat_GUP","Panchganga Ghat_GUP","Jatar Ghat_GUP","Ram Ghat_GUP","Mehta Ghat_GUP","Naya Ghat_GUP","Bhonsale Ghat_GUP","Ganga Mahal Ghat_GUP","Sankatha Ghat_GUP"};
    String []F={"Armenian Ferry Ghat_HWB","Azimganj Ferry Ghat_HWB","Burul Ferry Ghat_HWB","Babughat_HWB","Ferry Ghat Konnagar_HWB","Howrah Ferry Ghat_HWB","Metiabruz Ferry Ghat_HWB","Ramkrishnapur Ghat_HWB","Bhutni Ferry Ghat_GWB","P.Narayanpur Lathipitta Ferry Ghat_GWB","Panchanandapur Ferry Ghat_GWB","Dhulian Ferry Terminal_GWB","Parlalpur Ferry Ghat_GWB","Shilampur Ferry Ghat_DWB","Randiha Ferry Ghat_DWB","Hijalna Ferry Ghat_DWB","Barsul Ferry Ghat_DWB","Shumbhupur Ferry Ghat_DWB","Jamudaha Ferry Ghat_DWB","Joyt Chand Ferry Ghat_DWB","Amarpur Ferry Ghat_DWB","Kali Tola Ferry Ghat_DWB","Anchal Ferry Ghat_DWB","Dehibhursut Jhanda Ferry Ghat_DWB","Nowpara Ferry Ghat_DWB","Purba Bainan Ferry Ghat_DWB","Kulitapara Ferry Ghat_DWB","Boalia Ferry Ghat_DWB","Madhabpur Ferry Ghat_DWB","Garchumuk Ferry Ghat_DWB"};
    String []N={"Doltala Ganga Ghat_HWB","Dutta Ghat_HWB","Ganga River Ghat_HWB","Jagannath Ghat_HWB","Judges Ghat of Ganges_HWB","Kamarhati Pituri Ghat_HWB","Sarbamangala Ghat_HWB","Mayurpankhi Ghat_HWB","Gandhi Ghat_GWB","Dhulian Ghat_GWB","Par Lalpur Ghat_GWB","Shyam Ghat Mandir_YDEL","Shyam Ghat_YDEL","Sur Ghat_YDEL","Ganpati Visarjan Ghat_YDEL","Dayadham Yamuna Aarti Ghat_YDEL","Ganesh Ghat_YDEL","Kashmiri Ghat_YDEL","Kashyap Ghat_YDEL","Yamuna Ghat_YDEL","Jamnapaar Ghat_YDEL","Vishwakrma Chatt Ghat_YDEL","Chatth Ghat_YDEL","Chinakuri Shiv Mandir Ram Ghat_DWB","Telkupi Barni Ghat_DWB","Randiha Ghat_DWB","Bhagloi Nadi Ghat_DWB","Babla Tola Ghat_DWB","Bali Ghat_DWB","Balamhat Bali Ghat_DWB","Srirampur Ghat_DWB","Jiara Ghat_DWB","Khaya Ghat_DWB"};
    float min;
    RadioButton r1,r2,r3,r4;
    int i = 0,flag=0;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
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
        setContentView(R.layout.activity_nearby);
        prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        editor = prefs.edit();
        b=findViewById(R.id.b);
        r1=findViewById(R.id.rd1);
        r2=findViewById(R.id.rd2);
        r3=findViewById(R.id.rd3);
        r4=findViewById(R.id.rd4);
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
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(r3.isChecked())
                {
                    if(x.equals(""))
                        Toast.makeText(getApplicationContext(),"Wait",Toast.LENGTH_SHORT).show();
                    else {
                        i = 0;
                        flag = 0;
                        Location location1 = new Location("");
                        int n=C.length;
                        final Float[] dis = new Float[n];
                        for (i = 0; i < n; i++) {
                            location1.setLatitude(Clat[i]);
                            location1.setLongitude(Clon[i]);
                            float distanceInMeters = (loc.distanceTo(location1));
                            dis[i] = distanceInMeters;
                        }
                        min = dis[0];
                        for (int i = 1; i < n; i++) {
                            if (min > dis[i]) {
                                min = dis[i];
                                flag = i;
                            }
                        }
                        // d = String.valueOf(min);
                        // k = String.valueOf(flag);
                        editor.putString("Name",C[flag]);
                        editor.apply();
                        String a=C[flag].substring(0,C[flag].length()-4);
                        Toast.makeText(getApplicationContext(),"Nearest Ghat is "+a+", Distance: "+String.valueOf(min/1000)+"Km",Toast.LENGTH_LONG).show();
                        Intent intent=new Intent(Nearby.this,DescriptionofGhtas.class);
                        startActivity(intent);
                    }
                }
                else if(r4.isChecked())
                {
                    if(x.equals(""))
                        Toast.makeText(getApplicationContext(),"Wait",Toast.LENGTH_LONG).show();
                    else {
                        i = 0;
                        flag = 0;
                        Location location1 = new Location("");
                        int n=T.length;
                        final Float[] dis = new Float[n];
                        for (i = 0; i < n; i++) {
                            location1.setLatitude(Tlat[i]);
                            location1.setLongitude(Tlon[i]);
                            float distanceInMeters = (loc.distanceTo(location1));
                            dis[i] = distanceInMeters;
                        }
                        min = dis[0];
                        for (int i = 1; i < n; i++) {
                            if (min > dis[i]) {
                                min = dis[i];
                                flag = i;
                            }
                        }
                        // d = String.valueOf(min);
                        // k = String.valueOf(flag);
                        editor.putString("Name",T[flag]);
                        editor.apply();
                        String a=T[flag].substring(0,T[flag].length()-4);
                        Toast.makeText(getApplicationContext(),"Nearest Ghat is "+a+" , Distance: "+String.valueOf(min/1000)+"Km",Toast.LENGTH_LONG).show();
                        //Toast.makeText(getApplicationContext(), T[flag], Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(Nearby.this,DescriptionofGhtas.class);
                        startActivity(intent);
                    }
                }
                else if(r1.isChecked())
                {
                    if(x.equals(""))
                        Toast.makeText(getApplicationContext(),"Wait",Toast.LENGTH_SHORT).show();
                    else {
                        i = 0;
                        flag = 0;
                        Location location1 = new Location("");
                        int n=F.length;
                        final Float[] dis = new Float[n];
                        for (i = 0; i < n; i++) {
                            location1.setLatitude(Flat[i]);
                            location1.setLongitude(Flon[i]);
                            float distanceInMeters = (loc.distanceTo(location1));
                            dis[i] = distanceInMeters;
                        }
                        min = dis[0];
                        for (int i = 1; i < n; i++) {
                            if (min > dis[i]) {
                                min = dis[i];
                                flag = i;
                            }
                        }
                        //d = String.valueOf(min);
                        // k = String.valueOf(flag);
                        editor.putString("Name",F[flag]);
                        editor.apply();
                        String a=F[flag].substring(0,F[flag].length()-4);
                        Toast.makeText(getApplicationContext(),"Nearest Ghat is "+a+" , Distance: "+String.valueOf(min/1000)+"Km",Toast.LENGTH_LONG).show();
                        Intent intent=new Intent(Nearby.this,DescriptionofGhtas.class);
                        startActivity(intent);
                    }
                }
                else if(r2.isChecked()){
                    if(x.equals(""))
                        Toast.makeText(getApplicationContext(),"Wait",Toast.LENGTH_SHORT).show();
                    else {
                        i = 0;
                        flag = 0;
                        Location location1 = new Location("");
                        int n=N.length;
                        final Float[] dis = new Float[n];
                        for (i = 0; i < n; i++) {
                            location1.setLatitude(Nlat[i]);
                            location1.setLongitude(Nlon[i]);
                            float distanceInMeters = (loc.distanceTo(location1));
                            dis[i] = distanceInMeters;
                        }
                        min = dis[0];
                        for (int i = 1; i < n; i++) {
                            if (min > dis[i]) {
                                min = dis[i];
                                flag = i;
                            }
                        }
                        // d = String.valueOf(min);
                        // k = String.valueOf(flag);
                        editor.putString("Name",N[flag]);
                        editor.apply();
                        String a=N[flag].substring(0,N[flag].length()-4);
                        Toast.makeText(getApplicationContext(),"Nearest Ghat is "+a+", Distance: "+String.valueOf(min/1000)+"Km",Toast.LENGTH_LONG).show();
                        Intent intent=new Intent(Nearby.this,DescriptionofGhtas.class);
                        startActivity(intent);
                    }
                }
                else
                    Toast.makeText(getApplicationContext(),"Not Selected",Toast.LENGTH_SHORT).show();
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
