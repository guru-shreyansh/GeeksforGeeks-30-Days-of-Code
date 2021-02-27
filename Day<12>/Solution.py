class Solution:
    def sumBitDiff(self, arr, n): 
        ans = 0  # Initialize result 
      
        # traverse over all bits 
        for i in range(0, 32): 
          
            # count number of elements with i'th bit set 
            count = 0
            for j in range(0,n): 
                if ( (arr[j] & (1 << i)) ): 
                    count+=1
      
            # Add "count * (n - count) * 2" to the answer 
            ans += (count * (n - count) * 2); 
          
        return ans
#{ 
#  Driver Code Starts
#Initial Template for Python 3

if __name__=="__main__":
    t=int(input())
    for _ in range(t):
        n=int(input())
        arr=[int(x) for x in input().strip().split()]
        obj = Solution();
        print(obj.sumBitDiff(arr,n))
