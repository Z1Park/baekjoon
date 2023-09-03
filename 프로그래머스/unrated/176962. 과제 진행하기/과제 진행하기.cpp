#include <string>
#include <vector>
#include <queue>
#include <algorithm>
#include <iostream>

using namespace std;

bool cmp(vector<string>& a, vector<string>& b) {
    return a[1] < b[1];
}

vector<string> solution(vector<vector<string>> plans) {
    vector<string> answer;
    sort(plans.begin(), plans.end(), cmp);
    queue<vector<int>> homework;
    for (int i = 0; i < plans.size(); i++) {
        vector<int> v;
        v.push_back(i);
        v.push_back(stoi(plans[i][1].substr(0, 2)) * 60 + stoi(plans[i][1].substr(3,2)));
        v.push_back(stoi(plans[i][2]));
        homework.push(v);
    }
    vector<vector<int>> delayed;
    int time = homework.front()[1];
    vector<int> curr, next;
    while (!homework.empty()) {
        curr = homework.front();
        homework.pop();
        
        if (homework.empty()) {
            answer.push_back(plans[curr[0]][0]);
            break;
        }
        next = homework.front();
        if (time + curr[2] <= next[1]) {
            answer.push_back(plans[curr[0]][0]);
            time += curr[2];
            if (!delayed.empty()) {
                while (!delayed.empty() && time + delayed.back()[1] <= next[1]) {
                    vector<int> tmp = delayed.back();
                    delayed.pop_back();
                    answer.push_back(plans[tmp[0]][0]);
                    time += tmp[1];
                }
                if (!delayed.empty()) {
                    delayed.back()[1] -= next[1] - time;
                }
            }
        }
        else {
            vector<int> tmp;
            tmp.push_back(curr[0]);
            tmp.push_back(time + curr[2] - next[1]);
            delayed.push_back(tmp);
        }
        time = next[1];
    }
    while (!delayed.empty()) {
        vector<int> tmp = delayed.back();
        delayed.pop_back();
        answer.push_back(plans[tmp[0]][0]);
    }
    return answer;
}