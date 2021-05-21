class Solution:
    def repeatedStringMatch(self, A,B):
        S=A
        ret=1
        
        while len(S)<len(B):
            S+=A
            ret+=1
        
        if B in S:
            return ret

        if B in S+A:
            return ret+1
        return -1

if __name__=="__main__":
    t=int(input())
    for _ in range(t):
        A=input().strip()
        B=input().strip()
        obj = Solution()
        print(obj.repeatedStringMatch(A,B))
