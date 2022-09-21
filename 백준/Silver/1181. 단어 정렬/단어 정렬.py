import sys
input = sys.stdin.readline

n = int(input())
lst = []
for i in range(n):
    lst.append(input())
ss = list(set(lst))
ss.sort(key=lambda x:(len(x), x))
for s in ss:
    print(s, end = '')