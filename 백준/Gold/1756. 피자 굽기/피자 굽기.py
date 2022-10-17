import sys
input = sys.stdin.readline
d, n = map(int, input().split())
rad = list(map(int, input().split()))
pizza = list(map(int, input().split()))
for i in range(1, d):
    rad[i] = min(rad[i-1], rad[i])

def bisearch_right(start, end, value):
    while start < end:
        mid = (start + end) // 2
        if value > rad[mid]:
            end = mid
        else:
            start = mid+1
    return end

idx = d
for p in pizza:
    tmp = bisearch_right(0, idx-1, p)
    if tmp == idx-1 and rad[tmp] >= p:
        idx = tmp
    elif rad[tmp-1] >= p:
        idx = tmp-1
    else:
        print(0)
        sys.exit(0)
print(idx+1)