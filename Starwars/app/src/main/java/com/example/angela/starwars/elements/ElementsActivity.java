package com.example.angela.starwars.elements;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.example.angela.starwars.R;
import com.example.angela.starwars.data.models.HttpError;
import com.example.angela.starwars.data.models.People;
import com.example.angela.starwars.data.models.ResultList;
import com.example.angela.starwars.data.remote.ApiService;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Angela on 16/01/2018.
 */


public class ElementsActivity extends AppCompatActivity {

    private final ApiService apiService = ApiService.Builder.getInstance(); //singleton

    public static final String PEOPLE_CARACTERISTICS = "PEOPLE_CARACTERISTICS";
    private ElementAdapter elementsAdapter;
    private final List<People> listOfPeople = new ArrayList<>();
    private ResultList resultList = null;

    public static Intent getStartIntent(final Context context) {
        return new Intent(context, ElementsActivity.class);
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elements);

        final ListView people = findViewById(R.id.peopleListView);

        elementsAdapter = new ElementAdapter(this, listOfPeople, peopleSelectedListener);
        people.setAdapter(elementsAdapter);

        Log.d("DEBUG_TAG", "Start request");
        //Récupération éléments
        apiService.readResults().enqueue(new Callback <ResultList>() {
            @Override
            public void onResponse(final Call<ResultList> call, final Response<ResultList> response) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        handleResponse(response);
                    }
                });
            }

            @Override
            public void onFailure(final Call<ResultList> call, final Throwable t) {
                t.printStackTrace();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(ElementsActivity.this, R.string.status_error, Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    /*
     * Triggered when an item of the listView is clicked
     */
    private final ElementAdapter.OnPeopleSelectedListener peopleSelectedListener = new ElementAdapter.OnPeopleSelectedListener() {
        @Override
        public void handle(final People people) {
            final Intent data = CaracteristicsActivity.getStartIntent(ElementsActivity.this);
            data.putExtra(PEOPLE_CARACTERISTICS, (Parcelable) people);
            setResult(RESULT_OK);
            startActivity(data);
        }
    };

    private void updateDevices (final List<People> people){
        listOfPeople.clear();
        if (people != null && people.size() > 0){
            listOfPeople.addAll(people);
            elementsAdapter.notifyDataSetChanged();
        } else {
            return;
        }
    }

    private void handleResponse(final Response<ResultList> response){
        if (response.isSuccessful()) {
            ResultList resultList = (ResultList) response.body();
            updateDevices(resultList.results);
        } else { // error HTTP
            try {
                final HttpError error = new Gson().fromJson(response.errorBody().string(), HttpError.class);
                Toast.makeText(ElementsActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            } catch (final IOException e) {
                e.printStackTrace();
                Toast.makeText(ElementsActivity.this, R.string.unknown_error, Toast.LENGTH_SHORT).show();
            }
        }
    }
}

