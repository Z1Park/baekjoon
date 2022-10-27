import sys
input = lambda : sys.stdin.readline().rstrip()
sys.setrecursionlimit(10**6)

def find(node):
    if node == group[node]:
        return node
    else:
        root = find(group[node])
        weight[node] += weight[group[node]]
        group[node] = root
        return root

def union(a, b, w):
    ra = find(a)
    rb = find(b)
    if ra != rb:
        weight[rb] = weight[a] - weight[b] + w
        group[rb] = ra

while True:
    n, m = map(int, input().split())
    if n == 0 and m == 0:
        break
    group = [i for i in range(n+1)]
    weight = [0 for i in range(n+1)]
    for _ in range(m):
        tmp = input().split()
        if tmp[0] == '!':
            a, b, w = map(int, tmp[1:])
            union(a, b, w)
        else:
            a, b = map(int, tmp[1:])
            if find(a) != find(b):
                print("UNKNOWN")
            else:
                print(weight[b]-weight[a])