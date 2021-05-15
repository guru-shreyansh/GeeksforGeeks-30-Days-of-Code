class Solution:
    def Maximum_Sum(self, mat, N, K):
        sum_matrix = [[0 for _ in range(N) ] for _ in range(N)]

        for r in range(N):
            for c in range(N):
                sum_matrix[r][c] = mat[r][c]
                
                if r>0:
                    sum_matrix[r][c] += sum_matrix[r-1][c]
                
                if c>0:
                    sum_matrix[r][c] += sum_matrix[r][c-1]
                
                if r>0 and c>0:
                    sum_matrix[r][c] -= sum_matrix[r-1][c-1]
        
        ret=0
        for r in range(K-1,N):
            for c in range(K-1,N):
                value = sum_matrix[r][c]
                
                if r>K-1:
                    value -= sum_matrix[r-K][c]
                
                if c>K-1:
                    value -= sum_matrix[r][c-K]
                
                if r>K-1 and c>K-1:
                    value += sum_matrix[r-K][c-K]
                
                ret = max(ret,value)
        
        return ret
