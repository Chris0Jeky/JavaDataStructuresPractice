import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        int rand = (int)(Math.random() * 100);
        System.out.println(rand);
        ArrayList<Integer> arrayo = new ArrayList<>();
        for (int i = 0; i < 20; i++){
            arrayo.add((int)(Math.random() * 10));
        }
        Integer[] puarr = arrayo.toArray(new Integer[20]);

        System.out.println(Arrays.toString(puarr));

        solutionHashMap(puarr, 8);

    }

    public static void solutionHashMap(Integer[] ar, int k) {
        HashMap<Integer, Integer> broom = new HashMap<>();
        int counter = 0;
        for(int i = 0; i < ar.length; i++){
            if (!broom.containsKey(ar[i])){
                broom.put(ar[i], 1);
                System.out.println("Put my first " + ar[i]);
            }
            else {
                broom.put(ar[i], broom.get(ar[i]) + 1);
                System.out.println("Put " + ar[i] + " " + broom.get(ar[i]) + " times");
            }
        }
        System.out.println(broom.toString());

        for (int i = 0; i < ar.length; i++){
            int complement = k - ar[i];
            if (broom.containsKey(complement) && broom.get(complement) > 0 && broom.get(ar[i]) > 0) {
                counter++;
                broom.put(complement, broom.get(complement) - 1);
                broom.put(ar[i], broom.get(ar[i]) - 1);
            }
        }
        System.out.println(counter);
        System.out.println(broom.toString());
    }

    public static int solutionQuadratic(Integer[] ar, int k){
        int counter = 0;
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar.length; j++) {

            }
        }
        return counter;
    }
}