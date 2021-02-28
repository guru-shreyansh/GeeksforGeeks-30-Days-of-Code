class Solution:
    def build_bridges_util(self,str1, str2, i, j, dp):
        if i >= len(str1) or j >= len(str2):
            return 0
    
        if dp[i][j] != -1:
            return dp[i][j]
    
    
        if str1[i] == str2[j]:
            dp[i][j] = 1 + self.build_bridges_util(str1, str2, i + 1, j + 1, dp)
            return dp[i][j]
    
        dp[i][j] = max(self.build_bridges_util(str1, str2, i + 1, j, dp), self.build_bridges_util(str1, str2, i, j + 1, dp))
        
    
        return dp[i][j]
    
    
    def build_bridges(self, str1, str2):
        n1, n2 = len(str1), len(str2)
        dp = [[-1 for i in range(n2 + 1)] for j in range(n1 + 1)]
    
        return self.build_bridges_util(str1, str2, 0, 0,dp)


#{ 
#  Driver Code Starts
if __name__ == '__main__':
    T = int(input())
    for _ in range(T):
        obj = Solution()
        str1, str2 = input().split()
        print(obj.build_bridges(str1, str2))
