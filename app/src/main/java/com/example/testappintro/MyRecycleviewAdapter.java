package com.example.testappintro;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class
MyRecycleviewAdapter extends RecyclerView.Adapter<MyRecycleviewAdapter.View_holder> implements Filterable {
    private ArrayList<Ghat_items> ghat_items;
    private ArrayList<Ghat_items> ghat_itemsArrayList;
    private RecyclerViewClickInterface recyclerViewClickInterface;
    private Context context;
    String river_name,fil;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    public MyRecycleviewAdapter(ArrayList<Ghat_items>ghat_items, RecyclerViewClickInterface recyclerViewClickInterface, Context activity)
    {
        this.ghat_items=ghat_items;
        ghat_itemsArrayList=new ArrayList<>(ghat_items);
        this.recyclerViewClickInterface=recyclerViewClickInterface;
        this.context=activity;
    }
    @NonNull
    @Override
    public View_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_items,parent,false);
        View_holder view_holder=new View_holder(view);
        return view_holder;
    }

    @Override
    public void onBindViewHolder(@NonNull View_holder holder, int position) {
        final Ghat_items current_item=ghat_items.get(position);
        holder.ghatname.setText(current_item.getGhat_name());
        //holder.ghataddress.setText(current_item.getGhat_address());
        river_name= PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext()).getString("river","");
        prefs = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
        editor = prefs.edit();
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(river_name.equals("GANGA_WB"))
                    fil = current_item.getGhat_name() + "_GWB";
                else if(river_name.equals("HOOGHLY_WB"))
                    fil=current_item.getGhat_name()+"_HWB";
                else if(river_name.equals("MAHANANDA_WB"))
                    fil=current_item.getGhat_name()+"_MWB";
                else if(river_name.equals("DAMODAR_WB"))
                    fil=current_item.getGhat_name()+"_DWB";
                else if(river_name.equals("YAMUNA_DEL"))
                    fil=current_item.getGhat_name()+"_YDEL";
                else if(river_name.equals("GANGA_UP"))
                    fil=current_item.getGhat_name()+"_GUP";
                else if(river_name.equals("GANGA_BH"))
                    fil=current_item.getGhat_name()+"_GBH";
                editor.putString("Name",fil);
                editor.apply();
               // Toast.makeText(context, fil, Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(context,DescriptionofGhtas.class);
                context.startActivity(intent);
            }
        });
        /*holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,DescriptionofGhtas.class);
                context.startActivity(intent);
            }
        });*/

    }

    @Override
    public int getItemCount() {
        return ghat_items.size();
    }

    @Override
    public Filter getFilter() {
        return ghatFilter;
    }
    private Filter ghatFilter=new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<Ghat_items>filtered_list=new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filtered_list.addAll(ghat_itemsArrayList);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (Ghat_items item : ghat_itemsArrayList) {
                    if (item.getGhat_name().toLowerCase().contains(filterPattern)) {
                        filtered_list.add(item);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filtered_list;

            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            ghat_items.clear();
            ghat_items.addAll((ArrayList) filterResults.values);
            notifyDataSetChanged();

        }
    };

    public class View_holder extends RecyclerView.ViewHolder{
        public TextView ghatname;
        public TextView ghataddress;
        RelativeLayout parentLayout;


        public View_holder(@NonNull View itemView) {
            super(itemView);
            ghatname=itemView.findViewById(R.id.ghat_name);
            /*
            if(river_name.equals("GANGA_WB"))
                fil=ghatname+"_GWB";
            else if(river_name.equals("HOOGHLY_WB\""))
                fil=ghatname+"_HWB";
            else if(river_name.equals("MAHANANDA_WB"))
                fil=ghatname+"_MWB";
            else if(river_name.equals("DAMODAR_WB"))
                fil=ghatname+"_DWB";*/

           // ghataddress=itemView.findViewById(R.id.ghat_address);
            /*itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    recyclerViewClickInterface.onItemSelect(getAdapterPosition());
                }
            });*/
        }
    }
}
