import sys
input = lambda : sys.stdin.readline().rstrip()
k, n = map(int, input().split())
nums = [input() for _ in range(k)]

m = str(max(map(int, nums)))
for _ in range(k, n):
    nums.append(m)

for i in range(n):
    for j in range(i+1, n):
        if int(nums[i]+nums[j]) < int(nums[j]+nums[i]):
            nums[i], nums[j] = nums[j], nums[i]

print(*nums, sep='')