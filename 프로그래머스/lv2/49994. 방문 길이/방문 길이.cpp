#include <string>
using namespace std;

bool visitUpDown[11][11];
bool visitLeftRight[11][11];
int dir[4][2] = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

int solution(string dirs) {
    int r = 5, c = 5;
    string tmp = "UDRL";
    int count = 0;
    for (char d : dirs) {
        int t = tmp.find(d);
        int nr = r + dir[t][0];
        int nc = c + dir[t][1];
        if (nr < 0 || nr > 10 || nc < 0 || nc > 10) continue;
        switch (t) {
            case 0:
                if (!visitUpDown[nr][nc]) count++;
                visitUpDown[nr][nc] = true;
                break;
            case 1:
                if (!visitUpDown[r][c]) count++;
                visitUpDown[r][c] = true;
                break;
            case 2:
                if (!visitLeftRight[nr][nc]) count++;
                visitLeftRight[nr][nc] = true;
                break;
            case 3:
                if (!visitLeftRight[r][c]) count++;
                visitLeftRight[r][c] = true;
                break;
        }
        r = nr;
        c = nc;
    }
    return count;
}