#include <bits/stdc++.h>

using namespace std;

long long solution(int k, int d) {
    long long answer = 0;
    long long dist = (long long)d * d;
    for (long long height = 0; height <= d; height += k)
        answer += ((long long)sqrt(dist - height * height)) / k + 1;
    return answer;
}