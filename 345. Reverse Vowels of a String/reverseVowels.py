from sets import Set
class Solution(object):
    def reverseVowels(self, s):
        """
        :type s: str
        :rtype: str
        """
        vowels = Set( ['a', 'e', 'i', 'o', 'u'] )
        s = list(s)
        left = 0
        right = len(s) - 1
        while left < right:
            while left < right and s[left].lower() not in vowels:
                left += 1
            while left < right and s[right].lower() not in vowels:
                right -= 1
                
            s[left], s[right] = s[right], s[left]
            left += 1
            right -= 1
                
        return ''.join(s)