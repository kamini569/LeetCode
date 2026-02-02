Intuition

For each index, we need the product of all elements except itself.
Instead of dividing the total product, we calculate:

the product of elements to the left

the product of elements to the right

Multiplying these two gives the required result.

Approach

Create three arrays:

prodL to store left-side products

prodR to store right-side products

ans to store the final answer

Build the left product array:

prodL[i] stores the product of all elements before index i

Build the right product array:

prodR[i] stores the product of all elements after index i

For each index i:

ans[i] = prodL[i] * prodR[i]

Return the result array

Complexity
Time Complexity

O(n)
Three linear loops are used, each running once over the array.

Space Complexity

O(n)
Extra arrays prodL, prodR, and ans are used.
Solution:
#include <stdlib.h>

int* productExceptSelf(int* arr, int n, int* returnSize) {
    *returnSize = n;

    int* ans = (int*)malloc(n * sizeof(int));
    int* prodL = (int*)malloc(n * sizeof(int));
    int* prodR = (int*)malloc(n * sizeof(int));

    // Left product
    prodL[0] = 1;
    for (int i = 1; i < n; i++) {
        prodL[i] = prodL[i - 1] * arr[i - 1];
    }

    // Right product
    prodR[n - 1] = 1;
    for (int i = n - 2; i >= 0; i--) {
        prodR[i] = prodR[i + 1] * arr[i + 1];
    }

    // Final result
    for (int i = 0; i < n; i++) {
        ans[i] = prodL[i] * prodR[i];
    }
    return ans;
}
