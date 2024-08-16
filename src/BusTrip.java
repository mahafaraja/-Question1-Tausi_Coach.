public class BusTrip {

    public static void main(String[] args) {
        // Define the total distance from Kampala to Kabale
        int totalDistanceKm = 10000;
        // Define the stopping distances and time
        int passengerStopDistance = 150;
        int refuelStopDistance = 200;
        int stopTimeMinutes = 5;
        double speedKmPerHour = 250;
        double refuelSpeedMps = 225.5;
        int refuelStopTimeMinutes = 5; // Time per refuel stop

        // (i)  the number of stops for passenger offloading/loading and refueling


        int passengerStops = totalDistanceKm / passengerStopDistance;
        int refuelStops = totalDistanceKm / refuelStopDistance;
        int totalStops = passengerStops + refuelStops;
        // If the train stops exactly at the end, we should not count the last stop
        if (totalDistanceKm % passengerStopDistance == 0) {
            totalStops--;
        }
        if (totalDistanceKm % refuelStopDistance == 0) {
            totalStops--;
        }
        // Ensure we don't double-count a stop at the exact end of both requirements
        totalStops = Math.max(totalStops, 0);

        System.out.println("Total number of stops when traveling from Kampala to Kabale: " + totalStops);

        // (ii)  the total time taken including stops
        double travelTimeHours = (double) totalDistanceKm / speedKmPerHour;
        double totalStopTimeHours = (double) totalStops * stopTimeMinutes / 60;
        double totalTimeHours = travelTimeHours + totalStopTimeHours;

        System.out.println("Total time taken to travel from Kampala to Kabale including stops: " + totalTimeHours + " hours");

        // (iii)  total time spent on the journey back (only refueling stops)
        int refuelStopsReturn = totalDistanceKm / refuelStopDistance;
        if (totalDistanceKm % refuelStopDistance == 0) {
            refuelStopsReturn--;
        }
        double travelTimeHoursReturn = (double) totalDistanceKm / speedKmPerHour;
        double totalStopTimeHoursReturn = (double) refuelStopsReturn * refuelStopTimeMinutes / 60;
        double totalTimeHoursReturn = travelTimeHoursReturn + totalStopTimeHoursReturn;

        System.out.println("Total time spent on the journey back including refueling stops: " + totalTimeHoursReturn + " hours");

        // (iv) Compute the arrival time for the second coach
        // Convert speed from m/s to km/hr for consistency
        double speedKmPerHourSecondCoach = refuelSpeedMps * 3.6;
        double travelTimeHoursSecondCoach = (double) totalDistanceKm / speedKmPerHourSecondCoach;
        int departureHour = 9; // 09:00 hrs
        double arrivalHour = departureHour + travelTimeHoursSecondCoach;

        System.out.printf("Approximate arrival time for the second coach: %.2f hours past 09:00 (i.e., %.2f hours past midnight)%n", arrivalHour - departureHour, arrivalHour);

    }
}
