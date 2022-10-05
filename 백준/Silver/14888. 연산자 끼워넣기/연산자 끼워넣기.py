n = int(input())
nums = list(map(int, input().split()))
oper = list(map(int, input().split()))
min_val = 1e10
max_val = -1e10

def dfs(value, idx):
    global min_val, max_val
    if idx == n:
        if min_val > value:
            min_val = value
        if max_val < value:
            max_val = value
        return
    for i in range(4):
        if oper[i] != 0:
            if i == 0:
                oper[i] -= 1
                dfs(value+nums[idx], idx+1)
                oper[i] += 1
            elif i == 1:
                oper[i] -= 1
                dfs(value-nums[idx], idx+1)
                oper[i] += 1
            elif i == 2:
                oper[i] -= 1
                dfs(value*nums[idx], idx+1)
                oper[i] += 1
            else:
                oper[i] -= 1
                if value < 0:
                    dfs((abs(value)//nums[idx])*-1, idx+1)
                else:
                    dfs(value//nums[idx], idx+1)
                oper[i] += 1

dfs(nums[0], 1)
print(max_val)
print(min_val)