from heapq import *
class Solution(object):
    # def findKthLargest(self, nums, k):
    #     """
    #     :type nums: List[int]
    #     :type k: int
    #     :rtype: int
    #     """
    #     nums.sort(key = lambda x: -x)
    #     return nums[k-1]
        
    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        output = 0
        heap = []
        for n in nums:
            heappush(heap, -n)
        for i in range(k):
            output = heappop(heap)
        return -output
        