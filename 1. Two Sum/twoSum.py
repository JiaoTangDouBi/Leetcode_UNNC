class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        cache = {}
        output = None
        for i in range(len(nums)):
            val = nums[i]
            pair = target - val
            if val in cache:
                output = [cache[val], i]
                break
            else:
                cache[pair] = i
        return output