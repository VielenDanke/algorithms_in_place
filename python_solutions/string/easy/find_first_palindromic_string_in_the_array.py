from typing import List


class Solution:
    def firstPalindrome(self, words: List[str]) -> str:
        for word in words:
            if word == word[::-1]:
                return word
        return ""

    def firstPalindromeBruteForce(self, words: List[str]) -> str:
        def is_palindrome(word: str) -> bool:
            left, right = 0, len(word) - 1
            while left < right:
                if word[left] != word[right]:
                    return False
                left += 1
                right -= 1
            return True

        for word in words:
            if is_palindrome(word):
                return word
        return ""

    def firstPalindromeDeclarative(self, words: List[str]) -> str:
        return next((word for word in words if word == word[::-1]), "")

    def firstPalindromeDeclarativeBruteForce(self, words: List[str]) -> str:
        def is_palindrome(word: str) -> bool:
            return all(word[left] == word[right] for left, right in
                       zip(range(len(word) // 2), range(len(word) - 1, len(word) // 2 - 1, -1)))

        return next((word for word in words if is_palindrome(word)), "")
