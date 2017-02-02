class Solution(object):
    def maxProduct(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        max_product = local_min = local_max = nums[0]
        for i in range(1, len(nums)):
            cur = nums[i]
            local_min, local_max = min(min(cur*local_min, cur*local_max), cur), max(max(cur*local_min, cur*local_max), cur)
            max_product = max(max_product, local_max)
        return max_product