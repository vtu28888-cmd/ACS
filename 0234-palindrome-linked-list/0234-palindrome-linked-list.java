/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        // Step 1: Find the middle of the linked list
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the list starting from slow
        ListNode secondHalfHead = reverseList(slow);
        ListNode firstHalfHead = head;

        // Step 3: Compare values of first half and reversed second half
        ListNode temp = secondHalfHead;
        boolean isPalindrome = true;
        while (temp != null) {
            if (firstHalfHead.val != temp.val) {
                isPalindrome = false;
                break;
            }
            firstHalfHead = firstHalfHead.next;
            temp = temp.next;
        }

        // Optional Step 4: Restore the original list structure
        reverseList(secondHalfHead);

        return isPalindrome;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }
}