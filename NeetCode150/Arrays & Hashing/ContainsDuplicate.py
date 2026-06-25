from typing import List

class Solution:

    def containsDuplicateUsingSeen(self, nums: List[int]) -> bool:
        """
        Approach 1: Using a Set While Traversing

        Time Complexity: O(n)
        Reason:
        - We visit each element once.
        - Set lookup and insertion are O(1) on average.

        Space Complexity: O(n)
        Reason:
        - In the worst case, all elements are unique and stored in the set.
        """

        # Stores elements we have already seen
        seen = set()

        for num in nums:

            # If number already exists in the set,
            # we found a duplicate
            if num in seen:
                return True

            # Add current number to the set
            seen.add(num)

        # No duplicate found
        return False

    def containsDuplicateUsingLength(self, nums: List[int]) -> bool:
        """
        Approach 2: Compare Length of List and Set

        Time Complexity: O(n)
        Reason:
        - Creating the set requires traversing all elements.

        Space Complexity: O(n)
        Reason:
        - Set may store all unique elements.
        """

        # A set automatically removes duplicates
        unique_elements = set(nums)

        # If lengths differ, duplicates exist
        return len(nums) != len(unique_elements)


def main():
    solution = Solution()

    test_cases = [
        [1, 2, 3, 1],
        [1, 2, 3, 4],
        [1, 1, 1, 3, 3, 4, 3, 2, 4, 2]
    ]

    for nums in test_cases:
        print(f"Input: {nums}")

        result1 = solution.containsDuplicateUsingSeen(nums)
        print("Using Seen Set      :", result1)

        result2 = solution.containsDuplicateUsingLength(nums)
        print("Using Length Check  :", result2)

        print("-" * 40)


if __name__ == "__main__":
    main()