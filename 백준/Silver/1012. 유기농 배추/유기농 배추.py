from collections import deque

t = int(input())
for i in range(t):
    c, r, k = map(int, input().split())
    arr = [[0 for a in range(c)] for b in range(r)]
    for i in range(k):
        a, b = map(int, input().split())
        arr[b][a] = 1
    que = deque()
    count = 0
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]

    def del_island(x, y):
        global arr
        arr[x][y] = 0
        for i in range(4):
            if 0 <= x+dx[i] < r and 0 <= y+dy[i] < c and arr[x+dx[i]][y+dy[i]] == 1:
                if (x+dx[i], y+dy[i]) not in que:
                    que.append((x+dx[i], y+dy[i]))

    def check_island():
        global arr, que, count
        for i in range(r):
            if 1 in arr[i]:
                count += 1
                que.append((i, arr[i].index(1)))
                return False
        return True

    while True:
        if check_island():
            break
        while que:
            del_island(*(que.popleft()))
    print(count)