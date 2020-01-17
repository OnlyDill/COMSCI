package Lesson10.insertRemove;

import static Lesson10.insertRemove.InsertRemovePeople.logicalSize;
import static Lesson10.insertRemove.InsertRemovePeople.search;
import static Lesson10.insertRemove.InsertRemovePeople.showPeeps;
import java.util.ArrayList;

public class PersonArrayList {

    public static void main(String[] args) {
        ArrayList<Person> peeps = new ArrayList();

        /*
        .add(item)              - adds item to bottom of arraylist
        .add(loc, item)         - adds item at given location
        .get();                 - gets a COPY of item at given location
        .remove(loc)            - remove at a location
        .remove(item)           - remove by item
        .set(loc, new item)     - replaces item at location with a new item
        .size()                 - how many items we have
         */
        peeps.add(new Person("Andy", "male", 45));
        peeps.add(new Person("Deb", "female", 55));
        peeps.add(new Person("Mike", "male", 17));
        peeps.add(new Person("Susan", "female", 28));

        showPeeps(peeps);
        
        showPeeps(peeps);
        System.out.println("Inserting Joe, male, age 32");
        Person p = new Person ("Joe", "male", 32);
        int loc = findInsertPoint(peeps, p);
        peeps.add(loc, p); //arr, new item, where it goes
        
        showPeeps(peeps);
        System.out.println("Inserting Leonard and Penny");
        p = new Person ("Leonard", "male", 38);
        loc = findInsertPoint(peeps, p);
        peeps.add(loc, p);
        
        p = new Person ("Penny", "female", 36);
        loc = findInsertPoint(peeps, p);
        peeps.add(loc, p);
        
        showPeeps (peeps);
        
        System.out.println("Deleting Mike");
        loc = search(peeps, new Person("Mike","",0));
        peeps.remove(loc);
        
        System.out.println("Deleting Penny");
        loc = search(peeps, new Person("Penny","",0));
        peeps.remove(loc);
        
        showPeeps(peeps);
       
    }

    public static void showPeeps(ArrayList<Person> a) {
        
        for (Person p : a){
            System.out.println(p);
        }
        System.out.println("---------------------------------");

    }
    
    public static int search(ArrayList a, Object searchValue) {
        int left = 0;
        int right = a.size() - 1;
        while (left <= right) {
            int midpoint = (left + right) / 2;
            int result = ((Comparable) a.get(midpoint)).compareTo(searchValue);
            if (result == 0) {
                return midpoint;
            } else if (result < 0) {
                left = midpoint + 1;
            } else {
                right = midpoint - 1;
            }
        }
        return -1;

    }

    public static boolean delete(Object array[], int targetIndex) {
        if (targetIndex < 0 || targetIndex >= logicalSize) {
            return false;
        }

        // Shift items up by one position
        for (int i = targetIndex; i < logicalSize - 1; i++) {
            array[i] = array[i + 1];
        }

        // Decrement logical size and return true 
        logicalSize--;
        return true;
    }

    //Call this just before inserting - it returns location where new item goes
    //similar to binary search, except we are looking for location of NEW item
////////////////////////////////////////////////////////////////////////////////// 
    public static int findInsertPoint(ArrayList a, Object searchValue) {
        int left = 0;
        int right = a.size() - 1;
        int midpoint = 0;

        while (left <= right) {
            midpoint = (left + right) / 2;

            int result = ((Comparable) a.get(midpoint)).compareTo(searchValue);

            if (result < 0) {
                left = midpoint + 1;
            } else {
                right = midpoint - 1;
            }
        }
        if (((Comparable) a.get(midpoint)).compareTo(searchValue) < 0) {
            midpoint++;
        }
        return midpoint;
    }
//////////////////////////////////////////////////////////////////////////////////
    //call this after findinsertpoint, sending in location we found
    //this starts at bottom and shifts each thing DOWN until we get to insertPoint

    public static boolean insert(Object array[], Object newItem, int targetIndex) {
        // Check for a full array and return false if full
        if (logicalSize == array.length) {
            return false;
        }
        // Check for valid target index or return false 
        if (targetIndex < 0 || targetIndex > logicalSize) {
            return false;
        }
        // Shift items down by one position
        for (int i = logicalSize; i > targetIndex; i--) {
            array[i] = array[i - 1];
        }
        // Add new item, increment logical size,return true                       
        array[targetIndex] = newItem;
        logicalSize++;
        return true;
    }
}
