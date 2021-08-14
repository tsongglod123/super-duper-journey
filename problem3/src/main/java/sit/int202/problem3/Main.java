package sit.int202.problem3;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        int[] list = new int[]{1, 2, 3, 5, 8, 7, 9, 6, 4};

        Scanner input = new Scanner(System.in);
        System.out.print("input: ");
        int number = input.nextInt();

        Map<Integer, Integer> pair = new HashMap<>();
        for (int i = 0; i < list.length; i++) {
            int result = number - list[i];
            if (result > list[i]) {
                List<Integer> k = Arrays.stream(list).boxed().collect(Collectors.toList());
                pair.put(k.indexOf(result), i);
            }
        }
        pair.forEach((x, y) -> System.out.print("(" + x + ", " + y + ")"));
    }
}
