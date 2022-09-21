import sys
input = sys.stdin.readline

n = int(input())
lst = []
for i in range(n):
    lst.append(list(map(int, input().split())))
lst.sort(key=lambda x : (x[1], x[0]))
for s in lst:
    print(s[0], s[1])