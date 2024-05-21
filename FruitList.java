import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FruitList {
    public static int countRemainingNumbers(int[] nums) {

        List<Integer> numsList = Arrays.stream(nums)
                .boxed()
                .sorted()
                .collect(Collectors.toList());

        while (!numsList.isEmpty() && !numsList.get(0).equals(numsList.get(numsList.size() - 1))) {
            numsList.remove(0);
            numsList.remove(numsList.size() - 1);
        }

        return numsList.size();

    }

    public static void main(String[] args) {
        // int[] nums = {1, 2, 2, 3, 3, 4, 5, 5, 6};
        int[] nums = { 3, 3, 3, 3, 1 };
        System.out.println("Remaining numbers after deleting pairs: " + countRemainingNumbers(nums));
    }
}