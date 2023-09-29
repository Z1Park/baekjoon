#include <string>
#include <vector>
#include <cctype>

using namespace std;

string solution(string s) {
    string answer = "";
    answer.append(1, toupper(s[0]));
    for (int i = 1; i < s.length(); i++)
        answer.append(1, (s[i-1] == ' ') ? toupper(s[i]) : tolower(s[i]));
    return answer;
}