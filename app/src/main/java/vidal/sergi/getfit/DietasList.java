package vidal.sergi.getfit;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import vidal.sergi.getfit.Objetos.Dietas;

/**
 * Created by jordi on 24/03/2018.
 */

public class DietasList extends ArrayAdapter<Dietas> {
    private Activity context;
    private List<Dietas>  dietList;
    public DietasList(Activity context,List<Dietas> dietList){
        super(context,R.layout.list_layout,dietList);
        this.context = context;
        this.dietList = dietList;
    }

    @Override
    public View getView(int position, View convertView,ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_layout,null,true);
        TextView txtNombre = (TextView) listViewItem.findViewById(R.id.txtnombre);
        TextView txtCalorias = (TextView) listViewItem.findViewById(R.id.txtcalorias);
        Dietas dietas = dietList.get(position);
        txtNombre.setText(dietas.getNombre());
        txtCalorias.setText(dietas.getCalorias());
        return listViewItem;
    }

}
