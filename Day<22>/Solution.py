'''
    root: current node
    lvl: depth of current node
    lin: inorder traversal of tree
    llv: stores levels of the nodes
'''

class Solution:
    def storein(self, root, lvl, lin, llv):
        if not root:
            return
        # recur for left subtree
        self.storein(root.left,lvl+1,lin,llv)
        # store inorder
        lin.append(root.data)
        llv.append(lvl)
        self.storein(root.right,lvl+1,lin,llv)
    
    def shortestRange(self, root):
        #  inOrder: stores inorder traversal of the bst
        #  level: stores level of ith node in inorder traversal
        inorder=[]
        level=[]
        self.storein(root,0,inorder,level)
        '''
            cntZero: counts number of zeros
            i: left pointer (initially at 0)
            j: right pointer
            k: index of root in inorder traversal 
            maxDepth: maximum depth of bst
            Note: these pointers are on the inorder traversal of the tree
        '''
        i=j=k=cntzero=0
        maxDepth=max(level)+1
        #  stores number of nodes at ith level
        depth=[0]*maxDepth
        # first count number of nodes at ith level till the root 
        # right pointer initially is at root's index in inorder traversal of bst
        for k in range(len(level)):
            depth[level[k]]+=1
            if level[k]==0:
                j=k
                break
        #  count number of levels where there are 0 nodes in the range inorder[i] to inorder[j]
        cntzero=depth.count(0)
        #  intially shortest range is [x, y]
        #  x=node at 0th index
        #  y=node at last index
        #  i.e. the whole tree
        x,y=inorder[0],inorder[-1]
        # if currently picked range contains all levels change x and y accordingly
        if cntzero==0:
            x,y=inorder[i],inorder[j]

        # left pointer can at most go upto root's index(i.e. k)
        # right pointer can go upto last index of inorder traversal of tree
        while i<=k and j<len(inorder):
            #  while right pointer doesn't reach last index
            #  and the current range doesn't contain all levels
            while j<len(inorder):
                #  if cntZero is 0 then this range contains all levels
                if cntzero==0:
                    #  if previous range is large then change the range
                    if (y-x) > (inorder[j]-inorder[i]):
                        x,y=inorder[i],inorder[j]
                    break
                j+=1

                if len(inorder) <= j:
                    break
                #  if new level is discovered by this range then cntZero is decreased by 1
                if depth[level[j]]==0:
                    cntzero-=1
                depth[level[j]]+=1
            #  while current range contains all levels we can shift the left pointer by +1
            while not cntzero and i<=k:
                if (y-x)>(inorder[j]-inorder[i]):
                    x,y=inorder[i],inorder[j]
                depth[level[i]]-=1
                #  if this level is outside the current range then cntZero is increased by 1
                if depth[level[i]]==0:
                    cntzero+=1
                i+=1
        return (x,y)

# Tree Node
class Node:
    def __init__(self, val):
        self.right = None
        self.data = val
        self.left = None


# Function to Build Tree
def buildTree(s):
    # Corner Case
    if (len(s) == 0 or s[0] == "N"):
        return None

    # Creating list of strings from input string after spliting by space
    ip = list(map(str, s.split()))

    # Create the root of the tree
    root = Node(int(ip[0]))
    size = 0
    q = deque()

    # Push the root to the queue
    q.append(root)
    size = size + 1

    # Starting from the second element
    i = 1
    while (0 < size and i < len(ip)):
        # Get and remove the front of the queue
        currNode = q[0]
        q.popleft()
        size = size - 1

        # Get the current node's value from the string
        currVal = ip[i]

        # If the left child is not null
        if (currVal != "N"):
            # Create the left child for the current node
            currNode.left = Node(int(currVal))

            # Push it to the queue
            q.append(currNode.left)
            size = size + 1
        # For the right child
        i = i + 1
        if (len(ip) <= i):
            break
        currVal = ip[i]

        # If the right child is not null
        if (currVal != "N"):
            # Create the right child for the current node
            currNode.right = Node(int(currVal))

            # Push it to the queue
            q.append(currNode.right)
            size = size + 1
        i = i + 1
    return root


if __name__ == "__main__":
    from collections import deque
    t = int(input())
    for _ in range(t):
        s = input()
        root = buildTree(s)
        obj = Solution()
        ans = obj.shortestRange(root)
        print(ans[0],ans[1])
