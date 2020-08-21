package za.ac.iie.opsc.starsucks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,
        NavigationView.OnNavigationItemSelectedListener {

    // declare fields for the ImageViews
    private ImageView img_Sb1;
    private ImageView img_Sb2;
    private ImageView img_Sb3;
    private ImageView img_Sb4;
    private ImageView img_Sb5;
    private ImageView img_Sb6;
    private Order order;
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggleOnOff;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_with_nav_drawer);

        toolbar = findViewById(R.id.nav_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        drawerLayout = findViewById(R.id.drawer_layout);
        toggleOnOff = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggleOnOff);
        toggleOnOff.syncState();

        navigationView = findViewById(R.id.nav_view);
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);

        order = new Order();

        img_Sb1 = findViewById(R.id.img_sb1);
        img_Sb2 = findViewById(R.id.img_sb2);
        img_Sb3 = findViewById(R.id.img_sb3);
        img_Sb4 = findViewById(R.id.img_sb4);
        img_Sb5 = findViewById(R.id.img_sb5);
        img_Sb6 = findViewById(R.id.img_sb6);

        img_Sb1.setOnClickListener(this);
        img_Sb2.setOnClickListener(this);
        img_Sb3.setOnClickListener(this);
        img_Sb4.setOnClickListener(this);
        img_Sb5.setOnClickListener(this);
        img_Sb6.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        // if the drawer is open, close it
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            // otherwise, let the super class handle it
            super.onBackPressed();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.img_sb1:
                order.setProductName("Soy Latte");
                break;
            case R.id.img_sb2:
                order.setProductName("Chocco Frappe");
                break;
            case R.id.img_sb3:
                order.setProductName("Bottled Americano");
                break;
            case R.id.img_sb4:
                order.setProductName("Rainbow Frapp");
                break;
            case R.id.img_sb5:
                order.setProductName("Caramel Frapp");
                break;
            case R.id.img_sb6:
                order.setProductName("Black Forest Frapp");
                break;
        }
        Toast.makeText(MainActivity.this, "MMM " +
                order.getProductName(), Toast.LENGTH_SHORT).show();
        IntentHelper.openIntent(this,
                order.getProductName(), OrderDetailsActivity.class);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.nav_photo:
                IntentHelper.openIntent(this, "", CoffeeSnapsActivity.class);
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        // returning true marks the item as selected
        return true;
    }
}














