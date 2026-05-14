#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */ 
    // Optimize standard I/O operations for performance
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    long long N, P, Q, S;
    if (!(cin >> N >> P >> Q >> S)) return 0;

    // Mask to handle modulo 2^31 efficiently using bitwise AND
    const long long MOD_MASK = (1LL << 31) - 1;

    // Lambda function to calculate the next element in the sequence
    auto next_step = [&](long long val) {
        return (val * P + Q) & MOD_MASK;
    };

    // Initialize Floyd's Cycle-Finding pointers
    long long tortoise = S & MOD_MASK;
    long long hare = next_step(tortoise);

    long long count = 1;

    // Step 1: Detect if a cycle exists
    while (count < N && tortoise != hare) {
        tortoise = next_step(tortoise);
        hare = next_step(next_step(hare));
        count++;
    }

    // If no cycle is found within N steps, all N elements are distinct
    if (count >= N) {
        cout << N << "\n";
        return 0;
    }

    // Step 2: Find the start index of the cycle (mu)
    tortoise = S & MOD_MASK;
    long long mu = 0;
    while (tortoise != hare) {
        tortoise = next_step(tortoise);
        hare = next_step(hare);
        mu++;
    }

    // Step 3: Find the length of the cycle (lambda)
    hare = next_step(tortoise);
    long long lambda = 1;
    while (tortoise != hare) {
        hare = next_step(hare);
        lambda++;
    }

    // FIX: The number of distinct elements cannot exceed N
    cout << min(N, mu + lambda) << "\n";

    return 0;
}
