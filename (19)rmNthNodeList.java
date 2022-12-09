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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode iter = head; int len = 0;
        while(iter != null){ // go to end of list
            iter = iter.next;
            len++;
        }
        int target = len - n - 1; iter = head;
        if(target == 0){
            head.next = head.next.next;
        }else if(target < 0){
            head = head.next;
        }else{
            for(int i = 0; i < len - n - 1; i++){
            iter = iter.next;
            }
            iter.next = iter.next.next;
        }
        return head;
    }
}
