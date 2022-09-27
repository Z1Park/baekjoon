from collections import deque

# input = sys.stdin.readline
row, col = map(int, input().split())
arr = [list(input()) for _ in range(row)]
st_que = deque()
for i in range(row):
    for j in range(col):
        if arr[i][j] == 'L':
            st_que.append((i, j))
m = 0
dr = [1, -1, 0, 0]
dc = [0, 0, 1, -1]
while st_que:
    new = []
    for i in range(row):
        new.append(arr[i].copy())
    que = deque()
    st_r, st_c = st_que.popleft()
    new[st_r][st_c] = 'W'
    que.append((st_r, st_c, 0))
    while que:
        r, c, count = que.popleft()
        for i in range(4):
            nr = r+dr[i]
            nc = c+dc[i]
            if 0 <= nr < row and 0 <= nc < col and new[nr][nc] == 'L':
                new[nr][nc] = 'W'
                que.append((nr, nc, count+1))
    if m < count:
        m = count
print(m)