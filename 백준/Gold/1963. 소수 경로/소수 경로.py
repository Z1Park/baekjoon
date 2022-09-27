import sys
from collections import deque

input = sys.stdin.readline
prime = [False, False] + [True] * 9998
for i in range(2, 10000):
    if prime[i]:
        for j in range(2*i, 10000, i):
            prime[j] = False
tc = int(input())
for t in range(tc):
    bef, aft = map(int, input().split())
    visit = [0 for _ in range(10000)]
    flag = True
    que = deque()
    que.append((bef, 0))
    while que:
        curr, count = que.popleft()
        if curr == aft:
            flag = False
            print(count)
            break
        curr = str(curr)
        for i in range(4):
            for j in range(10):
                tmp = int(curr[:i] + str(j) + curr[i+1:])
                if tmp >= 1000 and not visit[tmp] and prime[tmp]:
                    visit[tmp] = 1
                    que.append((tmp, count+1))
    if flag:
        print("Impossible")