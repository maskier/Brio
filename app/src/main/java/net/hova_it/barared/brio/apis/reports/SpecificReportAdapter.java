package net.hova_it.barared.brio.apis.reports;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import net.hova_it.barared.brio.R;
import net.hova_it.barared.brio.apis.models.entities.Reporte;

import java.util.ArrayList;
import java.util.List;


public class SpecificReportAdapter extends RecyclerView.Adapter<SpecificReportAdapter.SpecificReportViewholder>{

    private Context context;
    private List<Reporte> specific_report_entries;



    public SpecificReportAdapter(Context context,List<Reporte> specific_report_entries) {
        this.context = context;
        this.specific_report_entries = specific_report_entries;

    }

    @Override
    public SpecificReportViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View vitem = LayoutInflater.from(context).inflate(R.layout.report_specfic_entry_row,parent,false);

        return new SpecificReportViewholder(vitem);
    }

    @Override
    public void onBindViewHolder(SpecificReportViewholder holder, int position) {
        Log.w("SpecificAdapter","SpecificReportViewholder Setting data to row ");

        Reporte reporteHoleder = specific_report_entries.get(position);
        holder.reporte = reporteHoleder;
        holder.posicion=position;
        holder.hora.setText(reporteHoleder.getHora());
        holder.cantidad.setText(reporteHoleder.getCantidad());
        holder.descripcion.setText(reporteHoleder.getDescripcionItem());

    }

    @Override
    public int getItemCount() {
        return /*specific_report_entries == null? 0:*/specific_report_entries.size();
    }


    public void setData(List<Reporte> data) {
        if (data != null) {
            specific_report_entries = new ArrayList<>();
            specific_report_entries.addAll(data);
            Log.w("ReporteSpecificAdapter","setData null");
        }
        Log.w("ReporteSpecificAdapter","setData not null");
        this.notifyDataSetChanged();
    }

    public class SpecificReportViewholder extends RecyclerView.ViewHolder {

        private TextView hora,cantidad,descripcion;
        public int posicion;
        public Reporte reporte;

        public SpecificReportViewholder(View itemView) {
            super(itemView);
            hora = (TextView) itemView.findViewById(R.id.reporte_specific_hora);
            cantidad = (TextView) itemView.findViewById(R.id.reporte_specific_cantidad);
            descripcion = (TextView) itemView.findViewById(R.id.reporte_specific_descripcion);


        }
    }
}
