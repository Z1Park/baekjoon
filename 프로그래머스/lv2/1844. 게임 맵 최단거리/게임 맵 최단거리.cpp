#include <vector>
#include <deque>

using namespace std;

typedef pair<pair<int, int>, int> pi;

int solution(vector<vector<int>> maps)
{
    int R = maps.size(), C = maps[0].size();
    int dr[4] = {0, 1, 0, -1};
    int dc[4] = {1, 0, -1, 0};
    deque<pi> dq;
    dq.push_back({{0, 0}, 1});
    maps[0][0] = 0;
    while (!dq.empty()) {
        int r = dq.front().first.first;
        int c  = dq.front().first.second;
        int cnt = dq.front().second;
        if (r == R-1 && c == C -1) return cnt;
        dq.pop_front();
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (0 <= nr && nr < R && 0 <= nc && nc < C) {
                if (maps[nr][nc] == 1) {
                    maps[nr][nc] = 0;
                    dq.push_back({{nr, nc}, cnt+1});
                }
            }
        }
    }
    return -1;
}