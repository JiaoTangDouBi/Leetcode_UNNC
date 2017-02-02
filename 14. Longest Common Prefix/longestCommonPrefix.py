class Solution(object):
    def longestCommonPrefix(self, strs):
        """
        :type strs: List[str]
        :rtype: str
        """
        if len(strs) == 0:
            return ""
            
        output = ""
        min_len = min([len(x) for x in strs])
        for i in range(min_len):
            j = 1
            while j < len(strs) and strs[0][i] == strs[j][i]:
                j += 1
            if j < len(strs):
                break
            else:
                output += strs[0][i]
        return output