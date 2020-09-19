class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        
        for (int i = 0; i <= n ; i++) {
            first = first.next;
        }
        
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        
        second.next = second.next.next;
        return dummy.next;
        
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }   
        return head;
    }

      public Node insert(Node head, int insertVal) {
        if (head == null) {
          Node newNode = new Node(insertVal, null);
          newNode.next = newNode;
          return newNode;
        }

        Node prev = head;
        Node curr = head.next;
        boolean toInsert = false;

        do {
          if (prev.val <= insertVal && insertVal <= curr.val) {
            toInsert = true;
          } else if (prev.val > curr.val) {
            if (insertVal >= prev.val || insertVal <= curr.val)
              toInsert = true;
          }

          if (toInsert) {
            prev.next = new Node(insertVal, curr);
            return head;
          }

          prev = curr;
          curr = curr.next;
        } while (prev != head);
        prev.next = new Node(insertVal, curr);
        return head;
    }

    public int getDecimalValue(ListNode head) {
        int num = head.val;
        while (head.next != null) {
            num = num * 2 + head.next.val;
            head = head.next;    
        }
        return num;
    }

    public ListNode partition(ListNode head, int x) {

        ListNode before_head = new ListNode(0);
        ListNode before = before_head;
        ListNode after_head = new ListNode(0);
        ListNode after = after_head;

        while (head != null) {
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }
        after.next = null;
        before.next = after_head.next;

        return before_head.next;
    }
}