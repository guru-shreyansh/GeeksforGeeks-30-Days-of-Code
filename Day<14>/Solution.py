class Solution:

    def digitSum(self, n):
    	sum = 0
    	while (n):
    		sum += (n % 10)
    		n //= 10
    	return sum
	
    def RulingPair(self, arr, n):
    	map = dict()
    	ans = -1
    	for i in range(n):
    		dSum = self.digitSum(arr[i])

    		if (dSum in map):
    			ans = max(ans, map[dSum] + arr[i])
    		map[dSum] = max(map.get(dSum, 0) , arr[i])
    	return ans

if __name__ == '__main__':
    t = int(input())
    for _ in range(t):
        n = int(input())
        arr = list(map(int, input().strip().split()))
        obj = Solution();
        print(obj.RulingPair(arr,n))
