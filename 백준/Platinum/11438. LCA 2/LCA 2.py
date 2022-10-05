import sys
input = sys.stdin.readline
sys.setrecursionlimit(100000)
L = 21 # 2^0 ~ 2^20 (1,000,000)
n = int(input())
parent = [[0] * L for _ in range(n+1)]
depth = [-1 for _ in range(n+1)]
graph = [[] for _ in range(n+1)]
for i in range(n-1):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

def dfs(node, dep):
    depth[node] = dep
    for child in graph[node]:
        if depth[child] != -1:  # 부모 노드는 이미 depth 저장되어 있으므로
            continue
        parent[child][0] = node # 2^0 부모 저장
        dfs(child, dep+1)

dfs(1, 0)
for i in range(1, L):
    for j in range(1, n+1):
        parent[j][i] = parent[parent[j][i-1]][i-1]  # 부모의 부모 저장

def lca(a, b):
    if depth[a] > depth[b]:
        a, b = b, a
    for i in range(L-1, -1, -1):
        if depth[b] - depth[a] >= (1 << i):
            b = parent[b][i]
    if a == b:
        return a
    for i in range(L-1, -1, -1):
        if parent[a][i] != parent[b][i]:
            a = parent[a][i]
            b = parent[b][i]
    return parent[a][0]

m = int(input())
for i in range(m):
    a, b = map(int, input().split())
    print(lca(a, b))