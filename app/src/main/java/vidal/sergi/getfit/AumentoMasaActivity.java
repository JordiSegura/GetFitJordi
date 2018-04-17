package vidal.sergi.getfit;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by alu2011187 on 09/04/2018.
 */

public class AumentoMasaActivity extends AppCompatActivity {
    Button mSexo;
    TextView txtSexoSeleccionado;
    String [] listSexos;
    boolean[] checkedItems;
    ArrayList<Integer> mUserItems = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aumento_masa);
        mSexo = findViewById(R.id.btnSexo);
        txtSexoSeleccionado = findViewById(R.id.txtSexoSeleccionado);
        listSexos = getResources().getStringArray(R.array.sexos);
        checkedItems = new boolean[listSexos.length];

        mSexo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(AumentoMasaActivity.this);
                AlertDialog.Builder builder =  mBuilder.setTitle("Selecciona tu sexo");
                mBuilder.setMultiChoiceItems(listSexos, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int position, boolean isChecked) {
                    if (isChecked) {
                        if (!mUserItems.contains(position)){
                            mUserItems.add(position);
                        }
                    }
                    else if (mUserItems.contains(position)){
                        mUserItems.remove(position);
                    }
                    }
                });
                mBuilder.setCancelable(false);
                mBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        String item = "";
                        for (int i = 0;i<mUserItems.size();i++){
                            item = item+listSexos[mUserItems.get(i)];
                            if ( i !=mUserItems.size()-1){
                                item = item + ",";
                            }
                        }
                        txtSexoSeleccionado.setText(item);

                    }
                });
                mBuilder.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                mBuilder.setNeutralButton("Clear All", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                         for (int i = 0; i<checkedItems.length;i++){
                             checkedItems[i] = false;
                             mUserItems.clear();
                             txtSexoSeleccionado.setText("");
                         }
                    }
                });
                AlertDialog mDialog = mBuilder.create();
                mDialog.show();
            }
        });
    }
}
