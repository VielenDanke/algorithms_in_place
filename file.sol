// return count of valid time
// correct format 24:00
?4:00 00:00

0 1 ?4:00
0 -> 9 1?:00
0 -> 5 14:?0
0 -> 9 14:0?

?3:00

Public int timeWays(String time) {
Return backtrack(time.toCharArray(), 0);
}

Private int backtrack(char[] time, int start) {
	If (start >= time.length) {
		Return 1;
}
Int sum = 0;
	If (time.charAt(start) == ‘?’) {
		for (int i = 0; i <= 9; i++) {
			Char current = time[start];
			time[start] = i;
			sum += backtrack(time, start + 1);
			Time[start] = current;
		}
} else {
	// current position is not a question mark
	sum += backtrack(time, start + 1);
}
Return sum;
}

N - length of time
// n - 1 -> 10
// n - 2 -> 6
// n - 4 -> 10 if n - 5 == 2 -> 3 if n - 5 == ‘?’
// n - 5 -> 3
// ??:??
// 
Private int determineVariants(int position) {
	If (position == 4) {
		Return 10;
} else if (position == 3) {

	Return 6;
} else if (position == 1) {
	Return 10;
} else if (position == 0) {
	Return 3;
} else {
Return 1;
}
}

Public int timeWays(String time) {
	int result = 1;
	for (int i = time.length() - 1; i >= 0; i–) {
		If (time.charAt(i) == ‘?’) {
			result *= determineVariants(i);
}
	}
	return result;
}

1?:??

1 10 6 10

60 * 10
600


11:01
11:02 etc


1?:00

[‘1’, ‘?’, ‘0’, ‘0’]

[‘1’, ‘?’, ‘0’, ‘0’], start = 0
[‘1’, ‘?’, ‘0’, ‘0’], start = 1
[1, 0, 0, 0] - 1
1, 1, 0, 0 - 1 
1, 2, 0, 0 - 1
1, 3, 0, 0 - 1
1, 4, 0, 0 - 1
1, 5, 0, 0 - 1
1, 6, 0, 0 - 1
1, 7, 0, 0 - 1
1, 8, 0, 0 - 1
1, 9, 0, 0 - 1


