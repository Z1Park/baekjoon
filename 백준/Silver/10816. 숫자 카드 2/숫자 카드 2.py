import sys
input = sys.stdin.readline
n = int(input())
nums = list(map(int, input().split()))
nums.sort()
m = int(input())
check = list(map(int, input().split()))
res = []
for c in check:
    start = 0
    end = n-1
    while start <= end:
        mid = (start + end) // 2
        if c < nums[mid]:
            end = mid-1
        else:
            start = mid+1
    tmp = end
    start = 0
    end = n-1
    while start <= end:
        mid = (start+end) // 2
        if c <= nums[mid]:
            end = mid-1
        else:
            start = mid+1
    res.append(tmp-end)
print(*res)