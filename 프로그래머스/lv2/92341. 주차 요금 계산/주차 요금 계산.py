def solution(fees, records):
    parking = []
    tlog = sorted(list(set([a for a in zip(*[list(rc.split()) for rc in records])][1])))
    tlog = [[a, 0] for a in tlog]
    for rc in records:
        time, car, io = map(str, rc.split())
        h, m = map(int, time.split(':'))
        if io == "IN":
            parking.append([car, h, m])
        else:
            for p in parking:
                if p[0] == car:
                    t = (h - p[1]) * 60 + m - p[2]
                    parking.remove(p)
                    break
            for tl in tlog:
                if tl[0] == car:
                    tl[1] += t
                    break
    while parking:
        car, h, m = parking.pop()
        for tl in tlog:
            if tl[0] == car:
                tl[1] += (23 - h) * 60 + 59 - m
    answer = []
    for tl in tlog:
        if tl[1] > fees[0]:
            tmp = tl[1] - fees[0]
            if tmp % fees[2] != 0:
                tmp += fees[2] - tmp % fees[2]
            answer.append(fees[1] + tmp / fees[2] * fees[3])
        else:
            answer.append(fees[1])
    return answer