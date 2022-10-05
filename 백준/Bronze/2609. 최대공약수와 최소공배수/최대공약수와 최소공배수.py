n, m = map(int, input().split())
if n < m:
    n, m = m, n
a, b = n, m
tmp = a % b
while tmp != 0:
    a = b
    b = tmp
    tmp = a % b
print(b)
print(n * (m // b))