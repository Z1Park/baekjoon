from collections import deque

def find_index(value):
    start = 0
    end = len(c)
    while start < end:
        mid = (end + start) // 2
        if c[mid] < value:
            start = mid + 1
        else:
            end = mid
    return end

n = int(input())
lst = list(map(int, input().split()))
c = [-1000000001]
dp = [0 for _ in range(n)]
for i in range(n):
    if c[-1] < lst[i]:
        dp[i] = len(c)
        c.append(lst[i])
    else:
        idx = find_index(lst[i])
        dp[i] = idx
        c[idx] = lst[i]
m = len(c)-1
print(m)
res = deque()
for i in range(n):
    if dp[n-1-i] == m:
        m -= 1
        res.appendleft(lst[n-1-i])
print(*res)