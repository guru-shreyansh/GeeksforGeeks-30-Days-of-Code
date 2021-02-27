from collections import deque 

def countPairs(head,x):
    if head==None or head.nxt==None or x<2:
        return 0
    dq = deque()
    walk = head
    while walk:
        dq.append(walk.val)
        walk=walk.nxt
    
    ret=0
    l=dq.popleft()
    r=dq.pop()
    while(1):
        if l+r==x:
            ret+=1
        if len(dq)==0:
            return ret
        if l+r>x:
            l=dq.popleft()
        else:
            r=dq.pop()

def countTriplets(head,x):
    ret = 0
    while head != None:
        ret += countPairs(head.nxt, x-head.val)
        head = head.nxt
    return ret

#{ 
#  Driver Code Starts
#Initial Template for Python 3

class Node:
    def __init__(self,x):
        self.val=x
        self.nxt=None

if __name__ == '__main__':
    t=int(input())
    for _ in range(t):
        line = input().strip().split()
        n = int(line[0])
        x = int(line[1])
        line = input().strip().split()
        
        head = Node(int(line[0]))
        tail = head
        for i in range(1,n):
            tail.nxt = Node(int(line[i]))
            tail = tail.nxt
        
        print(countTriplets(head,x))
