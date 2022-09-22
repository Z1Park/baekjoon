n, m = map(int, input().split())
lst = [list(map(int, list(input()))) for _ in range(n)]
sq = 1
for i in range(n):
    for j in range(m - 1):
        for k in range(j+1, m):
            if lst[i][j] == lst[i][k]:
                d = k - j
                if i + d < n and lst[i+d][j] == lst[i][k] and lst[i+d][k] == lst[i][k]:
                    if sq < (d+1)**2:
                        sq = (d+1)**2
print(sq)