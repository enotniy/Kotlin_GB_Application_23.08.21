package com.kotlin.app_java;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private WeatherAdapter adapter;
    private TextView counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counter = findViewById(R.id.textView);

        initAdapter();

        setTitle();

        addFilter();

    }

    void initAdapter() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        adapter = new WeatherAdapter();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL);

        dividerItemDecoration.setDrawable(getDrawable(R.drawable.divider));

        recyclerView.addItemDecoration(dividerItemDecoration);

        List<Weather> weatherList = Repository.getInstance().getWeatherList();
        adapter.setWeatherList(weatherList);
        setCounter(weatherList.size());
    }

    void setTitle() {
        getSupportActionBar().setTitle(Utils.getFullName(
                this.getPackageName(),
                this.getString(R.string.app_name)
        ));
    }

    void addFilter() {
        ((EditText) findViewById(R.id.editText)).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                applyFilter(s.toString());
            }
        });
    }

    void applyFilter(String s) {
        List<Weather> filteredWeatherList = new ArrayList<>();

        for (Weather weather : Repository.getInstance().getWeatherList()) {
            if (weather.getTown().toLowerCase().contains(s.toLowerCase())) {
                filteredWeatherList.add(weather);
            }
        }
        adapter.setWeatherList(filteredWeatherList);
        setCounter(filteredWeatherList.size());
    }

    void setCounter(Integer count) {
        if (count == 0) {
            counter.setText("Нет городов");
        } else {
            counter.setText(String.format("Городов: %d", count));
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}