/**
 * 🧩 Problem: Maximum Nesting Depth of Parentheses
 * LeetCode #1614
 * GeeksforGeeks: "Maximum Nesting Depth of the Parentheses"
 * HackerRank Equivalent: "Balanced Brackets Depth" (similar concept)
 */

public class MaxNestingDepth {

    /**
     * 💡 Approach: Single Scan Using Counter
     * --------------------------------------------------
     * We iterate through the string character by character:
     * - Increment count when we see '('
     * - Decrement count when we see ')'
     * - Track the max value of count during the traversal — that’s our max depth!
     *
     * 🧠 Intuition:
     * Think of count as your “current floor level” in a building.
     * Each '(' means you go *one floor deeper* 🏢⬇️
     * Each ')' means you *come back up* 🏢⬆️
     * The deepest you go — that’s your max nesting depth!
     *
     * --------------------------------------------------
     * ⏱️ Time Complexity: O(n)
     *  - We traverse the string once → linear in its length.
     *
     * 💾 Space Complexity: O(1)
     *  - Just two integer variables: `count` and `ans`.
     */
    static int maxDepth(String s) {
        int count = 0; // current depth
        int ans = 0;   // maximum depth so far

        // Traverse each character
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // If we encounter '(', we’re going one level deeper
            if (ch == '(') {
                count++;
                ans = Math.max(ans, count); // update max depth
            }
            // If we encounter ')', we’re closing one level
            else if (ch == ')') {
                count--;
            }
        }
        return ans;
    }

    // 🧪 Demo main() — because we test everything like pros
    public static void main(String[] args) {
        String s1 = "(1+(2*3)+((8)/4))+1";
        String s2 = "(1)+((2))+(((3)))";
        String s3 = "()(())((()))";

        System.out.println("Input: " + s1 + " → Max Depth: " + maxDepth(s1)); // 3
        System.out.println("Input: " + s2 + " → Max Depth: " + maxDepth(s2)); // 3
        System.out.println("Input: " + s3 + " → Max Depth: " + maxDepth(s3)); // 3
    }
}
