import sys
input = sys.stdin.readline

n, m = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)]

for j in range(1, m):
    board[0][j] += board[0][j-1]

for i in range(1, n):
    toright = board[i].copy()
    toleft = board[i].copy()
    toright[0] += board[i-1][0]
    toleft[-1] += board[i-1][-1]
    for j in range(1, m):
        toright[j] += max(board[i-1][j], toright[j-1])
    for j in range(m-2, -1, -1):
        toleft[j]  += max(board[i-1][j], toleft[j+1])

    for j in range(m):
        board[i][j] = max(toleft[j], toright[j])

print(board[-1][-1])