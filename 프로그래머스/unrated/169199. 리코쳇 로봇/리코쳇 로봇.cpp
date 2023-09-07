#include <string>
#include <vector>
#include <deque>

using namespace std;

typedef pair<int, int> pii;

int dr[4] = {0, 0, 1, -1};
int dc[4] = {1, -1, 0, 0};
int R, C;
int sr, sc;
int gr, gc;
int minVal = 10001;

bool checkPromise(vector<string>& board, int r, int c) {
    for (int i = 0; i < 4; i++) {
        int nr = r + dr[i];
        int nc = c + dc[i];
        if (board[nr][nc] == 'D') return true;
    }
    if (r == 0 || r == R-1 || c == 0 || c == C-1) return true;
    return false;
}

void move(vector<string>& board, int& r, int& c, int dir) {
    int nr = r;
    int nc = c;
    while (true) {
        nr += dr[dir];
        nc += dc[dir];
        if (nr < 0 || R <= nr || nc < 0 || C <= nc) break;
        if (board[nr][nc] == 'D') break;
    }
    r = nr - dr[dir];
    c = nc - dc[dir];
}

int bfs(vector<string>& board) {
    vector<vector<bool>> visit(R);
    for (int i = 0; i < R; i++) {
        visit[i].resize(C);
        for (int j = 0; j < C; j++) visit[i][j] = false;
    }
    deque<pair<pii, int>> dq;
    visit[sr][sc] = true;
    dq.push_back(make_pair(make_pair(sr, sc), 0));
    while (!dq.empty()) {
        int r = dq.front().first.first;
        int c = dq.front().first.second;
        int cnt = dq.front().second;
        dq.pop_front();
        if (r == gr && c == gc) return cnt;
        for (int i = 0; i < 4; i++) {
            int nr = r, nc = c;
            move(board, nr, nc, i);
            if (!visit[nr][nc]) {
                visit[nr][nc] = true;
                dq.push_back(make_pair(make_pair(nr, nc), cnt+1));
            }
        }
    }
    return -1;
}

int solution(vector<string> board) {
    R = board.size();
    C = board[0].length();
    for (int i = 0; i < R; i++) {
        for (int j = 0; j < C; j++) {
            if (board[i][j] == 'R') {
                sr = i;
                sc = j;
            }
            if (board[i][j] == 'G') {
                gr = i;
                gc = j;
            }
        }
    }
    if (!checkPromise(board, gr, gc)) return -1;
    return bfs(board);
}