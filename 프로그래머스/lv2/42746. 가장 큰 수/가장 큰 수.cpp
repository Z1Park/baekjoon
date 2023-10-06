#include <string>
#include <vector>
#include <algorithm>

using namespace std;

bool cmp(string& a, string& b) {
    if (a.size() == b.size()) return a > b;
    return a + b > b + a;
}

string solution(vector<int> numbers) {
    vector<string> vec;
    for (int num : numbers) vec.push_back(to_string(num));
    sort(vec.begin(), vec.end(), cmp);
    string res;
    for (auto v : vec) res.append(v);
    for (char c : res) if (c != '0') return res;
    return "0";
}