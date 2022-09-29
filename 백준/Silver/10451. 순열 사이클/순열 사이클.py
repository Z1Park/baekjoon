tc = int(input())
for t in range(tc):
    n = int(input())
    lst = [0] + list(map(int, input().split()))
    visit = [False for _ in range(n+1)]
    cnt = 0
    for i in range(1, n+1):
        if visit[i]:
            continue
        visit[i] = True
        cnt += 1
        tmp = lst[i]
        while i != tmp and not visit[tmp]:
            visit[tmp] = True
            tmp = lst[tmp]
    print(cnt)