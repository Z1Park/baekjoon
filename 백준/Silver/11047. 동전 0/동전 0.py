import sys
input = sys.stdin.readline

n, k = map(int, input().split())
lst = [int(input()) for _ in range(n)]
c = 0
for l in reversed(lst):
    c += k // l
    k %= l
print(c)