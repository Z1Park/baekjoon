import sys
input = sys.stdin.readline

n, m = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)]

for j in range(1, m):
    board[0][j] += board[0][j-1]

for i in range(1, n):
    left = [board[i][j]+board[i-1][j] for j in range(m)]
    right = left.copy()
    for j in range(1, m):
        left[j] = max(left[j], left[j-1]+board[i][j])
        right[m-1-j] = max(right[m-1-j], right[m-j]+board[i][m-j-1])
    for j in range(m):
        board[i][j] = max(left[j], right[j])

print(board[-1][-1])