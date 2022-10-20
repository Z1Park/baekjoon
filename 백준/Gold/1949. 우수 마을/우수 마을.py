import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**4)
n = int(input())
vil = [0] + list(map(int, input().split()))
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
        dp[node][1] = vil[node]
        dp[node][0] = 0
        return
    for nxt in graph[node]:
        if not visit[nxt]:
            dfs(nxt)
            dp[node][1] += dp[nxt][0]
            dp[node][0] += max(dp[nxt][0], dp[nxt][1])
    dp[node][1] += vil[node]

dfs(1)
print(max(dp[1][0], dp[1][1]))