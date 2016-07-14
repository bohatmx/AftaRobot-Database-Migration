package com.aftarobot.datamigrator.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aftarobot.datamigrator.R;
import com.aftarobot.library.data.TripDTO;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by aubreyM on 14/12/17.
 */
public class TripAdapter extends RecyclerView.Adapter<TripAdapter.TripViewHolder> {

    public interface TripListener {
        void onNameClicked(TripDTO trip);
        void onNumberClicked(TripDTO trip);
    }

    private TripListener mListener;
    private List<TripDTO> trips;

    public TripAdapter(List<TripDTO> trips, TripListener listener) {
        this.trips = trips;
        this.mListener = listener;
    }

    @Override
    public TripViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.trip_item, parent, false);
        return new TripViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final TripViewHolder holder, final int position) {

        final TripDTO p = trips.get(position);
        holder.city.setText(p.getCityName());
        holder.landmark.setText(p.getLandmarkName());
        holder.marshal.setText(p.getMarshalName());
        holder.vehicle.setText(p.getVehicleReg());
        holder.date.setText(sdf.format(new Date(p.getDateDispatched())));

    }

    @Override
    public int getItemCount() {
        return trips == null ? 0 : trips.size();
    }

    public class TripViewHolder extends RecyclerView.ViewHolder {
        protected TextView landmark, city, marshal, passengers, vehicle, date;


        public TripViewHolder(View itemView) {
            super(itemView);
            city = (TextView) itemView.findViewById(R.id.city);
            landmark = (TextView) itemView.findViewById(R.id.landmark);
            passengers = (TextView) itemView.findViewById(R.id.passengers);
            vehicle = (TextView) itemView.findViewById(R.id.vehicle);
            marshal = (TextView) itemView.findViewById(R.id.marshal);
            date = (TextView) itemView.findViewById(R.id.date);
        }

    }

    static final Locale loc = Locale.getDefault();
    static final SimpleDateFormat sdf = new SimpleDateFormat("EEEE, dd MMMM yyyy HH:mm", loc);
    static final String LOG = TripAdapter.class.getSimpleName();
}
