import java.util.*;
public class MergeKSortedLists {
    public static void main(String[] args) {
        List<ListNode> lists = new ArrayList<>();
        lists.add(createLinkedList(new int[]{1, 4, 5}));
        lists.add(createLinkedList(new int[]{1, 3, 4}));
        lists.add(createLinkedList(new int[]{2, 6}));
        ListNode merged = mergeKLists(lists);
        while (merged != null) {
            System.out.print(merged.val + " ");
            merged = merged.next;
        }
    }
    public static ListNode mergeKLists(List<ListNode> lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll();
            curr.next = minNode;
            curr = curr.next;
            if (minNode.next != null) {
                pq.add(minNode.next);
            }
        }
        return dummy.next;
    }
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
    private static ListNode createLinkedList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int num : arr) {
            curr.next = new ListNode(num);
            curr = curr.next;
        }
        return dummy.next;
    }
}
