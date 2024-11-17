import java.util.ArrayList;
import java.util.Scanner;

class LandPlot {
    private String plotId;
    private double length;
    private double width;
    private double area;

    // Constructor
    public LandPlot(String plotId, double length, double width) {
        this.plotId = plotId;
        this.length = length;
        this.width = width;
        this.area = calculateArea();
    }

    // Method to calculate area
    private double calculateArea() {
        return length * width;
    }

    @Override
    public String toString() {
        return "Plot ID: " + plotId + ", Length: " + length + "m, Width: " + width + "m, Area: " + area + " sq.m";
    }

    // Getter for area
    public double getArea() {
        return area;
    }
}

public class Main { 
    private static ArrayList<LandPlot> plots = new ArrayList<>();

    public static void displayMenu() {
        System.out.println("\n=== Land Area Calculation System ===");
        System.out.println("1. Add New Land Plot");
        System.out.println("2. View All Plots");
        System.out.println("3. Calculate Total Area");
        System.out.println("4. Exit");
        System.out.println("====================================");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            System.out.print("Enter your choice (1-4): ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter Plot ID: ");
                    String plotId = scanner.nextLine();
                    try {
                        System.out.print("Enter Length (in meters): ");
                        double length = Double.parseDouble(scanner.nextLine());
                        System.out.print("Enter Width (in meters): ");
                        double width = Double.parseDouble(scanner.nextLine());

                        if (length <= 0 || width <= 0) {
                            System.out.println("Error: Dimensions must be positive numbers.");
                        } else {
                            LandPlot plot = new LandPlot(plotId, length, width);
                            plots.add(plot);
                            System.out.println("Plot added successfully!");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Please enter valid numeric dimensions.");
                    }
                    break;

                case "2":
                    if (plots.isEmpty()) {
                        System.out.println("No plots available.");
                    } else {
                        System.out.println("\n--- All Plots ---");
                        for (LandPlot plot : plots) {
                            System.out.println(plot);
                        }
                    }
                    break;

                case "3":
                    if (plots.isEmpty()) {
                        System.out.println("No plots to calculate area.");
                    } else {
                        double totalArea = 0;
                        for (LandPlot plot : plots) {
                            totalArea += plot.getArea();
                        }
                        System.out.println("Total Area of All Plots: " + totalArea + " sq.m");
                    }
                    break;

                case "4":
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
