class Solution {
    private static final int MOD = (int)1e9 + 7;

    public int[] productQueries(int n, int[][] queries) {
        // 1. Build powers array
        int[] powers = new int[Integer.bitCount(n)];
        for (int i = 0; n > 0; ++i) {
            int x = n & -n;
            powers[i] = x;
            n -= x;
        }

        // 2. Compute results for each query
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; ++i) {
            long prod = 1;
            int l = queries[i][0], r = queries[i][1];
            for (int j = l; j <= r; ++j) {
                prod = (prod * powers[j]) % MOD;
            }
            ans[i] = (int) prod;
        }
        return ans;
    }
}
