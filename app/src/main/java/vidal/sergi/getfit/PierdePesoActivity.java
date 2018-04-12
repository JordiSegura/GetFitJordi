package vidal.sergi.getfit;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by alu2011187 on 09/04/2018.
 */

public class PierdePesoActivity extends AppCompatActivity {
    TextView final_result;
    private static SeekBar seekBar;
    private static TextView text_view;
    Button mSexo;
    TextView txtSexoSeleccionado;
    String [] listSexos;
    boolean[] checkedItems;
    ArrayList<Integer> mUserItems = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pierde_peso);
        final_result = findViewById(R.id.result_text);
        final_result.setEnabled(false);
        seekBar();
        mSexo = findViewById(R.id.btnSexo);
        txtSexoSeleccionado = findViewById(R.id.txtSexoSeleccionado);
        listSexos = getResources().getStringArray(R.array.sexos);
        checkedItems = new boolean[listSexos.length];

        mSexo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(PierdePesoActivity.this);
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
    public void seekBar(){
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        text_view = findViewById(R.id.textView5);
        text_view.setText("Covered: "+seekBar.getProgress()+"/"+seekBar.getMax());
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress_value;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            progress_value = progress;
                text_view.setText("Covered: "+progress+"/"+seekBar.getMax());
                Toast.makeText(PierdePesoActivity.this,"SeekBar in progress",Toast.LENGTH_LONG).show();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(PierdePesoActivity.this,"SeekBar in progress",Toast.LENGTH_LONG).show();


            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                text_view.setText("Indica tu peso actual: "+progress_value+" kg"+"/"+seekBar.getMax()+" kg");
                Toast.makeText(PierdePesoActivity.this,"SeekBar in progress",Toast.LENGTH_LONG).show();



            }
        });
    }

}
