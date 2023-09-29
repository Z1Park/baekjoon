#include <string>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

typedef pair<int, int> pii;

int R, C;
int dr[4] = {0, 0, 1, -1};
int dc[4] = {1, -1, 0, 0};

int toInt(char c) {
    return c -'0';
}

int bfs(vector<string>& maps, int sr, int sc) {
    int s = toInt(maps[sr][sc]);
    maps[sr][sc] = 'X';
    deque<pii> dq;
    dq.push_back({sr, sc});
    while (!dq.empty()) {
        int r = dq.front().first;
        int c = dq.front().second;
        dq.pop_front();
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (0 <= nr && nr < R && 0 <= nc && nc < C) {
                if (maps[nr][nc] != 'X') {
                    s += toInt(maps[nr][nc]);
                    maps[nr][nc] = 'X';
                    dq.push_back({nr, nc});
                }
            }
        }
    }
    return s;
}

vector<int> solution(vector<string> maps) {
    vector<int> answer;
    R = maps.size();
    C = maps[0].length();
    for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
            if (maps[i][j] != 'X') {
                answer.push_back(bfs(maps, i, j));
            }
        }
    }
    if (answer.empty())
        answer.push_back(-1);
    else
        sort(answer.begin(), answer.end());
    return answer;
}