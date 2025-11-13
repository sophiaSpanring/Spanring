package ue_2_s2410238052;

import java.util.ArrayList;
import java.util.List;

public class TelephoneBookEntry {

    private String firstName;
    private String lastName;
    private List<String> phoneNumbers;
    private String address;

    public TelephoneBookEntry(String firstName, String lastName, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumbers = new ArrayList<>();
    }

    public void addPhoneNumber(String number) {
        phoneNumbers.add(number);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Name: " + firstName + " " + lastName +
                "\nAdresse: " + address +
                "\nTelefonnummern: " + phoneNumbers + "\n";
    }
}
