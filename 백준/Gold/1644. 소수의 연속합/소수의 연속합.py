n = int(input())
if n == 1:
    print(0)
else:
    nums = [False, False] + [True for _ in range(n+1)]
    prime = []
    for i in range(2, n+1):
        if nums[i]:
            prime.append(i)
            for j in range(i*2, n+1, i):
                nums[j] = False

    s = prime[0]
    i = j = 0
    cnt = 0
    while True:
        if s >= n:
            if s == n:
                cnt += 1
            s -= prime[j]
            j += 1
        else:
            i += 1
            if i >= len(prime):
                break
            s += prime[i]
    print(cnt)