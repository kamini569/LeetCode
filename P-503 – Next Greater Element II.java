LeetCode P-503 – Next Greater Element II

📝 Intuition

The array is circular, so after the last element, we continue from the beginning.
For each element, we need the next greater element while moving forward.

To handle circular behavior efficiently, we traverse the array twice and use a stack to keep possible next greater elements.

🧠 Approach

Create a result array ans of size n.

Use a stack to store elements.

Traverse the array from index 2n - 1 to 0:

Use i % n to handle circular indexing.

While stack is not empty and top element ≤ current element → remove it.

If stack is empty → next greater = -1
Else → next greater = stack top.

Push current element into stack.

Return the result array.

⚙️ Complexity

⏱️ Time Complexity
O(n) — Each element is pushed and popped at most once.

💾 Space Complexity
O(n) — Stack and result array.

💻 Solution

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        LinkedList<Integer> stack = new LinkedList<>();
        int[] ans = new int[nums.length];
        int n = nums.length;

        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peekLast() <= nums[i % n]) {
                stack.removeLast();
            }
            ans[i % n] = stack.isEmpty() ? -1 : stack.peekLast();
            stack.addLast(nums[i % n]);
        }
        return ans;
    }
}
