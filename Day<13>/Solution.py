class Solution:
    def checktree(self, preorder, inorder, postorder, N):
	
    	# if the array lengths are 0, then all of them are obviously equal
    	if N == 0:
    	    return 1
    	
    	# if array lengths are 1, then check if all of them are equal
    	if N == 1:
    	    return (preorder[0] == inorder[0]) and (inorder[0] == postorder[0]);

    	# search for first element of preorder in inorder array
    	idx = -1;
    	
    	for i in range(N):
    	    if inorder[i] == preorder[0]:
    		idx = i
    		break
    	
    	if idx == -1:
    	    return 0;
    	
    	# matching element in postorder array
    	if preorder[0] != postorder[N-1]:
    	    return 0;
    	
    	# check for the left subtree
    	ret1 = self.checktree(preorder[1:], inorder, postorder, idx);
    	
    	# check for the right subtree
    	ret2 = self.checktree(preorder[idx + 1:], inorder[idx + 1:], postorder[idx:], N-idx-1);
    	
    	# return 1 only if both of them are correct else 0
    	return (ret1 and ret2)

class Solution:
    def checktree(self, preorder, inorder, postorder, N):
	
    	# if the array lengths are 0, then all of them are obviously equal
    	if N == 0:
    	    return 1

    	# if array lengths are 1, then check if all of them are equal
    	if N == 1:
    	    return (preorder[0] == inorder[0]) and (inorder[0] == postorder[0]);

    	# search for first element of preorder in inorder array
    	idx = -1;
    	
    	for i in range(N):
    	    if inorder[i] == preorder[0]:
    		idx = i
    		break
    	
    	if idx == -1:
    	    return 0;
    	
    	# matching element in postorder array
    	if preorder[0] != postorder[N-1]:
    	    return 0;
    	
    	# check for the left subtree
    	ret1 = self.checktree(preorder[1:], inorder, postorder, idx);
    	
    	# check for the right subtree
    	ret2 = self.checktree(preorder[idx + 1:], inorder[idx + 1:], postorder[idx:], N-idx-1);
    	
    	# return 1 only if both of them are correct else 0
    	return (ret1 and ret2)
