📝 Intuition

The Tribonacci sequence is similar to Fibonacci, but instead of adding two previous numbers, we add the last three numbers.

T0 = 0
T1 = 1
T2 = 1
For n ≥ 3:
Tn = Tn-1 + Tn-2 + Tn-3

We can calculate it iteratively to avoid repeated calculations.

🧠 Approach

Handle base cases:

If n == 0 → return 0

If n == 1 or n == 2 → return 1

Use three variables:

a = 0 (T0)

b = 1 (T1)

c = 1 (T2)

Loop from 3 to n:

d = a + b + c

Update values:

a = b

b = c

c = d

Return c

⚙️ Complexity
⏱️ Time Complexity

O(n) — Loop runs up to n.

💾 Space Complexity

O(1) — Only three variables are used.

💻 Solution
class Solution {
    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        int a = 0, b = 1, c = 1;

        for (int i = 3; i <= n; i++) {
            int d = a + b + c;
            a = b;
            b = c;
            c = d;
        }

        return c;
    }
}
