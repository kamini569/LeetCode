Intuition

Each linked list stores digits in reverse order, so we can add them digit by digit, just like normal addition.
We also need to handle a carry if the sum of digits is greater than 9.

Approach

Create a dummy node to build the result list easily

Use a carry variable initialized to 0

Traverse both linked lists at the same time:

Get the value of current nodes (use 0 if a list is finished)

Add both values and the carry

Store sum % 10 in a new node

Update carry as sum / 10

After traversal, if carry > 0, add a new node

Return the list starting from dummy.next

Complexity
Time Complexity

O(n)
Where n is the length of the longer linked list.

Space Complexity

O(n)
A new linked list is created to store the result.

Solution (Java)
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
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            int sum = x + y + carry;
            carry = sum / 10;

            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

        return dummy.next;
    }
}
