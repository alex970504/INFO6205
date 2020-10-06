package week2;

public class reorderLL {
  class Solution {
    public void reorderList(ListNode head) {
      if (head == null)
        return;

      ListNode slow = head, fast = head;
      while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
      }

      ListNode prev = null, curr = slow, tmp;
      while (curr != null) {
        tmp = curr.next;

        curr.next = prev;
        prev = curr;
        curr = tmp;
      }

      ListNode first = head, second = prev;
      while (second != null && second.next != null) {
        tmp = first.next;
        first.next = second;
        first = tmp;

        tmp = second.next;
        second.next = first;
        second = tmp;
      }
    }

  }
}