package leetcode.system_implementations.java_solutions;

import java.util.*;

public class DesignUndergroundSystem_1396 {

    private final Map<Integer, PassengerTime> passengerTimeMap = new HashMap<>();
    private final Map<String, Map<String, List<Integer>>> timeKeeper = new HashMap<>();

    private static class PassengerTime {
        String startStation;
        int startTime;

        PassengerTime(String startStation, int startTime) {
            this.startStation = startStation;
            this.startTime = startTime;
        }
    }

    public DesignUndergroundSystem_1396() {

    }

    public void checkIn(int id, String stationName, int t) {
        passengerTimeMap.put(id, new PassengerTime(stationName, t));
        if (!timeKeeper.containsKey(stationName)) {
            timeKeeper.put(stationName, new HashMap<>());
        }
    }

    public void checkOut(int id, String stationName, int t) {
        PassengerTime passengerTime = passengerTimeMap.get(id);
        int currentTime = t - passengerTime.startTime;
        timeKeeper.get(passengerTime.startStation).compute(stationName, (s, integers) -> {
            if (integers == null) {
                return new ArrayList<>() {{add(currentTime);}};
            }
            integers.add(currentTime);
            return integers;
        });
    }

    public double getAverageTime(String startStation, String endStation) {
        return timeKeeper.get(startStation).get(endStation).stream().mapToInt(Integer::intValue).average().orElse(0.0);
    }
}
