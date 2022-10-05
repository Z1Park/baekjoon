n = int(input())
nums = [False, False] + [True] * (999)
for i in range(2, 1001):
    if nums[i]:
        for j in range(i*2, 1001, i):
            nums[j] = False
check_lst = list(map(int, input().split()))
cnt = 0
for cl in check_lst:
    if nums[cl]:
        cnt += 1
print(cnt)