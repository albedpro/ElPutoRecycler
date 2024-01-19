package com.mcas2.historiceventsrecycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<divisasEventModel> DivisasEventModel = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.divisasEventsRecycler);
        setDivisasEventModel();

        HistoricEventRVAdapter adapter = new HistoricEventRVAdapter(this, DivisasEventModel);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setDivisasEventModel() {
        String[] eventNames = getResources().getStringArray(R.array.divisas);
        String[] eventPrecio = getResources().getStringArray(R.array.precio_divisas);
        String eventCantEuro = getString(R.id.cantidad_euros);

        for (int i = 0; i < eventNames.length; i++) {
            DivisasEventModel.add(new divisasEventModel(
                    eventNames[i],
                    eventPrecio[i],
                    eventCantEuro
            ));
        }
    }
}