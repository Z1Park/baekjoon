#include <string>
#include <vector>
#include <iostream>

using namespace std;

int R, C, r, c, dr, dc;

void findStart(vector<string> park) {
    for (int i = 0; i < park.size(); i++) {
        for (int j = 0; j < park[i].length(); j++) {
            if (park[i][j] == 'S') {
                r = i;
                c = j;
                return;
            }
        }
    }
}

void getDir(char d) {
    switch (d) {
        case 'E':
            dr = 0;
            dc = 1;
            break;
        case 'W':
            dr = 0;
            dc = -1;
            break;
        case 'S':
            dr = 1;
            dc = 0;
            break;
        case 'N':
            dr = -1;
            dc = 0;
            break;
        default:
            break;
    }
}

vector<int> solution(vector<string> park, vector<string> routes) {
    vector<int> answer;
    R = park.size();
    C = park[0].length();
    printf("R: %d, C: %d\n", R, C);
    findStart(park);
    int s, nr, nc;
    for (auto route : routes) {
        getDir(route[0]);
        s = (int)(route[2] - '0');
        bool flag = true;
        nr = r;
        nc = c;
        while (--s >= 0) {
            nr += dr;
            nc += dc;
            if (0 > nr || nr >= R || 0 > nc || nc >= C || park[nr][nc] == 'X') {
                flag = false;
                break;
            }
        }
        if (flag) {
            r = nr;
            c = nc;
        }
    }
    answer.push_back(r);
    answer.push_back(c);
    return answer;
}