package day35;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode current = head;
        int length = 0;
        while (current != null) {
            length++;
            current = current.next;
        }
        int mid = length / 2;
        int i = 0;
        ListNode res = head;
        while (i < mid) {
            res = res.next;
            i++;
        }

        return res;
    }
}
