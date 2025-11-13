package ue_2_s2410238052;

import lecture.chapter03.IKey;

public class TelephoneBookEntryKey implements IKey {

    private String firstName;
    private String lastName;

    public TelephoneBookEntryKey(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public boolean matches(Object object) {
        if (!(object instanceof TelephoneBookEntry)) {
            return false;
        }

        TelephoneBookEntry entry = (TelephoneBookEntry) object;

        return entry.getFirstName().equalsIgnoreCase(firstName)
            && entry.getLastName().equalsIgnoreCase(lastName);
    }
}
