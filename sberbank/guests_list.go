package sberbank

import "strings"

func GuestsList(invitedList int, dislikeList []string) bool {
	return invitedList%len(dislikeList) == 0
}

func GuestsList2(invitedList int, dislikeList []string) bool {
	result := 0
	for i := 0; i < len(dislikeList); i++ {
		guest := strings.Split(dislikeList[i], "-")[0]
		for j := i; j < len(dislikeList); j++ {
			dislikes := strings.Split(dislikeList[j], "-")[1]
			if strings.Contains(dislikes, guest) {
				continue
			} else {
				result++
			}
		}
		if invitedList == result {
			return false
		}
		result = 0
	}
	return true
}
