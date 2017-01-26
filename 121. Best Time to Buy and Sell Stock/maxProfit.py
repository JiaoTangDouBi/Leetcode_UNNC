class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        # min
        # max: max(cur - min, last)
        min_val = float('inf')
        max_val = 0
        for cur in prices:
            min_val = min(cur, min_val)
            max_val = max(cur - min_val, max_val)
        return max_val