package vidal.sergi.getfit;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import vidal.sergi.getfit.Objetos.Dietas;
import vidal.sergi.getfit.Objetos.FirebaseReferences;

/**
 * Created by jordi on 15/03/2018.
 */

public class CrearDietaActivity extends AppCompatActivity {

    EditText nombreIngrediente;
    EditText calorias;
    Button save;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creardieta_activity);
        final BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_home:
                        //   Toast.makeText(HomeActivity.this,"Action home clicked",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(CrearDietaActivity.this,HomeActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.action_rutinas:
                        //  Toast.makeText(HomeActivity.this,"Action rutinas clicked",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_dietas:
                        Intent intent2 = new Intent(CrearDietaActivity.this,DietasActivity.class);
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

        nombreIngrediente = findViewById(R.id.nombreIngrediente);
        calorias = findViewById(R.id.calorias);
        save = findViewById(R.id.save);
        String n = nombreIngrediente.toString();
        Log.d("TEXTO",n);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("BUTTON","onCLick()");
                Toast.makeText(CrearDietaActivity.this,"Plato guardado correctamente",Toast.LENGTH_SHORT).show();

                String nombre = nombreIngrediente.getText().toString();
                String kcal = calorias.getText().toString();
                int cal = Integer.parseInt(kcal);
                registrar(nombre,cal);
                crearGrupo1Ingredientes();
                crearGrupo2Ingredientes();
                crearGrupo3Ingredientes();
                crearGrupo4Ingredientes();
                crearGrupo5Ingredientes();
                crearGrupo6Ingredientes();
                crearGrupo7Ingredientes();
                Intent intent = new Intent(CrearDietaActivity.this, DietasActivity.class);
                startActivity(intent);}
        });


    }

    private void registrar(String nombre, Integer cal){
        Log.d("SESION", "nuevoplato()");
        DatabaseReference myRef = database.getReference(FirebaseReferences.INGREDIENTES_REFERENCE);
        myRef.child("PlatoDia1").child("Calorias").setValue("'"+cal+"'");
        myRef.child("PlatoDia1").child("Nombre").setValue(nombre);



    }
    private void crearGrupo1Ingredientes(){
        Log.d("LecheQuesoYogur","Se crea el grupo 1 de alimentos");
        DatabaseReference myRef = database.getReference(FirebaseReferences.GRUPOS_REFERENCE);
        myRef.child("Lacteos").child("Leche").child("Calorias").setValue("23");
        myRef.child("Lacteos").child("Queso").child("Calorias").setValue("23");
        myRef.child("Lacteos").child("Yogur").child("Calorias").setValue("23");

    }
    private void crearGrupo2Ingredientes(){
        Log.d("CarneHuevoPescado","Se crea el grupo 2 de alimentos");
        DatabaseReference myRef = database.getReference(FirebaseReferences.GRUPOS_REFERENCE);
        myRef.child("Proteinas animales").child("Carne").child("Calorias").setValue("23");
        myRef.child("Proteinas animales").child("Huevo").child("Calorias").setValue("23");
        myRef.child("Proteinas animales").child("Pescado").child("Calorias").setValue("23");

    }
    private void crearGrupo3Ingredientes(){
        Log.d("PatatsLegumbrsFrutsSecs","Se crea el grupo 3 de alimentos");
        DatabaseReference myRef = database.getReference(FirebaseReferences.GRUPOS_REFERENCE);
        myRef.child("Proteinas vegetales").child("Patatas").child("Calorias").setValue("23");
        myRef.child("Proteinas vegetales").child("Legumbres").child("Calorias").setValue("23");
        myRef.child("Proteinas vegetales").child("Frutos secos").child("Calorias").setValue("23");

    }
    private void crearGrupo4Ingredientes(){
        Log.d("VerdurasHortalizas","Se crea el grupo 4 de alimentos");
        DatabaseReference myRef = database.getReference(FirebaseReferences.GRUPOS_REFERENCE);
        myRef.child("Vitaminas").child("Verduras").child("Calorias").setValue("23");
        myRef.child("Vitaminas").child("Hortalizas").child("Calorias").setValue("23");
    }
    private void crearGrupo5Ingredientes(){
        Log.d("Frutas","Se crea el grupo 5 de alimentos");
        DatabaseReference myRef = database.getReference(FirebaseReferences.GRUPOS_REFERENCE);
        myRef.child("Vitaminas").child("Frutas").child("Calorias").setValue("23");
    }
    private void crearGrupo6Ingredientes(){
        Log.d("PanPastaCerealesAzucar","Se crea el grupo 6 de alimentos");
        DatabaseReference myRef = database.getReference(FirebaseReferences.GRUPOS_REFERENCE);

        myRef.child("Carbohidratos").child("Pan y Pasta").child("Calorias").setValue("23");
        myRef.child("Carbohidratos").child("Cereales").child("Calorias").setValue("23");
        myRef.child("Carbohidratos").child("Azucar").child("Calorias").setValue("23");


    }
    private void crearGrupo7Ingredientes(){
        Log.d("GrasaAceiteMantequilla","Se crea el grupo 7 de alimentos");
        DatabaseReference myRef = database.getReference(FirebaseReferences.GRUPOS_REFERENCE);
        myRef.child("Lípidos").child("Grasa y aceite").child("Calorias").setValue("23");
        myRef.child("Lípidos").child("Mantequilla").child("Calorias").setValue("23");


    }
}
