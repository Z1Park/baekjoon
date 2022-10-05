import sys
input = sys.stdin.readline
sys.setrecursionlimit(100000)
L = 17 # 2^0 ~ 2^17 (128,000)
n = int(input())
parent = [[0] * L for _ in range(n+1)]
depth = [-1 for _ in range(n+1)]
dp = [[[1000001, 0] for _ in range(L)] for _ in range(n+1)]
graph = [[] for _ in range(n+1)]
for i in range(n-1):
    a, b, c = map(int, input().split())
    graph[a].append([b, c])
    graph[b].append([a, c])

def dfs(node, dep):
    depth[node] = dep
    for child in graph[node]:
        if depth[child[0]] != -1:  # 부모 노드는 이미 depth 저장되어 있으므로
            continue
        parent[child[0]][0] = node # 2^0 부모 저장
        dp[child[0]][0] = [child[1], child[1]]
        dfs(child[0], dep+1)

dfs(1, 0)
for i in range(1, L):
    for j in range(1, n+1):
        parent[j][i] = parent[parent[j][i-1]][i-1]  # 부모의 부모 저장
        dp[j][i][0] = min(dp[j][i-1][0], dp[parent[j][i-1]][i-1][0])
        dp[j][i][1] = max(dp[j][i-1][1], dp[parent[j][i-1]][i-1][1])

def lca(a, b):
    min_val = 1000001
    max_val = 0
    if depth[a] > depth[b]:
        a, b = b, a
    for i in range(L-1, -1, -1):
        if depth[b] - depth[a] >= (1 << i):
            min_val = min(min_val, dp[b][i][0])
            max_val = max(max_val, dp[b][i][1])
            b = parent[b][i]
    if a == b:
        return [min_val, max_val]
    for i in range(L-1, -1, -1):
        if parent[a][i] != parent[b][i]:
            min_val = min(min_val, dp[a][i][0], dp[b][i][0])
            max_val = max(max_val, dp[a][i][1], dp[b][i][1])
            a = parent[a][i]
            b = parent[b][i]
    return [min(min_val, dp[a][0][0], dp[b][0][0]), max(max_val, dp[a][0][1], dp[b][0][1])]

m = int(input())
for i in range(m):
    a, b = map(int, input().split())
    print(*lca(a, b))