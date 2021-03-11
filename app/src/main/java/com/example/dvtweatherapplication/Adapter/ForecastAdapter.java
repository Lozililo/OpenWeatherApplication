package com.example.dvtweatherapplication.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dvtweatherapplication.R;
import com.kwabenaberko.openweathermaplib.model.threehourforecast.ThreeHourForecastWeather;

import java.util.List;
public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastViewHolder> {

    private List<ThreeHourForecastWeather> forecastDataList;

    public ForecastAdapter(List<ThreeHourForecastWeather> forecastDataList) {
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
        ThreeHourForecastWeather forecastData=forecastDataList.get(position);
        //holder.forecastTemp.setText((int) forecastDataList.get(position).getMain().getTemp());
        holder.weekday.setText(forecastDataList.get(position).getDtTxt());

    }

    @Override
    public int getItemCount() {
        return forecastDataList.size();
    }


    class ForecastViewHolder extends RecyclerView.ViewHolder {

        TextView forecastTemp, weekday;

        ForecastViewHolder(View view) {
            super(view);
            forecastTemp = view.findViewById(R.id.forecast_temperature);
            weekday = view.findViewById(R.id.weekday);

        }
    }
}


