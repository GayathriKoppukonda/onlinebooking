import java.util.*;

public class OnlineBookingSystem {
    static Scanner scanner = new Scanner(System.in);
    static Map<String, String> users = new HashMap<>();
    static List<String> bookings = new ArrayList<>();
    static String currentUser = null;

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Online Booking System ---");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Book a Service");
            System.out.println("4. View My Bookings");
            System.out.println("5. Logout");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1: register(); break;
                case 2: login(); break;
                case 3: bookService(); break;
                case 4: viewBookings(); break;
                case 5: logout(); break;
                case 6: System.out.println("Exiting..."); return;
                default: System.out.println("Invalid option.");
            }
        }
    }

    static void register() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        if (users.containsKey(username)) {
            System.out.println("Username already exists.");
            return;
        }
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        users.put(username, password);
        System.out.println("Registration successful!");
    }

    static void login() {
        if (currentUser != null) {
            System.out.println("Already logged in as " + currentUser);
            return;
        }
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        if (users.containsKey(username) && users.get(username).equals(password)) {
            currentUser = username;
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid credentials.");
        }
    }

    static void bookService() {
        if (currentUser == null) {
            System.out.println("Please login first.");
            return;
        }
        System.out.print("Enter service name to book: ");
        String service = scanner.nextLine();
        String booking = "User: " + currentUser + " booked: " + service;
        bookings.add(booking);
        System.out.println("Service booked successfully!");
    }

    static void viewBookings() {
        if (currentUser == null) {
            System.out.println("Please login first.");
            return;
        }
        System.out.println("Your Bookings:");
        boolean found = false;
        for (String booking : bookings) {
            if (booking.startsWith("User: " + currentUser)) {
                System.out.println("• " + booking);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No bookings found.");
        }
    }

    static void logout() {
        if (currentUser == null) {
            System.out.println("No user is logged in.");
        } else {
            System.out.println("Logged out: " + currentUser);
            currentUser = null;
        }
    }
}
