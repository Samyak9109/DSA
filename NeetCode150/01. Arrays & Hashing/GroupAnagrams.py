class Solution(object):
    def groupAnagrams(self, strs):
        anagrams = defaultdict(list)

        for word in strs:
            key = ''.join(sorted(word))
            anagrams[key].append(word)

        return list(anagrams.values())