#include <vector>

using namespace std;
#include <iostream>
vector<long long> solution(vector<long long> numbers) {
    vector<long long> answer;
    for (long long num : numbers) {
        long long bit = 1;
        while ((num & bit) == bit) bit <<= 1;
        num |= bit; 
        answer.push_back((num & (~(bit >> 1))));
    }
    return answer;
}