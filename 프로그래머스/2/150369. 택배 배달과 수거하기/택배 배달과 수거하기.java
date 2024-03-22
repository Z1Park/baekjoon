class Solution {
	public long solution(int cap, int n, int[] deliveries, int[] pickups) {
		long distance = 0, d = 0, p = 0;
		for (int i = n - 1; i >= 0; i--) {
			d -= deliveries[i];
            p -= pickups[i];
            
            if (d < 0 || p < 0) {
                int min = (int)Math.ceil((double)Math.min(d, p) * -1 / cap);
                d += cap * min;
                p += cap * min;
                distance += (i + 1) * 2 * min;
            }
		}
		return distance;
	}
}