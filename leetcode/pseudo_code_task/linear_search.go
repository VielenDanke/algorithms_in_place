package pseudo_code_task

/*
Linear-Search(A, V)
	for i = 0 to A.length
		if A[i] == V
			return i
	return NIL

1. Initialization
For first iteration we are comparing A[0] with V and if it is equal - return i
2. Saving
For each next iteration we are comparing A[i] with V and if it is equal - return i
3. Ending
We iterate over an leetcode.array and each time increment index by 1 till A.length. So we can agree - index i will never
cross A and will be in range A[0..n] where n - A.length exclusive
*/
