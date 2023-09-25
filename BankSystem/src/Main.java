import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.*;

class BankCustomer {
	private int accountNumber;
	private String name;
	private double accountBalance;

	// Constructors, getters, setters
	public BankCustomer(int accountNumber, String name, double accountBalance) {
		this.accountNumber = accountNumber;
		this.name = name;
		this.accountBalance = accountBalance;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
}
class Administrator {
	public void createCustomer(BankCustomer customer) {
		try (Connection connection = DatabaseConnection.getConnection()) {
			String insertQuery = "INSERT INTO customers (accountNumber, name, accountBalance) VALUES (?, ?, ?)";
			PreparedStatement pstm = connection.prepareStatement(insertQuery);
			pstm.setInt(1, customer.getAccountNumber());
			pstm.setString(2, customer.getName());
			pstm.setDouble(3, customer.getAccountBalance());
			pstm.executeUpdate();
			System.out.println("Customer created successfully!");
		} catch (SQLException e) {
			e.printStackTrace();
			// Handle exceptions
		}
	}

	public void searchCustomer(int accountNumber) {
		try (Connection connection = DatabaseConnection.getConnection()) {
			String selectQuery = "SELECT * FROM customers WHERE accountNumber = ?";
			PreparedStatement pstm = connection.prepareStatement(selectQuery);
			pstm.setInt(1, accountNumber);
			ResultSet resultSet = pstm.executeQuery();

			if (resultSet.next()) {
				int foundAccountNumber = resultSet.getInt("accountNumber");
				String name = resultSet.getString("name");
				double accountBalance = resultSet.getDouble("accountBalance");

				System.out.println("Account Number: " + foundAccountNumber);
				System.out.println("Name: " + name);
				System.out.println("Account Balance: " + accountBalance);
			} else {
				System.out.println("Customer not found.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// Handle exceptions
		}
	}

	public void modifyCustomer(int accountNumber, String newName) {
		try (Connection connection = DatabaseConnection.getConnection()) {
			String updateQuery = "UPDATE customers SET name = ? WHERE accountNumber = ?";
			PreparedStatement pstm = connection.prepareStatement(updateQuery);
			pstm.setString(1, newName);
			pstm.setInt(2, accountNumber);
			int rowsUpdated = pstm.executeUpdate();

			if (rowsUpdated > 0) {
				System.out.println("Customer details updated successfully!");
			} else {
				System.out.println("Customer not found.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// Handle exceptions
		}
	}

	// Other administrator functionalities using JDBC


	public void balanceInquiry(int accountNumber) {
		try (Connection connection = DatabaseConnection.getConnection()) {
			String selectQuery = "SELECT accountBalance FROM customers WHERE accountNumber = ?";
			PreparedStatement pstm = connection.prepareStatement(selectQuery);
			pstm.setInt(1, accountNumber);
			double balance = -1; // Default value if not found

			ResultSet resultSet = pstm.executeQuery();
			if (resultSet.next()) {
				balance = resultSet.getDouble("accountBalance");
				System.out.println("Account Balance: " + balance);
			} else {
				System.out.println("Customer not found.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// Handle exceptions
		}
	}

	public void closeAccount(int accountNumber) {
		try (Connection connection = DatabaseConnection.getConnection()) {
			String deleteQuery = "DELETE FROM customers WHERE accountNumber = ?";
			PreparedStatement pstm = connection.prepareStatement(deleteQuery);
			pstm.setInt(1, accountNumber);
			int rowsDeleted = pstm.executeUpdate();

			if (rowsDeleted > 0) {
				System.out.println("Account closed successfully!");
			} else {
				System.out.println("Customer not found.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}




class Customer {
	private int accountNumber;

	public Customer(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void deposit(double amount) {
		try (Connection connection = DatabaseConnection.getConnection()) {
			String updateQuery = "UPDATE customers SET accountBalance = accountBalance + ? WHERE accountNumber = ?";
			PreparedStatement pstm= connection.prepareStatement(updateQuery);
			pstm.setDouble(1, amount);
			pstm.setInt(2, accountNumber);
			int rowsUpdated = pstm.executeUpdate();

			if (rowsUpdated > 0) {
				System.out.println("Deposit successful!");
			} else {
				System.out.println("Customer not found.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// Handle exceptions
		}
	}

	public void withdraw(double amount) {
		try (Connection connection = DatabaseConnection.getConnection()) {
			String updateQuery = "UPDATE customers SET accountBalance = accountBalance - ? WHERE accountNumber = ?";
			PreparedStatement pstm = connection.prepareStatement(updateQuery);
			pstm.setDouble(1, amount);
			pstm.setInt(2, accountNumber);
			int rowsUpdated = pstm.executeUpdate();

			if (rowsUpdated > 0) {
				System.out.println("Withdrawal successful!");
			} else {
				System.out.println("Customer not found or insufficient balance.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// Handle exceptions
		}
	}

	public void printMiniStatement() {
	    try (Connection connection = DatabaseConnection.getConnection()) {
	        String selectQuery = "SELECT * FROM transactions WHERE accountNumber = ? ORDER BY transactionDate DESC LIMIT 5";
	        PreparedStatement pstm = connection.prepareStatement(selectQuery);
	        pstm.setInt(1, accountNumber);
	        ResultSet resultSet = pstm.executeQuery();

	        System.out.println("Mini Statement for Account Number: " + accountNumber);
	        double currentBalance = getAccountBalance(connection);

	        while (resultSet.next()) {
	            String transactionType = resultSet.getString("transactionType");
	            double transactionAmount = resultSet.getDouble("transactionAmount");
//	            System.out.println("Type: " + transactionType + ", Amount: " + transactionAmount);
//	            System.out.println("Type: " + transactionType + ", Amount: " + transactionAmount);
	            if(transactionType.equals("Deposit")) {
	            	System.out.println("depsoit : " +transactionAmount);
	            }else if (transactionType.equals("WITHDRAW")) {
	            	System.out.println("withdrawal : "+transactionAmount);
	            }
	            currentBalance -= transactionAmount;
	        }
	        System.out.println("Current Balance: " + currentBalance);

	    } catch (SQLException e) {
	        e.printStackTrace();
	        // Handle exceptions
	    }
	}
	private double getAccountBalance(Connection connection) throws SQLException {
	    String selectQuery = "SELECT accountBalance FROM customers WHERE accountNumber = ?";
	    PreparedStatement pstm = connection.prepareStatement(selectQuery);
	    pstm.setInt(1, accountNumber);
	    ResultSet resultSet = pstm.executeQuery();

	    if (resultSet.next()) {
	        return resultSet.getDouble("accountBalance");
	    } else {
	        return 1; // Default value if balance is not found
	    }
	}

	public void transfer(int targetAccountNumber, double amount) {
		try (Connection connection = DatabaseConnection.getConnection()) {
			connection.setAutoCommit(false);

			String senderUpdateQuery = "UPDATE customers SET accountBalance = accountBalance - ? WHERE accountNumber = ?";
			PreparedStatement senderStatement = connection.prepareStatement(senderUpdateQuery);
			senderStatement.setDouble(1, amount);
			senderStatement.setInt(2, accountNumber);

			String receiverUpdateQuery = "UPDATE customers SET accountBalance = accountBalance + ? WHERE accountNumber = ?";
			PreparedStatement receiverStatement = connection.prepareStatement(receiverUpdateQuery);
			receiverStatement.setDouble(1, amount);
			receiverStatement.setInt(2, targetAccountNumber);

			int senderRowsUpdated = senderStatement.executeUpdate();
			int receiverRowsUpdated = receiverStatement.executeUpdate();

			if (senderRowsUpdated > 0 && receiverRowsUpdated > 0) {
				updateTransaction(connection, "TRANSFER", -amount);
				updateTransaction(connection, "TRANSFER", amount, targetAccountNumber);
				connection.commit();
				System.out.println("Transfer successful!");
				printUpdatedBalance(connection);
			} else {
				connection.rollback();
				System.out.println("Transfer failed: Customer not found or insufficient balance.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// Handle exceptions
		}
	}

	private void updateTransaction(Connection connection, String transactionType, double amount) throws SQLException {
		String insertQuery = "INSERT INTO transactions (accountNumber, transactionType, transactionAmount) VALUES (?, ?, ?)";
		PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
		preparedStatement.setInt(1, accountNumber);
		preparedStatement.setString(2, transactionType);
		preparedStatement.setDouble(3, amount);
		preparedStatement.executeUpdate();
	}

	private void updateTransaction(Connection connection, String transactionType, double amount, int targetAccountNumber) throws SQLException {
		String insertQuery = "INSERT INTO transactions (accountNumber, transactionType, transactionAmount) VALUES (?, ?, ?)";
		PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
		preparedStatement.setInt(1, targetAccountNumber);
		preparedStatement.setString(2, transactionType);
		preparedStatement.setDouble(3, amount);
		preparedStatement.executeUpdate();
	}

	private void printUpdatedBalance(Connection connection) throws SQLException {
		String selectQuery = "SELECT accountBalance FROM customers WHERE accountNumber = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
		preparedStatement.setInt(1, accountNumber);
		ResultSet resultSet = preparedStatement.executeQuery();

		if (resultSet.next()) {
			double updatedBalance = resultSet.getDouble("accountBalance");
			System.out.println("Updated Account Balance: " + updatedBalance);
		}
	}
}


class DatabaseConnection {
	private static final String URL = "jdbc:mysql://localhost/bank_account";
	private static final String USER = "root";
	private static final String PASSWORD = "root";

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
}



public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Welcome to the Bank System!");
		System.out.println("Please select an option:");
		System.out.println("1. Administrator");
		System.out.println("2. Customer");
		System.out.print("Enter your choice: ");
		int choice = scanner.nextInt();

		if (choice == 1) {
			runAdministrator(scanner);
		} else if (choice == 2) {
			System.out.print("Enter your account number: ");
			int accountNumber = scanner.nextInt();
			runCustomer(scanner, accountNumber);
		} else {
			System.out.println("Invalid choice. Exiting...");
		}

		// Close the scanner
		scanner.close();
	}

	public static void runAdministrator(Scanner scanner) {
		// Create a BankSystem instance to manage customer accounts
		Main bankSystem = new Main();
		Administrator admin = new Administrator();

		while (true) {
			System.out.println("\nAdministrator Menu:");
			System.out.println("1. Add Customer");
			System.out.println("2. Search Customer");
			System.out.println("3. Modify Customer");
			System.out.println("4. Balance Inquiry");
			System.out.println("5. Close Account");
			System.out.println("6. Exit Administrator Menu");
			System.out.print("Enter your choice: ");
			int adminChoice = scanner.nextInt();

			switch (adminChoice) {
			case 1:
				BankCustomer customer = takeCustomerInput(scanner);
				admin.createCustomer(customer);
				break;
			case 2:
				System.out.print("Enter account number to search: ");
				int searchAccountNumber = scanner.nextInt();
				admin.searchCustomer(searchAccountNumber);
				break;
			case 3:
				System.out.print("Enter account number to modify: ");
				int modifyAccountNumber = scanner.nextInt();
				scanner.nextLine(); // Consume newline
				System.out.print("Enter new name: ");
				String newName = scanner.nextLine();
				admin.modifyCustomer(modifyAccountNumber, newName);
				break;
			case 4:
				System.out.print("Enter account number to check balance: ");
				int balanceAccountNumber = scanner.nextInt();
				admin.balanceInquiry(balanceAccountNumber);
				break;
			case 5:
				System.out.print("Enter account number to close: ");
				int closeAccountNumber = scanner.nextInt();
				admin.closeAccount(closeAccountNumber);
				break;
			case 6:
				System.out.println("Exited Administrator Menu.");
				return;
			default:
				System.out.println("Invalid choice. Please enter a valid option.");
			}
		}
	}

	public static void runCustomer(Scanner scanner, int accountNumber) {
		Customer customer = new Customer(accountNumber);

		while (true) {
			System.out.println("\nCustomer Menu:");
			System.out.println("1. Deposit");
			System.out.println("2. Withdraw");
			System.out.println("3. Print Mini Statement");
			System.out.println("4. Transfer");
			System.out.println("5. Exit Customer Menu");
			System.out.print("Enter your choice: ");
			int customerChoice = scanner.nextInt();

			switch (customerChoice) {
			case 1:
				System.out.print("Enter amount to deposit: ");
				double depositAmount = scanner.nextDouble();
				customer.deposit(depositAmount);
				break;
			case 2:
				System.out.print("Enter amount to withdraw: ");
				double withdrawAmount = scanner.nextDouble();
				customer.withdraw(withdrawAmount);
				break;
			case 3:
				customer.printMiniStatement();
				break;
			case 4:
				System.out.print("Enter target account number: ");
				int targetAccountNumber = scanner.nextInt();
				System.out.print("Enter amount to transfer: ");
				double transferAmount = scanner.nextDouble();
				customer.transfer(targetAccountNumber, transferAmount);
				break;
			case 5:
				System.out.println("Exited Customer Menu.");
				return;
			default:
				System.out.println("Invalid choice. Please enter a valid option.");
			}
		}
	}

	public static BankCustomer takeCustomerInput(Scanner scanner) {
		System.out.print("Enter account number: ");
		int accountNumber = scanner.nextInt();
		scanner.nextLine(); // Consume newline
		System.out.print("Enter name: ");
		String name = scanner.nextLine();
		System.out.print("Enter initial account balance: ");
		double accountBalance = scanner.nextDouble();
		return new BankCustomer(accountNumber, name, accountBalance);
	}
}
