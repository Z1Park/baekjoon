#include <stdio.h>
#include <stdlib.h>

int main() {
	int A,B,C;
	int RES;
	int cnt = 0;
	int rep=0;
	char* str;
	char stand[10] = {'0','1','2','3','4','5','6','7','8','9' };

	scanf("%d%d%d", &A,&B,&C);

	RES = A * B * C;

	for (int i = 1; RES>=i; i=i*10) {
		cnt += 1;
	}

	str = malloc(sizeof(char) * cnt);
	sprintf(str,"%d",RES);

	for (int j = 0; j <= 9; j++) {
		if (j != 0) {
			rep = 0;
			for (int k = 0; k < cnt; k++) {
				if (str[k] == stand[j])
					rep += 1;
			}
			printf("%d\n",rep);
		}
		else {
			for (int k = 0; k < cnt; k++) {
				if (str[k] == stand[j])
					rep += 1;
			}
			printf("%d\n", rep);
		}
	}
	
	free(str);

	return 0;
}