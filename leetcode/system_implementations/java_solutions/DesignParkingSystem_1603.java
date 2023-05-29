package leetcode.system_implementations.java_solutions;

public class DesignParkingSystem_1603 {

    static class ParkingSystem {

        private final int[] parking;

        public ParkingSystem(int big, int medium, int small) {
            this.parking = new int[]{big, medium, small};
        }

        public boolean addCar(int carType) {
            return parking[carType - 1]-- > 0;
        }
    }

    static class ParkingSystemBruteForce {

        private int big;
        private int medium;
        private int small;

        public ParkingSystemBruteForce(int big, int medium, int small) {
            this.big = big;
            this.medium = medium;
            this.small = small;
        }

        public boolean addCar(int carType) {
            if (carType == 1 && big-- > 0) {
                return true;
            } else if (carType == 2 && medium-- > 0) {
                return true;
            } else return carType == 3 && small-- > 0;
        }
    }
}
