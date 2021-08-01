class Solution:
    def catchThieves(self, arr, n, k):
    	i = 0
    	l = 0
    	r = 0
    	result = 0
    	thief = []
    	police = []

    	while i < n:
    		if arr[i] == 'P':
    			police.append(i)
    		elif arr[i] == 'T':
    			thief.append(i)
    		i += 1

    	# track lowest current indices of thief: thief[l], police: police[r]
    	while l < len(thief) and r < len(police):
    		
    		# can be caught
    		if (abs( thief[l] - police[r] ) <= k):
    			result += 1
    			l += 1
    			r += 1
    		
    		# increment the minimum index
    		elif thief[l] < police[r]:
    			l += 1
    		else:
    			r += 1
    	return result

if __name__=='__main__':
	t = int(input())
	for _ in range(t):
		line1 = list(map(int, input().strip().split()))
		n = line1[0]
		k = line1[1]
		arr = list(input().strip().split())
		obj = Solution()
		print(obj.catchThieves(arr, n, k))
