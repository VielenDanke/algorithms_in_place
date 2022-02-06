package strings

func CaesarCipherEncryptor(str string, key int) string {
	// check if string is empty?
	// check if key is 0 return str
	// if all letters are lowercased?
	// translate str to array of runes
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
