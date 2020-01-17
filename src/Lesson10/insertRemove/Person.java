/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lesson10.insertRemove;

import Lesson10.searching.ISSStudent;

public class Person implements Comparable {
    private String name, gender;
    private int age;
    
    public Person(String nm, String g, int a){
        name = nm;
        gender = g;
        age = a;
    }
    
    public String getName(){
        return name;
    }
    
    public int getAge(){
        return age;
    }
    
    public String getGender(){
        return gender;    
    }
    public String toString(){
        //Bob: Age 12 | male
        return name + ": Age " +  age + " | " + gender;
    }
    
    @Override
    public int compareTo(Object t) {
        String othername = ((Person)t).getName();
        return name.compareTo(othername); //0 = match
    }
}
