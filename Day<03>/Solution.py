class Solution:
    def smallestpositive(self, array, n):
        array.sort()
        result = 1
        for i in range(n):
            if(array[i] <= result):
                result = result + array[i]
        return result

if __name__ == '__main__':
    t = int(input())
    for _ in range(t):
        n = int(input())
        array = list(map(int, input().strip().split()))
        ob = Solution()
        print(ob.smallestpositive(array,n))
