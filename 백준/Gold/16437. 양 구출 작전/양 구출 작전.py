import sys
sys.setrecursionlimit(10**8)
input = sys.stdin.readline
n = int(input())
island = [0 for _ in range(n)]
bridge = [[] for _ in range(n)]
for i in range(1, n):
    a, b, c = input().rstrip().split()
    b, c = int(b), int(c)-1
    island[i] = b if a == 'S' else -b
    bridge[c].append(i)

def dfs(curr):
    sheep = 0
    for next in bridge[curr]:
        sheep += dfs(next)
    sheep += island[curr]
    if sheep <= 0:
        sheep = 0
    return sheep

print(dfs(0))