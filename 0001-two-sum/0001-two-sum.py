class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        for idx, val in enumerate(nums):
            for index, value in enumerate(nums[idx+1:], idx+1):
                if(val + value == target):
                    return [idx, index]