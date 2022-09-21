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

for i in range(2, 123456 * 2 + 1):
    if is_prime(i):
        prime_lst.append(i)

while (True):
    n = int(input())
    count = 0
    if (n == 0):
        break
    for i in prime_lst:
        if i > n * 2:
            break
        elif (n < i <= n * 2):
            count += 1
    print(count)