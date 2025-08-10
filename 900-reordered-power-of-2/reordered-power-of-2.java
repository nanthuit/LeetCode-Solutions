class Solution {
    public boolean reorderedPowerOf2(int n) {
        int[] cnt = countDigits(n);
        for (int i = 0; i < 31; i++) {
            if (Arrays.equals(cnt, countDigits(1 << i))) {
                return true;
            }
        }
        return false;
    }
    private int[] countDigits(int x) {
        int[] c = new int[10];
        while (x > 0) {
            c[x % 10]++;
            x /= 10;
        }
        return c;
    }
}
