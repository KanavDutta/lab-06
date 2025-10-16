package com.example.listycity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private CityList cityList = new CityList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        listView = findViewById(R.id.city_list);

        // seed some demo data
        try {
            cityList.add(new City("Edmonton", "Alberta"));
            cityList.add(new City("Calgary", "Alberta"));
            cityList.add(new City("Regina", "Saskatchewan"));
            cityList.add(new City("Charlottetown", "Prince Edward Island"));
        } catch (IllegalArgumentException ignored) {
            // ignore duplicates if this ever re-runs
        }

        List<City> sorted = cityList.getCities();
        ArrayAdapter<City> adapter =
                new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sorted);
        listView.setAdapter(adapter);
    }
}
