n = int(input())
nums = [int(input()) for _ in range(n)]
stk = []
cnt = 0
m = 0
for num in nums:
    if not stk:
        stk.append(num)
    elif stk[-1] < num:
        cnt += num - stk.pop()
        stk.append(num)
    elif stk[-1] > num:
        stk.pop()
        stk.append(num)
    if stk[-1] > m:
        m = stk[-1]
cnt += m - stk.pop()
print(cnt)