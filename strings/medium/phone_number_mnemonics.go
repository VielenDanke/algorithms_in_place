package medium

func PhoneNumberMnemonics(phoneNumber string) []string {
	// Write your code here.
	phoneCodes := constructCodes()

	result := make([]string, 0)

	recursiveMnemonics(&result, phoneCodes, "", phoneNumber, 0)

	return result
}

func recursiveMnemonics(result *[]string, phoneCodes [][]string, str string, phoneNumber string, idx int) {
	if len(str) == len(phoneNumber) {
		*result = append(*result, str)
		return
	}
	num := phoneNumber[idx] - 48
	variants := phoneCodes[num]
	for _, v := range variants {
		recursiveMnemonics(result, phoneCodes, str+v, phoneNumber, idx+1)
	}
}

func constructCodes() [][]string {
	codes := make([][]string, 10)

	codes[0] = []string{"0"}
	codes[1] = []string{"1"}
	codes[2] = []string{"a", "b", "c"}
	codes[3] = []string{"d", "e", "f"}
	codes[4] = []string{"g", "h", "i"}
	codes[5] = []string{"j", "k", "l"}
	codes[6] = []string{"m", "n", "o"}
	codes[7] = []string{"p", "q", "r", "s"}
	codes[8] = []string{"t", "u", "v"}
	codes[9] = []string{"w", "x", "y", "z"}

	return codes
}
