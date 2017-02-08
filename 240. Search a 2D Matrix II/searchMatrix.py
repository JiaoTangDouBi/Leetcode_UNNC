class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        if len(matrix) == 0:
            return False
            
        row = 0
        col = len(matrix[0]) - 1
        
        while row < len(matrix) and col >= 0:
            val = matrix[row][col]
            if target == val:
                return True
            if target > val:
                row += 1
            if target < val:
                col -= 1

        return False