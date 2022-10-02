n, m = map(int, input().split())
lst = [list(map(int, input())) for _ in range(n)]

mv = 0
if n == 1:
    idx1 = 1
    while idx1 < m-1:
        idx2 = idx1+1
        while idx2 < m:
            s = sum(lst[0][:idx1])*sum(lst[0][idx1:idx2])*sum(lst[0][idx2:])
            if mv < s:
                mv = s
            idx2 += 1
        idx1 += 1
elif m == 1:
    idx1 = 1
    while idx1 < n-1:
        idx2 = idx1+1
        while idx2 < n:
            a = b = c = 0
            for i in range(idx1):
                a += lst[i][0]
            for i in range(idx1, idx2):
                b += lst[i][0]
            for i in range(idx2, n):
                c += lst[i][0]
            s = a*b*c
            if mv < s:
                mv = s
            idx2 += 1
        idx1 += 1
else:
    idx1 = 1
    while idx1 < m-1:
        idx2 = idx1+1
        while idx2 < m:
            a = b = c = 0
            for i in range(n):
                a += sum(lst[i][:idx1])
                b += sum(lst[i][idx1:idx2])
                c += sum(lst[i][idx2:])
            s = a*b*c
            if mv < s:
                mv = s
            idx2 += 1
        idx1 += 1
    idx1 = 1
    while idx1 < n-1:
        idx2 = idx1+1
        while idx2 < n:
            a = b = c = 0
            for i in range(idx1):
                a += sum(lst[i])
            for i in range(idx1, idx2):
                b += sum(lst[i])
            for i in range(idx2, n):
                c += sum(lst[i])
            s = a*b*c
            if mv < s:
                mv = s
            idx2 += 1
        idx1 += 1
    idx1 = 1
    while idx1 < n:
        a1 = 0
        for i in range(idx1):
            a1 += sum(lst[i])
        a2 = 0
        for i in range(idx1, n):
            a2 += sum(lst[i])
        idx2 = 1
        while idx2 < m:
            b1 = c1 = 0
            for i in range(idx1, n):
                b1 += sum(lst[i][:idx2])
                c1 += sum(lst[i][idx2:])
            b2 = c2 = 0
            for i in range(idx1):
                b2 += sum(lst[i][:idx2])
                c2 += sum(lst[i][idx2:])
            s = max(a1*b1*c1, a2*b2*c2)
            if mv < s:
                mv = s
            idx2 += 1
        idx1 += 1
    idx1 = 1
    while idx1 < m:
        a1 = a2 = 0
        for i in range(n):
            a1 += sum(lst[i][:idx1])
            a2 += sum(lst[i][idx1:])
        idx2 = 1
        while idx2 < n:
            b1 = c1 = b2 = c2 = 0
            for i in range(idx2):
                b1 += sum(lst[i][idx1:])
                b2 += sum(lst[i][:idx1])
            for i in range(idx2, n):
                c1 += sum(lst[i][idx1:])
                c2 += sum(lst[i][:idx1])
            s = max(a1*b1*c1, a2*b2*c2)
            if mv < s:
                mv = s
            idx2 += 1
        idx1 += 1
print(mv)