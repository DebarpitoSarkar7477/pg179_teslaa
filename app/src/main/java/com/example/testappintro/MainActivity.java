package com.example.testappintro;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    private ImageButton wb,up,jhr,bh,mp,hr,del,ut,hp,cg,rj;
    String river;
    private Button back2home;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    Spinner wbrvr;
    String riverWB[] = {"RIVERS","GANGA","DAMODAR","HOOGHLY","KASAI","MAHANANDA","MAYURAKSHI"};
    String riverBH[] = {"RIVERS","GANGA","GANDHAK","GHAGHARA","KOSI","BHURIGHANDHAK","SONE"};
    String riverDL[] = {"RIVERS","GANGA","KALI","YAMUNA","RAMGANGA"};
    String riverJH[] = {"RIVERS","GANGA","BURHI GANGA","FALGU","GHAGHARA","KALI GANDAKI","KARAMNASA","KIUL","KOSHI","MAHANANDA","PUNPUN","SONE"};
    String riverUP[] = {"RIVERS","GANGA","KALIGANDAK","GOMTI","GHAGHARA","RAMGANGA","TAMSA","YAMUNA"};
    String riverHA[] = {"RIVERS","YAMUNA"};
    String riverMP[] = {"RIVERS","SONE","TAMSA","TONS"};
    String riverUK[] = {"RIVERS","GANGA","RAMGANGA"};
    String riverHP[] = {"SELECT A RIVER"};
    String riverCG[] = {"SELECT A RIVER"};
    String riverRJ[] = {"SELECT A RIVER"};
    ArrayAdapter <String> adapter1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wb=findViewById(R.id.wbngl);
        up=findViewById(R.id.upd);
        jhr=findViewById(R.id.jhrkhnd);
        bh=findViewById(R.id.bhr);
        mp=findViewById(R.id.mpd);
        hr=findViewById(R.id.hrn);
        del=findViewById(R.id.delh);
        ut=findViewById(R.id.utk);
        hp=findViewById(R.id.hp);
        cg=findViewById(R.id.cg);
        rj=findViewById(R.id.rj);
        wbrvr=findViewById(R.id.wbs);
        prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        editor = prefs.edit();
        back2home=findViewById(R.id.back);

        wb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wbrvr=(Spinner)findViewById(R.id.wbs);
                adapter1=new ArrayAdapter<String >(getApplicationContext(),android.R.layout.simple_list_item_1,riverWB);
                wbrvr.setAdapter(adapter1);
                wbrvr.setVisibility(View.VISIBLE);
                back2home.setVisibility(View.VISIBLE);
                wb.setVisibility(View.GONE);
                up.setVisibility(View.GONE);
                jhr.setVisibility(View.GONE);
                bh.setVisibility(View.GONE);
                mp.setVisibility(View.GONE);
                hr.setVisibility(View.GONE);
                del.setVisibility(View.GONE);
                ut.setVisibility(View.GONE);
                wbrvr.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if(position>0) {
                            river=parent.getItemAtPosition(position).toString();
                            editor.putString("river",river+"_WB");
                            editor.apply();
                            Intent intent = new Intent(MainActivity.this, west_bengal.class);
                            startActivity(intent);
                            MainActivity.this.finish();
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }
        });
        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wbrvr=(Spinner)findViewById(R.id.wbs);
                adapter1=new ArrayAdapter<String >(getApplicationContext(),android.R.layout.simple_list_item_1,riverUP);
                wbrvr.setAdapter(adapter1);
                wbrvr.setVisibility(View.VISIBLE);
                back2home.setVisibility(View.VISIBLE);
                wb.setVisibility(View.GONE);
                up.setVisibility(View.GONE);
                jhr.setVisibility(View.GONE);
                bh.setVisibility(View.GONE);
                mp.setVisibility(View.GONE);
                hr.setVisibility(View.GONE);
                del.setVisibility(View.GONE);
                ut.setVisibility(View.GONE);
                wbrvr.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if(position>0) {
                            river=parent.getItemAtPosition(position).toString();
                            editor.putString("river",river+"_UP");
                            editor.apply();
                            Intent intent = new Intent(MainActivity.this, west_bengal.class);
                            startActivity(intent);
                            MainActivity.this.finish();
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }
        });
        jhr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wbrvr=(Spinner)findViewById(R.id.wbs);
                adapter1=new ArrayAdapter<String >(getApplicationContext(),android.R.layout.simple_list_item_1,riverJH);
                wbrvr.setAdapter(adapter1);
                wbrvr.setVisibility(View.VISIBLE);
                back2home.setVisibility(View.VISIBLE);
                wb.setVisibility(View.GONE);
                up.setVisibility(View.GONE);
                jhr.setVisibility(View.GONE);
                bh.setVisibility(View.GONE);
                mp.setVisibility(View.GONE);
                hr.setVisibility(View.GONE);
                del.setVisibility(View.GONE);
                ut.setVisibility(View.GONE);
                wbrvr.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if(position>0) {
                            river=parent.getItemAtPosition(position).toString();
                            editor.putString("river",river+"_JHR");
                            editor.apply();
                            Intent intent = new Intent(MainActivity.this, west_bengal.class);
                            startActivity(intent);
                            MainActivity.this.finish();
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }
        });
        bh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wbrvr=(Spinner)findViewById(R.id.wbs);
                adapter1=new ArrayAdapter<String >(getApplicationContext(),android.R.layout.simple_list_item_1,riverBH);
                wbrvr.setAdapter(adapter1);
                wbrvr.setVisibility(View.VISIBLE);
                back2home.setVisibility(View.VISIBLE);
                wb.setVisibility(View.GONE);
                up.setVisibility(View.GONE);
                jhr.setVisibility(View.GONE);
                bh.setVisibility(View.GONE);
                mp.setVisibility(View.GONE);
                hr.setVisibility(View.GONE);
                del.setVisibility(View.GONE);
                ut.setVisibility(View.GONE);
                wbrvr.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if(position>0) {
                            river=parent.getItemAtPosition(position).toString();
                            editor.putString("river",river+"_BH");
                            editor.apply();
                            Intent intent = new Intent(MainActivity.this, west_bengal.class);
                            startActivity(intent);
                            MainActivity.this.finish();
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }
        });
        mp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wbrvr=(Spinner)findViewById(R.id.wbs);
                adapter1=new ArrayAdapter<String >(getApplicationContext(),android.R.layout.simple_list_item_1,riverMP);
                wbrvr.setAdapter(adapter1);
                wbrvr.setVisibility(View.VISIBLE);
                back2home.setVisibility(View.VISIBLE);
                wb.setVisibility(View.GONE);
                up.setVisibility(View.GONE);
                jhr.setVisibility(View.GONE);
                bh.setVisibility(View.GONE);
                mp.setVisibility(View.GONE);
                hr.setVisibility(View.GONE);
                del.setVisibility(View.GONE);
                ut.setVisibility(View.GONE);
                wbrvr.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if(position>0) {
                            river=parent.getItemAtPosition(position).toString();
                            editor.putString("river",river+"_MP");
                            editor.apply();
                            Intent intent = new Intent(MainActivity.this, west_bengal.class);
                            startActivity(intent);
                            MainActivity.this.finish();
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }
        });
        hr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wbrvr=(Spinner)findViewById(R.id.wbs);
                adapter1=new ArrayAdapter<String >(getApplicationContext(),android.R.layout.simple_list_item_1,riverHA);
                wbrvr.setAdapter(adapter1);
                wbrvr.setVisibility(View.VISIBLE);
                back2home.setVisibility(View.VISIBLE);
                wb.setVisibility(View.GONE);
                up.setVisibility(View.GONE);
                jhr.setVisibility(View.GONE);
                bh.setVisibility(View.GONE);
                mp.setVisibility(View.GONE);
                hr.setVisibility(View.GONE);
                del.setVisibility(View.GONE);
                ut.setVisibility(View.GONE);
                wbrvr.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if(position>0) {
                            river=parent.getItemAtPosition(position).toString();
                            editor.putString("river",river+"_HR");
                            editor.apply();
                            Intent intent = new Intent(MainActivity.this, west_bengal.class);
                            startActivity(intent);
                            MainActivity.this.finish();
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }
        });
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wbrvr=(Spinner)findViewById(R.id.wbs);
                adapter1=new ArrayAdapter<String >(getApplicationContext(),android.R.layout.simple_list_item_1,riverDL);
                wbrvr.setAdapter(adapter1);
                wbrvr.setVisibility(View.VISIBLE);
                back2home.setVisibility(View.VISIBLE);
                wb.setVisibility(View.GONE);
                up.setVisibility(View.GONE);
                jhr.setVisibility(View.GONE);
                bh.setVisibility(View.GONE);
                mp.setVisibility(View.GONE);
                hr.setVisibility(View.GONE);
                del.setVisibility(View.GONE);
                ut.setVisibility(View.GONE);
                wbrvr.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if(position>0) {
                            river=parent.getItemAtPosition(position).toString();
                            editor.putString("river",river+"_DEL");
                            editor.apply();
                            Intent intent = new Intent(MainActivity.this, west_bengal.class);
                            startActivity(intent);
                            MainActivity.this.finish();
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }
        });
        ut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wbrvr=(Spinner)findViewById(R.id.wbs);
                adapter1=new ArrayAdapter<String >(getApplicationContext(),android.R.layout.simple_list_item_1,riverUK);
                wbrvr.setAdapter(adapter1);
                wbrvr.setVisibility(View.VISIBLE);
                back2home.setVisibility(View.VISIBLE);
                wb.setVisibility(View.GONE);
                up.setVisibility(View.GONE);
                jhr.setVisibility(View.GONE);
                bh.setVisibility(View.GONE);
                mp.setVisibility(View.GONE);
                hr.setVisibility(View.GONE);
                del.setVisibility(View.GONE);
                ut.setVisibility(View.GONE);
                wbrvr.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if(position>0) {
                            river=parent.getItemAtPosition(position).toString();
                            editor.putString("river",river+"_UK");
                            editor.apply();
                            Intent intent = new Intent(MainActivity.this, west_bengal.class);
                            startActivity(intent);
                            MainActivity.this.finish();
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }
        });
        cg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wbrvr=(Spinner)findViewById(R.id.wbs);
                adapter1=new ArrayAdapter<String >(getApplicationContext(),android.R.layout.simple_list_item_1,riverCG);
                wbrvr.setAdapter(adapter1);
                wbrvr.setVisibility(View.VISIBLE);
                back2home.setVisibility(View.VISIBLE);
                wb.setVisibility(View.GONE);
                up.setVisibility(View.GONE);
                jhr.setVisibility(View.GONE);
                bh.setVisibility(View.GONE);
                mp.setVisibility(View.GONE);
                hr.setVisibility(View.GONE);
                del.setVisibility(View.GONE);
                ut.setVisibility(View.GONE);
                cg.setVisibility(View.GONE);
                hp.setVisibility(View.GONE);
                rj.setVisibility(View.GONE);
                wbrvr.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if(position>0) {
                            river=parent.getItemAtPosition(position).toString();
                            editor.putString("river",river+"_CG");
                            editor.apply();
                            Intent intent = new Intent(MainActivity.this, west_bengal.class);
                            startActivity(intent);
                            MainActivity.this.finish();
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }
        });
        hp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wbrvr=(Spinner)findViewById(R.id.wbs);
                adapter1=new ArrayAdapter<String >(getApplicationContext(),android.R.layout.simple_list_item_1,riverHP);
                wbrvr.setAdapter(adapter1);
                wbrvr.setVisibility(View.VISIBLE);
                back2home.setVisibility(View.VISIBLE);
                wb.setVisibility(View.GONE);
                up.setVisibility(View.GONE);
                jhr.setVisibility(View.GONE);
                bh.setVisibility(View.GONE);
                mp.setVisibility(View.GONE);
                hr.setVisibility(View.GONE);
                del.setVisibility(View.GONE);
                ut.setVisibility(View.GONE);
                cg.setVisibility(View.GONE);
                hp.setVisibility(View.GONE);
                rj.setVisibility(View.GONE);
                wbrvr.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if(position>0) {
                            river=parent.getItemAtPosition(position).toString();
                            editor.putString("river",river+"_CG");
                            editor.apply();
                            Intent intent = new Intent(MainActivity.this, west_bengal.class);
                            startActivity(intent);
                            MainActivity.this.finish();
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }
        });
        rj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wbrvr=(Spinner)findViewById(R.id.wbs);
                adapter1=new ArrayAdapter<String >(getApplicationContext(),android.R.layout.simple_list_item_1,riverRJ);
                wbrvr.setAdapter(adapter1);
                wbrvr.setVisibility(View.VISIBLE);
                back2home.setVisibility(View.VISIBLE);
                wb.setVisibility(View.GONE);
                up.setVisibility(View.GONE);
                jhr.setVisibility(View.GONE);
                bh.setVisibility(View.GONE);
                mp.setVisibility(View.GONE);
                hr.setVisibility(View.GONE);
                del.setVisibility(View.GONE);
                ut.setVisibility(View.GONE);
                cg.setVisibility(View.GONE);
                hp.setVisibility(View.GONE);
                rj.setVisibility(View.GONE);
                wbrvr.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        if(position>0) {
                            river=parent.getItemAtPosition(position).toString();
                            editor.putString("river",river+"_CG");
                            editor.apply();
                            Intent intent = new Intent(MainActivity.this, west_bengal.class);
                            startActivity(intent);
                            MainActivity.this.finish();
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }
        });
        back2home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wbrvr.setVisibility(View.GONE);
                back2home.setVisibility(View.GONE);
                wb.setVisibility(View.VISIBLE);
                up.setVisibility(View.VISIBLE);
                jhr.setVisibility(View.VISIBLE);
                bh.setVisibility(View.VISIBLE);
                mp.setVisibility(View.VISIBLE);
                hr.setVisibility(View.VISIBLE);
                del.setVisibility(View.VISIBLE);
                ut.setVisibility(View.VISIBLE);

            }
        });


    }

}
