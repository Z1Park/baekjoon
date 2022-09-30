tc = int(input())
for t in range(tc):
    n = int(input())
    lst = [0] + list(map(int, input().split()))
    visit = [0 for _ in range(n+1)]
    res = []
    for i in range(1, n+1):
        if visit[i] != 0:
            continue
        tmp = i
        loop = []
        while visit[tmp] == 0:
            visit[tmp] = 1
            loop.append(tmp)
            tmp = lst[tmp]
        if tmp in loop:
            res += loop[loop.index(tmp):]
    print(n - len(res))