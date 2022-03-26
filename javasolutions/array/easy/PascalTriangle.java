package javasolutions.array.easy;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public static List<Integer> getRow(int rowIndex) {
        List<List<Integer>> res = new ArrayList<>();
        int row;
        for (row = 0; row < rowIndex + 1; row++){
            List<Integer> col = new ArrayList<>();
            for (int i = 0; i <= row; i++){
                if (row == i || i == 0){
                    col.add(1);
                }else {
                    col.add(res.get(row - 1).get(i - 1) + res.get(row - 1).get(i));
                }
            }
            res.add(col);
        }
        row = rowIndex;
        return res.get(row);
    }
}
