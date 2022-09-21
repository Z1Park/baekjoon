def get_char(s, idx):
    try:
        c = s[idx]
    except:
        c = ""
    return c


s = []
m_len = 0
for i in range(5):
    s.append(input())
    if (len(s[-1]) > m_len):
        m_len = len(s[-1])

strs = ["" for _ in range(m_len)]
for i in range(m_len):
    for j in range(5):
        strs[i] += get_char(s[j], i)

for s in strs:
    print(s, end='')