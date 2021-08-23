package com.kotlin.app_java;

import static com.kotlin.app_java.WeatherType.*;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.ViewHolder> {

    private List<Weather> weatherList = new ArrayList<>();

    public void setWeatherList(List<Weather> weatherList) {
        this.weatherList = weatherList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(weatherList.get(position));
    }

    @Override
    public int getItemCount() {
        return weatherList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        private void bind(Weather weather) {
            ((TextView) itemView.findViewById(R.id.town)).setText(weather.getTown());
            ((TextView) itemView.findViewById(R.id.temp)).setText(String.format("%d°", weather.getTemperature()));

            itemView.findViewById(R.id.space).setBackgroundColor(getColor(RAINY));
        }


        private Integer getColor(WeatherType type) {
            int color;
            switch (type) {
                case RAINY:
                    color = Color.BLUE;
                    break;
                case CLOUDY:
                    color = Color.GRAY;
                    break;
                case SUNNY:
                    color = Color.YELLOW;
                    break;
                case MISTY:
                    color = Color.GREEN;
                    break;
                case SNOWY:
                    color = Color.WHITE;
                    break;
                case HAILY:
                    color = Color.RED;
                    break;
                default:
                    color = Color.BLACK;
            }

            return color;
        }
    }
}
