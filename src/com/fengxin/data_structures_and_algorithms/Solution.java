package com.fengxin.data_structures_and_algorithms;

/**
 * @author FENGXIN
 * @data 2024.5.1
 **/

public class Solution {
    public static void main (String[] args) {
        ListNode linkedList = new ListNode(-3);
        linkedList.next = new ListNode(5);
        linkedList.next.next = new ListNode(99);
        ListNode newList = deleteNode(linkedList, -3);
        while (newList != null) {
            System.out.println (newList.val);
            newList = newList.next;
        }
    }
    public static ListNode deleteNode(ListNode head, int val) {
        if(head == null){
            return null;
        }
        ListNode dummy = new ListNode(-1);
        ListNode preNode = dummy;
        preNode.next = head;
        while(preNode.next.val != val){
            preNode = preNode.next;
        }
        ListNode removeNode = preNode.next;
        preNode.next = removeNode.next;
        removeNode.next = null;
        return head;
    }
}
class ListNode {
   int val;
   ListNode next;
  ListNode(int x) { val = x; }
}



