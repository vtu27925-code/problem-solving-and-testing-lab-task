import java.util.*;
import java.util.stream.Collectors;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Reading> readings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String sensorId = sc.next();
            double temperature = sc.nextDouble();
            readings.add(new Reading(sensorId, temperature));
        }

        Map<String, Double> averages = readings.stream()
                // 1. Filter temperatures greater than 50
                .filter(r -> r.temperature > 50)

                // 2. Group by sensor ID and 3. Calculate average
                .collect(Collectors.groupingBy(
                        r -> r.sensorId,
                        Collectors.averagingDouble(r -> r.temperature)
                ));

        // 4. Sort by average temperature in descending order
        averages.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .forEach(entry ->
                        System.out.println(entry.getKey() + " " + entry.getValue())
                );
    }

    static class Reading {
        String sensorId;
        double temperature;

        Reading(String sensorId, double temperature) {
            this.sensorId = sensorId;
            this.temperature = temperature;
        }
    }
}
