#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <set>
#include <algorithm>
using namespace std;


int main() {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */  
     int Q;
    std::cin >> Q;
    std::set<int> s;
    for (int i = 0; i < Q; ++i) {
        int type, val;
        std::cin >> type >> val;
        if (type == 1) {
            s.insert(val);
        } else if (type == 2) {
            s.erase(val);
        } else if (type == 3) {
            if (s.find(val) != s.end()) {
                std::cout << "Yes" << std::endl;
            } else {
                std::cout << "No" << std::endl;
            }
        }
    }
    return 0;
}



