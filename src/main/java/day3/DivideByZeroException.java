package day3;

//1) Make your own Exception implementation. Use it in your CalcApp
public class DivideByZeroException extends Exception {
    public DivideByZeroException(String message){
        super(message+"abcde");
    }
}
