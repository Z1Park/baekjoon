import sys
input = sys.stdin.readline
toggle = lambda x : '#' if x == 'O' else 'O'
board = [list(input().rstrip()) for _ in range(10)]
dr = [0, 1, -1, 0, 0]
dc = [0, 0, 0, 1, -1]

def press(arr, r, c):
    for i in range(5):
        nr, nc = r+dr[i], c+dc[i]
        if 0 <= nr < 10 and 0 <= nc < 10:
            arr[nr][nc] = toggle(arr[nr][nc])

case = [101] * (1 << 10)
for c in range(1 << 10):
    tmp = [board[i].copy() for i in range(10)]
    count = 0
    for i in range(10):
        if c & (1<<i):
            press(tmp, 0, i)
            count += 1
    for i in range(1, 10):
        for j in range(10):
            if tmp[i-1][j] == 'O':
                press(tmp, i, j)
                count += 1
    if 'O' not in tmp[9]:
        case[c] = count
print(min(case))