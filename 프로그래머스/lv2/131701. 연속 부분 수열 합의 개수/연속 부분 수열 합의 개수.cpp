#include <set>
#include <vector>

using namespace std;

int getSum(vector<int>& elements, int start, int range) {
    int sum = 0;
    for (int i = 0; i < range; i++)
        sum += elements[(start + i) % elements.size()];
    return sum;
}

int solution(vector<int> elements) {
    set<int> s;
    for (int i = 0; i < elements.size(); i++) {
        for (int j = 0 ; j < elements.size(); j++)
            s.insert(getSum(elements, i, j));
    }
    return s.size();
}