import heapq

 # } Driver Code Ends
#User function Template for python3

class Solution:
    def Kclosest(self, arr, n, x, k):
        max_heap = [ ( -1*abs(x-arr[i]) , -1*arr[i] ) for i in range(k) ]
        heapq.heapify(max_heap)
        # python heapq generates min heap
        # it can be used as max_heap by multiplying elements by -1
        
        for i in range(k,n):
            dist = -1*max_heap[0][0]
            hno  = -1*max_heap[0][1]
            if abs(arr[i]-x)<dist or ( abs(arr[i]-x)==dist and arr[i]<hno ):
                heapq.heappop(max_heap)
                heapq.heappush( max_heap, ( -1*abs(x-arr[i]) , -1*arr[i] ) )
        
        ret=[ -1*x[1] for x in max_heap]
        ret.sort()
        return ret


#{ 
#Driver Code Starts.
if __name__=="__main__":
    t=int(input())
    for _ in range(t):
        line=input().strip().split()
        n=int( line[0] )
        x=int( line[1] )
        k=int( line[2] )
        arr=[int(x) for x in input().strip().split()]
        obj = Solution()
        result=obj.Kclosest(arr, n, x, k)
        for i in result:
            print(i, end=' ')
        print()
