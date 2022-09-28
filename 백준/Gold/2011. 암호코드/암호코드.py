lst = list(input())
if lst[0] == '0':
    print('0')
else:
    dp = [0 for _ in range(len(lst))]
    dp[0] = 1
    if len(lst) > 1:
        if int(lst[1]) > 0:
            dp[1] = 1
        if 10 <= int(lst[0]+lst[1]) <= 26:
            dp[1] += 1
        for i in range(2, len(lst)):
            if int(lst[i]) > 0:
                dp[i] = dp[i-1]
            if 10 <= int(lst[i-1]+lst[i]) <= 26:
                dp[i] += dp[i-2]
    print(dp[-1] % 1000000)