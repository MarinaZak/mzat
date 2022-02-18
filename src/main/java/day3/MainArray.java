package day3;

import java.util.Arrays;

public class MainArray {
    public static void main(String[] args) {
        //1) Find max number in array: 5, 9, 3, 2, 0, -4, -8.3, 3, -4
        double[] array1 = new double[]{5, 9, 3, 2, 0, -4, -8.3, 3, -4};
        double max = array1[0];
        for (double d:array1) {
            if (max < d) {
                max = d;
            }
        }
        System.out.println("max: "+max);

        //2) Given array: {1, 6, 3, 3, 4, 5, 5, 6, 0}. Print array with only unique values, which are sorted.
        int[] array2 = new int[]{1, 6, 3, 3, 4, 5, 5, 6, 0};
        int[] res2 = new int[array2.length];
        res2[0] = array2[0];
        int resIndex = 0;
        for (int i:array2) {
            if (!contains(res2,i)) {
                res2[resIndex++] = i;
            }
        }
        Arrays.sort(res2);
        System.out.println(Arrays.toString(res2));

        //3)Given an array, e.g. "12", "23", "34", "12", "56", "67“. Replace all values “12” to “replaced”
        String[] array3 = new String[]{"12", "23", "34", "12", "56", "67"};
        for (int i=0; i<array3.length; i++) {
            if (array3[i]=="12") {
                array3[i]="replaced";
            }
        }
        System.out.println(Arrays.toString(array3));

        //4) Print any array in reverse mode (from the end)
        String[] array4 = new String[]{"12", "23", "34", "12", "56", "67"};
        String[] rev = new String[array4.length];
        for(int i=array4.length-1; i>-1; i--){
            rev[array4.length-1-i]=array4[i];
        }
        System.out.println(Arrays.toString(rev));
    }

    private static boolean contains(int[] testArray, int testValue){
        for(int i:testArray){
            if(i==testValue){
                return true;
            }
        }
        return false;
    }




}
