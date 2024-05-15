class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        for idx in range(len(nums)):
            for index in range(idx+1, len(nums)):
                if(nums[idx]+nums[index] == target):
                    return [idx, index]