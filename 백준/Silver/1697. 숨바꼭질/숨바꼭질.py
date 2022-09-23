from collections import deque

n, m = map(int, input().split())
que = deque()
arr_time = [0] * 100001

def bfs(x):
    que.append(x)
    while que:
        x = que.popleft()
        if x == m:
            print(arr_time[x])
            return
        for i in [x - 1, x + 1, x * 2]:
            if 0 <= i <= 100000 and arr_time[i] == 0:
                arr_time[i] = arr_time[x] + 1
                que.append(i)

bfs(n)