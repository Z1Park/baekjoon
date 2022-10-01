def dfs(start, curr, idx, distance):
    global minimum
    if False not in visit:
        if arr[curr][start] != 0 and minimum > distance+arr[curr][start]:
            minimum = distance+arr[curr][start]
        return
    for i in range(n):
        if arr[curr][i] != 0 and not visit[i]:
            visit[i] = True
            dfs(start, i, idx+1, distance+arr[curr][i])
            visit[i] = False

n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]
visit = [False for _ in range(n)]
minimum = 10000000
for i in range(n):
    visit[i] = True
    dfs(i, i, 0, 0)
    visit[i] = False
print(minimum)