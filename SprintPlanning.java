import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SprintPlanning {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int nTask = Integer.parseInt(sc.next());

        if (nTask % 2 != 0) {
            System.out.println(-1);
            return;
        }
        List<Integer> arr = new ArrayList<>();

        while (nTask > 0) {
            arr.add(Integer.parseInt(sc.next()));
            nTask--;
        }
        int left = 0, right = arr.size() - 1;

        Integer pairWeight = null;

        while (left <= right) {
            int currentPairWeight = arr.get(left++) + arr.get(right--);
            if (pairWeight != null && !pairWeight.equals(currentPairWeight)) {
                System.out.println(-1);
                return;
            }
            pairWeight = currentPairWeight;
        }
        System.out.println(pairWeight);
    }
}
