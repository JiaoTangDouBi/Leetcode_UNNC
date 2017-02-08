class Solution(object):
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        row = [{} for _ in range(9)]
        col = [{} for _ in range(9)]
        square = [[{} for _ in range(3)] for _ in range(3)]
        for i in range(9):
            for j in range(9):
                val = board[i][j]
                if val == '.':
                    continue
                
                if val in row[i]:
                    return False
                else:
                    row[i][val] = (i, j)
                    
                if val in col[j]:
                    return False
                else:
                    col[j][val] = (i, j)
                
                if val in square[i//3][j//3]:
                    return False
                else:
                    square[i//3][j//3][val] = (i, j)
        return True
            