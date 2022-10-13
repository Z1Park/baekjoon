from itertools import combinations
n, m = map(int, input().split())
city = [list(map(int, input().split())) for _ in range(n)]
hou = []
chi = []
for i in range(n):
    for j in range(n):
        if city[i][j] == 1:
            hou.append([i, j])
        elif city[i][j] == 2:
            chi.append([i, j])

res = []
for comb in combinations(chi, m):
    total = 0
    for h in hou:
        min_val = 101
        for c in comb:
            dis = abs(c[0]-h[0]) + abs(c[1]-h[1])
            if min_val > dis:
                min_val = dis
        total += min_val
    res.append(total)
print(min(res))