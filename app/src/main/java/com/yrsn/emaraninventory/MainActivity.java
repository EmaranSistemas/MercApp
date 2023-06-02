package com.yrsn.emaraninventory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.yrsn.emaraninventory.mercapp.MyAdapter;
import com.yrsn.emaraninventory.mercapp.smercados.s_metro;
import com.yrsn.emaraninventory.mercapp.smercados.s_super;
import com.yrsn.emaraninventory.mercapp.smercados.s_tottus;
import com.yrsn.emaraninventory.mercapp.smercados.sc_franco;
import com.yrsn.emaraninventory.mercapp.smercados.sp_peruanos;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ImageView menu;
    LinearLayout home,settings,share,about,logout,mercap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawerLayout);

        menu = findViewById(R.id.menu);
        home = findViewById(R.id.home);
        about = findViewById(R.id.about);
        settings = findViewById(R.id.settings);
        share = findViewById(R.id.share);
        logout = findViewById(R.id.logout);
        mercap = findViewById(R.id.store);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDrawer(drawerLayout);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(MainActivity.this, MainActivity.class);
            }
        });

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(MainActivity.this, AboutActivity.class);
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(MainActivity.this, settingsActivity.class);
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(MainActivity.this, ShareActivity.class);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"logout",Toast.LENGTH_LONG).show();
            }
        });

        mercap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(MainActivity.this, MercappActivity.class);
            }
        });

    }

    public static void openDrawer(DrawerLayout drawerLayout)
    {
        drawerLayout.openDrawer(GravityCompat.START);
    }
    public static void closeDrawer(DrawerLayout drawerLayout)
    {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public static void redirectActivity(Activity activity,Class secondActivity)
    {
        Intent intent = new Intent(activity,secondActivity);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
        activity.finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
        closeDrawer(drawerLayout);
    }
}

/*


    Button btn;
    private ListView listView;
    private List<String> names;


    @SuppressLint("WrongViewCast")

    // este el clasico

        listView = findViewById(R.id.listView);
        names = new ArrayList<String>();

        names.add("FRANCO SUPERMERCADOS");
        names.add("SUPERMERCADOS PERUANOS");
        names.add("HIPERMERCADOS TOTTUS");
        names.add("CENCOSUD RETAIL");
        names.add("REPRESENTACIONES INTERNACIONALES - EL SUPER");

        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,names);
        //listView.setAdapter(adapter);

        MyAdapter myAdapter= new MyAdapter(this,R.layout.list_item,names);
        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                if(names.get(position).equals("FRANCO SUPERMERCADOS")){
                    Intent intent = new Intent(MainActivity.this, sc_franco.class);
                    intent.putExtra("FRANCO",names.get(position));
                    startActivity(intent);
                }
                else if (names.get(position).equals("SUPERMERCADOS PERUANOS")) {
                    Intent intent = new Intent(MainActivity.this, sp_peruanos.class);
                    intent.putExtra("SPERUANOS",names.get(position));
                    startActivity(intent);

                }
                else if (names.get(position).equals("HIPERMERCADOS TOTTUS")) {
                    Intent intent = new Intent(MainActivity.this, s_tottus.class);
                    intent.putExtra("TOTTUS",names.get(position));
                    startActivity(intent);

                }
                else if (names.get(position).equals("CENCOSUD RETAIL")) {
                    Intent intent = new Intent(MainActivity.this, s_metro.class);
                    intent.putExtra("METRO",names.get(position));
                    startActivity(intent);

                }
                else if (names.get(position).equals("REPRESENTACIONES INTERNACIONALES - EL SUPER")) {
                    Intent intent = new Intent(MainActivity.this, s_super.class);
                    intent.putExtra("SUPER",names.get(position));
                    startActivity(intent);

                }else {
                    Toast.makeText(MainActivity.this,"No existe el mercado",Toast.LENGTH_LONG).show();
                }


            }
        });



 */