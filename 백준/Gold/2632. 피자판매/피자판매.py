import sys
from itertools import combinations
input = sys.stdin.readline
n = int(input())
a, b = map(int, input().split())
al, bl = [], []
for _ in range(a):
    al.append(int(input()))
for _ in range(b):
    bl.append(int(input()))

def subset_sum(arr, size):
    tmp = [0, sum(arr)]
    for i in range(size):
        s = arr[i]
        tmp.append(s)
        for j in range(1, size-1):
            s += arr[(i+j)%size]
            tmp.append(s)
    return (list(sorted(tmp)))

def bisearch_right(arr, value):
    start = 0
    end = len(arr)
    while start < end:
        mid = (start + end) // 2
        if value < arr[mid]:
            end = mid
        else:
            start = mid+1
    return start

def bisearch_left(arr, value):
    start = 0
    end = len(arr)
    while start < end:
        mid = (start + end) // 2
        if value <= arr[mid]:
            end = mid
        else:
            start = mid+1
    return start

sa = subset_sum(al, a)
sb = subset_sum(bl, b)
res = 0
for i in range(n+1):
    ares = bisearch_right(sa, i) - bisearch_left(sa, i)
    bres = bisearch_right(sb, n-i) - bisearch_left(sb, n-i)
    res += ares * bres
print(res)