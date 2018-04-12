package vidal.sergi.getfit.Objetos;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import vidal.sergi.getfit.ConsultarDietasActivity;
import vidal.sergi.getfit.DietasList;
import vidal.sergi.getfit.R;
import vidal.sergi.getfit.RecyclerViewAdapter;

/**
 * Created by alu2011187 on 22/03/2018.
 */

public class HorizontalRVActivity extends AppCompatActivity {

    private static final String TAG = "HorizontalRVActivity";
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference myRef;
    ListView mListView;
    FirebaseDatabase database=FirebaseDatabase.getInstance();
    DatabaseReference databaseReference = database.getReference();
    DatabaseReference databaseDietas;
    List<Dietas> dietasList;

    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontalrvactivity);
        mListView = (ListView) findViewById(R.id.user_list);
        mFirebaseDatabase =FirebaseDatabase.getInstance();
        databaseDietas = FirebaseDatabase.getInstance().getReference("Ingredientes");
        dietasList = new ArrayList<>();
        myRef = mFirebaseDatabase.getReference("Ingredientes");
        getImages();

    }


    private void getImages(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mImageUrls.add("data:image/jpeg;base64,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");
        mNames.add("Desayunos");

        mImageUrls.add("https://res-2.cloudinary.com/sharecare/image/upload/c_fill,f_auto,g_faces:center,h_340,w_600/v1484937023/slideshows/satisfying-lunch-foods-nutritionist-10");
        mNames.add("Comida");

        mImageUrls.add("https://psicologiaymente.net/media/V4AD/yogur-almendras-merienda/default.jpg");
        mNames.add("Merienda");

        mImageUrls.add("https://www.ecestaticos.com/imagestatic/clipping/8b9/929/8b992907ccc0fab8e8cbcc3ac2bc039e/las-reglas-que-debes-seguir-cuando-vayas-a-una-cena-de-gala.jpg?mtime=1511364153");
        mNames.add("Cena");

        initRecyclerView();

    }
    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview");

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mNames, mImageUrls);
        recyclerView.setAdapter(adapter);
    }
    @Override
    protected void onStart() {
        //Recuperar datos! :)
        super.onStart();
        databaseDietas.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                dietasList.clear();
                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){
                    Dietas dietas = dataSnapshot1.getValue(Dietas.class);
                    dietasList.add(dietas);
                }
                DietasList adapter = new DietasList(HorizontalRVActivity.this,dietasList);
                mListView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}