package leetcode.array.easy.java_solutions;

/*
use std::collections::HashSet;

pub fn intersection(nums1: Vec<i32>, nums2: Vec<i32>) -> Vec<i32> {
    let mut intersect = vec![0i32; 1001];
    let mut result = Vec::new();

    for num in nums1.iter() {
        let nums_usize = *num as usize;
        if intersect[nums_usize] == 0 {
            intersect[nums_usize] = 1;
        }
    }
    for num in nums2.iter() {
        let num_usize = *num as usize;
        if intersect[num_usize] == 1 {
            result.push(*num);
            intersect[num_usize] -= 1;
        }
    }
    result
}

pub fn intersection_hash_set(nums1: Vec<i32>, nums2: Vec<i32>) -> Vec<i32> {
    let mut set = HashSet::new();
    let mut result = Vec::new();
    for num in nums1.iter() {
        set.insert(num);
    }
    for num in nums2.iter() {
        if set.contains(num) {
            result.push(*num);
            set.remove(num);
        }
    }
    result
}

 */

public class IntersectionTwoArrays_349 {
}
