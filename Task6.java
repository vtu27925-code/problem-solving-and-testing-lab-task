import java.util.*;

class InvalidBookingException extends Exception {
    public InvalidBookingException(String message) {
        super(message);
    }
}

class Driver {
    String name;

    Driver(String name) {
        this.name = name;
    }
}

class Rider {
    String name;

    Rider(String name) {
        this.name = name;
    }
}

class Vehicle {
    String number;

    Vehicle(String number) {
        this.number = number;
    }
}

abstract class Trip {
    protected double distance;

    Trip(double distance) throws InvalidBookingException {
        if (distance <= 0) {
            throw new InvalidBookingException("Invalid distance");
        }
        this.distance = distance;
    }

    abstract int calculateFare();
}

class BikeTrip extends Trip {
    BikeTrip(double distance) throws InvalidBookingException {
        super(distance);
    }

    int calculateFare() {
        return (int) (distance * 5);
    }
}

class AutoTrip extends Trip {
    AutoTrip(double distance) throws InvalidBookingException {
        super(distance);
    }

    int calculateFare() {
        return (int) (distance * 12);
    }
}

class CabTrip extends Trip {
    CabTrip(double distance) throws InvalidBookingException {
        super(distance);
    }

    int calculateFare() {
        return (int) (distance * 12);
    }
}

public class Task6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double distance = sc.nextDouble();

            try {
                Trip trip;

                if (type.equalsIgnoreCase("Bike")) {
                    trip = new BikeTrip(distance);
                } else if (type.equalsIgnoreCase("Auto")) {
                    trip = new AutoTrip(distance);
                } else if (type.equalsIgnoreCase("Cab")) {
                    trip = new CabTrip(distance);
                } else {
                    throw new InvalidBookingException("Invalid ride type");
                }

                System.out.println(trip.calculateFare());

            } catch (InvalidBookingException e) {
                System.out.println("Invalid Booking");
            }
        }
    }
}
