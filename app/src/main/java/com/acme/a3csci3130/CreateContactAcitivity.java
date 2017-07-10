package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateContactAcitivity extends Activity {

    private Button submitButton;
    private EditText nameField, emailField, busNumField, primaryBusField, addressField, provinceTerritoryField;
    private MyApplicationData appState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact_acitivity);
        //Get the app wide shared variable
        appState = ((MyApplicationData) getApplicationContext());

        submitButton = (Button) findViewById(R.id.submitButton);
        nameField = (EditText) findViewById(R.id.name);
        emailField = (EditText) findViewById(R.id.email);
        busNumField = (EditText) findViewById(R.id.business_number);
        primaryBusField = (EditText) findViewById(R.id.primary_business);
        addressField = (EditText) findViewById(R.id.address);
        provinceTerritoryField = (EditText) findViewById(R.id.province_territory);
    }

    public void submitInfoButton(View v) {
        //each entry needs a unique ID
        String personID = appState.firebaseReference.push().getKey();
        String name = nameField.getText().toString();
        String email = emailField.getText().toString();
        String business_number = busNumField.getText().toString();
        String primary_business = primaryBusField.getText().toString();
        String address = addressField.getText().toString();
        String province_territory = provinceTerritoryField.getText().toString();

        Contact person = new Contact(personID, name, email, business_number, primary_business, address, province_territory);

        appState.firebaseReference.child(personID).setValue(person);

        finish();
    }
}
