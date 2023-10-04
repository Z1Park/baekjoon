#include <string>
#include <vector>
#include <algorithm>

using namespace std;

bool solution(vector<string> pb) {
    sort(pb.begin(), pb.end());
    for (int i = 0; i < pb.size() - 1; i++)
        if (pb[i][0] == pb[i+1][0] && pb[i] == pb[i+1].substr(0, pb[i].size()))
            return false;
    return true;
}