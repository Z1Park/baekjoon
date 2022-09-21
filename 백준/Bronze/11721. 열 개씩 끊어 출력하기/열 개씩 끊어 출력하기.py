s = input()
for key, value in enumerate(s):
    if (key != 0 and key % 10 == 0):
        print()
    print(value, end ='')