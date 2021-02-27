# function to change 'N' from base10 to base9
class Solution:
    def findNth(self, N):
        # taking remainders by 9
        # dividing 'N' by 9 till N become 0
        s = ""
        while (N):
            s = str(N%9) + s
            N = N//9
        return int(s)

t = int(input())
for i in range(0,t):
    n = int(input())
    obj = Solution()
    s = obj.findNth(n)
    print(s)
