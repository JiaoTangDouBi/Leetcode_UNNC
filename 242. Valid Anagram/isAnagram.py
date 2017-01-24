class Solution(object):
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        cache = {}
        for i in s:
            if i not in cache:
                cache[i] = 1
            else:
                cache[i] += 1
        for i in t:
            if i not in cache:
                return False
            else:
                cache[i] -= 1
        for i in cache:
            if cache[i] > 0:
                return False
        return True
        