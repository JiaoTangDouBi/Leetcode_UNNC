class Solution(object):
    def isHappy_hash(self, n):
        """
        :type n: int
        :rtype: bool
        """
        cache = set()
        ops = lambda n : sum(int(x)**2 for x in str(n))
        while n not in cache:
            cache.add(n) 
            n = ops(n)
        return n == 1
            
    def isHappy(self, n):
        """
        :type n: int
        :rtype: bool
        """
        ops = lambda n : sum(int(x)**2 for x in str(n))
        slow = n 
        fast = ops(n)
        while slow != fast:
            slow = ops(slow)
            fast = ops(ops(fast))
        return fast == 1