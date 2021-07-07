class Solution:
    def candies(self, m, n):
    	i = 0
    	X = (m * n) - m - n

    	queue = []
    	queue.append(X)
    	set = {X}

    	count = 0
    	while (len(queue) > 0):
    		curr = queue[0] 
    		queue.remove(queue[0])

    		count += 1
    		key = curr-m
    		if (key > 0 and key not in set):
    			queue.append(key)
    			set.add(key)

    		key = curr-n
    		if (key > 0 and key not in set):
    			queue.append(key)
    			set.add(key)
    	return count

if __name__ == '__main__':
    t = int(input())
    for _ in range(t):
    	arr = list(map(int, input().strip().split()))
    	m = arr[0]
    	n = arr[1]
    	obj = Solution()
    	print(obj.candies(m,n))
