import sys
input = sys.stdin.readline

n = int(input())
lst = [int(input()) for _ in range(n)]
lst.sort()
new = []
left = 0
while left < n - 1 and lst[left + 1] <= 0:
    new.append(lst[left] * lst[left + 1])
    left += 2
right = n - 1
while right > 0 and lst[right - 1] > 1:
    new.append(lst[right] * lst[right - 1])
    right -= 2
new += lst[left:right+1]
print(sum(new))