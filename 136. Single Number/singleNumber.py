class Solution(object):
    def singleNumber_mem_On(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        cache = {}
        for i in range(len(nums)):
            val = nums[i]
            if val in cache:
                cache[val] += 1
            else:
                cache[val] = 1
        for key in cache:
            if cache[key] == 1:
                return key
                
    def singleNumber(self, nums):
        output = 0
        for n in nums:
            output ^= n
        return output
        