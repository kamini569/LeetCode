📝 Intuition

Each Fibonacci number is the sum of the previous two numbers.
Instead of using recursion (which repeats calculations), we can build the result step by step using iteration.

🧠 Approach

If n == 0, return 0

If n == 1, return 1

Use two variables to store previous two Fibonacci numbers:

prev1 = 0

prev2 = 1

Loop from 2 to n:

current = prev1 + prev2

Update values:

prev1 = prev2

prev2 = current

Return the final value

⚙️ Complexity
⏱️ Time Complexity

O(n) — Loop runs from 2 to n.

💾 Space Complexity

O(1) — Only a few variables are used.

💻 Solution
class Solution {
    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int prev1 = 0, prev2 = 1;

        for (int i = 2; i <= n; i++) {
            int current = prev1 + prev2;
            prev1 = prev2;
            prev2 = current;
        }

        return prev2;
    }
}
