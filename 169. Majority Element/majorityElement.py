class Solution(object):
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        hash = {}
        output = nums[0]
        for i in range(len(nums)):
            val = nums[i]
            if val in hash:
                hash[val] += 1
                if hash[val] > len(nums) / 2:
                    output = val
                    break
            else:
                hash[val] = 1
        return output