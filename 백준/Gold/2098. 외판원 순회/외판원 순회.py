def dfs(curr, visit):
    if dp[curr][visit] != 0:
        return dp[curr][visit]
    if visit == (1 << n) - 1:
        if arr[curr][0] > 0:
            return arr[curr][0]
        else:
            return 10000000
    case = 10000000
    for i in range(1, n):
        if visit & (1 << i) == 0 and arr[curr][i] != 0:
            case = min(case, arr[curr][i] + dfs(i, visit | (1 << i)))
    dp[curr][visit] = case
    return dp[curr][visit]

n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]
dp = [[0 for a in range(1 << n)] for b in range(n)]
print(dfs(0, 1))