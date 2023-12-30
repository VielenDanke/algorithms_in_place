package golang_solution

/*
Rust

impl Solution {
    pub fn make_equal(words: Vec<String>) -> bool {
        let mut alph = vec![0; 26];

        for word in &words {
            for c in word.chars() {
                alph[(c as u8 - b'a') as usize] += 1;
            }
        }
        alph.iter().all(|&count| count % words.len() == 0)
    }
}
*/

func makeEqual(words []string) bool {
	alph := make([]int, 26)
	for _, word := range words {
		for _, r := range word {
			alph[r-'a']++
		}
	}
	n := len(words)
	for _, r := range alph {
		if r%n != 0 {
			return false
		}
	}
	return true
}
