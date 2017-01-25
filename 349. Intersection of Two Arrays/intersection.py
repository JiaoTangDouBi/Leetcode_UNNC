class Solution(object):
    def intersection(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        cache = {}
        output = set([])
        for i in range(len(nums1)):
            val = nums1[i]
            if val not in cache:
                cache[val] = 1
            else:
                cache[val] += 1
        
        for i in range(len(nums2)):
            val = nums2[i]
            if val in cache and val not in output:
                output.add(val)
        return list(output)