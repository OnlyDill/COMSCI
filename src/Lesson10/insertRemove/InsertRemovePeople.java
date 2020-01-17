/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lesson10.insertRemove;

import static Lesson10.insertRemove.InsertRemoveFruit.logicalSize;

/**
 *
 * @author just5040
 */
public class InsertRemovePeople {

    static int logicalSize = 0;

    public static void main(String[] args) {
        Person peeps[] = new Person[10];
        peeps[0] = new Person("Andy", "male", 45);
        peeps[1] = new Person("Deb", "female", 55);
        peeps[2] = new Person("Mike", "male", 17);
        peeps[3] = new Person("Sue", "female", 28);
        
        logicalSize = 4;
        showPeeps(peeps);
        System.out.println("Inserting Joe, male, age 32");
        Person p = new Person ("Joe", "male", 32);
        int loc = findInsertPoint(peeps, p);
        insert(peeps, p, loc); //arr, new item, where it goes
        
        showPeeps(peeps);
        System.out.println("Inserting Leonard and Penny");
        p = new Person ("Leonard", "male", 38);
        loc = findInsertPoint(peeps, p);
        insert(peeps, p, loc);
        
        p = new Person ("Penny", "female", 36);
        loc = findInsertPoint(peeps, p);
        insert(peeps, p, loc);
        
        showPeeps (peeps);
        
        ////////////////Testing Delete///////////////////////
        System.out.println("Deleting Mike");
        loc = search(peeps, new Person("Mike","",0));
        
        if(delete(peeps, loc)==true){
            System.out.println("Person was deleted");
        }
        else
            System.out.println("Person was NOT deleted");
        showPeeps(peeps);
        
        System.out.println("Deleting Penny");
        loc = search(peeps, new Person("Penny","",0));
        
        if(delete(peeps, loc)==true){
            System.out.println("Person was deleted");
        }
        else
            System.out.println("Person was NOT deleted");
        showPeeps(peeps);
        
        System.out.println("Deleting Bill");
        loc = search(peeps, new Person("Bill","",0));
        
        if(delete(peeps, loc)==true){
            System.out.println("Person was deleted");
        }
        else
            System.out.println("Person was NOT deleted");
        showPeeps(peeps);
    }

    public static void showPeeps(Person arr[]) {
        for (int i = 0; i < logicalSize; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("\n---------------------------\n");
    }
    /////This is a BINARY search////
    ///We call this FIRST to find the location to be deleted

    public static int search(Object[] a, Object searchValue) {
        int left = 0;
        int right = logicalSize - 1;
        while (left <= right) {
            int midpoint = (left + right) / 2;
            int result = ((Comparable) a[midpoint]).compareTo(searchValue);
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
    public static int findInsertPoint(Object a[], Object searchValue) {
        int left = 0;
        int right = logicalSize - 1;
        int midpoint = 0;

        while (left <= right) {
            midpoint = (left + right) / 2;

            int result = ((Comparable) a[midpoint]).compareTo(searchValue);

            if (result < 0) {
                left = midpoint + 1;
            } else {
                right = midpoint - 1;
            }
        }
        if (((Comparable) a[midpoint]).compareTo(searchValue) < 0) {
            midpoint++;
        }
        return midpoint;
    }
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
