package day2;

public class StringCalculator {
     public static void main(String[] args) {

         //Task 2. Given a string, find the number of words in it.
         String s="London is the capital of Great Britain";
         System.out.println(s.split(" ").length);

         //Task 3. Given a string, show number of chars in each word
         for(String w:s.split(" ")){
             System.out.println(w.length());
         }

         //Task 4. Create function which takes 2 parameters:
         //1st(String) – text; 2nd (int) - index of word. Function should return number of chars in word by its index in text
         System.out.println(stringCalculator(s, 0));
     }
    static int stringCalculator(String s, int i){
        return s.split(" ")[i].length();
    }
}
