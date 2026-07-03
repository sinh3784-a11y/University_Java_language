/**
 * Simple data class representing one student record:
 * code, name, gender, address.
 */
public class Student {
    private String code;
    private String name;
    private String gender;
    private String address;

    public Student(String code, String name, String gender, String address) {
        this.code = code;
        this.name = name;
        this.gender = gender;
        this.address = address;
    }

    public String getCode()    { return code; }
    public String getName()    { return name; }
    public String getGender()  { return gender; }
    public String getAddress() { return address; }

    // Used by TextFile to write one line as "code,name,gender,address"
    public String toCsvLine() {
        return code + "," + name + "," + gender + "," + address;
    }

    // Build a Student back from a csv line
    public static Student fromCsvLine(String line) {
        String[] parts = line.split(",", -1);
        return new Student(parts[0], parts[1], parts[2], parts[3]);
    }

    @Override
    public String toString() {
        return String.format("Code: %-6s Name: %-15s Gender: %-8s Address: %s",
                code, name, gender, address);
    }
}
