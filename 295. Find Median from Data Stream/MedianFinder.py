from heapq import *

class MedianFinder(object):

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.small = [] # max heap
        self.large = [] # min heap

    def addNum(self, num):
        """
        :type num: int
        :rtype: void
        """
        heappush(self.small, -heappushpop(self.large, num))
        if len(self.large) < len(self.small):
            heappush(self.large, -heappop(self.small))

    def findMedian(self):
        """
        :rtype: float
        """
        # even: root of large; odd: mean of two roots
        if len(self.large) == len(self.small):
            return (-self.small[0] + self.large[0] ) / 2.0
        else:
            return float(self.large[0])


# Your MedianFinder object will be instantiated and called as such:
# obj = MedianFinder()
# obj.addNum(num)
# param_2 = obj.findMedian()