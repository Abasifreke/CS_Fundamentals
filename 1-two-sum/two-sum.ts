function twoSum(nums: number[], target: number): number[] {
    const diff = {};
    for (let i = 0; i < nums.length; i++) {
        if (diff[target - nums[i]] != null && diff[target - nums[i]] !== i) {
            return [diff[target - nums[i]], i];
        }
        diff[nums[i]] = i;
    }

    return [-1, -1];
};