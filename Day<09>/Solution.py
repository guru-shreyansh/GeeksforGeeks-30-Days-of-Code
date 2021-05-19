class Solution:
    def transfigure(self, A, B):
        m = len(A)
        n = len(B)

        # Check whether conversion is possible or not
        if n != m:
            return -1

        count = {}
        keys = count.keys()

        # count characters in A
        for i in A:
            if i in keys:
                count[i] += 1
            else:
                count[i] = 1

        # subtract count for every char in B
        for i in B:
            if i in keys:
                count[i] -= 1
            else:
                count[i] = 1

        # Check if all counts become 0
        for i in keys:
            if count[i]:
                return -1

        # Calculate the number of operations required
        res = 0
        i = n-1
        j = n-1
        while i >= 0:
            # if there is a mismatch, then keep incrementing
            # result 'res' until B[j] is not found in A[0..i]
            while i>= 0 and A[i] != B[j]:
                i -= 1
                res += 1

            # if A[i] and B[j] match
            if i >= 0:
                i -= 1
                j -= 1

        return res
