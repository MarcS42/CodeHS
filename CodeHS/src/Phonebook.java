import java.util.ArrayList;

public class Phonebook {

    private static ArrayList<Contact> contacts = new ArrayList<>();

    public void addContact(Contact addMe)
    {
        contacts.add(addMe);
        printPhonebook();
        origALStringSort(contacts);
        printPhonebook();
    }

    /*This prints each name in the phonebook to the console*/
    public static void printPhonebook()
    {
        StringBuilder printMe = new StringBuilder();
        for(Contact c:contacts)
        {
            printMe.append(c.getName()).append("\n");
        }
        System.out.println(printMe);
    }

    /*InsertionSort1 ArrayList of objects sorted on String instance Var.
    * Uses '.compareTo(String other)'. When AL is partially sorted, it evaluates sorted
    * elements but does change their position other than to shift rt to make space*/
    public static void origALStringSort(ArrayList<Contact> myContacts)
    {
        for(int i = 1; i < myContacts.size(); i++)
        {
            Contact insertMeContact = myContacts.get(i);
            String insertNameValue = insertMeContact.getName();
            int j = i;//j is "not sorted yet this cycle"
            int sortedLoc = j - 1;
            while(j > 0 && myContacts.get(sortedLoc).getName().compareTo(insertNameValue) > 0)
            {
                myContacts.set(j,myContacts.get(sortedLoc));
                j--;
                sortedLoc--; //This line is key if you defined sortedLocation above!
            }
            myContacts.set(j, insertMeContact);
        }
    }
}
