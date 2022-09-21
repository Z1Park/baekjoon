def func(nums, check_num, start, end):
    if check_num == nums[start] or check_num == nums[end]:
        return 1
    if start+1 == end:
        return 0
    if check_num > nums[start] and check_num <= nums[(end+start)//2]:
        return func(nums, check_num, start, (end+start)//2)
    elif check_num > nums[(end+start)//2] and check_num < nums[end]:
        return func(nums, check_num, (end+start)//2, end)
    else:
        return 0


N = int(input())
nums = list(map(int, input().split()))
M = int(input())
check_list = list(map(int, input().split()))
nums.sort()

answer = []
for c in check_list:
    print(func(nums, c, 0, N-1), end=' ')
