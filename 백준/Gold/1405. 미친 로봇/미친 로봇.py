import sys
input = lambda : sys.stdin.readline().rstrip()
nums = list(map(int, input().split()))
n = nums[0]
prob = [num/100 for num in nums[1:]]
board = [[False for _ in range(2*n+1)] for _ in range(2*n+1)]
dr = [0, 0, 1, -1]
dc = [1, -1, 0, 0]

def dfs(r, c, p, cnt):
    global total
    if cnt == n:
        total += p
        return
    for i in range(4):
        nr, nc = r+dr[i], c+dc[i]
        if not board[nr][nc]:
            board[nr][nc] = True
            dfs(nr, nc, p*prob[i], cnt+1)
            board[nr][nc] = False

total = 0
board[n][n] = True
dfs(n, n, 1, 0)
print(total)