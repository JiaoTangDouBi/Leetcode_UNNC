class Solution(object):
    # dp - Bottom up, O(n) space
    def climbStairs_On(self, n):
        """
        :type n: int
        :rtype: int
        """
        ls = [0]*(n+1)
        if n == 0:
            return 1
        if n == 1:
            return 1
            
        ls[0] = ls[1] = 1
        
        for i in range(2, len(ls)):
            ls[i] = ls[i-1] + ls[i-2] # 1-step back + 2-step back
        
        return ls[n]
        
    # dp - Bottom up, O(1) space
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        """
        ls = [0]*(n+1)
        if n == 0:
            return 1
        if n == 1:
            return 1
            
        one_step_back = 1
        two_steps_back = 1
        for i in range(n - 1):
            output = one_step_back + two_steps_back
            one_step_back, two_steps_back = output, one_step_back
            
        
        return output