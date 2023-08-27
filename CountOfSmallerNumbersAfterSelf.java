import java.util.*;
public class CountOfSmallerNumbersAfterSelf {
    public static void main(String[] args) {
        int[] nums = {5, 2, 6, 1};
        int[] count = countSmaller(nums);
        System.out.println(Arrays.toString(count));
    }
    public static int[] countSmaller(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        List<Integer> sorted = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            int index = binarySearch(sorted, nums[i]);
            sorted.add(index, nums[i]);
            result[i] = index;
        }
        return result;
    }
    private static int binarySearch(List<Integer> list, int target) {
        int left = 0;
        int right = list.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) >= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
