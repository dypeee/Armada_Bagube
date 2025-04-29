import java.util.Scanner;
import java.util.*;

abstract class Room {
    private String roomType;
    private double price;
    private boolean isAvailable;

    public Room(String roomType, double price) {
        this.roomType = roomType;
        this.price = price;
        this.isAvailable = true;
    }

    public String getRoomType() {
        return roomType;
    }

    public double getPrice() {
        return price;
    }

    public String setRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double setPrice() {
        return price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void bookRoom() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println(roomType + " is available.");
        } else {
            System.out.println(roomType + " is not available.");
        }
    }

    public void releaseRoom() {
        if (!isAvailable) {
            isAvailable = true;
            System.out.println(roomType + " has been released.");
        } else {
            System.out.println(roomType + " is already available.");
        }
    }

    public abstract String getDescription();
}

class SingleRoom extends Room {
    public SingleRoom(double price) {
        super("Single Room", price);
    }

    @Override
    public String getDescription() {
        return "A small room perfect for one person.";
    }

}

class DoubleRoom extends Room {
    public DoubleRoom(double price) {
        super("Double Room", price);
    }

    @Override
    public String getDescription() {
        return "A Big room perfect for family.";
    }
}

class Suite extends Room {
    public Suite(double price) {
        super("Suite Room", price);
    }

    @Override
    public String getDescription() {
        return "A room perfect for single person.";
    }
}

class Customer {
    private String name, email, membershipStatus;

    public Customer(String name, String email, String membershipStatus) {
        this.name = name;
        this.email = email;
        this.membershipStatus = membershipStatus;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getMembershipStatus() {
        return membershipStatus;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String name) {
        this.name = name;
    }

    public void setMembershipStatus(String name) {
        this.name = name;
    }

    public void displayInfo() {
        System.out.println("Customer Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Membership Status: " + membershipStatus);
    }
}

class Reservation {
    private String checkInDate, checkOutDate;
    private double totalPrice;
    private Room room;
    private Customer customer;

    public Reservation(String checkInDate, String checkOutDate, Double totalPrice, Room room, Customer customer) {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.room = room;
        this.customer = customer;
        this.totalPrice = totalPrice;
    }

    // Getters
    public String getCheckInDate() {
        return checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void applyDiscount() {
        double discount = 0;

        if (customer.getMembershipStatus().equalsIgnoreCase("Gold")) {
            discount = 0.20;
        } else if (customer.getMembershipStatus().equalsIgnoreCase("Silver")) {
            discount = 0.10;
        }

        totalPrice -= totalPrice * discount;
    }

    public void displayReservationDetails() {
        System.out.println("Reservation Details:");
        System.out.println("Customer: " + customer.getName());
        System.out.println("Room: " + room.getRoomType());
        System.out.println("Check-in Date: " + checkInDate);
        System.out.println("Check-out Date: " + checkOutDate);
        System.out.println("Total Price (after discount if any): $" + totalPrice);
    }
}

class Payment {
    private double amount;
    private String paymentMethod, creditCardNumber;

    public Payment(double amount, String paymentMethod, String creditCardNumber) {
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.creditCardNumber = creditCardNumber;
    }

    public Double getAmount() {
        return amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public void processPayment() {
        System.out.println("Processing payment of $" + amount + " using " + paymentMethod);
        if (paymentMethod.equalsIgnoreCase("Credit Card")) {
            System.out.println("Charging card: " + maskCreditCard());
        } else {
            System.out.println("Payment method: " + paymentMethod + " selected.");
        }
        System.out.println("Payment successful!");
    }

    public String maskCreditCard() {
        if (creditCardNumber.length() >= 4) {
            String last4Digits = creditCardNumber.substring(creditCardNumber.length() - 4);
            return "**** **** **** " + last4Digits;
        } else {
            return "Invalid Card Number";
        }
    }

}

class InvalidDateException extends Exception {
    public InvalidDateException(String message) {
        super(message);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Room[] rooms = {
                new SingleRoom(1500),
                new DoubleRoom(3000),
                new Suite(5000)
        };

        System.out.println("Available Rooms:");
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i].isAvailable()) {
                System.out.println((i + 1) + ". " + rooms[i].getRoomType() + " - $" + rooms[i].getPrice());
            }
        }

        System.out.println("\nEnter customer details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Membership Status (Gold/Silver/None): ");
        String membershipStatus = scanner.nextLine();

        Customer customer = new Customer(name, email, membershipStatus);

        System.out.print("\nSelect a room number: ");
        int roomChoice = scanner.nextInt();
        scanner.nextLine(); 

        Room selectedRoom = rooms[roomChoice - 1];

        if (!selectedRoom.isAvailable()) {
            System.out.println("Sorry, this room is not available.");
            return;
        }

        String checkInDate = "", checkOutDate = "";
        boolean validDates = false;

        while (!validDates) {
            try {
                System.out.print("Enter check-in date (YYYY-MM-DD): ");
                checkInDate = scanner.nextLine();
                System.out.print("Enter check-out date (YYYY-MM-DD): ");
                checkOutDate = scanner.nextLine();

                if (checkInDate.equals("") || checkOutDate.equals("")) {
                    throw new InvalidDateException("Dates cannot be empty.");
                }

                validDates = true;
            } catch (InvalidDateException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        double totalPrice = selectedRoom.getPrice();
        Reservation reservation = new Reservation(checkInDate, checkOutDate, totalPrice, selectedRoom, customer);
        reservation.applyDiscount();

        System.out.print("\nChoose payment method (Cash/Credit Card): ");
        String paymentMethod = scanner.nextLine();

        String creditCardNumber = "";
        if (paymentMethod.equalsIgnoreCase("Credit Card")) {
            System.out.print("Enter credit card number: ");
            creditCardNumber = scanner.nextLine();
        }

        Payment payment = new Payment(reservation.getTotalPrice(), paymentMethod, creditCardNumber);
        payment.processPayment();

        reservation.displayReservationDetails();
    }
}