from collections import deque

class Solution:
    def help_classmate(self, arr, n):
        stack = deque()
        ret = [-1 for _ in range(n)]
        
        for i in range(n):
            while len(stack) and arr[i] < arr[stack[-1]]:
                ret[ stack.pop() ] = arr[i]
            stack.append(i)
        
        return ret

if __name__=="__main__":
    for _ in range(int(input())):
        n = int(input())
        arr = [ int(x) for x in input().split() ]
        obj = Solution()
        result = obj.help_classmate(arr,n)
        for i in result:
            print(i,end=' ')
        print()
