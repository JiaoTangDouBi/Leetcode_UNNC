class Solution(object):
    def rotate(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: void Do not return anything, modify matrix in-place instead.
        """
        n = len(matrix)
        # upside down -> symmery
        if n == 0:
            return matrix
            
        top, down = 0, n-1
        while top < down:
            matrix[top], matrix[down] = matrix[down], matrix[top]
            top += 1
            down -= 1
            
        for i in range(n):
            for j in range(i, n):
                matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]
