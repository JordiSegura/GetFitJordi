package vidal.sergi.getfit;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.wenchao.cardstack.CardStack;

import vidal.sergi.getfit.Objetos.Dietas;
import vidal.sergi.getfit.Objetos.FirebaseReferences;
import vidal.sergi.getfit.Objetos.HorizontalRVActivity;

/**
 * Created by jordi on 15/03/2018.
 */

public class DietasActivity extends AppCompatActivity {

    Button btnañadirDieta;
    FloatingActionButton fab_plus,fab_dietas;
    Animation FabOpen,FabClose,FabRClockwise,FabRanticlockwise;
    boolean isOpen = false;
    Button btnconsultarDietas;

    Button crearPlato,btnPierdePeso,btnAumentaMasa,btnSano;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_dietas);

         btnañadirDieta = findViewById(R.id.newDieta);
         btnconsultarDietas = findViewById(R.id.consultarDietas);
        btnPierdePeso = findViewById(R.id.btnPierdePeso);
        btnAumentaMasa = findViewById(R.id.btnAumentaMasa);
        btnSano = findViewById(R.id.btnSano);
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



        crearPlato= findViewById(R.id.crearPlato);
        btnañadirDieta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DietasActivity.this, CrearDietaActivity.class);
                startActivity(intent);
            }
        });
        crearPlato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DietasActivity.this, HorizontalRVActivity.class);
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
        btnconsultarDietas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DietasActivity.this, ConsultarDietasActivity.class);
                startActivity(intent);
            }
        });

    }

}
