package golang_solutions

func FindTheWinner(n int, k int) int {
	friends := prepareFriends(n)
	return recursiveFindWinner(friends, k, 0)[0]
}

func FindTheWinnerIterative(n, k int) int {
	friends := prepareFriends(n)

	currentPosition := 0

	for len(friends) > 1 {
		nextFriend := currentPosition + k - 1

		if nextFriend >= len(friends) {
			nextFriend %= len(friends)
		}
		friends = append(friends[:nextFriend], friends[nextFriend+1:]...)
		currentPosition = nextFriend
	}
	return friends[0]
}

func prepareFriends(n int) []int {
	friends := make([]int, n)

	friends[0] = 1

	for i := 1; i < len(friends); i++ {
		friends[i] = friends[i-1] + 1
	}
	return friends
}

func recursiveFindWinner(friends []int, step int, currentPosition int) []int {
	if len(friends) == 1 {
		return friends
	}
	nextFriend := step + currentPosition - 1
	if nextFriend >= len(friends) {
		nextFriend = nextFriend % len(friends)
	}
	friends = append(friends[:nextFriend], friends[nextFriend+1:]...)
	return recursiveFindWinner(friends, step, nextFriend)
}
