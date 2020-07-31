package com.example.testappintro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class west_bengal extends AppCompatActivity implements RecyclerViewClickInterface{
        String river_name;
        String names[],address[];
        private RecyclerView recyclerView;
        private MyRecycleviewAdapter adapter;
        private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_west_bengal);
        river_name= PreferenceManager.getDefaultSharedPreferences(getApplicationContext()).getString("river","");
        ArrayList<Ghat_items>ghat_items=new ArrayList<>();
        if(river_name.equals("GANGA_WB")) {
            int n = 8;
            names = new String[n];
            address = new String[n];
            names = getResources().getStringArray(R.array.GANGA_WB);
            //address = getResources().getStringArray(R.array.GANGA_address);
            for (int i = 0; i < n; i++) {
                ghat_items.add(new Ghat_items(names[i],address[i]));
            }

        }
        else if(river_name.equals("HOOGHLY_WB"))
        {
            int n = 38;
            names = new String[n];
            address = new String[n];
            names = getResources().getStringArray(R.array.HOOGHLY_WB);
            //address = getResources().getStringArray(R.array.GANGA_address);
            for (int i = 0; i < n; i++) {
                ghat_items.add(new Ghat_items(names[i],address[i]));
            }
        }
        else if(river_name.equals("MAHANANDA_WB"))
        {
            int n = 1;
            names = new String[n];
            address = new String[n];
            names = getResources().getStringArray(R.array.MAHANANDA_WB);
            //address = getResources().getStringArray(R.array.GANGA_address);
            for (int i = 0; i < n; i++) {
                ghat_items.add(new Ghat_items(names[i],address[i]));
            }
        }
        else if(river_name.equals("DAMODAR_WB"))
        {
            int n = 31;
            names = new String[n];
            address = new String[n];
            names = getResources().getStringArray(R.array.DAMODAR_WB);
            //address = getResources().getStringArray(R.array.GANGA_address);
            for (int i = 0; i < n; i++) {
                ghat_items.add(new Ghat_items(names[i],address[i]));
            }
        }
        else if(river_name.equals("GANGA_BH"))
        {
            int n = 18;
            names = new String[n];
            address = new String[n];
            names = getResources().getStringArray(R.array.GANGA_BH);
            //address = getResources().getStringArray(R.array.GANGA_address);
            for (int i = 0; i < n; i++) {
                ghat_items.add(new Ghat_items(names[i],address[i]));
            }
        }
        else if(river_name.equals("GANDHAK_BH"))
        {
            int n = 7;
            names = new String[n];
            address = new String[n];
            names = getResources().getStringArray(R.array.GANDHAK_BH);
            //address = getResources().getStringArray(R.array.GANGA_address);
            for (int i = 0; i < n; i++) {
                ghat_items.add(new Ghat_items(names[i],address[i]));
            }
        }
        else if(river_name.equals("GHAGHARA_BH"))
        {
            int n = 5;
            names = new String[n];
            address = new String[n];
            names = getResources().getStringArray(R.array.GHAGHARA_BH);
            //address = getResources().getStringArray(R.array.GANGA_address);
            for (int i = 0; i < n; i++) {
                ghat_items.add(new Ghat_items(names[i],address[i]));
            }
        }
        else if(river_name.equals("KOSI_BH"))
        {
            int n = 2;
            names = new String[n];
            address = new String[n];
            names = getResources().getStringArray(R.array.KOSI_BH);
            //address = getResources().getStringArray(R.array.GANGA_address);
            for (int i = 0; i < n; i++) {
                ghat_items.add(new Ghat_items(names[i],address[i]));
            }
        }
        else if(river_name.equals("BHURIGHANDHAK_BH"))
        {
            int n = 5;
            names = new String[n];
            address = new String[n];
            names = getResources().getStringArray(R.array.BHURIGHANDHAK_BH);
            //address = getResources().getStringArray(R.array.GANGA_address);
            for (int i = 0; i < n; i++) {
                ghat_items.add(new Ghat_items(names[i],address[i]));
            }
        }
        else if(river_name.equals("GANGA_UP"))
        {
            int n = 35;
            names = new String[n];
            address = new String[n];
            names = getResources().getStringArray(R.array.GANGA_UP);
            //address = getResources().getStringArray(R.array.GANGA_address);
            for (int i = 0; i < n; i++) {
                ghat_items.add(new Ghat_items(names[i],address[i]));
            }
        }
        else if(river_name.equals("KALIGANDAK_UP"))
        {
            int n = 26;
            names = new String[n];
            address = new String[n];
            names = getResources().getStringArray(R.array.KALIGANDHAK_UP);
            //address = getResources().getStringArray(R.array.GANGA_address);
            for (int i = 0; i < n; i++) {
                ghat_items.add(new Ghat_items(names[i],address[i]));
            }
        }
        else if(river_name.equals("GOMTI_UP"))
        {
            int n = 12;
            names = new String[n];
            address = new String[n];
            names = getResources().getStringArray(R.array.GOMTI_UP);
            //address = getResources().getStringArray(R.array.GANGA_address);
            for (int i = 0; i < n; i++) {
                ghat_items.add(new Ghat_items(names[i],address[i]));
            }
        }
        else if(river_name.equals("GHAGHARA_UP"))
        {
            int n = 9;
            names = new String[n];
            address = new String[n];
            names = getResources().getStringArray(R.array.GHAGHARA_UP);
            //address = getResources().getStringArray(R.array.GANGA_address);
            for (int i = 0; i < n; i++) {
                ghat_items.add(new Ghat_items(names[i],address[i]));
            }
        }
        else if(river_name.equals("TAMSA_MP"))
        {
            int n = 10;
            names = new String[n];
            address = new String[n];
            names = getResources().getStringArray(R.array.TAMSA_MP);
            //address = getResources().getStringArray(R.array.GANGA_address);
            for (int i = 0; i < n; i++) {
                ghat_items.add(new Ghat_items(names[i],address[i]));
            }
        }
        else if(river_name.equals("YAMUNA_DEL"))
        {
            int n = 17;
            names = new String[n];
            address = new String[n];
            names = getResources().getStringArray(R.array.YAMUNA_DEL);
            //address = getResources().getStringArray(R.array.GANGA_address);
            for (int i = 0; i < n; i++) {
                ghat_items.add(new Ghat_items(names[i],address[i]));
            }
        }
        else if(river_name.equals("GANGA_UK"))
        {
            int n = 26;
            names = new String[n];
            address = new String[n];
            names = getResources().getStringArray(R.array.GANGA_UK);
            //address = getResources().getStringArray(R.array.GANGA_address);
            for (int i = 0; i < n; i++) {
                ghat_items.add(new Ghat_items(names[i],address[i]));
            }
        }
        else if(river_name.equals("GANGA_JHR"))
        {
            int n = 8;
            names = new String[n];
            address = new String[n];
            names = getResources().getStringArray(R.array.GANGA_JHR);
            //address = getResources().getStringArray(R.array.GANGA_address);
            for (int i = 0; i < n; i++) {
                ghat_items.add(new Ghat_items(names[i],address[i]));
            }
        }
        else if(river_name.equals("SONE_JHR"))
        {
            int n = 1;
            names = new String[n];
            address = new String[n];
            names = getResources().getStringArray(R.array.SONE_JHR);
            //address = getResources().getStringArray(R.array.GANGA_address);
            for (int i = 0; i < n; i++) {
                ghat_items.add(new Ghat_items(names[i],address[i]));
            }
        }
        else
            Toast.makeText(getApplicationContext(),"No data Found",Toast.LENGTH_SHORT).show();
        recyclerView = findViewById(R.id.listofghats);

        layoutManager = new LinearLayoutManager(this);
        adapter = new MyRecycleviewAdapter(ghat_items,this,west_bengal.this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu,menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }

    @Override
    public void onItemSelect(int position) {

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        west_bengal.this.finish();
    }
}
