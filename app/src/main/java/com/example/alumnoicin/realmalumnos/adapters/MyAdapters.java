package com.example.alumnoicin.realmalumnos.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alumnoicin.realmalumnos.R;
import com.example.alumnoicin.realmalumnos.models.alumno;

import java.util.List;

public class MyAdapters extends BaseAdapter {
    private List<alumno> list;
    private int layout;
    private Context context;

    public MyAdapters(List<alumno> list, int layout, Context context) {
        this.list = list;
        this.layout = layout;
        this.context = context;
    }





    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh;
        if (convertView == null) {

            convertView = LayoutInflater.from(context).inflate(layout, null);
            vh = new ViewHolder();
            vh.id = (TextView) convertView.findViewById(R.id.textView_id);
            vh.rut = (TextView) convertView.findViewById(R.id.textView_rut);
            vh.nombre = (TextView) convertView.findViewById(R.id.textView_nombre);
            vh.apellido = (TextView) convertView.findViewById(R.id.textView_apellido);
            vh.edad = (TextView) convertView.findViewById(R.id.textView_edad);
            vh.carrera = (TextView) convertView.findViewById(R.id.textView_carrera);
            vh.semestre = (TextView) convertView.findViewById(R.id.textView_semestre);
            vh.ano = (TextView) convertView.findViewById(R.id.textView_ano);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();

        }
        alumno p = list.get(position);
        vh.id.setText(p.getId() + "");
        vh.rut.setText(p.getRut() + "");
        vh.nombre.setText(p.getNombre());
        vh.apellido.setText(p.getApellido());
        vh.edad.setText(p.getEdad()+"");
        vh.ano.setText(p.getAno()+"");
        vh.carrera.setText(p.getCarrera());
        vh.semestre.setText(p.getSemestre());
       return convertView;
    }


    public class ViewHolder {
        TextView id;
        TextView rut;
        TextView nombre;
        TextView apellido;
        TextView edad;
        TextView carrera;
        TextView ano;
        TextView semestre;
    }
}
