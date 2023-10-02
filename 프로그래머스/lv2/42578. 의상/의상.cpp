#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

int solution(vector<vector<string>> clothes) {
    int answer = 1;
    unordered_map<string, int> m;
    for (auto cloth : clothes)
        m[cloth[1]]++;
    for (auto elem : m)
        answer *= elem.second + 1;
    return answer - 1;
}