a, p = map(int, input().split())
lst = [a]
while True:
    s = 0
    for i in list(map(int, str(lst[-1]))):
        s += i**p
    if s in lst:
        break
    lst.append(s)
print(lst.index(s))