package golang_solutions

import "sort"

/*
pub fn custom_sort_string(order: String, s: String) -> String {
    let order_map = order
        .chars()
        .enumerate()
        .fold([0; 26], |mut acc, (i, c)| {
            acc[c as usize - 'a' as usize] = i;
            acc
        });
    let mut s = s.into_bytes();
    s.sort_unstable_by_key(|&c| order_map[c as usize - 'a' as usize]);
    String::from_utf8(s).unwrap_or(String::new())
}
*/

func customSortString(order string, s string) string {
	letters := make([]int, 26)

	maxOrder := len(order)

	for _, v := range order {
		letters[v-'a'] = maxOrder
		maxOrder--
	}
	runes := []rune(s)

	sort.Slice(runes, func(i, j int) bool {
		iLetter, jLetter := runes[i], runes[j]
		return letters[iLetter-'a'] > letters[jLetter-'a']
	})
	return string(runes)
}
