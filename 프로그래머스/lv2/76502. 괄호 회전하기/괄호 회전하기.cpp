#include <string>
#include <vector>

using namespace std;

bool isPair(char c1, char c2) {
    switch (c1) {
        case ')':
            return c2 == '(';
        case '}':
            return c2 == '{';
        case ']':
            return c2 == '[';
    }
}

bool isPromise(string& s, int start) {
    vector<char> stk;
    for (int i = start; i < s.length(); i++) {
        if (s[i] == '{' || s[i] == '[' || s[i] == '(') 
            stk.push_back(s[i]);
        else {
            if (stk.empty() || !isPair(s[i], stk.back())) 
                return false;
            else stk.pop_back();
        }
    }
    for (int i = 0; i < start; i++) {
        if (s[i] == '{' || s[i] == '[' || s[i] == '(') 
            stk.push_back(s[i]);
        else {
            if (stk.empty() || !isPair(s[i], stk.back())) 
                return false;
            else stk.pop_back();
        }
    }
    if (stk.empty()) return true;
    return false;
}

int solution(string s) {
    int cnt = 0;
    for (int i = 0; i < s.length(); i++) {
        if (isPromise(s, i)) cnt++;
    }
    return cnt;
}