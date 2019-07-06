package com.ckdtech.www.introduction;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import static android.R.layout.simple_spinner_dropdown_item;

public class SignUpActivity extends AppCompatActivity {

    TextInputLayout namewrapper;
    TextInputLayout Emailwrapper;
    TextInputLayout Contactwrapper;
    TextInputEditText nameeditText;
    TextInputEditText EmaileditText;
    TextInputEditText ContacteditText;
    Button RegisterBtn;
    Spinner spinner1;
    Spinner spinner2;
    Spinner spinner3;

    String selectedage;
    String selectedcountry;
    String selectedstate;

    String selectedStateArray[];

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin);


        namewrapper = (TextInputLayout) findViewById(R.id.namewrapper);
        Emailwrapper = (TextInputLayout) findViewById(R.id.emailwrapper);
        Contactwrapper = (TextInputLayout) findViewById(R.id.contactwrapper);

        nameeditText = (TextInputEditText) findViewById(R.id.nameeditText);
        EmaileditText = (TextInputEditText) findViewById(R.id.EmaileditText);
        ContacteditText = (TextInputEditText) findViewById(R.id.ContacteditText);
        Button RegisterBtn = (Button) findViewById(R.id.button1);




        spinner1 = (Spinner) findViewById(R.id.spinner1);
        final String [] Age={"12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34",
                "35","36","37","38","39","40","41","42","43","44","45","46","47", "48","49","50","51","52","53","54","55","56","57","58",
                "59","60","61","62","63","64","65","66","67","68","69","70","71","72","73","74","75","76","77","78","79","80","81","82",
                "83","84","85","86","87","88","89","90","91","92","93","94","95","96","97","98","99","100","more than 100"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, simple_spinner_dropdown_item,Age);
        spinner1.setAdapter(adapter);



        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                selectedage = Age[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        spinner2 = (Spinner) findViewById(R.id.spinner2);   //country
        spinner3 = (Spinner) findViewById(R.id.spinner3);        // state

        final String [] Country={"Algeria","India","Australia","Brazil","China","USA"};
        final String [] AlgeriaStateCountry={"Adrar","Chlef","Laghouat","Oum el-Bouaghi","Batna","Béjaïa","Biskra","Béchar","Blida", "Bouira"};
        final String [] IndiaStateCountry={"Haryana","Goa","Gujrat","Mumbai","Jk","Karnatka","MP","Delhi"};
        final String [] AustraliaStateCountry={"Australian Capital Territory","New South Wales","Victoria","Queensland","South Australia",
                "Western Australia","Tasmania","Northern Territory"};

        final String [] BrazilStateCountry={"Bsate1","Bstate2","Bstate3"};
        final String [] ChinaStateCountry={"Cstate1","Cstate2","Cstate3"};
        final String [] USAStateCountry={"Ustate1","ustate2","Ustate3"};




        ArrayAdapter<String> countryadapter = new ArrayAdapter<>(this, simple_spinner_dropdown_item,Country);
        spinner2.setAdapter(countryadapter);






        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SignUpActivity.this, "Country selected is"+Country[position], Toast.LENGTH_SHORT).show();

                selectedcountry=Country[position];

              if (Country[position].equalsIgnoreCase("Algeria")) {
                  ArrayAdapter<String> stateadapter;
                  selectedStateArray = AlgeriaStateCountry;
                  stateadapter = new ArrayAdapter<String>(getApplicationContext(), simple_spinner_dropdown_item, AlgeriaStateCountry);
                  spinner3.setAdapter(stateadapter);

              }

              if (Country[position].equalsIgnoreCase("India")) {
                    ArrayAdapter<String> stateadapter;
                  selectedStateArray = IndiaStateCountry;

                    stateadapter = new ArrayAdapter<String>(getApplicationContext(), simple_spinner_dropdown_item,IndiaStateCountry);
                    spinner3.setAdapter(stateadapter);

                }

                if (Country[position].equalsIgnoreCase("Australia")) {
                    ArrayAdapter<String> stateadapter;
                    selectedStateArray = AustraliaStateCountry;
                    stateadapter = new ArrayAdapter<String>(getApplicationContext(), simple_spinner_dropdown_item, AustraliaStateCountry);
                    spinner3.setAdapter(stateadapter);

                }

                if (Country[position].equalsIgnoreCase("Brazil")) {
                        ArrayAdapter<String> stateadapter;
                    selectedStateArray = BrazilStateCountry;

                        stateadapter = new ArrayAdapter<String>(getApplicationContext(), simple_spinner_dropdown_item, BrazilStateCountry);
                        spinner3.setAdapter(stateadapter);
                    }

                    if (Country[position].equalsIgnoreCase("China")) {
                            ArrayAdapter<String> stateadapter;
                        selectedStateArray = ChinaStateCountry;
                            stateadapter = new ArrayAdapter<String>(getApplicationContext(), simple_spinner_dropdown_item, ChinaStateCountry);
                            spinner3.setAdapter(stateadapter);

                        }
                if (Country[position].equalsIgnoreCase("USA")){
                                ArrayAdapter<String> stateadapter;
                    selectedStateArray = USAStateCountry;
                                stateadapter = new ArrayAdapter<String>(getApplicationContext(), simple_spinner_dropdown_item,USAStateCountry);
                                spinner3.setAdapter(stateadapter);

            }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                selectedstate=selectedStateArray[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
    public void RegisterBtnClicked(View v){


        String name = nameeditText.getText().toString();

        Toast.makeText(this, "name is..."+name, Toast.LENGTH_SHORT).show();


        String Email = EmaileditText.getText().toString();

        Toast.makeText(this, "Email is..."+Email, Toast.LENGTH_SHORT).show();


        String Contact = ContacteditText.getText().toString();

        Toast.makeText(this, "Contact is..."+Contact, Toast.LENGTH_SHORT).show();

        Intent i = new Intent(SignUpActivity.this,ProfileActivity.class);










    }
}
