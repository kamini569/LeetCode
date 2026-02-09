LeetCode P-27 – Remove Element

📝 Intuition
We need to remove all occurrences of a given value val in-place and return the count of remaining elements.
Instead of shifting elements every time, we can use two pointers: one for iterating, one for placing valid elements.

🧠 Approach

Initialize k = 0 to track the position of next valid element.

Loop through each element in nums:

If nums[i] != val → place it at nums[k] and increment k.

Return k as the count of elements not equal to val.

⚙️ Complexity
⏱️ Time Complexity
O(n) — Single pass through the array.
💾 Space Complexity
O(1) — No extra space used.

💻 Solution
class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for (int num : nums) {
            if (num != val) {
                nums[k] = num;
                k++;
            }
        }
        return k;
    }
}
