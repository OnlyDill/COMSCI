package Lesson10.searching;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StuSearchEx1 {

    public static void main(String[] args) {
        Scanner scan1, scan2;
        scan2 = new Scanner(System.in);
        ISSStudent iss[] = new ISSStudent[100];
        String nm, ad;
        int id;
        try {
            scan1 = new Scanner(new File("studata.txt"));
            for (int i = 0; i < 100; i++) {
                nm = scan1.nextLine();
                ad = scan1.nextLine();
                id = Integer.parseInt(scan1.nextLine());
                iss[i] = new ISSStudent(nm, ad, id);
                System.out.println(iss[i]);
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }

        //ask for id, make a temp iss student and search for student
        System.out.print("Enter a Student ID to search > ");
        int sid = scan2.nextInt();
        ISSStudent temp = new ISSStudent("", "", sid);
        int loc = search(iss, temp);
        if (loc > -1) {
            System.out.println(iss[loc]);
        } else {
            System.out.println("Student not found");
        }
    }

    public static int search(Object[] a, Object searchValue) {
        int tries = 0;
        int left = 0;
        int right = a.length - 1;
        while (left <= right) {
            int midpoint = (left + right) / 2;
            int result = ((Comparable) a[midpoint]).compareTo(searchValue);
            tries++;
            if (result == 0) {
                System.out.println("Binary returning after " + tries + " tries.");
                return midpoint;
            } else if (result < 0) {
                left = midpoint + 1;
            } else {
                right = midpoint - 1;
            }
        }
        System.out.println("Binary returning after " + tries + " tries.");
        return -1;

    }

}


