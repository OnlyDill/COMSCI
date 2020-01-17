package Lesson10.Recursion;

public class Fib {

    public static void main(String[] args) {
        int x=11,y=8;
        System.out.println("The " + x + "th fib number is " + fib(x)); //89
        System.out.println("The " + y + "th fib number is " + fib(y)); //21
        System.out.println("-----------Recursive Versions-----------");
        System.out.println("The " + x + "th fib number is " + fib(x)); //89
        System.out.println("The " + y + "th fib number is " + fib(y));
    }
    
    public static int rfib(int num){
        //stopping state is when num is either 1 or 2
        if(num==1 || num == 2) return 1;
        else{
            return rfib(num-1) + rfib(num-2);
        }
    }
    
    public static int fib(int num){
        if(num == 1 || num == 2) return 1;
        
        int num1 = 1, num2 = 1;
        int fibnum=2;
        
        for (int i = 3; i <=num; i++) {
            fibnum = num1 + num2;
            num1 = num2;
            num2 = fibnum;
        }
        return fibnum;
    }
    
}

