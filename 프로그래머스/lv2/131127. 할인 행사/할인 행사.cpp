#include <string>
#include <vector>

using namespace std;

int solution(vector<string> want, vector<int> number, vector<string> discount) {
    int answer = 0;
    vector<vector<int>> prefix(discount.size() + 1);
    for (int i = 0; i < discount.size() + 1; i++)
        prefix[i].resize(number.size());
    for (int i = 0; i < number.size(); i++)
        prefix[0][i] = 0;
    for (int i = 0; i < discount.size(); i++) {
        for (int j = 0; j < number.size(); j++) {
            prefix[i+1][j] = prefix[i][j] + (want[j] == discount[i]);
        }
    }
    for (int i = 0; i < discount.size() - 9; i++) {
        bool flag = true;
        for (int j = 0; j < number.size(); j++) {
            if (prefix[i+10][j] - prefix[i][j] < number[j]) {
                flag = false;
                break;
            }
        }
        if (flag) answer++;
    }
    return answer;
}