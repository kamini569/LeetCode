📝 Intuition

Both arrays are sorted.
We need the middle element of the combined array.
Instead of merging completely, we use binary search to find the correct partition so that left side has smaller elements and right side has larger elements.

🧠 Approach

Always apply binary search on the smaller array.

Divide both arrays into two parts such that total elements on left side = total elements on right side.

Find:

left1, right1 from nums1

left2, right2 from nums2

If
left1 <= right2 and left2 <= right1
then partition is correct.

If total length is even → median = average of max(left) and min(right)

If odd → median = max(left)

If left1 > right2 → move left

Else → move right

⚙️ Complexity

⏱️ Time Complexity
O(log(min(m, n)))

💾 Space Complexity
O(1)

💻 Solution

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;
        int low = 0, high = m;

        while (low <= high) {
            int cut1 = (low + high) / 2;
            int cut2 = (m + n + 1) / 2 - cut1;

            int left1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int right1 = (cut1 == m) ? Integer.MAX_VALUE : nums1[cut1];

            int left2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
            int right2 = (cut2 == n) ? Integer.MAX_VALUE : nums2[cut2];

            if (left1 <= right2 && left2 <= right1) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                } else {
                    return Math.max(left1, left2);
                }
            } else if (left1 > right2) {
                high = cut1 - 1;
            } else {
                low = cut1 + 1;
            }
        }

        return 0.0;
    }
}
