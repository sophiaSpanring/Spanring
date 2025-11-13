package ue_2_s2410238052;

import lecture.chapter03.tests.Student;
import lecture.chapter03.IFIterator;
import lecture.chapter03.IKey;
import lecture.chapter03.SList;

public class TestMySList {

    public static void main(String[] args) {
        MySList list = new MySList();

        // Aufgabe 1: append testen

        System.out.println("Aufgabe 1: append");
        // Beispiel-Studenten anlegen
        Student s1 = new Student("M001", "Anna",  "Muster");
        Student s2 = new Student("M002", "Ben",   "Beispiel");
        Student s3 = new Student("M003", "Carla", "Demo");

        // append testen
        list.append(s1);
        list.append(s2);
        list.append(s3);

        // Ausgabe zur Kontrolle
        System.out.println("Inhalt der Liste nach append:");
        IFIterator it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        // Aufgabe 2: insert testen

        // neues Student-Objekt, das wir hinter s2 einfügen wollen
        Student s4 = new Student("M010","Lena","Neu");

        System.out.println();
        System.out.println("Aufgabe 2: insert");
        System.out.println("Liste vor insert(s2, s4):");
        it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        // erfolgreicher Insert: s4 soll hinter s2 eingefügt werden
        boolean result1 = list.insert(s2, s4);
        System.out.println();
        System.out.println("Rückgabewert von insert(s2, s4): " + result1);

        System.out.println("Liste nach insert(s2, s4):");
        it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        // Negativfall: prev ist NICHT in der Liste - insert muss false liefern
        Student notInList = new Student("X999","Fake","KeinEintrag");
        boolean result2 = list.insert(notInList,
                new Student("M011","Extra","SollNichtEingefügtWerden"));

        System.out.println();
        System.out.println("Rückgabewert von insert(notInList, ...): " + result2);
        System.out.println("(hier soll false herauskommen, Liste bleibt unverändert)");

        // Aufgabe 3: searchAll testen

        // Noch einen Student ergänzen, der auch "Muster" in der Ausgabe hat
        Student s5 = new Student("M004","Lena","Muster");
        list.append(s5);

        System.out.println();
        System.out.println("Aufgabe 3: searchAll");

        // IKey, der alle Studenten findet, deren toString() "Muster" enthält
        IKey key = new IKey() {
            @Override
            public boolean matches(Object object) {
                return object != null && object.toString().contains("Muster");
            }
        };

        // Suche alle passenden Studenten
        SList resultList = list.searchAll(key);

        System.out.println("Alle Studenten, die 'Muster' enthalten:");
        IFIterator it3 = resultList.iterator();
        while (it3.hasNext()) {
            System.out.println(it3.next());
        }

        // Aufgabe 4: Telefonbuch-Einträge testen

        System.out.println();
        System.out.println("Aufgabe 4: Telefonbuch Testen");

        MySList phoneList = new MySList();

        TelephoneBookEntry e1 = new TelephoneBookEntry("Anna", "Huber", "Linz, Landstrasse 1");
        e1.addPhoneNumber("0660 1234567");
        e1.addPhoneNumber("0732 555555");

        TelephoneBookEntry e2 = new TelephoneBookEntry("Ben", "Huber", "Wels, Kaiser Josef Platz 3");
        e2.addPhoneNumber("0650 9876543");

        TelephoneBookEntry e3 = new TelephoneBookEntry("Anna", "Müller", "Steyr, Ennskai 10");
        e3.addPhoneNumber("0676 1122334");

        phoneList.append(e1);
        phoneList.append(e2);
        phoneList.append(e3);

        // Key zum Suchen nach Vorname + Nachname
        TelephoneBookEntryKey keyHuberAnna = new TelephoneBookEntryKey("Anna", "Huber");

        System.out.println("\nSuche nach Anna Huber (search):");
        Object found = phoneList.search(keyHuberAnna);
        System.out.println(found);

        System.out.println("Suche nach allen Hubers mit Anna (searchAll):");
        SList allFound = phoneList.searchAll(keyHuberAnna);

        var it4 = allFound.iterator();
        while (it4.hasNext()) {
            System.out.println(it4.next());
        }

    }
}
