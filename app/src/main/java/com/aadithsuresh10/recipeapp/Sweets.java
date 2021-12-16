package com.aadithsuresh10.recipeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Sweets extends AppCompatActivity {

    int images[]={R.drawable.ppfull2,R.drawable.gulabjamun,R.drawable.rasgulla,R.drawable.motichoor_ladoo,R.drawable.rkesari,R.drawable.peda,R.drawable.rasmalai1,R.drawable.kaju_katli,R.drawable.halwa};
    String names[]={"Payasam","Gulab Jamun","Rasagulla","Motichoor Laddu","Kesari","Peda","Rasmaalai","Kaju Katli","Halwa"};
    String desc[]={"payasam","gulab","rasagula","motichoor","rkesari","peda","rasma","kajukatli","halwa"};

    List<itemsModel> itemList=new ArrayList<>();

    GridView gridview;
    CustomAdapter customAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sweets);
        gridview = findViewById(R.id.gridview);
        for (int i = 0; i < names.length; i++) {
            itemsModel itemsModel = new itemsModel(names[i], desc[i], images[i]);
            itemList.add(itemsModel);
        }

        customAdapter = new CustomAdapter(itemList, this);
        gridview.setAdapter(customAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        MenuItem menuItem=menu.findItem(R.id.search_view);
        SearchView searchView=(SearchView) menuItem.getActionView();
        searchView.setQueryHint("Search Here");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                customAdapter.getFilter().filter(s);
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.search_view){
            return true;
        }

        if(id == R.id.contactUs)
        {

            Intent intent1 = new Intent(getApplicationContext(),ContactUS.class);
            startActivity(intent1);
        }
        else if(id == R.id.aboutUs)
        {

            Intent intent1 = new Intent(getApplicationContext(),AboutUs.class);
            startActivity(intent1);
        }

        else if(id == R.id.logout)
        {

            AlertDialog.Builder alertDialog = new AlertDialog.Builder(Sweets.this);
            alertDialog.setTitle("Confirm Delete"); // Setting Dialog Title
            alertDialog.setMessage("Are you sure you want delete this?");// Setting Dialog Message
            alertDialog.setIcon(R.drawable.ic_baseline_delete_24);// Setting Icon to Dialog
            alertDialog.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int which) {
                    Toast.makeText(getApplicationContext(), "You clicked on YES : " , Toast.LENGTH_SHORT).show();
                    Intent intent1 = new Intent(getApplicationContext(),Login.class);
                    startActivity(intent1);
                }
            });
            alertDialog.setNegativeButton("no", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int which) {
                    Toast.makeText(getApplicationContext(), "Good choice..." , Toast.LENGTH_SHORT).show();
                }
            });
            alertDialog.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int which) {
                    Toast.makeText(getApplicationContext(), "You clicked on Cancel : " , Toast.LENGTH_SHORT).show();
                }
            });
            alertDialog.show();
        }
        else if(id == R.id.home)
        {

            Intent intent1 = new Intent(getApplicationContext(),MainActivity3.class);
            startActivity(intent1);
        }
        else if(id == R.id.settings)
        {
            Intent intent = new Intent(Settings.ACTION_APPLICATION_SETTINGS);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }

        }
        else if(id == R.id.changeTheme)
        {
            String cur = "n";
            if(AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_NO)
            {
                cur = "y";
            }
            else
            {
                cur = "n";
            }

            if(cur == "y")
            {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                restartApp();
            }
            else
            {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                restartApp();
            }
        }
        return super.onOptionsItemSelected(item);
    }
    public class CustomAdapter extends BaseAdapter implements Filterable
    {
        private List<itemsModel>itemsModelList;
        private List<itemsModel>itemsModelListFiltered;
        private Context context;
        public CustomAdapter(List<itemsModel> itemsModelList, Context context)
        {
            this.itemsModelList = itemsModelList;
            this.itemsModelListFiltered=itemsModelList;
            this.context = context;
        }
        @Override
        public int getCount() {
            return itemsModelListFiltered.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int position, View convertview, ViewGroup parent) {

            View view=getLayoutInflater().inflate(R.layout.rowitems,null);

            ImageView imageView=view.findViewById(R.id.imageview);
            TextView tvNames=view.findViewById(R.id.tvname);


            imageView.setImageResource(itemsModelListFiltered.get(position).getImage());
            tvNames.setText(itemsModelListFiltered.get(position).getName());

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getApplicationContext(),Payasam.class);
                    startActivity(intent);
                }
            });

            return view;
        }

        @Override
        public Filter getFilter() {
            Filter filter = new Filter() {
                @Override
                protected FilterResults performFiltering(CharSequence constraint) {
                    FilterResults filterResults = new FilterResults();
                    if (constraint == null || constraint.length() == 0) {
                        filterResults.count = itemsModelList.size();
                        filterResults.values = itemsModelList;
                    }
                    else
                        {
                        String searchStr = constraint.toString().toLowerCase();
                        List<itemsModel> resultData = new ArrayList<>();
                        for (itemsModel itemsModel : itemsModelList) {
                            if (itemsModel.getName().contains(searchStr) || itemsModel.getDesc().contains(searchStr)) {
                                resultData.add(itemsModel);
                            }
                            filterResults.count = resultData.size();
                            filterResults.values = resultData;
                        }
                    }
                    return filterResults;
                }

                @Override
                protected void publishResults(CharSequence constraint, FilterResults results) {
                    itemsModelListFiltered=(List<itemsModel>) results.values;
                    notifyDataSetChanged();
                }
            };
            return filter;
        }


    }

    public void restartApp()
    {
        Intent i = new Intent(getApplicationContext(),VegDishes.class);
        startActivity(i);
        finish();
    }


}