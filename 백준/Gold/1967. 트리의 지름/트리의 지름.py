import sys
sys.setrecursionlimit(100000)
def dfs(node, weight):
    distance[node] = weight
    for i in tree[node]:
        if distance[i[0]] == -1:
            dfs(i[0], weight+i[1])

n = int(input())
tree = [[] for _ in range(n+1)]
for i in range(n-1):
    a, b, w = map(int, input().split())
    tree[a].append([b, w])
    tree[b].append([a, w])
distance = [-1 for _ in range(n+1)]
dfs(1, 0)
last = distance.index(max(distance))
distance = [-1 for _ in range(n+1)]
dfs(last, 0)
print(max(distance))