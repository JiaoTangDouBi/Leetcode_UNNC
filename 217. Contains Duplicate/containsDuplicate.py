class Solution(object):
    def containsDuplicate(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        cache = {}
        for i in range(len(nums)):
            val = nums[i]
            if val not in cache:
                cache[val] = i
            else:
                return True
        return False