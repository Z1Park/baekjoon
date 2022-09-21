#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void function(int x, int y, int w, int h) {
	int hori = 0, vert = 0;
	
	if (x < (w - x))
		hori = x;
	else
		hori = w - x;

	if (y < (h - y))
		vert = y;
	else
		vert = h - y;
	
	if (vert < hori)
		printf("%d",vert);
	else
		printf("%d",hori);
}

int main() {
	int x, y, w, h;

	scanf("%d %d %d %d", &x, &y, &w, &h);

	function(x,y,w,h);

	return 0;
}