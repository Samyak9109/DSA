from typing import List

class Solution:

    def encode(self, strs: List[str]) -> str:
        """
        Encodes a list of strings into a single string.

        Approach:
        - For each string, store its length first.
        - Add a separator '#'.
        - Then add the actual string.

        Example:
        ["leet", "code"] -> "4#leet4#code"

        Time Complexity: O(n)
        Space Complexity: O(n)
        where n is the total number of characters in all strings.
        """

        encoded = ""

        for word in strs:
            encoded += str(len(word)) + "#" + word

        return encoded


    def decode(self, s: str) -> List[str]:
        """
        Decodes a single encoded string back into a list of strings.

        Approach:
        - Read digits until '#'.
        - Convert digits to length.
        - Extract exactly that many characters after '#'.

        Time Complexity: O(n)
        Space Complexity: O(n)
        where n is the length of the encoded string.
        """

        result = []
        i = 0

        while i < len(s):

            # Find the separator '#'
            j = i
            while s[j] != "#":
                j += 1

            # Length of the next word
            length = int(s[i:j])

            # Word starts after '#'
            word_start = j + 1
            word_end = word_start + length

            # Extract word
            result.append(s[word_start:word_end])

            # Move pointer to next encoded word
            i = word_end

        return result