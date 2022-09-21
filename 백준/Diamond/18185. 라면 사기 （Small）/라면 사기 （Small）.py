import sys
input = sys.stdin.readline

n = int(input())
lst = list(map(int, input().split())) + [0, 0]
money = 0
for i in range(n):
    if lst[i+1] > lst[i+2]:
        m = min(lst[i], lst[i+1]-lst[i+2])
        lst[i] -= m
        lst[i+1] -= m
        money += 5 * m
    if lst[i] > 0 and lst[i+1] > 0 and lst[i+2] > 0:
        m = min(lst[i:i+3])
        lst[i] -= m
        lst[i+1] -= m
        lst[i+2] -= m
        money += 7 * m
    if lst[i] > 0 and lst[i+1] > 0:
        m = min(lst[i:i+2])
        lst[i] -= m
        lst[i+1] -= m
        money += 5 * m
    money += lst[i] * 3
print(money)