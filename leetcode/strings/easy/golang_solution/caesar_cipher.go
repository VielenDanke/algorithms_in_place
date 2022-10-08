package golang_solution

func CaesarCipherEncryptor(str string, key int) string {
	// check if string is empty?
	// check if key is 0 return str
	// if all letters are lowercased?
	// translate str to leetcode.array of runes
	shift, offset := rune(key%26), rune(26)
	runes := []rune(str)
	for i, char := range runes {
		if char >= 'a' && char+shift <= 'z' {
			char += shift
		} else {
			char += shift - offset
		}
		runes[i] = char
	}
	return string(runes)
}

func CaesarCipherEncryptor2(str string, key int) string {
	start, end := 96, 122

	key = key % 26

	runes := []rune(str)

	for i, char := range runes {
		if start <= int(char)+key && end >= int(char)+key {
			runes[i] = rune(int(char) + key)
		} else if int(char)+key > end {
			runes[i] = rune(start + int(char) + key - end)
		}
	}
	return string(runes)
}
