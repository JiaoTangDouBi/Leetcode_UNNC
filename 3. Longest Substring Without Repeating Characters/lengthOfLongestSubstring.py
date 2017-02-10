class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        # a a d v d f a
        # a: 0
        # a: 1
        # a: 1, d: 2
        # a: 1, d: 2, v: 3
        # (start=3) a: 1, d: 4, v: 3
        # (start=3) a: 1, d: 4, v: 3, ...
        start = i = 0
        result = 0
        cache = {}
        while i < len(s):
            while i < len(s) and (s[i] not in cache or cache[s[i]] < start):
                cache[s[i]] = i
                i += 1
            result = max(result, i - start)
            if i < len(s):
                start = cache[s[i]] + 1
        return result