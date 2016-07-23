package com.aftarobot.datamigrator.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aftarobot.datamigrator.R;
import com.aftarobot.library.data.RouteDTO;

import java.util.List;

/**
 * Created by aubreyM on 14/12/17.
 */
public class RouteAdapter extends RecyclerView.Adapter<RouteAdapter.RouteViewHolder> {

    public interface RouteListener {
        void onNameClicked(RouteDTO route);
        void onNumberClicked(RouteDTO route);
    }

    private RouteListener mListener;
    private List<RouteDTO> routes;

    public RouteAdapter(List<RouteDTO> routes, RouteListener listener) {
        this.routes = routes;
        this.mListener = listener;
    }

    @Override
    public RouteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.city_item, parent, false);
        return new RouteViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final RouteViewHolder holder, final int position) {

        final RouteDTO p = routes.get(position);
        holder.route.setText(p.getName());
        if (p.getLandmarks() != null) {
            holder.number.setText("" + p.getLandmarks().values().size());
        } else {
            holder.number.setText("0");
        }
        StringBuilder sb = new StringBuilder();
        if (p.getAssociationName() != null) {
            sb.append(p.getAssociationName());
        }
        if (p.getStatus() != null) {
            sb.append(" : ").append(p.getStatus());
        }
        holder.province.setText(sb.toString());


        holder.route.setOnClickListener(new View.OnClickListener() {
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
        return routes == null ? 0 : routes.size();
    }

    public class RouteViewHolder extends RecyclerView.ViewHolder {
        protected TextView route, province, number, label;


        public RouteViewHolder(View itemView) {
            super(itemView);
            route = (TextView) itemView.findViewById(R.id.name);
            province = (TextView) itemView.findViewById(R.id.province);
            number = (TextView) itemView.findViewById(R.id.number);
            label = (TextView) itemView.findViewById(R.id.countLabel);
            label.setText("Route Cities");
        }

    }

    static final String LOG = RouteAdapter.class.getSimpleName();
}
