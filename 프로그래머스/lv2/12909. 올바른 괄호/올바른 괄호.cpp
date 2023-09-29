#include <string>
#include <vector>

using namespace std;

bool solution(string s)
{
    vector<int> stk;
    for (int i = 0; i < s.length(); i++) {
        if (s[i] == '(') stk.push_back('(');
        else {
            if (stk.empty()) return false;
            stk.pop_back();
        }
    }
    if (!stk.empty()) return false;
    return true;
}