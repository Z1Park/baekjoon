import sys
input = sys.stdin.readline

n, s = map(int, input().split())
lst = list(map(int, input().split()))
count = 0

def dfs(t, idx, ss):
    global count
    ss += t * lst[idx]
    if idx < n-1:
        dfs(0, idx+1, ss)
        dfs(1, idx+1, ss)
    else:
        if ss == s:
            count += 1
    ss -= t * lst[idx]

dfs(0, 0, 0)
dfs(1, 0, 0)
if s == 0:
    count -= 1
print(count)