class Solution:
    def findK(self, a, n, m, k):
        top = 0
        left = 0
        right = m-1;
        bottom = n-1;
        dir =0;
        count=0;
        while(top<=bottom and left<=right):
            if(dir==0):
                for i in range(left, right+1):
                    k -= 1
                    if k == 0:
                        return (a[top][i])
                top += 1
                dir=1
                    
            if(dir==1):
                for i in range(top, bottom+1):
                    k -= 1
                    if k == 0:
                        return (a[i][right])
                right -= 1
                dir=2
            if(dir==2):
                for i in range(right, left - 1, -1):
                    k -= 1
                    if k == 0:
                        return (a[bottom][i])
                bottom -= 1
                dir=3
            if(dir==3):
                for i in range(bottom, top - 1, -1):
                    k -= 1
                    if k == 0:
                        return (a[i][left])
                left += 1
                dir=0
if __name__=='__main__':
    t = int(input())
    for i in range(t):
        n = list(map(int, input().strip().split()))
        arr = list(map(int, input().strip().split()))
        matrix = [[0 for i in range(n[1])]for j in range(n[0])]
        c=0
        for i in range(n[0]):
            for j in range(n[1]):
                matrix[i][j] = arr[c]
                c+=1
        obj = Solution()
        print(obj.findK(matrix, n[0], n[1], n[2]))
