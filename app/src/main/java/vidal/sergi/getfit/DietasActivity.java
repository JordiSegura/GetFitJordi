package vidal.sergi.getfit;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.github.clans.fab.FloatingActionMenu;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.wenchao.cardstack.CardStack;

import vidal.sergi.getfit.Objetos.Dietas;
import vidal.sergi.getfit.Objetos.FirebaseReferences;
import vidal.sergi.getfit.Objetos.HorizontalRVActivity;
import vidal.sergi.getfit.Tabs_ViewPager.Tab1;
import vidal.sergi.getfit.Tabs_ViewPager.Tab2;
import vidal.sergi.getfit.Tabs_ViewPager.Tab3;

/**
 * Created by jordi on 15/03/2018.
 */

public class DietasActivity extends AppCompatActivity implements Tab1.OnFragmentInteractionListener,Tab2.OnFragmentInteractionListener,Tab3.OnFragmentInteractionListener {

  FloatingActionMenu floatingActionMenu;
    com.github.clans.fab.FloatingActionButton op1,op2,op3;

    Button btnPierdePeso,btnAumentaMasa,btnSano;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_dietas);

        btnPierdePeso = findViewById(R.id.btnPierdePeso);
        btnAumentaMasa = findViewById(R.id.btnAumentaMasa);
        btnSano = findViewById(R.id.btnSano);
        op1 =  findViewById(R.id.floatingActionItem1);
        op2 =  findViewById(R.id.floatingActionItem2);
        op3 =  findViewById(R.id.floatingActionItem3);
        TabLayout tabLayout = findViewById(R.id.tablayout);
        tabLayout.addTab(tabLayout.newTab().setText(""));
        tabLayout.addTab(tabLayout.newTab().setText(""));
        tabLayout.addTab(tabLayout.newTab().setText(""));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        final ViewPager viewPager = findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

              /*  Log.d(String.valueOf(viewPager.getCurrentItem()), "onTabSelected: ");
                viewPager.getCurrentItem();
                switch (viewPager.getCurrentItem()){
                    case 0:Intent intent = new Intent(DietasActivity.this,PierdePesoActivity.class);
                    startActivity(intent);break;
                    case 1:Intent intent1 = new Intent(DietasActivity.this,AumentoMasaActivity.class);
                        startActivity(intent1);break;
                    case 2:Intent intent2 = new Intent(DietasActivity.this,MantenteSanoActivity.class);
                        startActivity(intent2);break;
                        }*/


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        op1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DietasActivity.this, HorizontalRVActivity.class);
                startActivity(intent);
            }
        });
        op2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DietasActivity.this, CrearDietaActivity.class);
                startActivity(intent);
            }
        });
        op3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DietasActivity.this, ConsultarDietasActivity.class);
                startActivity(intent);
            }
        });




        btnPierdePeso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DietasActivity.this, PierdePesoActivity.class);
                startActivity(intent);
            }
        });
        btnAumentaMasa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DietasActivity.this, AumentoMasaActivity.class);
                startActivity(intent);
            }
        });
        btnSano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DietasActivity.this, MantenteSanoActivity.class);
                startActivity(intent);
            }
        });



        final BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_home:
                        //   Toast.makeText(HomeActivity.this,"Action home clicked",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(DietasActivity.this,HomeActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.action_rutinas:
                        //  Toast.makeText(HomeActivity.this,"Action rutinas clicked",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_dietas:
                        Intent intent2 = new Intent(DietasActivity.this,DietasActivity.class);
                        startActivity(intent2);
                        // Toast.makeText(HomeActivity.this,"Action remove clicked",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_ajustes:
                        // Toast.makeText(HomeActivity.this,"Action remove clicked",Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });


    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}

