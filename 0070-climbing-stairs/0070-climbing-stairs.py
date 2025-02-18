class Solution:
    def climbStairs(self, n: int) -> int:
        if n == 1:
            return 1
        if n == 2:
            return 2

        prev_1 = 1
        prev_2 = 2

        # 1,2 -> 3, (2,3) -> 5, (3,5) -> 8
        temp = 0
        for i in range(3, n+1):
            temp = prev_1 + prev_2
            prev_1 = prev_2
            prev_2 = temp

        return temp