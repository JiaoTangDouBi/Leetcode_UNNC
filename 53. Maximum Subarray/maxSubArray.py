class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        cur_sum = max_sum = float("-Inf")
        for cur in nums:
            cur_sum = max(cur_sum + cur, cur)
            max_sum = max(max_sum, cur_sum)
        return max_sum