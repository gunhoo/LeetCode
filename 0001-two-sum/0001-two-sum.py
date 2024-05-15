class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        answer = []
        for idx, val in enumerate(nums):
            for index, value in enumerate(nums[idx+1:], idx+1):
                if(val + value == target):
                    answer.append(idx)
                    answer.append(index)
                    return answer