#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;


int main() {
    int n, q;
    cin >> n >> q;
    int** a = new int*[n];
    for (int i = 0; i < n; i++) {
        int k;
        cin >> k;
        a[i] = new int[k];
        for (int j = 0; j < k; j++) {
            cin >> a[i][j];
        }
    }
    for (int k = 0; k < q; k++) {
        int i, j;
        cin >> i >> j;
        cout << a[i][j] << endl;
    }
    for (int i = 0; i < n; i++) {
        delete[] a[i];
    }
    delete[] a;
    return 0;
}
