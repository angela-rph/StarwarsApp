package com.example.angela.starwars.elements;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
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

import static com.example.angela.starwars.elements.ElementsActivity.PEOPLE_CARACTERISTICS;

/**
 * Created by Angela on 16/01/2018.
 */

public class CaracteristicsActivity extends AppCompatActivity {


    public static final int REQUEST_CODE_PEOPLE_ID = 1;

    public static Intent getStartIntent(final Context context) {
        return new Intent(context, CaracteristicsActivity.class);
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_caracteristics);


        final People people = getIntent().getExtras().getParcelable(PEOPLE_CARACTERISTICS);

        TextView titleList = (TextView) findViewById(R.id.elementTitle);
        TextView peopleNameStatic = (TextView) findViewById(R.id.elementNameStatic);
        TextView elementHeightStatic = (TextView) findViewById(R.id.elementHeightStatic);
        TextView elementMassStatic = (TextView) findViewById(R.id.elementMassStatic);
        TextView elementHairColorStatic = (TextView) findViewById(R.id.elementHairColorStatic);
        TextView elementSkinColorStatic = (TextView) findViewById(R.id.elementSkinColorStatic);
        TextView elementEyeColorStatic = (TextView) findViewById(R.id.elementEyeColorStatic);
        TextView elementBirthYearStatic = (TextView) findViewById(R.id.elementBirthYearStatic);
        TextView elementGenderStatic = (TextView) findViewById(R.id.elementGenderStatic);

        TextView peopleName = (TextView) findViewById(R.id.elementName);
        TextView elementHeight = (TextView) findViewById(R.id.elementHeight);
        TextView elementMass = (TextView) findViewById(R.id.elementMass);
        TextView elementHairColor = (TextView) findViewById(R.id.elementHairColor);
        TextView elementSkinColor = (TextView) findViewById(R.id.elementSkinColor);
        TextView elementEyeColor = (TextView) findViewById(R.id.elementEyeColor);
        TextView elementBirthYear = (TextView) findViewById(R.id.elementBirthYear);
        TextView elementGender = (TextView) findViewById(R.id.elementGender);

        peopleName.setText(" "+people.getName());
        elementHeight.setText(" "+people.getHeight());
        elementMass.setText(" "+people.getMass());
        elementHairColor.setText(" "+people.getHairColor());
        elementSkinColor.setText(" "+people.getSkinColor());
        elementEyeColor.setText(" "+people.getEyeColor());
        elementBirthYear.setText(" "+people.getBirthYear());
        elementGender.setText(" "+people.getGender());

        setResult(RESULT_OK);
    }

}
