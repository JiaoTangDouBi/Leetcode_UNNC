class Solution(object):
    def hammingWeight(self, n):
        """
        :type n: int
        :rtype: int
        """
        w = 0
        while n > 0:
            (n, res) = divmod(n, 2)
            w += res
        return w