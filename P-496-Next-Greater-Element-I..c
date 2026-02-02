Intuition

To find how many days we must wait for a warmer temperature, we need to quickly know the next greater temperature for each day.
Using a stack helps track future days that can be warmer than the current day.

Approach

Traverse the temperature array from right to left

Use a stack to store indices of days

For each day:

Remove all days from the stack that have temperatures less than or equal to the current day

If the stack is empty, no warmer day exists → answer is 0

Otherwise, the top of the stack gives the next warmer day

Push the current index into the stack

Complexity
Time Complexity

O(n)
Each element is pushed and popped from the stack at most once.

Space Complexity

O(n)
Extra space is used for the stack and result array.

Solution
#include <vector>
using namespace std;

class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& temperatures) {
        int n = temperatures.size();
        vector<int> result(n, 0);
        vector<int> stack; // stores indices

        for (int i = n - 1; i >= 0; --i) {
            while (!stack.empty() && temperatures[i] >= temperatures[stack.back()]) {
                stack.pop_back();
            }
            result[i] = stack.empty() ? 0 : stack.back() - i;
            stack.push_back(i);
        }
        return result;
    }
};
