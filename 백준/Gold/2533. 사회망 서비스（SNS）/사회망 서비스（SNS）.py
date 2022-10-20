import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)
n = int(input())
graph = [[] for _ in range(n+1)]
visit = [False for _ in range(n+1)]
dp = [[0, 0] for _ in range(n+1)]
for _ in range(n-1):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

def dfs(node):
    visit[node] = True
    if len(graph[node]) == 0:
        dp[node][1] = 1
        dp[node][0] = 0
        return
    for nxt in graph[node]:
        if not visit[nxt]:
            dfs(nxt)
            dp[node][1] += min(dp[nxt][0], dp[nxt][1])
            dp[node][0] += dp[nxt][1]
    dp[node][1] += 1

dfs(1)
print(min(dp[1][0], dp[1][1]))