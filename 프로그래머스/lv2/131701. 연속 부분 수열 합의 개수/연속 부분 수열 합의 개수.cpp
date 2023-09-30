#include <unordered_set>
#include <vector>

using namespace std;

int solution(vector<int> elements) {
    unordered_set<int> us;
    for (int i = 0; i < elements.size(); i++) {
        int sum = 0;
        for (int j = 0 ; j < elements.size(); j++) {
            sum += elements[(i + j) % elements.size()];
            us.insert(sum);
        }
    }
    return us.size();
}