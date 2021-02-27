'''
# node class:

class Node:
    def __init__(self, val):
        self.right = None
        self.data = val
        self.left = None

'''
class Solution:
    def add_subtree(self, n, dist):
        if n is None or dist<0:
            return 0
        return n.data + self.add_subtree(n.left,dist-1) + self.add_subtree(n.right,dist-1)
    
    def traverse(self, n ,target, k):
        if n is None:
            return (0,-1)
        if n.data==target:
            return (self.add_subtree(n,k), k-1)
            # adding all nodes within range in the sub tree below
            # and returning sum
        
        Sum,dist = self.traverse(n.left, target, k)
        if Sum>0:
            # Sum>0 indicates target was found in left subtree
            if dist==-1:
                return (Sum,dist)
            return ( Sum+n.data + self.add_subtree(n.right,dist-1) , dist-1 )
            # adding values from right sub tree
        
        Sum,dist = self.traverse(n.right, target, k)
        if Sum>0:
            # Sum>0 indicates target was found in right subtree
            if dist==-1:
                return (Sum,dist)
            return ( Sum+n.data + self.add_subtree(n.left,dist-1) , dist-1 )
            # adding values from left sub tree
        
        return (0,-1)
    
    def sum_at_distK(self, root, target, k):
        Sum,dist = self.traverse(root, target, k)
        return Sum


#{ 
#  Driver Code Starts
#driver code:
from collections import deque

# Tree Node
class Node:
    def __init__(self, val):
        self.right = None
        self.data = val
        self.left = None

# Function to Build Tree   
def buildTree(s):
    #Corner Case
    if(len(s)==0 or s[0]=="N"):           
        return None
        
    # Creating list of strings from input 
    # string after spliting by space
    ip=list(map(str,s.split()))
    
    # Create the root of the tree
    root=Node(int(ip[0]))                     
    size=0
    q=deque()
    
    # Push the root to the queue
    q.append(root)                            
    size=size+1 
    
    # Starting from the second element
    i=1                                       
    while(size>0 and i<len(ip)):
        # Get and remove the front of the queue
        currNode=q[0]
        q.popleft()
        size=size-1
        
        # Get the current node's value from the string
        currVal=ip[i]
        
        # If the left child is not null
        if(currVal!="N"):
            
            # Create the left child for the current node
            currNode.left=Node(int(currVal))
            
            # Push it to the queue
            q.append(currNode.left)
            size=size+1
        # For the right child
        i=i+1
        if(i>=len(ip)):
            break
        currVal=ip[i]
        
        # If the right child is not null
        if(currVal!="N"):
            
            # Create the right child for the current node
            currNode.right=Node(int(currVal))
            
            # Push it to the queue
            q.append(currNode.right)
            size=size+1
        i=i+1
    return root

if __name__ == '__main__':
    t=int(input())
    for _ in range(t):
        line=input()
        root=buildTree(line)
        line=input().strip().split()
        target=int(line[0])
        k=int(line[1])
        obj = Solution();
        print(obj.sum_at_distK(root,target,k))
