package vidal.sergi.getfit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import vidal.sergi.getfit.Objetos.FirebaseReferences;

public class PierdePesoActivity2 extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pierde_peso2);
        crearDietaPierdePeso();

    }
    private void crearDietaPierdePeso(){
        Log.d("crearDietaPierdePeso","Se crea el grupo crearDietaPierdePeso");
        DatabaseReference myRef = database.getReference(FirebaseReferences.DIETA_PIERDE_PESO);
        myRef.child("Desayuno").child("NombrePlato1").setValue("café con leche desnatada");
        myRef.child("Desayuno").child("Calorias").setValue("200");


    }





}
