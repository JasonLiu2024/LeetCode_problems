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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        ListNode cur = result;
        boolean add1 = false;
        while(l1 != null || l2 != null){
            int temp = 0;
            if(l1 == null){
                temp = l2.val;
                l2 = l2.next;
            }else if(l2 == null){
                temp = l1.val;
                l1 = l1.next;
            } else{
                temp = l1.val + l2.val;
                l1 = l1.next;
                l2 = l2.next;
            }
            if(add1){
                temp++;
            } 
            if(temp >= 10){
                add1 = true;
                temp = temp - 10;
            } else{
                add1 = false;
            }
            ListNode num = new ListNode();
            num.val = temp;
            cur.next = num;
            cur = cur.next;
        }
        if(add1){
            ListNode lastNum = new ListNode();
            lastNum.val = 1;
            cur.next = lastNum;
            cur = cur.next;
        }
        return result.next;
    }
}
