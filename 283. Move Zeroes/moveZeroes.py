class Solution(object):
    def moveZeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        cur = 0
        for i in range(len(nums)):
            val = nums[i]
            if val != 0:
                nums[i] = 0
                nums[cur] = val
                cur += 1