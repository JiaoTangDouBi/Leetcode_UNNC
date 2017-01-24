class Solution(object):
    def isPowerOfTwo_loop(self, n):
        """
        :type n: int
        :rtype: bool
        """
        if n <= 0:
            return False
            
        while n > 1:
            (d, res) = divmod(n, 2)
            if res > 0:
                return False
            n = d
        return True
    
    def isPowerOfTwo_rec(self, n):
        """
        :type n: int
        :rtype: bool
        """
        return n > 0 and \
              (n == 1 or \
               n % 2 == 0 and \
               self.isPowerOfTwo(n / 2)
              )
              
    def isPowerOfTwo(self, n):
        """
        :type n: int
        :rtype: bool
        """
        return n > 0 and \
               n & (n-1) == 0