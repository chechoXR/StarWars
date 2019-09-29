package com.checho.starwars;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.http.conn.*;
import javax.net.ssl.HttpsURLConnection;
import static android.provider.ContactsContract.CommonDataKinds.Website.URL;

public class people extends AppCompatActivity {

    public static final String URL_SWAPI = "https://swapi.co/api/people/";
    public static  int people=1;
    private TextView Name;
    private TextView height;
    private TextView mass;
    private TextView hairColor;
    private TextView SkinColor;
    private TextView eyeColor;
    private TextView birthYear;
    private TextView gender;

    String nameResponse = "";
    String heighResponse = "";
    String massResponse = "";
    String hairResponse = "";
    String skinResponse = "";
    String eyeResponse = "";
    String birthResponse = "";
    String genderResponse = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people);

        Name = findViewById(R.id.name);
        height = findViewById(R.id.height);
        mass = findViewById(R.id.mass);
        hairColor = findViewById(R.id.hair_color);
        SkinColor = findViewById(R.id.skin_color);
        eyeColor= findViewById(R.id.eye_color);
        birthYear = findViewById(R.id.birth_year);
        gender = findViewById(R.id.gender);


        Name.setText("Name");
        height.setText("Height");
        mass.setText("mass");
        hairColor.setText("hair Color");
        SkinColor.setText("Skin Color");
        eyeColor.setText("Eye Color");
        birthYear.setText("birth");
        gender.setText("Gender");

      callWebService("");



    }


    public void sig(View view) {


        if(people<87)
            people++;


        callWebService("");
    }

    public void prev (View v) {
        if(people>1)
            people--;
        callWebService("");
    }

    public void callWebService(String serviceEndPoint){
        System.out.println("callwebservice");
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {

                try {
                    URL urlService = new URL (URL_SWAPI + String.valueOf(people)+ "/" );
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



                        String keyHeight = jsonReader.nextName(); // Fetch the next key
                        System.out.println("Height "+keyHeight);
                        String valueHeight = jsonReader.nextString();

                        String keyMass = jsonReader.nextName(); // Fetch the next key
                        System.out.println("Mass "+keyMass);
                        String valueMass = jsonReader.nextString();

                        String keyHair = jsonReader.nextName(); // Fetch the next key
                        System.out.println("Hair "+keyHair);
                        String valuehair = jsonReader.nextString();

                        String keySkin = jsonReader.nextName(); // Fetch the next key
                        System.out.println("Skin " + keySkin);
                        String valueSkin = jsonReader.nextString();

                        String keyEye = jsonReader.nextName(); // Fetch the next key
                        System.out.println("Eye "+keyEye);
                        String valueEye = jsonReader.nextString();

                        String keyBirth = jsonReader.nextName(); // Fetch the next key
                        System.out.println("birth "+keyBirth);
                        String valueBirth = jsonReader.nextString();

                        String keyGender = jsonReader.nextName(); // Fetch the next key
                        System.out.println("Gender "+keyGender);
                        String valueGender = jsonReader.nextString();


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


                        heighResponse = valueHeight;
                        massResponse = valueMass;
                        hairResponse = valuehair;
                        skinResponse = valueSkin;
                        eyeResponse = valueEye;
                        birthResponse = valueBirth;
                        genderResponse = valueGender;


                        Name.post(new Runnable() {
                            @Override
                            public void run() {
                                Name.setText(nameResponse);

                            }
                        });


                        height.post(new Runnable() {
                            @Override
                            public void run() {
                                height.setText(heighResponse);

                            }
                        });
                        mass.post(new Runnable() {
                            @Override
                            public void run() {
                                mass.setText(massResponse);

                            }
                        });
                        hairColor.post(new Runnable() {
                            @Override
                            public void run() {
                                hairColor.setText(hairResponse);

                            }
                        });
                        SkinColor.post(new Runnable() {
                            @Override
                            public void run() {
                                SkinColor.setText(skinResponse);

                            }

                        });
                        eyeColor.post(new Runnable() {
                            @Override
                            public void run() {
                                eyeColor.setText(eyeResponse);

                            }
                        });
                        birthYear.post(new Runnable() {
                            @Override
                            public void run() {
                                birthYear.setText(birthResponse);

                            }
                        });
                        gender.post(new Runnable() {
                            @Override
                            public void run() {
                                gender.setText(genderResponse);

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
        height.setText(String.valueOf(heighResponse));
        mass.setText(massResponse);
        hairColor.setText(hairResponse);
        SkinColor.setText(skinResponse);
        eyeColor.setText(eyeResponse);
        birthYear.setText(birthResponse);
        gender.setText(genderResponse);

    System.out.println(people);
    } // end callWebService()
}
