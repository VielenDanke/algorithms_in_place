package array.medium.java_solutions;

import java.util.*;

public class Operations_Yandex {

    private static final Queue<Progression> priority = new PriorityQueue<>((left, right) -> {
        if (left.startElem == right.startElem) {
            return left.id - right.id;
        }
        return left.startElem - right.startElem;
    });

    private static class Progression {
        int startElem;
        int step;
        int id;

        Progression(int startElem, int step, int id) {
            this.startElem = startElem;
            this.step = step;
            this.id = id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Progression that = (Progression) o;
            return id == that.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numberOfOperations = sc.nextInt();

        List<Integer> operationResult = new ArrayList<>();

        for (int i = 0; i <= numberOfOperations; i++) {
            String line = sc.nextLine();

            if (line.equals("")) {
                continue;
            }

            String[] numbers = line.split(" ");

            int operation = Integer.parseInt(numbers[0]);

            if (operation == 1) {
                priority.add(new Progression(Integer.parseInt(numbers[1]), Integer.parseInt(numbers[2]), Integer.parseInt(numbers[3])));
            } else if (operation == 2) {
                priority.remove(new Progression(0, 0, Integer.parseInt(numbers[1])));
            } else {
                if (!priority.isEmpty()) {
                    Progression lastElem = priority.poll();

                    operationResult.add(lastElem.startElem);

                    lastElem.startElem += lastElem.step;

                    priority.add(lastElem);
                }
            }
        }
        operationResult.forEach(System.out::println);
    }
}
