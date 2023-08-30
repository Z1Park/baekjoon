#include <stdio.h>
#include <vector>
#include <map>

using namespace std;

typedef struct shark_t {
	int s, d, z;
} shark_t;

int R, C, M;
vector<shark_t> sharks[100][100];
int dr[4] = {-1, 1, 0, 0};
int dc[4] = {0, 0, 1, -1};

int main() {
	scanf("%d %d %d", &R, &C, &M);
	for (int i = 0; i < M; i++) {
		int r, c;
		shark_t tmp;
		scanf("%d %d %d %d %d", &r, &c, &tmp.s, &tmp.d, &tmp.z);
		tmp.d -= 1;
		sharks[r-1][c-1].push_back(tmp);
	}
	int res = 0;
	for (int pos = 0; pos < C; pos++) {
		for (int i = 0; i < R; i++) {
			if (!sharks[i][pos].empty()) {
				res += sharks[i][pos][0].z;
				sharks[i][pos].pop_back();
				break;
			}
		}
		vector<shark_t> tmpSharks[100][100];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (sharks[i][j].empty()) continue;
				int nr = i + dr[sharks[i][j][0].d] * sharks[i][j][0].s;
				int nc = j + dc[sharks[i][j][0].d] * sharks[i][j][0].s;
				while (nr < 0 || R <= nr) {
					if (nr < 0) nr *= -1;
					else nr = 2*(R-1) - nr;
					sharks[i][j][0].d = (sharks[i][j][0].d == 0) ? 1 : 0;
				}
				while (nc < 0 || C <= nc) {
					if (nc < 0) nc *= -1;
					else nc = 2*(C-1) - nc;
					sharks[i][j][0].d = (sharks[i][j][0].d == 2) ? 3 : 2;
				}
				if (tmpSharks[nr][nc].empty()) tmpSharks[nr][nc].push_back(sharks[i][j][0]);
				else {
					if (tmpSharks[nr][nc][0].z < sharks[i][j][0].z) {
						tmpSharks[nr][nc].pop_back();
						tmpSharks[nr][nc].push_back(sharks[i][j][0]);
					}
				}
				sharks[i][j].pop_back();
			}
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++)
				sharks[i][j] = tmpSharks[i][j];
		}
	}
	printf("%d", res);
}