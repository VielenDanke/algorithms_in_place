package golang_solutions

/*
impl Solution {

    pub fn num_rolls_to_target(n: i32, k: i32, target: i32) -> i32 {
        let modifier: i32 = 10_0000_0007;
        let mut cache = vec![vec![-1; (target + 1) as usize]; (n + 1) as usize];
        Self::memo(n, k, target, modifier, &mut cache)
    }

    fn memo(n: i32, k: i32, target: i32, modifier: i32, cache: &mut Vec<Vec<i32>>) -> i32 {
        if n == 0 && target == 0 {
            return 1;
        }
        if n == 0 || target == 0 {
            return 0;
        }
        if cache[n as usize][target as usize] >= 0 {
            return cache[n as usize][target as usize];
        }
        let mut total_sum = 0;
        for i in 1..=k {
            if target - i < 0 {
                break;
            }
            total_sum = (total_sum + Self::memo(n - 1, k, target - i, modifier, cache)) % modifier;
        }
        cache[n as usize][target as usize] = total_sum % modifier;
        cache[n as usize][target as usize]
    }
}
*/

func numRollsToTarget(n, k, target int) int {
	cache := make([][]int, n+1)
	for i := range cache {
		cache[i] = make([]int, target+1)
		for j := range cache[i] {
			cache[i][j] = -1
		}
	}
	return memo(n, k, target, cache)
}

func memo(n, k, target int, cache [][]int) int {
	if n == 0 && target == 0 {
		return 1
	}
	if n == 0 || target == 0 {
		return 0
	}
	if cache[n][target] >= 0 {
		return cache[n][target]
	}
	var totalSum int
	for i := 1; i <= k; i++ {
		if target-i < 0 {
			break
		}
		totalSum = (totalSum + memo(n-1, k, target-i, nil)) % mod
	}
	cache[n][target] = totalSum % mod
	return cache[n][target]
}
