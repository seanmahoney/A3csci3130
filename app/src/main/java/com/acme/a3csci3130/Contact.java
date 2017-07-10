package com.acme.a3csci3130;

import com.google.firebase.database.Exclude;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Class that defines how the data will be stored in the
 * Firebase databse. This is converted to a JSON format
 */

public class Contact implements Serializable {

    public String uid;
    public String name;
    public String email;
    public String business_number;
    public String primary_business;
    public String address;
    public String province_territory;

    public Contact() {
        // Default constructor required for calls to DataSnapshot.getValue
    }

    public Contact(String uid, String name, String email, String business_number, String primary_business, String address, String province_territory) {
        this.uid = uid;
        this.name = name;
        this.email = email;
        this.business_number = business_number;
        this.primary_business = primary_business;
        this.address = address;
        this.province_territory = province_territory;

    }
    @Exclude
    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("uid", uid);
        result.put("name", name);
        result.put("email", email);
        result.put("business_number", business_number);
        result.put("priamry_business", primary_business);
        result.put("address", address);
        result.put("province_territory", province_territory);

        return result;
    }
}
