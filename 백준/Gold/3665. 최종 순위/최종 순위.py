import sys
from collections import deque
input = sys.stdin.readline
tc = int(input())
for t in range(tc):
    n = int(input())
    teams = [[0] for _ in range(n+1)]
    rank = list(map(int, input().split()))
    for i in range(1, n):
        for j in range(i):
            teams[rank[j]].append(rank[i])
            teams[rank[i]][0] += 1

    m = int(input())
    for _ in range(m):
        left, right = map(int, input().split())
        if right not in teams[left][1:]:
            left, right = right, left
        idx = teams[left][1:].index(right)
        del teams[left][idx+1]
        teams[right].append(left)
        teams[left][0] += 1
        teams[right][0] -= 1
    
    que = deque()
    res = []
    for i in range(1, n+1):
        if teams[i][0] == 0:
            que.append(i)
    flag = False
    while que:
        if len(que) > 1:
            flag = True
            break
        node = que.popleft()
        res.append(node)
        for nxt in teams[node][1:]:
            teams[nxt][0] -= 1
            if teams[nxt][0] == 0:
                que.append(nxt)
            elif teams[nxt][0] < 0:
                flag = True
                break
        if flag:
            break
    if flag or len(res) < n:
        print("IMPOSSIBLE")
    else:
        print(*res)