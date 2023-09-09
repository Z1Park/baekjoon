#include <string>
#include <vector>
#include <algorithm>

using namespace std;

bool visit[8];
int cnt;

void dfs(int l, vector<vector<int>> dungeons) {
    int tmp = count(visit, visit + dungeons.size(), true);
    if (tmp > cnt)
        cnt = tmp;
    for (int i = 0; i < dungeons.size(); i++) {
        if (!visit[i] && l >= dungeons[i][0]) {
            visit[i] = true;
            dfs(l - dungeons[i][1], dungeons);
            visit[i] = false;
        }
    }
}

int solution(int k, vector<vector<int>> dungeons) {
    dfs(k, dungeons);
    return cnt;
}