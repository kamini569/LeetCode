Intuition

For each day, we want to find the next day with a higher temperature.
Checking every future day would be slow, so we use a stack to keep track of useful future days.

Approach

Use a stack that stores indices of days

Traverse the array from right to left

For each day i:

Remove indices from the stack while their temperature is less than or equal to the current day

After removal:

If the stack is empty → no warmer day exists → result is 0

Else → the top of the stack is the next warmer day

Store the difference of indices in result[i]

Push the current index into the stack

Finally, return the result array

Complexity
Time Complexity

O(n)
Each index is pushed and popped from the stack at most once.

Space Complexity

O(n)
The stack and result array both use extra space.
Solution:
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
