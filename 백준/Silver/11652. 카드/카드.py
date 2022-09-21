import sys
input = sys.stdin.readline

n = int(input())
lst = []
for i in range(n):
    lst.append(int(input()))
lst.sort()
ss = list(set(lst))
ss.sort()
m_lst = []
for i in ss:
    m_lst.append(1)
j = 0
for i in range(1, n):
    if lst[i] == lst[i - 1]:
        m_lst[j] += 1
    else:
        j += 1
m = ss[m_lst.index(max(m_lst))]

print(m)