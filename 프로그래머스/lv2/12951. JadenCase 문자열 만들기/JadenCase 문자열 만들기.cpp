#include <string>
#include <vector>
#include <cctype>

using namespace std;

string solution(string s) {
    string answer = "";
    bool capital = true;
    for (int i = 0; i < s.length(); i++) {
        if (isdigit(s[i])) answer.append(1, s[i]);
        else if (s[i] == ' ') {
            capital = true;
            answer.append(1, s[i]);
            continue;
        }
        else if (capital) answer.append(1, toupper(s[i]));
        else answer.append(1, tolower(s[i]));
        capital = false;
    }
    return answer;
}