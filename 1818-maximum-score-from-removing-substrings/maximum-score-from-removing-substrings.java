class Solution {
    public int maximumGain(String s, int x, int y) {
        String first = x >= y ? "ab" : "ba";
        String second = x >= y ? "ba" : "ab";
        int firstVal = x >= y ? x : y;
        int secondVal = x >= y ? y : x;

        int score = 0;
        Deque<Character> stack1 = new ArrayDeque<>();
         for (char c : s.toCharArray()) {
            if (!stack1.isEmpty() &&
                stack1.peekLast() == first.charAt(0) &&
                c == first.charAt(1)) {
                stack1.removeLast();
                score += firstVal;
            } else {
                stack1.addLast(c);
            }
        }
        Deque<Character> stack2 = new ArrayDeque<>();
        for (char c : stack1) {
            if (!stack2.isEmpty() &&
                stack2.peekLast() == second.charAt(0) &&
                c == second.charAt(1)) {
                stack2.removeLast();
                score += secondVal;
            } else {
                stack2.addLast(c);
            }
        }

        return score;

    }
}