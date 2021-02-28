class Solution:
    def z_function(self, s):
        n = len(s)
    
        z = [0] * n
    
        l = r = 0
        for i in range(1, n):
            if i <= r:
                z[i] = min(r - i + 1, z[i - l])
    
            while i + z[i] < n and s[z[i]] == s[i + z[i]]:
                z[i] += 1
    
            if i + z[i] - 1 > r:
                l = i
                r = i + z[i] - 1
    
        return z
    
    
    def update(self, idx, val, bit, n):
        if idx == 0:
            return
        while idx <= n:
            bit[idx] += val
            idx += (idx & - idx)
    
    
    def pref(self, idx, bit):
        ans = 0
        while idx > 0:
            ans += bit[idx]
            idx -= (idx & - idx)
    
        return ans
    
    
    def maxFrequency(self, s):
        n = len(s)
        z = self.z_function(s)
    
        bit = [0] * (n + 5)
    
        for i in range(1, n):
            self.update(z[i], 1, bit, n)
    
        m = defaultdict(int)
    
        for i in range(n - 1, 0, -1):
            if z[i] != n - i:
                continue
    
            m[z[i]] += ((self.pref(n, bit)) - self.pref(z[i] - 1, bit) + 1)
    
        ans = 1
        for val in m.values():
            ans = max(ans, val)
    
        return ans
#{ 
#  Driver Code Starts
#Initial Template for Python 3

from collections import defaultdict

if __name__ == '__main__':
    T = int(input())

    for _ in range(T):
        Str = input()
        obj = Solution()

        print(obj.maxFrequency(Str))
