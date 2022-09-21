def is_prime(n):
    if (n <= 1):
        False
    i = 2
    while (i**2 <= n):
        if (n % i == 0):
            return False
        i += 1    
    return True

prime_lst = []

for i in range(2, 10000):
    if is_prime(i):
        prime_lst.append(i)

t = int(input())

for i in range(t):
    n = int(input())

    a = n // 2
    b = n // 2
    while (a not in prime_lst or b not in prime_lst):
        a -= 1
        b += 1
 
    print(a, b)