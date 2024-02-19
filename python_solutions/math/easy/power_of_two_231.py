class Solution:
    def isPowerOfTwo(self, n: int) -> bool:
        return n > 0 and (n & (n - 1)) == 0

    def isPowerOfTwoDevision(self, n: int) -> bool:
        if n <= 0:
            return False
        while n > 1:
            if n % 2 != 0:
                return False
            n = n // 2
        return True

    def isPowerOfTwoBruteForce(self, n: int) -> bool:
        if n == 1:
            return True
        elif n == 0:
            return False
        num = 2
        while True:
            if num == n:
                return True
            if num > n:
                return False
            num = num * 2
