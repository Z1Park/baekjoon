s = input()
res = ""
for key, a in enumerate(s):
    if (a >= 'a' and a <= 'z'):
        a = ord(a) + 13
        if (a > 122):
            a -= 26
        res += chr(a)
    elif (a >= 'A' and a <= 'Z'):
        a = ord(a) + 13
        if (a > 90):
            a -= 26
        res += chr(a)
    else:
        res += a
print(res)