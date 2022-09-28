n = int(input())
lst = list(map(int, input().split()))
r_lst = list(reversed(lst))
dp1 = [1]
dp2 = [1]
for i in range(1, n):
    tmp1 = 0
    tmp2 = 0
    for j in range(i):
        if lst[j] < lst[i] and tmp1 < dp1[j]:
            tmp1 = dp1[j]
        if r_lst[j] < r_lst[i] and tmp2 < dp2[j]:
            tmp2 = dp2[j]
    dp1.append(tmp1+1)
    dp2.append(tmp2+1)
dp = []
for i in range(n):
    dp.append(dp1[i] + dp2[n-1-i] - 1)
print(max(dp))