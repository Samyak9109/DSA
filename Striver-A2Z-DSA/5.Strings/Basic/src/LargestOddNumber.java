public class LargestOddNumber {

    /**
     * 💡 Problem Statement:
     * Given a numeric string, find the largest possible substring (from the start)
     * that forms an odd number.
     *
     * Example:
     * num = "4206" → output = ""
     * num = "35427" → output = "35427"
     * num = "35420" → output = "3542"
     */

    static String largestOddNumber(String num) {
        // 🧠 Time Complexity: O(n)
        // We scan the string once from the end to find the last odd digit → O(n)
        // Space Complexity: O(1)
        // We only store a few variables (constant extra space)

        int index = -1;  // stores index of last odd digit (if any)

        // 🔁 Step 1: Traverse from right to left (we’re looking for last odd digit)
        for (int i = num.length() - 1; i >= 0; i--) {
            // Convert char to int: ('7' - '0') = 7
            if ((num.charAt(i) - '0') % 2 != 0) {
                index = i; // found last odd digit
                break;
            }
        }

        // ⚠️ Step 2: If no odd digit exists, return empty string
        if (index == -1) return "";

        // 🧹 Step 3: Skip leading zeros (optional, just for neatness)
        int i = 0;
        while (i <= index && num.charAt(i) == '0') i++;

        // ✂️ Step 4: Return substring from first non-zero to last odd digit
        return num.substring(i, index + 1);
    }

    // 🧪 Test the function
    public static void main(String[] args) {
        System.out.println(largestOddNumber("4206"));   // Output: ""
        System.out.println(largestOddNumber("35427"));  // Output: "35427"
        System.out.println(largestOddNumber("35420"));  // Output: "3542"
        System.out.println(largestOddNumber("0001350")); // Output: "000135"
    }
}
