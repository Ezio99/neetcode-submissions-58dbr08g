# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        queue = deque()
        ans=[]

        if(root==None):
            return []

        queue.append(root)

        while len(queue)>0:
            currAns=[]
            n=len(queue)
            for i in range(0,n):
                curr = queue.popleft()
                currAns.append(curr.val)
                if curr.left!=None:
                    queue.append(curr.left)
                if curr.right!=None:
                    queue.append(curr.right)
            
            ans.append(currAns)
        
        return ans
