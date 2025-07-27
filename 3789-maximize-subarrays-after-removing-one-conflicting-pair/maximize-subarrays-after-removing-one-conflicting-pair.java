class Solution {
    public long maxSubarrays(int n, int[][] conflictingPairs) {
        long validSubarrays = 0L;
        int maxLeft = 0, secondMaxLeft = 0;
        long[] gains = new long[n + 1];
        List<Integer>[] conflicts = new List[n + 1];
        for (int i = 0; i <= n; i++) conflicts[i] = new ArrayList<>();

        for (int[] p : conflictingPairs) {
            int a = p[0], b = p[1];
            int right = Math.max(a, b), left = Math.min(a, b);
            conflicts[right].add(left);
        }

        for (int right = 1; right <= n; right++) {
            for (int left : conflicts[right]) {
                if (left > maxLeft) {
                    secondMaxLeft = maxLeft;
                    maxLeft = left;
                } else if (left > secondMaxLeft) {
                    secondMaxLeft = left;
                }
            }
            validSubarrays += right - maxLeft;
            gains[maxLeft] += (long)(maxLeft - secondMaxLeft);
        }

        long maxGain = 0;
        for (long g : gains) {
            if (g > maxGain) maxGain = g;
        }
        return validSubarrays + maxGain;
    }
}
