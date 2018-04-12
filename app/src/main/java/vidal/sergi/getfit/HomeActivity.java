package vidal.sergi.getfit;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Sergi on 02/03/2018.
 */
public class HomeActivity extends AppCompatActivity {
    FloatingActionButton fab_plus,fab_dietas;
    Animation FabOpen,FabClose,FabRClockwise,FabRanticlockwise;
    boolean isOpen = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        fab_plus = findViewById(R.id.fab_plus);
        fab_dietas = findViewById(R.id.fab_dietas);
        FabOpen = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_open);
        FabClose = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_close);
        FabRClockwise = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_clockwise);
        FabRanticlockwise = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_anticlockwise);
        fab_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOpen){
                    fab_dietas.startAnimation(FabClose);
                    fab_plus.startAnimation(FabRanticlockwise);
                    fab_dietas.setClickable(false);
                    isOpen = false;
                }
                else{
                    fab_dietas.startAnimation(FabOpen);
                    fab_plus.startAnimation(FabRClockwise);
                    fab_dietas.setClickable(true);
                    isOpen = true;
                }
            }
        });

        final BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_home:
                     //   Toast.makeText(HomeActivity.this,"Action home clicked",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(HomeActivity.this,HomeActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.action_rutinas:
                      //  Toast.makeText(HomeActivity.this,"Action rutinas clicked",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_dietas:
                        Intent intent2 = new Intent(HomeActivity.this,DietasActivity.class);
                        startActivity(intent2);
                       // Toast.makeText(HomeActivity.this,"Action remove clicked",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_ajustes:
                       // Toast.makeText(HomeActivity.this,"Action remove clicked",Toast.LENGTH_SHORT).show();
                        break;
                }
                return true; }});
    }
}
