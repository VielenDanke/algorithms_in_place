# Dynamic approach

def max_subset_sum_non_adjacent(array):
    # Write your code here.
    if not len(array):
        return 0
    elif len(array) == 1:
        return array[0]
    max_sums = array[:]
    max_sums[1] = max(array[0], array[1])
    for i in range(2, len(array)):
        max_sums[i] = max(max_sums[i-1], max_sums[i-2] + array[i])
    return max_sums[-1]

# --------------------------------------------------------------------
# Backtracking approach using list


def max_subset_sum_non_adjacent_backtrack(array):
    if len(array) == 0:
        return 0
    lis = []
    for i in range(len(array)):
        backtrack(array, lis, i, 0)
    return max(lis)


def backtrack(array, result, start, common_sum):
    for i in range(start, len(array)):
        backtrack(array, result, i + 2, common_sum + array[i])
    result.append(common_sum)


# -------------------------------------------------------------------
# Backtracking without global

def max_subset_sum_non_adjacent_backtrack_without_global(array):
    if len(array) == 0:
        return 0
    max_sum = 0
    for i in range(len(array)):
        temp_sum = backtrack_without_global(array, i)
        if max_sum < temp_sum:
            max_sum = temp_sum
    return max_sum


def backtrack_without_global(array, start):
    if start >= len(array):
        return 0
    max_sum = 0
    for i in range(start, len(array)):
        max_sum = max(max_sum, backtrack_without_global(array, i + 2) + array[i])
    return max_sum

