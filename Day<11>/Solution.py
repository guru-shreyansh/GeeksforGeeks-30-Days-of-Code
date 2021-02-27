class Solution:
    def fillarray(self, s, a):
        a[0]=0
        for i in range(1,len(s)):
            series=a[i-1]
            while(series):
                if(s[series]==s[i]):
                    a[i]=series+1
                    break
                series=a[series-1]
            if(series==0):
                a[i]=(int(s[i]==s[0]))
        return a
        
    def compress(self, s):
        a=[0]*len(s)
        
        #  ith element of array a stores the length of longest
        #  proper suffix which is also a proper prefix
        #  for substr s[0] to s[i]
        a = self.fillarray(s, a)
        #print(a)
        shortened=[]
        n=len(s)
        i=n-1
        
        #  for even index, string length is odd
        #  hence it cannot be divided into two
        #  so we simply push ith character in stack
        while(i>0):
            if(i%2==0):
                shortened.append(s[i])
                i=i-1
                continue
            
            # star_here will be made TRUE if substring s[0] to s[i]
            # can be divided into identical halves
            star_here=False
            
            #  suffix and substring length are also meant for
            #  substring s[0] to s[i]
            suffix=a[i]
            substrlen=i+1
            
            #  these conditions, if true, imply that, substring
            #  can be divided into 2 identical halves
            if(suffix*2>=substrlen):
                if(substrlen%(substrlen-suffix)==0):
                    if((substrlen/(substrlen-suffix))%2==0):
                        star_here=True
                        
            
            #  adding * to stack and moving index as required
            if(star_here==True):
                shortened.append('*')
                i=(i//2)+1
                
            #  else, simply adding character to stack
            else:
                shortened.append(s[i])
            i=i-1
        ret=""
        ret=ret+s[0]
        n=len(shortened)
        
        #  since we analysed input string from end to start
        #  removing elements from stack and pushing back to
        #  output string will reverse them back to required order
        while(n):
            ret=ret+shortened[n-1]
            shortened.pop()
            n=n-1
        return ret

#{ 
#  Driver Code Starts
#Initial Template for Python 3


t=int(input())    
for _ in range(0,t):
    s=input()
    obj = Solution();
    ans=obj.compress(s)
    print(ans)
