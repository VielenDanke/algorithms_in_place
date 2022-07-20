import java.util.*;

public class ComplexArray_Yandex {
    private static final Map<Integer, Integer> counter = new HashMap<>();
    private static int max = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String next = sc.nextLine();

        Object o = convertToObjectArray(next, 0);

        findMaxAppearedNumber(o);

        counter.entrySet().stream().filter(entry -> entry.getValue() == max)
                .map(Map.Entry::getKey).sorted(Comparator.comparingInt(Integer::intValue)).forEach(System.out::println);
    }

    public static void findMaxAppearedNumber(Object obj) {
        if (obj.getClass().isAssignableFrom(ArrayList.class)) {
            ArrayList arr = (ArrayList) obj;
            for (Object o : arr) {
                findMaxAppearedNumber(o);
            }
        } else {
            Integer num = (Integer) obj;
            if (counter.containsKey(num)) {
                counter.put(num, counter.get(num) + 1);
            } else {
                counter.put(num, 1);
            }
            max = Math.max(max, counter.get(num));
        }
    }

    private static Object convertToObjectArray(String str, int idx) {
        List<Object> l = new ArrayList<>();

        if (str.charAt(idx) == '[') {
            idx++;
            boolean isMinus = false;
            while (idx < str.length() && str.charAt(idx) != ']') {
                if (str.charAt(idx) == '[') {
                    l.add(convertToObjectArray(str, idx));
                }
                if (str.charAt(idx) == '-') {
                    isMinus = true;
                }
                if (Character.isDigit(str.charAt(idx))) {
                    StringBuilder num = new StringBuilder();
                    while (Character.isDigit(str.charAt(idx))) {
                        num.append(str.charAt(idx));
                        idx++;
                    }
                    int va = Integer.parseInt(num.toString());
                    if (isMinus) {
                        va = -va;
                        isMinus = false;
                    }
                    l.add(va);
                    idx--;
                }
                idx++;
            }
        }
        return l;
    }
}
