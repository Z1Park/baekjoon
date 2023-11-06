#include <cmath>

using namespace std;

long long solution(int w,int h) {
    if (w == h) return (long long)w * (w -1);
    if (w == 1 || h == 1) return 0;
    long long cnt = 0;
    for (int i = 1; i <= w; i++)
        cnt += ceil((double)i * h / w) - floor((double)(i-1) * h / w);
    return (long long)w * h - cnt;
}