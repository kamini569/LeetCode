Intuition

To remove the nth node from the end, we first need to know the total number of nodes in the linked list.
Once the length is known, we can find the position of the node that must be removed from the start.

Approach

Traverse the linked list once to count the total number of nodes

If the node to remove is the head node (totalElements == n), return head->next

Otherwise:

Calculate the position from the start as totalElements - n

Traverse the list again until just before this position

Adjust the next pointer to skip the required node

Return the updated head of the list

Complexity
Time Complexity

O(n)
The list is traversed at most two times.

Space Complexity

O(1)
Only a few pointers and variables are used.

Solution
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* removeNthFromEnd(struct ListNode* head, int n) {
    int totalElements = 0;
    struct ListNode *curr = head;

    while(curr != NULL) {
        totalElements++;
        curr = curr->next;
    }
    if(totalElements == n){
        return head->next;
    }
    int post = totalElements - n;
    int i = 1;
    curr = head;
    while(i < post) {
        curr = curr->next;
        i++;
    }
    if(curr->next != NULL)
        curr->next = curr->next->next;

    return head;
}
