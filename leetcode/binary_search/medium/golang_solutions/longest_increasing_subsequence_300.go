package golang_solutions

/*
Rust code

impl Solution {
    pub fn length_of_lis(nums: Vec<i32>) -> i32 {
        if nums.is_empty() {
            return 0;
        }
        let mut list = vec![nums[0]];
        let mut index = 1;

        for &num in &nums[1..] {
            index = Self::binary_search(&list, 0, list.len(), num);
            if index == list.len() {
                list.push(num);
            } else {
                list[index] = num;
            }
        }
        list.len() as i32
    }

    fn binary_search(list: &[i32], mut left: usize, mut right: usize, target: i32) -> usize {
        while left < right {
            let mid = (left + right) / 2;
            if list[mid] == target {
                return mid;
            }
            if list[mid] > target {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        left
    }
}
*/

func lengthOfLIS(nums []int) int {
	list := []int{nums[0]}
	index := 1
	for i := 1; i < len(nums); i++ {
		index = binarySearch(list, 0, len(list), nums[i])
		if index == len(list) {
			list = append(list, nums[i])
		} else {
			list[index] = nums[i]
		}
	}
	return len(list)
}

func binarySearch(list []int, left, right, target int) int {
	for left < right {
		mid := (left + right) / 2
		if list[mid] == target {
			return mid
		}
		if list[mid] > target {
			right = mid
		} else {
			left = mid + 1
		}
	}
	return left
}
