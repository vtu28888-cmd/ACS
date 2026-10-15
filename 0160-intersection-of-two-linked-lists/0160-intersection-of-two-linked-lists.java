/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        
        ListNode pA = headA;
        ListNode pB = headB;
        
        // Loop until they meet at the intersection node (or both become null)
        while (pA != pB) {
            // If pA reaches the end of listA, redirect to headB; otherwise, move to next
            pA = (pA == null) ? headB : pA.next;
            
            // If pB reaches the end of listB, redirect to headA; otherwise, move to next
            pB = (pB == null) ? headA : pB.next;
        }
        
        return pA;
    }
}