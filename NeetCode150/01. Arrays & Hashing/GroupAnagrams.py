from typing import List
from collections import defaultdict


class Solution:

    def groupAnagramsUsingSorting(self, strs: List[str]) -> List[List[str]]:
        """
        Approach: Group Anagrams Using Sorted String as Key

        Time Complexity: O(n * k log k)
        Reason:
        - n is the number of words in the list.
        - k is the average length of each word.
        - For every word, we sort its characters.
        - Sorting one word takes O(k log k).
        - So for n words, total time is O(n * k log k).

        Space Complexity: O(n * k)
        Reason:
        - We store all words inside the dictionary groups.
        - In the worst case, all words are stored.
        - Sorted keys also take extra space.
        """

        # Dictionary where:
        # key   = sorted version of the word
        # value = list of words that are anagrams
        anagrams = defaultdict(list)

        # Traverse each word in the input list
        for word in strs:

            # Sort the characters of the word
            # Example:
            # "eat" -> ['a', 'e', 't'] -> "aet"
            key = ''.join(sorted(word))

            # Add the original word to the group
            # having the same sorted key
            anagrams[key].append(word)

        # Return only the grouped anagrams,
        # not the dictionary keys
        return list(anagrams.values())


def main():
    solution = Solution()

    test_cases = [
        ["eat", "tea", "tan", "ate", "nat", "bat"],
        [""],
        ["a"],
        ["abc", "bca", "cab", "xyz", "zyx"]
    ]

    for strs in test_cases:
        print(f"Input: {strs}")

        result = solution.groupAnagramsUsingSorting(strs)
        print("Grouped Anagrams:", result)

        print("-" * 40)


if __name__ == "__main__":
    main()