class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        l, r, min_h, water = 0, len(height)-1, 0, 0
        while l < r:
            # left side
            while l < r and min_h >= height[l]:
                water += min_h - height[l]
                l += 1
            while l < r and min_h >= height[r]:
                water += min_h - height[r]
                r -= 1
            min_h = min(height[l], height[r])
        return water