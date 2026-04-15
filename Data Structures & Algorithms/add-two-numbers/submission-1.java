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
        ListNode l3 = new ListNode(0);
        ListNode temp = l3;
        int count = 0;
        while(l1!=null && l2!=null){
            int val = l1.val+l2.val+count;
            if(val>9) count = 1;
            else count = 0;
            val = val % 10;

            temp.next = new ListNode(val);
            temp = temp.next;

            l1=l1.next;
            l2=l2.next;
        }
        while(l1!=null){
            int val = l1.val+count;
            if(val>9) count = 1;
            else count = 0;
            val = val % 10;
            temp.next = new ListNode(val);
            temp = temp.next;

            l1 = l1.next;
        }

        while(l2!=null){
           int val = l2.val+count;
            if(val>9) count = 1;
            else count = 0;
            val = val % 10;
            temp.next = new ListNode(val);
            temp = temp.next;

            l2=l2.next;
        }

        if(count == 1){
            temp.next = new ListNode(1);
            temp = temp.next;
        }

        return l3.next;
    }
}
