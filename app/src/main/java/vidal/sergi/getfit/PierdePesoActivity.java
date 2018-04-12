package vidal.sergi.getfit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by alu2011187 on 09/04/2018.
 */

public class PierdePesoActivity extends AppCompatActivity {
    TextView final_result;
    private static SeekBar seekBar;
    private static TextView text_view;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pierde_peso);
        final_result = findViewById(R.id.result_text);
        final_result.setEnabled(false);
        seekBar();

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
                text_view.setText("Covered: "+progress_value+"/"+seekBar.getMax());
                Toast.makeText(PierdePesoActivity.this,"SeekBar in progress",Toast.LENGTH_LONG).show();



            }
        });
    }
    public void selectSexo(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()){
            case R.id.Hombre:
                if (checked){
                final_result.setText("Has seleccionado hombre");
           // final_result.setEnabled(true);
                }
            else {
                    final_result.setEnabled(false);

                }
            break;
            case R.id.Mujer:
                if (checked){
                final_result.setText("Has seleccionado Mujer");
            //final_result.setEnabled(true);
                    }
            else{
                    final_result.setEnabled(false);

                }
                break;

        }

    }
}
