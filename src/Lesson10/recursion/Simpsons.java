package Lesson10.recursion;

public class Simpsons {

    static String start[] = {"Simpsons go to cave",
        "Lisa gets trapped with Monty Burns",
        "Monty gets job at Moes",
        "Moe gets gold and dates Edna",
        "Edna goes into school to resign"};
    static String end[] = {"Simpsons leave the cave",
        "Burns get photo with Lisa",
        "Monty gets back everything but his plant until he gets picture",
        "Moes heart broken, puts gold in jukebox",
        "Edna decides to stay in school"};
    
    public static void story(int n){
        System.out.println(start[n]);
        //are there more starts
        if(n < end.length-1)
            story(n+1); //call the next start
        //print each ending
        System.out.println(end[n]);
    }
    public static void main(String[] args) {
        story(0);
    }

}
