import java.sql.*;
import java.util.Scanner;

public class OnlineMobileStore1 {

    static Connection con;
    static Statement st;
    static int currentUserID;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mobile_store_db?characterEncoding=utf8", "root", "");
            st = con.createStatement();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    static void registerUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your details for registration");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        try {
            String insertUserQuery = "INSERT INTO users (name, email, password, balance) VALUES (?, ?, ?, 0)";
            PreparedStatement ps = con.prepareStatement(insertUserQuery, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.executeUpdate();

            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                currentUserID = generatedKeys.getInt(1);
                System.out.println("Registration successful!");
                System.out.println("User ID: " + currentUserID);
            } else {
                System.out.println("Error generating user ID.");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
    }

    static void userLogin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        try {
            String loginQuery = "SELECT * FROM users WHERE email = ? AND password = ?";
            PreparedStatement ps = con.prepareStatement(loginQuery);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                currentUserID = resultSet.getInt("user_id");
                System.out.println("Login successful!");

                // Display available mobiles
                viewAllMobiles();

                // Prompt user to select a mobile for purchase
                System.out.print("Enter the Mobile ID to purchase: ");
                int mobileID = scanner.nextInt();

                // Retrieve selected mobile details
                String getMobileQuery = "SELECT * FROM mobiles WHERE mobile_id = " + mobileID;
                ResultSet mobileResultSet = st.executeQuery(getMobileQuery);

                if (mobileResultSet.next()) {
                    double price = mobileResultSet.getDouble("price");
                    System.out.println("Buying mobile: " + mobileResultSet.getString("brand") + " " +
                            mobileResultSet.getString("model") + " for $" + price);

                    // Confirm the purchase
                    System.out.print("Confirm purchase? (yes/no): ");
                    String confirm = scanner.next().toLowerCase();

                    if (confirm.equals("yes")) {
                        // Deduct the purchase amount from the user's balance
                        String updateBalanceQuery = "UPDATE users SET balance = balance - ? WHERE user_id = ?";
                        PreparedStatement balancePS = con.prepareStatement(updateBalanceQuery);
                        balancePS.setDouble(1, price);
                        balancePS.setInt(2, currentUserID);
                        balancePS.executeUpdate();

                        System.out.println("Purchase successful!");
                    } else {
                        System.out.println("Purchase cancelled.");
                    }
                } else {
                    System.out.println("Mobile not found!");
                }
            } else {
                System.out.println("Invalid email or password.");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
    }

    static void viewAllMobiles() {
        try {
            String query = "SELECT * FROM mobiles";
            ResultSet resultSet = st.executeQuery(query);

            System.out.println("All Mobiles");
            while (resultSet.next()) {
                System.out.println("Mobile ID: " + resultSet.getInt("mobile_id"));
                System.out.println("Brand: " + resultSet.getString("brand"));
                System.out.println("Model: " + resultSet.getString("model"));
                System.out.println("Price: $" + resultSet.getDouble("price"));
                System.out.println("---------------");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
    }

    static void admin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Admin Operations");
        System.out.println("1. Add Mobile Details");
        System.out.println("2. View All Mobiles");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                addMobileDetails();
                break;
            case 2:
                viewAllMobiles();
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }

    static void addMobileDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Mobile Details");
        System.out.print("Brand: ");
        String brand = scanner.nextLine();
        System.out.print("Model: ");
        String model = scanner.nextLine();
        System.out.print("Price: ");
        double price = scanner.nextDouble();

        try {
            String insertMobileQuery = "INSERT INTO mobiles (brand, model, price) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(insertMobileQuery);
            ps.setString(1, brand);
            ps.setString(2, model);
            ps.setDouble(3, price);
            ps.executeUpdate();

            System.out.println("Mobile details added successfully!");
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Online Mobile Store");

        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Admin");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    registerUser();
                    break;
                case 2:
                    userLogin();
                    break;
                case 3:
                    admin();
                    break;
                case 4:
                    System.out.println("Exiting the application. Thank you!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
