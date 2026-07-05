
public class BitwiseCompliment {

    // ✅ Version 1: Brute Force using binary string manipulation
    public int bitwiseComplementBrute(int n) {
        // 🔸 Special Case: If input is 0, binary is "0", flipping gives "1" → decimal = 1
        if (n == 0) return 1;

        // Step 1: Convert number to binary string (e.g., 5 → "101")
        String binary = Integer.toBinaryString(n);

        // Step 2: Flip every bit in the binary string
        //         If bit is '1', change to '0', and vice versa
        StringBuilder complement = new StringBuilder();
        for (char bit : binary.toCharArray()) {
            if (bit == '0') {
                complement.append('1');
            } else {
                complement.append('0');
            }
        }

        // Step 3: Convert the flipped binary string back to decimal
        return Integer.parseInt(complement.toString(), 2);
    }

    // ✅ Version 2: Better Approach using bitwise logic manually (no strings)
    public int bitwiseComplementBetter(int n) {
        // 🔸 Special Case
        if (n == 0) return 1;

        int result = 0;     // To store the final complement value
        int power = 1;      // Represents the current bit position's decimal value (1, 2, 4, 8, ...)

        // Loop through each bit of n (starting from LSB)
        while (n > 0) {
            // Get the last bit of n: if even → 0, if odd → 1
            int lastBit = n % 2;

            // Flip the bit: if 1 → 0, if 0 → 1
            int flippedBit = (lastBit == 0) ? 1 : 0;

            // Add the flipped bit to result at the correct place using 'power'
            result += flippedBit * power;

            // Move to next bit:
            n = n / 2;         // Remove last bit
            power = power * 2; // Move to next binary position (1→2→4→8...)
        }

        return result;
    }

    // ✅ Version 3: Optimal Approach using bitwise mask and XOR
    public int bitwiseComplementOptimal(int n) {
        // 🔸 Special Case: 0 → complement is 1
        if (n == 0) return 1;

        int mask = 0;   // Will store a number with same number of bits as 'n', but all bits are 1
        int temp = n;   // A temporary copy of 'n' to calculate bit length

        // Step 1: Build the mask
        // Example: if n = 5 (binary 101), we want mask = 111
        // Shift mask left by 1 and add 1 repeatedly until temp becomes 0
        while (temp != 0) {
            mask = (mask << 1) | 1;  // Shift left by 1 and add 1 at end
            temp = temp >> 1;        // Shift temp right by 1 to reduce its bit size
        }

        // Step 2: XOR 'n' with the mask to flip all bits
        // XOR logic: 1^1 = 0, 0^1 = 1 → exactly what we want for complement
        return n ^ mask;
    }

    // ✅ Main method to test all three versions with sample inputs
    public static void main(String[] args) {
        BitwiseCompliment obj = new BitwiseCompliment(); // Create object of class

        // Sample test inputs
        int[] testInputs = {0, 1, 5, 10, 32, 100};

        // Print header for table
        System.out.printf("%-10s %-25s %-25s %-25s\n", "Input", "Brute Force", "Better (Bitwise)", "Optimal (Mask + XOR)");
        System.out.println("----------------------------------------------------------------------------------------------");

        // Loop through test inputs and evaluate each version
        for (int num : testInputs) {
            int brute = obj.bitwiseComplementBrute(num);
            int better = obj.bitwiseComplementBetter(num);
            int optimal = obj.bitwiseComplementOptimal(num);

            // Print results in formatted table
            System.out.printf("%-10d %-25d %-25d %-25d\n", num, brute, better, optimal);
        }
    }
}

