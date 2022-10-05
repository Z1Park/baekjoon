n, m = map(int, input().split())
tri = [[1] for _ in range(n+1)]
for i in range(1, n+1):
    if i != 1:
        for j in range(i-1):
            tri[i].append(tri[i-1][j] + tri[i-1][j+1])
    tri[i].append(1)
print(tri[n][m])