package golang_solutions

/*
impl Solution {
    pub fn num_subarrays_with_sum(nums: Vec<i32>, goal: i32) -> i32 {
        let (mut sum, mut result) = (0, 0);
        let mut counter = vec![0i32; nums.len() + 1];

        counter[0] = 1;

        for num in nums.iter() {
            sum += *num;

            if sum >= goal {
                result += counter[(sum-goal) as usize];
            }
            counter[sum as usize] += 1;
        }
        result
    }
}

impl Solution {
    pub fn num_subarrays_with_sum(nums: Vec<i32>, goal: i32) -> i32 {
        Solution::sliding_window(&nums, goal) - Solution::sliding_window(&nums, goal - 1)
    }

    fn sliding_window(nums: &Vec<i32>, goal: i32) -> i32 {
        let (mut left, mut right, mut sum, mut counter) = (0usize, 0usize, 0i32, 0i32);

        while right < nums.len() {
            sum += nums[right];

            while left <= right && sum > goal {
                sum -= nums[left];
                left += 1;
            }
            counter += (right - left + 1) as i32;
            right += 1;
        }
        counter
    }
}
*/

func numSubarraysWithSumSlidingBetter(nums []int, goal int) (counter int) {
	return slidingWindow(nums, goal) - slidingWindow(nums, goal-1)
}

func slidingWindow(nums []int, goal int) (counter int) {
	left, sum := 0, 0

	for right := 0; right < len(nums); right++ {
		sum += nums[right]

		for left <= right && sum > goal {
			sum -= nums[left]
			left++
		}
		counter += right - left + 1
	}
	return
}

func numSubarraysWithSum(nums []int, goal int) (counter int) {
	right := 1

	for right <= len(nums) {
		for i := 0; i+right <= len(nums); i++ {
			tempSum := 0
			tempNums := nums[i : i+right]
			for _, v := range tempNums {
				tempSum += v
			}
			if tempSum == goal {
				counter++
			}
		}
		right++
	}
	return
}

func numSubarraysWithSumBetter(nums []int, goal int) int {
	sum, result := 0, 0
	counter := make([]int, len(nums)+1)
	counter[0] = 1

	for _, v := range nums {
		sum += v

		if sum >= goal {
			result += counter[sum-goal]
		}
		counter[sum]++
	}
	return result
}
