package day3;
//Task 1. Implement a simple calculator with 4 operations. Each operation - different method. Use it in the main method.
public class Calculator {
    public static void main(String[] args) throws DivideByZeroException {
        int a=1;
        int b=2;
        System.out.println(add(a,b));
        System.out.println(minus(a,b));
        System.out.println(mult(a,b));
        System.out.println(divide(a,b));

        System.out.println(divide(5,0));
    }

    private static int add(int a, int b) {
        return a+b;
    }

    private static int minus(int a, int b) {
        return a-b;
    }

    private static int mult(int a, int b) {
        return a*b;
    }

    private static int divide(int a, int b) throws DivideByZeroException {
        if(b==0) throw new DivideByZeroException("");
        return a/b;
    }
}
