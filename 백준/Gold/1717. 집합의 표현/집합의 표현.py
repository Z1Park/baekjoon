import sys
input = sys.stdin.readline

n, m = map(int, input().split())
lst = [i for i in range(n + 1)]
for i in range(m):
    cmd, s1, s2 = map(int, input().split())
    if cmd == 0:
        while s2 != lst[s2]:
            lst[s2] = lst[lst[s2]]
            s2 = lst[s2]
        lst[s2] = s1
    else:
        while s2 != lst[s2]:
            lst[s2] = lst[lst[s2]]
            s2 = lst[s2]
        while s1 != lst[s1]:
            lst[s1] = lst[lst[s1]]
            s1 = lst[s1]
        if s1 == s2:
            print("YES")
        else:
            print("NO")