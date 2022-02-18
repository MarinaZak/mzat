package day3;

import java.util.*;

public class MainCollection {
    public static void main(String[] args) {
        //1) Implement an application to work with a list. In the 1st half of the list replace all elements E1 with E2
        Integer e1=5;
        Integer e2=7;
        List<Integer> collection1 = Arrays.asList(3,9,5,15,29,61,37,48);
        for(int i=0; i<collection1.size()/2; i++){
            if(collection1.get(i)==e1){
                collection1.set(i,e2);
            }
        }
        System.out.println(collection1);

        //2) Input: matrix of integers.
        //a) Print out matrix in reverse order.
        List<List<Integer>> collection2 = Arrays.asList(
                Arrays.asList(3,9,5,15),
                Arrays.asList(29,61,37,48),
                Arrays.asList(30,93,30,14),
                Arrays.asList(2,19,73,61)
        );

        for(int i1=0; i1<collection2.size();i1++){
            System.out.println();
            for(int i2=0; i2<collection2.get(i1).size();i2++){
                System.out.print(collection2.get(i2).get(i1)+" ");
            }
        }

        System.out.println();

        //b) Print out matrix with unique values (delete duplicates)
        Set<Integer> uniqueSet = new HashSet<>();
        for(int i1=0; i1<collection2.size();i1++){
            System.out.println();
            for(int i2=0; i2<collection2.get(i1).size();i2++){
                if(uniqueSet.contains(collection2.get(i1).get(i2))){
                    collection2.get(i1).set(i2,0);
                }
                else {
                    uniqueSet.add(collection2.get(i1).get(i2));
                }
                System.out.print(collection2.get(i1).get(i2)+" ");
            }
        }

        System.out.println();

        //3) Given: String with big text (more than 1000 words). Write a method that calculates
        // the numbers of words for each letter that starts the word.
        System.out.println();
        String s = "String with big text more than 1000 words. Write a method that calculates " +
                "the numbers of words for each letter that starts the word.";
        Map<Character,Integer> res = new HashMap<>();
        for(String w:s.split(" ")){
            res.putIfAbsent(w.charAt(0),0);
            res.put(w.charAt(0), res.get(w.charAt(0))+1);
        }
        System.out.println(new TreeMap<>(res));

        System.out.println();

        //4) Check performance for some List operations (get(i), insertAfter(i), ..) for different collection implementations.
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new LinkedList<>();
        for(int i=0; i<1000;i++){
            list1.add(UUID.randomUUID().toString());
            list2.add(UUID.randomUUID().toString());
        }
        System.out.println(checkPerfGet(list1));
        System.out.println(checkPerfGet(list2));

    }

    private static long checkPerfGet(List<String> list1) {
        long start = new Date().getTime();
        Random rand = new Random();
        for(int i=0; i<1000;i++){
            int length = list1.get(rand.nextInt(list1.size()-1)).length();
        }
        return new Date().getTime()-start;
    }
}
