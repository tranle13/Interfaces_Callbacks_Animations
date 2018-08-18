
    // Name: Tran Le
    // AID - 1808
    // File name: Contact.java

package com.sunny.android.letran_ce06;

import java.io.Serializable;

public class Contact implements Serializable {

    // Member variables
    private String firstName;
    private String lastName;
    private Integer phoneNumber;

    // Constructor
    public Contact(String firstName, String lastName, Integer phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    // Getters
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public Integer getPhoneNumber() { return phoneNumber; }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
