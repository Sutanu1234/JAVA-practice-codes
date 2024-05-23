/*
 Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.

 Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5]
 Output: Intersected at '8'
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int a = getLength(headA);
        int b = getLength(headB);

        while(a > b){
            a--;
            headA = headA.next;
        }
        while(a < b){
            b--;
            headB = headB.next;
        }
        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    private int getLength(ListNode head) {
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }
}
