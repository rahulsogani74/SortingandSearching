import java.util.Arrays;

public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public static void main(String[] args) {
        KthLargestElement solution = new KthLargestElement();
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        int kthLargest = solution.findKthLargest(nums, k);
        System.out.println("Kth largest element: " + kthLargest);
    }
}
