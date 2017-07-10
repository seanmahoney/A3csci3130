package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class DetailViewActivity extends Activity {

    private EditText nameField, emailField, busNumField, primaryBusField, addressField, provinceTerritoryField;
    Contact receivedPersonInfo;
    private MyApplicationData appState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        receivedPersonInfo = (Contact)getIntent().getSerializableExtra("Contact");

        nameField = (EditText) findViewById(R.id.name);
        emailField = (EditText) findViewById(R.id.email);
        busNumField = (EditText) findViewById(R.id.business_number);
        primaryBusField = (EditText) findViewById(R.id.primary_business);
        addressField = (EditText) findViewById(R.id.address);
        provinceTerritoryField = (EditText) findViewById(R.id.province_territory);

        if(receivedPersonInfo != null){
            nameField.setText(receivedPersonInfo.name);
            emailField.setText(receivedPersonInfo.email);
            busNumField.setText(receivedPersonInfo.business_number);
            primaryBusField.setText(receivedPersonInfo.primary_business);
            addressField.setText(receivedPersonInfo.address);
            provinceTerritoryField.setText(receivedPersonInfo.province_territory);
        }
    }

    public void updateContact(View v){
        //Get the app wide shared variable
        appState = ((MyApplicationData) getApplicationContext());
        String id = receivedPersonInfo.uid.toString();
        appState.firebaseReference.child(id).child("name").setValue(nameField.getText().toString());
        appState.firebaseReference.child(id).child("email").setValue(emailField.getText().toString());
        appState.firebaseReference.child(id).child("business_number").setValue(busNumField.getText().toString());
        appState.firebaseReference.child(id).child("primary_business").setValue(primaryBusField.getText().toString());
        appState.firebaseReference.child(id).child("addresss").setValue(addressField.getText().toString());
        appState.firebaseReference.child(id).child("province_territory").setValue(provinceTerritoryField.getText().toString());
        finish();
    }

    public void eraseContact(View v) {
        //Get the app wide shared variable
        appState = ((MyApplicationData) getApplicationContext());
        String id = receivedPersonInfo.uid.toString();
        appState.firebaseReference.child(id).removeValue();
        finish();
    }
}
