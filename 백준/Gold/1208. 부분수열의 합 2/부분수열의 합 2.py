from itertools import combinations
n, s = map(int, input().split())
lst = list(map(int, input().split()))
cnt = 0

def subset_sum(arr):
    tmp = []
    for i in range(1, len(arr)+1):
        for c in combinations(arr, i):
            tmp.append(sum(c))
    return list(sorted(tmp))

a = subset_sum(lst[:n//2])
b = subset_sum(lst[n//2:])

def bisect_left(arr, value):
    start = 0
    end = len(arr)
    while start < end:
        mid = (start + end) // 2
        if value <= arr[mid]:
            end = mid
        else:
            start = mid+1
    return start

def bisect_right(arr, value):
    start = 0
    end = len(arr)
    while start < end:
        mid = (start + end) // 2
        if value < arr[mid]:
            end = mid
        else:
            start = mid+1
    return start

cnt += bisect_right(a, s)-bisect_left(a, s)
cnt += bisect_right(b, s)-bisect_left(b, s)
for i in a:
    c = s - i
    cnt += bisect_right(b, c)-bisect_left(b, c)

print(cnt)