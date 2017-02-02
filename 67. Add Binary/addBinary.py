class Solution(object):
    def addBinary(self, a, b):
        """
        :type a: str
        :type b: str
        :rtype: str
        """
        output = ""
        carry = 0
        ptr_a = len(a) - 1
        ptr_b = len(b) - 1
        
        while ptr_a >= 0 or ptr_b >= 0 or carry == 1:
            val_a = int(a[ptr_a]) if ptr_a >= 0 else 0
            val_b = int(b[ptr_b]) if ptr_b >= 0 else 0
            (carry, val) = divmod(val_a + val_b + carry, 2)
            output = str(val) + output
            ptr_a -= 1
            ptr_b -= 1
        
        return output
        