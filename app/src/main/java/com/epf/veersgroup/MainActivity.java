package com.epf.veersgroup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{

    SharedPreferences Sprefs;
    EditText employeeName, name, surname, address1, address2, suburb, headOfHouseAge, numOfOccs, town, province, contactNum, emailAddress, q1, q2, q3, q4, q5, q6;
    Button btnSave;
    FirebaseDatabase rootNode;
    DatabaseReference reference;
    Spinner decisionSpinner1, decisionSpinner2, decisionSpinner3, decisionSpinner4, decisionSpinner5, ageSpinner, genderSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//      Storing data from the user inputs into variables
        employeeName = findViewById(R.id.employeeNameInputForm);
        name = findViewById(R.id.nameInputForm);
        surname = findViewById(R.id.surnameInputForm);
        address1 = findViewById(R.id.addressInputForm1);
        address2 = findViewById(R.id.addressInputForm2);
        suburb = findViewById(R.id.suburbInputForm);
//        headOfHouseAge = findViewById(R.id.headOfHouseInputForm);
        numOfOccs = findViewById(R.id.numberOfOccupantsInputForm);
        town = findViewById(R.id.townInputForm);
        province = findViewById(R.id.provinceInputForm);
        contactNum = findViewById(R.id.contactNumInputForm);
        emailAddress = findViewById(R.id.emailInputForm);
//        q1 = findViewById(R.id.q1InputForm);
//        q2 = findViewById(R.id.q2InputForm);
//        q3 = findViewById(R.id.q3InputForm);
//        q4 = findViewById(R.id.q4InputForm);
//        q5 = findViewById(R.id.q5InputForm);
//        q6 = findViewById(R.id.q6InputForm);
        btnSave = findViewById(R.id.saveButton);

        Spinner decisionSpinner1 = (Spinner) findViewById(R.id.decisionOneInputForm);
        Spinner decisionSpinner2 = (Spinner) findViewById(R.id.decisionTwoInputForm);
        Spinner decisionSpinner3 = (Spinner) findViewById(R.id.decisionThreeInputForm);
        Spinner decisionSpinner4 = (Spinner) findViewById(R.id.decisionFourInputForm);
        Spinner decisionSpinner5 = (Spinner) findViewById(R.id.decisionFiveInputForm);
        Spinner ageSpinner = (Spinner) findViewById(R.id.ageInputForm);
        Spinner genderSpinner = (Spinner) findViewById(R.id.genderInputForm);

//     Create an ArrayAdapter using the string array and a default spinner
        ArrayAdapter<CharSequence> staticAdDec1 = ArrayAdapter.createFromResource(this, R.array.decision_arr,android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> staticAdDec2 = ArrayAdapter.createFromResource(this, R.array.decision_arr,android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> staticAdDec3 = ArrayAdapter.createFromResource(this, R.array.decision_arr,android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> staticAdDec4 = ArrayAdapter.createFromResource(this, R.array.decision_arr,android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> staticAdDec5 = ArrayAdapter.createFromResource(this, R.array.decision_arr,android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> staticAdAge = ArrayAdapter.createFromResource(this, R.array.age_groups_arr,android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> staticAdGender = ArrayAdapter.createFromResource(this, R.array.gender_arr,android.R.layout.simple_spinner_item);

//     Specify the layout to use when the list of choices appears
        staticAdDec1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        staticAdDec2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        staticAdDec3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        staticAdDec4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        staticAdDec5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        staticAdAge.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        staticAdGender.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

//     Apply the adapter to the spinner
        decisionSpinner1.setAdapter(staticAdDec1);
        decisionSpinner2.setAdapter(staticAdDec2);
        decisionSpinner3.setAdapter(staticAdDec3);
        decisionSpinner4.setAdapter(staticAdDec4);
        decisionSpinner5.setAdapter(staticAdDec5);
        ageSpinner.setAdapter(staticAdAge);
        genderSpinner.setAdapter(staticAdGender);

//      First Question Spinner Dropdown
        decisionSpinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                Sprefs = getSharedPreferences("prefName", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = Sprefs.edit();

                editor.putString("DecisionOne", decisionSpinner1.getSelectedItem().toString());

                String decisionOneStr = decisionSpinner1.getSelectedItem().toString();

                for (int i = 0; i < 2; i++)
                    if (decisionOneStr.equals(decisionSpinner1.getItemAtPosition(i).toString()))
                    {
                        decisionSpinner1.setSelection(i);
                        break;
                    }

                editor.commit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });

//      Second Question Spinner Dropdown
        decisionSpinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                Sprefs = getSharedPreferences("prefName", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = Sprefs.edit();

                editor.putString("DecisionTwo", decisionSpinner2.getSelectedItem().toString());

                String decisionTwoStr = decisionSpinner2.getSelectedItem().toString();

                for (int i = 0; i < 2; i++)
                    if (decisionTwoStr.equals(decisionSpinner2.getItemAtPosition(i).toString()))
                    {
                        decisionSpinner2.setSelection(i);
                        break;
                    }

                editor.commit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });

//      Third Question Spinner Dropdown
        decisionSpinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                Sprefs = getSharedPreferences("prefName", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = Sprefs.edit();

                editor.putString("DecisionThree", decisionSpinner3.getSelectedItem().toString());

                String decisionThreeStr = decisionSpinner3.getSelectedItem().toString();

                for (int i = 0; i < 2; i++)
                    if (decisionThreeStr.equals(decisionSpinner3.getItemAtPosition(i).toString()))
                    {
                        decisionSpinner3.setSelection(i);
                        break;
                    }

                editor.commit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });

//      Fourth Question Spinner Dropdown
        decisionSpinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                Sprefs = getSharedPreferences("prefName", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = Sprefs.edit();

                editor.putString("DecisionFour", decisionSpinner4.getSelectedItem().toString());

                String decisionFourStr = decisionSpinner4.getSelectedItem().toString();

                for (int i = 0; i < 2; i++)
                    if (decisionFourStr.equals(decisionSpinner4.getItemAtPosition(i).toString()))
                    {
                        decisionSpinner4.setSelection(i);
                        break;
                    }

                editor.commit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });

//      Fifth Question Spinner Dropdown
        decisionSpinner5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                Sprefs = getSharedPreferences("prefName", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = Sprefs.edit();

                editor.putString("DecisionFive", decisionSpinner5.getSelectedItem().toString());

                String decisionFiveStr = decisionSpinner5.getSelectedItem().toString();

                for (int i = 0; i < 2; i++)
                    if (decisionFiveStr.equals(decisionSpinner5.getItemAtPosition(i).toString()))
                    {
                        decisionSpinner5.setSelection(i);
                        break;
                    }

                editor.commit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });

//      Age Question Spinner Dropdown
        ageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                Sprefs = getSharedPreferences("prefName", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = Sprefs.edit();

                editor.putString("AgeGroupChoice", ageSpinner.getSelectedItem().toString());

                String ageGroupStr = ageSpinner.getSelectedItem().toString();

                for (int i = 0; i < 5; i++)
                    if (ageGroupStr.equals(ageSpinner.getItemAtPosition(i).toString()))
                    {
                        ageSpinner.setSelection(i);
                        break;
                    }

                editor.commit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });

//      Gender Question Spinner Dropdown
        genderSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                Sprefs = getSharedPreferences("prefName", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = Sprefs.edit();

                editor.putString("GenderChoice", genderSpinner.getSelectedItem().toString());

                String genderStr = genderSpinner.getSelectedItem().toString();

                for (int i = 0; i < 2; i++)
                    if (genderStr.equals(genderSpinner.getItemAtPosition(i).toString()))
                    {
                        genderSpinner.setSelection(i);
                        break;
                    }

                editor.commit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });

    }

    public void formPage (View view)
    {

//      Change the reference based on the tablet device below
        rootNode = FirebaseDatabase.getInstance();
//        reference = rootNode.getReference("user-0007");
        reference = rootNode.getReference("user-test-last");

//      This is extracting the information from the shared preference and creating an editor to allow for cache clearing
        SharedPreferences Sprefs = getApplicationContext().getSharedPreferences("prefName", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = Sprefs.edit();

//      Getting the string value associated to the relevant key name and saving it into the variable
        String dec1Str = Sprefs.getString("DecisionOne", "");
        String dec2Str = Sprefs.getString("DecisionTwo", "");
        String dec3Str = Sprefs.getString("DecisionThree", "");
        String dec4Str = Sprefs.getString("DecisionFour", "");
        String dec5Str = Sprefs.getString("DecisionFive", "");
        String ageGroupStr = Sprefs.getString("AgeGroupChoice", "");
        String genderStr = Sprefs.getString("GenderChoice", "");

//        reference.setValue("Second Data");

//      Get the text from the variables and convert it to string in a new variable
        String empNameStr = employeeName.getText().toString();
        String nameStr = name.getText().toString();
        String surnameStr = surname.getText().toString();
        String address1Str = address1.getText().toString();
        String address2Str = address2.getText().toString();
        String suburbStr = suburb.getText().toString();
        String numOfOccsStr = numOfOccs.getText().toString();
        String townStr = town.getText().toString();
        String provinceStr = province.getText().toString();
        String contactNumStr = contactNum.getText().toString();
        String emailAddressStr = emailAddress.getText().toString();


        UserHelperClass helperClass = new UserHelperClass(empNameStr, nameStr, surnameStr,address1Str, address2Str, suburbStr, ageGroupStr,
                numOfOccsStr, townStr, provinceStr, contactNumStr, emailAddressStr, dec1Str, dec2Str, dec3Str, dec4Str, dec5Str, genderStr);
        reference.child(contactNumStr).setValue(helperClass);


        Toast.makeText(getApplicationContext(), "The users application has been Saved!",Toast.LENGTH_SHORT).show();

        startActivity(new Intent(MainActivity.this, MainActivity2.class));
        finish();

    }
}