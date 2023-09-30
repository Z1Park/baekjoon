#include <string>
#include <vector>

using namespace std;

int gcd(int a, int b) {
    int tmp;
    while (a % b) {
        tmp = a % b;
        a = b;
        b = tmp;
    }
    return b;
}

int solution(vector<int> arr) {
    int answer = arr[0];
    for (int i = 1; i < arr.size(); i++) {
        int g = gcd(answer, arr[i]);
        answer = answer * arr[i] / g;
    }
    return answer;
}