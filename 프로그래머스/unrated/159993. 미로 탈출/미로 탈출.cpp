#include <string>
#include <vector>
#include <deque>

using namespace std;

typedef pair<int, int> pii;

int R, C, r, c, count = 0;
bool visit[100][100];
int dr[4] = {0, 0, 1, -1};
int dc[4] = {1, -1, 0, 0};

void findStart(vector<string> maps) {
    for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
            if (maps[i][j] == 'S') {
                r = i;
                c = j;
                return;
            }
        }
    }
}

bool bfs(vector<string> maps, char target) {
    deque< pair<pii, int> > dq;
    dq.push_back(make_pair(make_pair(r, c), 0));
    while (!dq.empty()) {
        int tmpR = dq.front().first.first;
        int tmpC = dq.front().first.second;
        int tmpCnt = dq.front().second;
        if (maps[tmpR][tmpC] == target) {
            r = tmpR;
            c = tmpC;
            count += tmpCnt;
            return true;
        }
        dq.pop_front();
        for (int i = 0; i < 4; i++) {
            int nr = tmpR + dr[i];
            int nc = tmpC + dc[i];
            if (0 <= nr && nr < R && 0 <= nc && nc < C) {
                if (maps[nr][nc] != 'X' && !visit[nr][nc]) {
                    visit[nr][nc] = true;
                    dq.push_back(make_pair(make_pair(nr, nc), tmpCnt+1));
                }
            }
        }
    }
    return false;
}

int solution(vector<string> maps) {
    R = maps.size();
    C = maps[0].length();
    findStart(maps);
    if (!bfs(maps, 'L')) 
        return -1;
    for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++)
            visit[i][j] = false;
    }
    if (!bfs(maps, 'E')) return -1;
    return count;
}