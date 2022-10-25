import sys
input = sys.stdin.readline
n = int(input())
board = [list(map(int, input().split())) for _ in range(n)]
dr = [0, 1, -1, 0, 0]
dc = [0, 0, 0, 1, -1]

def press(arr, r, c):
    for i in range(5):
        nr, nc = r+dr[i], c+dc[i]
        if 0 <= nr < n and 0 <= nc < n:
            arr[nr][nc] ^= 1

case_count = [n**2 + 1] * (1 << n)
for case in range(1 << n):
    tmp = [board[i].copy() for i in range(n)]
    count = 0
    for i in range(n):
        if case & (1 << i):
            press(tmp, 0, i)
            count += 1
    for i in range(1, n):
        for j in range(n):
            if tmp[i-1][j] == 1:
                press(tmp, i, j)
                count += 1
    if sum(tmp[-1]) == 0:
        case_count[case] = count
res = min(case_count)
print(res if res != n**2+1 else -1)