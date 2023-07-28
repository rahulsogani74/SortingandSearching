public class FindFirstAndLastPositionOfElementInSortedArray {
    public static class FirstLastPositionInSortedArray {
        public static int[] searchRange(int[] nums, int target) {
            int[] result = {-1, -1};
            int n = nums.length;
            int firstOccurrence = -1;
            int lastOccurrence = -1;

            for (int i = 0; i < n; i++) {
                if (nums[i] == target) {
                    firstOccurrence = i;
                    break;
                }
            }
            for (int i = n - 1; i >= 0; i--) {
                if (nums[i] == target) {
                    lastOccurrence = i;
                    break;
                }
            }
            result[0] = firstOccurrence;
            result[1] = lastOccurrence;
            return result;
        }
        public static void main(String[] args) {
            int[] nums = {5, 7, 7, 8, 8, 10};
            int target = 8;
            int[] result = searchRange(nums, target);

            System.out.println("First Position: " + result[0]);
            System.out.println("Last Position: " + result[1]);
        }
    }
}
