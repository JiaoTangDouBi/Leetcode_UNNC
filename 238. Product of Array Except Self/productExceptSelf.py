class Solution(object):
    def productExceptSelf(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        
        # [2, 3, 4, 5]
        # [1, 2, 2*3, 2*3*4]
        # [1*5*4*3, 2*5*4, 2*3*5, 2*3*4]
        
        output = []
        p = 1
        for i in range(len(nums)):
            output.append(p)
            p *= nums[i]
        
        p = 1
        for i in range(len(nums)-1, -1 , -1):
            output[i] *= p
            p *= nums[i]

        return output