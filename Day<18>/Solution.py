from math import inf

class Solution:
	def recreationalSpot(self, arr, n):
	    l=[]

	    if len(arr)<=2:
	        return False
	    if len(arr)==3:
	        if arr[0]<arr[2]<arr[1]:
	            return True
	        else:
	            return False

	    if arr[0] < arr[2] < arr[1]:
	        return True
	    
	    temp=[inf]*n
	    
	    temp[0]=arr[0]
	    
	    for i in range(n):
	        temp[i]=min(temp[i-1],arr[i])
	        
	    for j in range(n-1,-1,-1):
	        if arr[j]>temp[j]:
	            while l and l[-1]<=temp[j]:
	                l.pop()
	            
	            if l and l[-1]<arr[j]:
	                return True
	            l.append(arr[j])
	    return False

#{ 
#  Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':
    tcs=int(input())
    for _ in range(tcs):
        n=int(input())
        arr=[int(x) for x in input().split()]
        ob = Solution()
        if ob.recreationalSpot(arr,n):
        	print("True")
        else:
        	print("False")
