import sys
input = sys.stdin.readline

n = int(input())
lst = []
for i in range(n):
    tmp = list(map(str, input().split()))
    lst.append([int(tmp[0]), tmp[1], i])
lst.sort(key=lambda x : (x[0], x[2]))
for s in lst:
    print(s[0], s[1])