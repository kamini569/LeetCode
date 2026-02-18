LeetCode P-21 – Merge Two Sorted Lists

📝 Intuition

Both linked lists are already sorted.
We compare the current nodes of both lists and attach the smaller node to the result list.
Repeat this until one list becomes empty, then attach the remaining part.

🧠 Approach

Create a dummy node to build the result list.

Use a pointer curr to track the current position.

While both lists are not null:

Compare list1.val and list2.val

Attach the smaller node to curr

Move that list forward

Move curr forward

If any list still has nodes, attach it to the result.

Return dummy.next as the head of merged list.

⚙️ Complexity

⏱️ Time Complexity
O(n + m) — Traverse both lists once.

💾 Space Complexity
O(1) — No extra space used.

💻 Solution

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ans = new ListNode();
        ListNode curr = ans;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                curr.next = list1;
                curr = curr.next;
                list1 = list1.next;
            } else {
                curr.next = list2;
                curr = curr.next;
                list2 = list2.next;
            }
        }

        while (list1 != null) {
            curr.next = list1;
            curr = curr.next;
            list1 = list1.next;
        }

        while (list2 != null) {
            curr.next = list2;
            curr = curr.next;
            list2 = list2.next;
        }

        return ans.next;
    }
}
