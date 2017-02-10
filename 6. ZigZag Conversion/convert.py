class Solution(object):
    def convert(self, s, numRows):
        """
        :type s: str
        :type numRows: int
        :rtype: str
        """
        
        if numRows == 1 or len(s) < numRows:
            return s
        
        output = ["" for _ in range(numRows)]
        
        # index: index of row (output[index])
        # step: step 1 row further or back 
        index, step = 0, 1
        
        for ch in s:
            output[index] += ch
            if index == numRows - 1:
                step = -1
            elif index == 0:
                step = 1
            index += step
            
        return ''.join(output)