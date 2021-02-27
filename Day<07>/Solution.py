from bisect import bisect_left as lower_bound 
class Solution:
    def ValidPair(self, a, n): 
    	a = sorted(a) 
    	ans = 0
    	for i in range(n): 
    		if (a[i] <= 0): 
    			continue
    		# search for first element >= (-a[i] + 1)
    		j = lower_bound(a,-a[i] + 1) 
    		ans += i - j 
    	return ans

#{ 
#Driver Code Starts.

if __name__ == '__main__': 
	t = int(input())
	for _ in range(t):
		n = int(input())
		array = list(map(int, input().strip().split()))
		obj = Solution()
		ans = obj.ValidPair(array, n)
		print(ans)
