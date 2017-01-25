class Solution(object):
    # hash (sol #2: sort and then two pointers)
    def intersect(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        cache = {}
        output = []
        for i in range(len(nums1)):
            val = nums1[i]
            if val not in cache:
                cache[val] = 1
            else:
                cache[val] += 1
        
        for i in range(len(nums2)):
            val = nums2[i]
            if val in cache and cache[val] > 0:
                output.append(val)
                cache[val] -= 1
        return output
        