import sys
input = sys.stdin.readline

n, m, k = map(int, input().split())
t = 0
while True:
    n -= 2
    m -= 1
    if n < 0 or m < 0 or n+m < k:
        break
    t += 1
print(t)