Intuition

To reverse a linked list, we need to change the direction of each node’s next pointer so that it points to the previous node instead of the next one.

Approach

Use three pointers:

prev to store the previous node

curr to store the current node

next to temporarily store the next node

Start with prev = NULL and curr = head

Traverse the list:

Move next to the next node

Reverse the link of the current node

Move prev and curr one step forward

When traversal ends, prev becomes the new head

Return prev

Complexity
Time Complexity

O(n)
Each node is visited once.

Space Complexity

O(1)
Only pointer variables are used.

Solution
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* reverseList(struct ListNode* head) {
    struct ListNode *prev = NULL;
    struct ListNode *curr = head;
    struct ListNode *next = head;

    while(next != NULL) {
        next = next->next;
        curr->next = prev;
        prev = curr;
        curr = next;
    }
    return prev;
}
