class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        num_to_index_map = {}

        for i, num in enumerate(nums):
            complement = target - num
            if complement in num_to_index_map:
                return [num_to_index_map[complement], i]
            num_to_index_map[num] = i
        return []
        
        