class Solution:
    def prank(self, a, n):
        for i in range(n):
            a[i] = a[i] + (a[a[i]]%n) * n

        for i in range(n):
            a[i] = a[i]//n

if __name__ == '__main__':
    t = int(input())
    for _ in range(t):
        n = int(input())
        a = list(map(int, input().strip().split()))
        ob = Solution()
        ob.prank(a, n)
        for i in a:
            print(i, end=" ")
        print()
