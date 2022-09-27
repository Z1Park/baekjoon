def dfs(r, c, p, cnt):
    global pin, move
    if pin >= p:
        pin = p
        move = cnt
    for i in range(4):
        nr = r+dr[i]
        nc = c+dc[i]
        if 0 <= nr < row and 0 <= nc < col and arr[nr][nc] == 'o':
            nr2 = nr+dr[i]
            nc2 = nc+dc[i]
            if 0 <= nr2 < row and 0 <= nc2 < col and arr[nr2][nc2] == '.':
                arr[r][c] = arr[nr][nc] = '.'
                arr[nr2][nc2] = 'o'
                for i in range(row):
                    for j in range(col):
                        if arr[i][j] == 'o':
                            dfs(i, j, p-1, cnt+1)
                arr[r][c] = arr[nr][nc] = 'o'
                arr[nr2][nc2] = '.'

row, col = 5, 9
dr = [1, -1, 0, 0]
dc = [0, 0, 1, -1]
tc = int(input())
for t in range(tc):
    arr = [list(input()) for _ in range(row)]
    p = 0
    for i in range(row):
        p += arr[i].count('o')
    pin = p
    move = 0
    for i in range(row):
        for j in range(col):
            if arr[i][j] == 'o':
                dfs(i, j, p, 0)
    print(pin, move)
    if t != tc - 1:
        input()