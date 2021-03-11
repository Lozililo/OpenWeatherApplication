package com.example.dvtweatherapplication.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dvtweatherapplication.Model.ForecastData;
import com.example.dvtweatherapplication.R;

import java.util.List;
public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastViewHolder> {

    private List<ForecastData> forecastDataList;

    public ForecastAdapter(List<ForecastData> forecastDataList) {
        this.forecastDataList = forecastDataList;
    }
    @NonNull
    @Override
    public ForecastViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.forecast_card, viewGroup, false);
        return new ForecastViewHolder( itemView);

    }

    @Override
    public void onBindViewHolder(ForecastViewHolder holder, int position) {
        ForecastData forecastData=forecastDataList.get(position);
        holder.temperature.setText(forecastData.getTeemperature());
        holder.weekday.setText(forecastData.getWeekday());
    }

    @Override
    public int getItemCount() {
        return forecastDataList.size();
    }


    class ForecastViewHolder extends RecyclerView.ViewHolder {

        TextView temperature, weekday;

        ForecastViewHolder(View view) {
            super(view);
            temperature = view.findViewById(R.id.current_temperature);
            weekday = view.findViewById(R.id.weekday);

        }
    }
}


