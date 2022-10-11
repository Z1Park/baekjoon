import sys
from itertools import combinations
input = sys.stdin.readline
t = int(input())
n = int(input())
a = list(map(int, input().split()))
m = int(input())
b = list(map(int, input().split()))

def subset_sum(arr, size):
    tmp = []
    for i in range(size):
        s = arr[i]
        tmp.append(s)
        for j in range(i+1, size):
            s += arr[j]
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

sa = subset_sum(a, n)
sb = subset_sum(b, m)
res = 0
for i in sa:
    tmp = t - i
    res += bisearch_right(sb, tmp) - bisearch_left(sb, tmp)
print(res)