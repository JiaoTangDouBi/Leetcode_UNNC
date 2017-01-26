class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # max(f(n) + f(n-2), f(n-1))
        last2 = last1 = cur = 0
        for i in range(len(nums)):
            cur = max(nums[i] + last2, last1)
            last1, last2 = cur, last1
        return cur
            