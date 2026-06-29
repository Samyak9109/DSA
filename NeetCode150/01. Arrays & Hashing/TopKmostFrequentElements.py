from collections import Counter

class Solution(object):
    def topKFrequent(self, nums, k):
        """
        Approach: Frequency Count + Bucket Sort

        Time Complexity: O(n)
        Reason:
        - Counting frequency takes O(n).
        - Placing numbers into buckets takes O(n).
        - Traversing buckets also takes O(n).

        Space Complexity: O(n)
        Reason:
        - Frequency map stores up to n unique elements.
        - Bucket array also takes O(n) space.

        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """

        # Count frequency of each number
        freq = Counter(nums)

        # Create buckets where index = frequency
        # Example: bucket[3] contains numbers that appear 3 times
        bucket = [[] for _ in range(len(nums) + 1)]

        # Put each number into its frequency bucket
        for num, count in freq.items():
            bucket[count].append(num)

        # Store final answer
        result = []

        # Start from highest frequency and move down
        for i in range(len(bucket) - 1, 0, -1):

            # Add all numbers with current frequency
            for num in bucket[i]:
                result.append(num)

                # Stop once we have k frequent elements
                if len(result) == k:
                    return result