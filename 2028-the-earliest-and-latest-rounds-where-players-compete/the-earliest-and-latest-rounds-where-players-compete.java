class Solution {
    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        int[][][][] mem = new int[n + 1][n + 1][n + 1][2];
       return solve(firstPlayer,n-secondPlayer+1, n, mem); 
    }
    private int[] solve(int l, int r, int k, int[][][][] mem) {
        if (l == r) return new int[]{1,1};
        if (l > r) return solve(r, l, k, mem);
        if (mem[l][r][k][0] != 0) return mem[l][r][k];

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 1; i <= l; i++) {
            for (int j = l - i + 1; j <= r - i; j++) {
                if (i + j < l + r - k/2 || i + j > (k + 1)/2) continue;
                int[] res = solve(i, j, (k + 1)/2, mem);
                min = Math.min(min, res[0] + 1);
                max = Math.max(max, res[1] + 1);
            }
        }
        return mem[l][r][k] = new int[]{min, max};
    }
}