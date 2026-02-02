Intuition

If a linked list has a cycle, moving through the list will eventually bring us back to a previously visited node.
By using two pointers that move at different speeds, we can detect whether such a loop exists.

Approach

Use two pointers:

slow moves one step at a time

fast moves two steps at a time

Initially:

slow starts at head

fast starts at head->next

Traverse the list:

If at any point slow == fast, a cycle exists

If fast or fast->next becomes NULL, the list has no cycle

If the loop ends with slow == fast, return true

Otherwise, return false

Complexity
Time Complexity

O(n)
Each node is visited at most once by the pointers.

Space Complexity

O(1)
Only two pointers are used; no extra memory is required.
Solution:
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */

bool hasCycle(struct ListNode *head) {
    if (head == NULL || head->next == NULL) 
        return false;

    struct ListNode *slow = head;
    struct ListNode *fast = head->next;

    while (slow != fast) {
        if (fast == NULL || fast->next == NULL)
            return false;

        slow = slow->next;          // move slow by 1
        fast = fast->next->next;    // move fast by 2
    }

    return true;  // slow == fast -> cycle exists
}
