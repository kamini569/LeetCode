LeetCode P-496 – Next Greater Element I

📝 Intuition

For each element in nums1, we need to find its next greater element in nums2.
Instead of searching again and again, we first compute the next greater element for all elements of nums2 using a stack, and store the result in a map.

🧠 Approach

Use a stack and traverse nums2 from right to left.

For each element:

Remove all smaller or equal elements from the stack.

If stack is empty → next greater = -1
Else → next greater = stack top.

Store this in a map: element → next greater.

Push current element into stack.

Now for each element in nums1, get its answer directly from the map.

Return the result array.

⚙️ Complexity

⏱️ Time Complexity
O(n + m) — One pass for nums2 and one for nums1.

💾 Space Complexity
O(n) — Stack and HashMap.

💻 Solution

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        LinkedList<Integer> stack = new LinkedList<>();

        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peekLast() <= nums2[i]) {
                stack.removeLast();
            }
            map.put(nums2[i], stack.isEmpty() ? -1 : stack.peekLast());
            stack.addLast(nums2[i]);
        }

        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }

        return ans;
    }
}
