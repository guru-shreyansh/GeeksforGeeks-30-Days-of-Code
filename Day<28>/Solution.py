class Solution:
    def min_sprinklers(self, gallery, n):
        # code here
        sprinklers = []
        for i in range(n):
            if gallery[i]>-1:
                sprinklers.append( [i-gallery[i] , i+gallery[i]] );
        sprinklers.sort()
        target=0
        sprinklers_on=0
        i=0
        while(target<n):
            if i==len(sprinklers) or sprinklers[i][0]>target:
                return -1
            max_range = sprinklers[i][1]
            while( i+1<len(sprinklers) and sprinklers[i+1][0]<=target ):
                i+=1
                max_range = max(max_range,sprinklers[i][1])
            if max_range<target:
                return -1
            sprinklers_on+=1
            target=max_range+1
            i+=1
        return sprinklers_on


#{ 
#  Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':
    t = int(input())
    for _ in range(t):
        n = int(input())
        gallery = [int(x) for x in input().strip().split()]
        obj = Solution()
        print(obj.min_sprinklers(gallery,n))
