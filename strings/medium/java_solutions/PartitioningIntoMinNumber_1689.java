package strings.medium.java_solutions;

public class PartitioningIntoMinNumber_1689 {

    /*
        for 34 it should be 11+11+11+1
        so if we have a number say 829 then we can write it as
        111 // now remaining 1 for getting sum 8 = 7 , 2 is 1 and 9 is 8
        111 // now remaining 1 for getting sum 8 = 6 , 2 is 0 and 9 is 7
        101 // now remaining 1 for getting sum 8 = 5 , 2 is 0 and 9 is 6
        101 // now remaining 1 for getting sum 8 = 4 , 2 is 0 and 9 is 5
        101 // now remaining 1 for getting sum 8 = 3 , 2 is 0 and 9 is 4
        101 // now remaining 1 for getting sum 8 = 2 , 2 is 0 and 9 is 3
        101 // now remaining 1 for getting sum 8 = 1 , 2 is 0 and 9 is 2
        101 // now remaining 1 for getting sum 8 = 0 , 2 is 0 and 9 is 1
        001 // now remaining 1 for getting sum 8 = 0 , 2 is 0 and 9 is 0
     */

    public int minPartitions(String n) {
        int max = 0;
        for (int i = 0; i < n.length(); i++) {
            max = Math.max(max, n.charAt(i) - '0');
        }
        return max;
    }
}
