import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MargeIntervals {
    public static int[][] mergeIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        ArrayList<int[]> list = new ArrayList<>();
        for (int[] interval : intervals) {
            if (list.size() == 0) {
                list.add(interval);
            } else {
                int[] preInterval = list.get(list.size() - 1);
                if (interval[0] < preInterval[1]) {
                    preInterval[1] = Math.max(preInterval[1], interval[1]);
                } else {
                    list.add(interval);
                }
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of intervals: ");
        int n = scanner.nextInt();
        int[][] input = new int[n][2];
        System.out.println("Enter the intervals (start end):");
        for (int i = 0; i < n; i++) {
            input[i][0] = scanner.nextInt();
            input[i][1] = scanner.nextInt();
        }
        int[][] mergedIntervals = mergeIntervals(input);
        System.out.println("Merged Intervals:");
        for (int[] interval : mergedIntervals) {
            System.out.println(interval[0] + " " + interval[1]);
        }
    }
}
