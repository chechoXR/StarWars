package com.checho.starwars;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.AsyncTask;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class planets extends AppCompatActivity {

    public static final String URL_SWAPI = "https://swapi.co/api/planets/";
    public static  int planet=1;
    private TextView Name;
    private TextView rotation;
    private TextView orbital;
    private TextView diameter;
    private TextView climate;
    private TextView gravity;
    private TextView terrain;
    private TextView surface;
    private TextView population;

    String nameResponse = "";
    String rotationResponse = "";
    String orbitalResponse = "";
    String diameterResponse = "";
    String climateResponse = "";
    String gravityResponse = "";
    String terrainResponse = "";
    String surfaceResponse = "";
    String populationResponse = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planets);

        Name = findViewById(R.id.name);
        rotation = findViewById(R.id.rotation);
        orbital = findViewById(R.id.orbital);
        diameter = findViewById(R.id.diameter);
        climate = findViewById(R.id.climate);
        gravity = findViewById(R.id.gravity);
        terrain = findViewById(R.id.terrain);
        surface = findViewById(R.id.surface);
        population = findViewById(R.id.population);


        Name.setText("Name");
        rotation.setText("rotation");
        orbital.setText("orbital");
        diameter.setText("diameter");
        climate.setText("climate");
        gravity.setText("gravity");
        terrain.setText("terrain");
        surface.setText("surface");
        population.setText("population");

        callWebService("");



    }


    public void sig(View view) {


        if(planet<61)
            planet++;


        callWebService("");
    }

    public void prev (View v) {
        if(planet>1)
            planet--;
        callWebService("");
    }

    public void callWebService(String serviceEndPoint){
        System.out.println("callwebservice");
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {

                try {
                    URL urlService = new URL (URL_SWAPI + String.valueOf(planet)+ "/" );
                    HttpsURLConnection connection =  (HttpsURLConnection) urlService.openConnection();
                    connection.setRequestMethod("GET");
                    InputStream responseBody = connection.getInputStream();

                    if (connection.getResponseCode() == 200) {
                        // Success


                        InputStreamReader responseBodyReader = new InputStreamReader(responseBody, "UTF-8");

                        JsonReader jsonReader = new JsonReader(responseBodyReader);
                        jsonReader.beginObject(); // Start processing the JSON object
                        System.out.println("start prints ");

                        String keyName = jsonReader.nextName(); // Fetch the next key
                        System.out.println("Name "+keyName);
                        String valueName = jsonReader.nextString();

                        String keyRotation = jsonReader.nextName(); // Fetch the next key
                        System.out.println("Height "+keyRotation);
                        String valueRotation = jsonReader.nextString();

                        String keyOrbital = jsonReader.nextName(); // Fetch the next key
                        System.out.println("Mass "+keyOrbital);
                        String valueOrbital = jsonReader.nextString();

                        String keyDiameter = jsonReader.nextName(); // Fetch the next key
                        System.out.println("Hair "+keyDiameter);
                        String valueDiameter = jsonReader.nextString();

                        String keyClimate = jsonReader.nextName(); // Fetch the next key
                        System.out.println("Skin " + keyClimate);
                        String valueClimate = jsonReader.nextString();

                        String keyGravity = jsonReader.nextName(); // Fetch the next key
                        System.out.println("Eye "+keyGravity);
                        String valueGravity = jsonReader.nextString();

                        String keyTerrain = jsonReader.nextName(); // Fetch the next key
                        System.out.println("birth "+keyTerrain);
                        String valueTerrain = jsonReader.nextString();

                        String keySurface = jsonReader.nextName(); // Fetch the next key
                        System.out.println("Gender "+keySurface);
                        String valueSurface = jsonReader.nextString();

                        String keyPopulation = jsonReader.nextName(); // Fetch the next key
                        System.out.println("Gender "+keyPopulation);
                        String valuePopulation = jsonReader.nextString();


                        //
                        //Log.v("INFO",valueName);
                        // Log.v("INFO",valueHeight);
                        //Log.v("INFO",valueMass);
                        //Log.v("INFO",valuehair);
                        //Log.v("INFO",valueSkin);
                        //Log.v("INFO",valueEye);
                        //Log.v("INFO",valueBirth);
                        //Log.v("INFO",valueGender);


                        nameResponse = valueName;
                        rotationResponse = valueRotation;
                        orbitalResponse = valueOrbital;
                        diameterResponse = valueDiameter;
                        climateResponse = valueClimate;
                        gravityResponse = valueGravity;
                        terrainResponse = valueTerrain;
                        surfaceResponse = valueSurface;
                        populationResponse = valuePopulation;


                        Name.post(new Runnable() {
                            @Override
                            public void run() {
                                Name.setText(nameResponse);

                            }
                        });


                        rotation.post(new Runnable() {
                            @Override
                            public void run() {
                                rotation.setText(rotationResponse);

                            }
                        });
                        orbital.post(new Runnable() {
                            @Override
                            public void run() {
                                orbital.setText(orbitalResponse);

                            }
                        });
                        diameter.post(new Runnable() {
                            @Override
                            public void run() {
                                diameter.setText(diameterResponse);

                            }
                        });
                        climate.post(new Runnable() {
                            @Override
                            public void run() {
                                climate.setText(climateResponse);

                            }

                        });
                        gravity.post(new Runnable() {
                            @Override
                            public void run() {
                                gravity.setText(gravityResponse);

                            }
                        });
                        terrain.post(new Runnable() {
                            @Override
                            public void run() {
                                terrain.setText(terrainResponse);

                            }
                        });
                        surface.post(new Runnable() {
                            @Override
                            public void run() {
                                surface.setText(surfaceResponse);

                            }
                        });
                        population.post(new Runnable() {
                            @Override
                            public void run() {
                                population.setText(populationResponse);

                            }
                        });


                    } else {
                        // Error handling code goes here
                        Log.v("ERROR", "ERROR");
                    }

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        Name.setText(nameResponse);
        rotation.setText(String.valueOf(rotationResponse));
        orbital.setText(orbitalResponse);
        diameter.setText(diameterResponse);
        climate.setText(climateResponse);
        gravity.setText(gravityResponse);
        terrain.setText(terrainResponse);
        surface.setText(surfaceResponse);
        population.setText(populationResponse);

        System.out.println(planet);
    } // end callWebService()
}
