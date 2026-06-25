class Solution(object):
    def isAnagram(self, s, t):
        """
        Time Complexity: O(n)
        Reason:
        - First loop traverses s once -> O(n)
        - Second loop traverses t once -> O(n)
        - Dictionary operations (get, insert, delete) are O(1) on average
        - Overall: O(n)

        Space Complexity: O(k)
        Reason:
        - Dictionary stores frequency of unique characters
        - k = number of unique characters
        """

        # If lengths are different, strings cannot be anagrams
        if len(s) != len(t):
            return False

        # Dictionary to store character frequencies
        freq = {}

        # Count frequency of each character in string s
        for ch in s:
            freq[ch] = freq.get(ch, 0) + 1

        # Reduce frequencies using characters from string t
        for ch in t:

            # Character not found in s
            if ch not in freq:
                return False

            # Decrease frequency count
            freq[ch] -= 1

            # Remove character when count becomes 0
            # This keeps the dictionary clean
            if freq[ch] == 0:
                del freq[ch]

        # If dictionary is empty, all frequencies matched
        return len(freq) == 0


# Driver Code (similar to Java main method)
if __name__ == "__main__":
    sol = Solution()

    print(sol.isAnagram("anagram", "nagaram"))  # True
    print(sol.isAnagram("rat", "car"))          # False
    print(sol.isAnagram("listen", "silent"))    # True
    print(sol.isAnagram("hello", "world"))      # False