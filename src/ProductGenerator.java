import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductGenerator {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Product> products = new ArrayList<>();
        boolean moreProducts = true;

        while (moreProducts) {
            System.out.println("Enter details for a new product:");

            String name = SafeInput.getNonZeroLenString(in, "Enter product name");
            String description = SafeInput.getNonZeroLenString(in, "Enter product description");
            String id = SafeInput.getNonZeroLenString(in, "Enter product ID");
            double cost = SafeInput.getRangedDouble(in, "Enter product cost", 0.0, 10000.0);

            Product product = new Product(name, description, id, cost);
            products.add(product);

            moreProducts = SafeInput.getYNConfirm(in, "Would you like to add another product?");
        }

        // Write the products to a file in CSV format
        String filePath = "products.csv";
        try {
            writeProductsToCSV(products, filePath);
            System.out.println("Products saved to " + filePath);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

        in.close();
    }

    /**
     * Writes an ArrayList of Products to a CSV file.
     *
     * @param products The list of products to write.
     * @param filePath The file path where the products will be saved.
     * @throws IOException If there is an error while writing to the file.
     */
    public static void writeProductsToCSV(ArrayList<Product> products, String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (Product product : products) {
                writer.write(product.toCSV() + "\n");
            }
        }
    }
}
