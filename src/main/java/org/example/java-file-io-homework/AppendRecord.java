/**
 * Data class representing one appended record: code, name, price.
 * Used for Requirement 3 & 4 (data typed from the keyboard).
 */
public class AppendRecord {
    private String code;
    private String name;
    private double price;

    public AppendRecord(String code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public String getCode()  { return code; }
    public String getName()  { return name; }
    public double getPrice() { return price; }

    public String toCsvLine() {
        return code + "," + name + "," + price;
    }

    public static AppendRecord fromCsvLine(String line) {
        String[] parts = line.split(",", -1);
        return new AppendRecord(parts[0], parts[1], Double.parseDouble(parts[2]));
    }

    @Override
    public String toString() {
        return String.format("Code: %-6s Name: %-15s Price: %.2f", code, name, price);
    }
}
