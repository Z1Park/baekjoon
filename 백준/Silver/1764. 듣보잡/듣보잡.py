from sys import stdin

n, m = map(int, stdin.readline().split())
nh = [stdin.readline().strip() for _ in range(n)]
ns = [stdin.readline().strip() for _ in range(m)]

nsh = sorted(list(set(nh) & set(ns)))

print(len(nsh))
for i in nsh:
    print(i)