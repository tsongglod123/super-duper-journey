package sit.int202.problem3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] list = new int[]{1, 2, 3, 5, 8, 7, 9, 6, 4};

        Scanner input = new Scanner(System.in);
        System.out.print("input: ");
        int number = input.nextInt();

        List<Integer> intList = new ArrayList<>(list.length);
        for (int i : list) intList.add(i);

        Map<Integer, Integer> pair = new HashMap<>();
        for (int i = 0; i < list.length; i++) {
            int result = number - list[i];
            if (result > list[i] && intList.contains(result)) {
                pair.put(intList.indexOf(result), i);
            }
        }
        pair.forEach((x, y) -> System.out.printf("(%d, %d)", x, y));
    }
}
