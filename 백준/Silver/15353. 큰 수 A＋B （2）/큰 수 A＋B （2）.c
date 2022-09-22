#include <stdio.h>

int main() {
	char    s1[100001], s2[100001];
    int     res[100001];
    int     len_s1, len_s2, n1, n2, up, idx;

    scanf("%s %s", s1, s2);
    len_s1 = 0;
    while (s1[len_s1] != 0)
        len_s1++;
    len_s2 = 0;
    while (s2[len_s2] != 0)
        len_s2++;
    up = 0;
    idx = 0;
    while (len_s1 > 0 || len_s2 > 0 || up != 0)
    {
        if (--len_s1 >= 0)
            n1 = s1[len_s1] - '0';
        if (--len_s2 >= 0)
            n2 = s2[len_s2] - '0';
        res[idx++] = (n1 + n2 + up) % 10;
        up = (n1 + n2 + up >= 10) ? 1 : 0;
        n1 = 0;
        n2 = 0;
    }
    idx--;
    for (idx; idx >= 0; idx--)
        printf("%d", res[idx]);
	return 0;
}