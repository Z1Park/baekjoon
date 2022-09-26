n = int(input())

res = []
def dfs(idx, strn):
    if res:
        return
    for i in range(1, idx // 2 + 1):
        for j in range(idx - 2*i + 1):
            if strn[j:j+i] == strn[j+i:j+2*i]:
                return
    if idx == n:
        print(strn)
        res.append(strn)
        return
    for i in range(1, 4):
        dfs(idx + 1, strn + str(i))

dfs(0, "")