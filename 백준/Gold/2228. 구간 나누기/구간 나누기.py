n, m = map(int, input().split())
nums = [int(input()) for _ in range(n)]
con = [[0] + [-3276900 for _ in range(m)] for _ in range(n)]
notcon = [[0] + [-3276900 for _ in range(m)] for _ in range(n)]
for i in range(n):
    for j in range(1, min(m, i//2+1)+1):
        notcon[i][j] = max(con[i-1][j], notcon[i-1][j])
        con[i][j] = max(con[i-1][j], notcon[i-1][j-1]) + nums[i]
print(max(con[-1][-1], notcon[-1][-1]))