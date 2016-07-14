package com.aftarobot.datamigrator.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aftarobot.datamigrator.R;
import com.aftarobot.library.data.CityDTO;

import java.util.List;

/**
 * Created by aubreyM on 14/12/17.
 */
public class CityAdapter extends RecyclerView.Adapter<CityAdapter.CityViewHolder> {

    public interface CityListener {
        void onNameClicked(CityDTO city);
        void onNumberClicked(CityDTO city);
    }

    private CityListener mListener;
    private List<CityDTO> cities;

    public CityAdapter(List<CityDTO> cities, CityListener listener) {
        this.cities = cities;
        this.mListener = listener;
    }

    @Override
    public CityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.city_item, parent, false);
        return new CityViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final CityViewHolder holder, final int position) {

        final CityDTO p = cities.get(position);
        holder.city.setText(p.getName());
        if (p.getRoutes() != null) {
            holder.number.setText("" + p.getRoutes().values().size());
        } else {
            holder.number.setText("0");
        }
        StringBuilder sb = new StringBuilder();
        if (p.getProvinceName() != null) {
            sb.append(p.getProvinceName());
        }
        if (p.getCountryName() != null) {
            sb.append(" ").append(p.getCountryName());
        }
        holder.province.setText(sb.toString());


        holder.city.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onNameClicked(p);
            }
        });
        holder.province.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onNameClicked(p);
            }
        });
        holder.number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onNumberClicked(p);
            }
        });
        holder.label.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onNumberClicked(p);
            }
        });




    }

    @Override
    public int getItemCount() {
        return cities == null ? 0 : cities.size();
    }

    public class CityViewHolder extends RecyclerView.ViewHolder {
        protected TextView city, province, number, label;


        public CityViewHolder(View itemView) {
            super(itemView);
            city = (TextView) itemView.findViewById(R.id.name);
            province = (TextView) itemView.findViewById(R.id.province);
            number = (TextView) itemView.findViewById(R.id.number);
            label = (TextView) itemView.findViewById(R.id.countLabel);
            label.setText("Routes");
        }

    }

    static final String LOG = CityAdapter.class.getSimpleName();
}
