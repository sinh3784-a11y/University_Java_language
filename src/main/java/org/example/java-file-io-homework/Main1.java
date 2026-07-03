import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Demonstrates all 4 requirements from the homework:
 * 1. TextFile   -> Mydata1.txt
 * 2. BinaryFile -> Mydata2.bin
 * 3. Append data typed from the keyboard (code, name, price) to Adata.txt / Adata.bin
 * 4. Read the appended data back and display it
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // ---- Sample group / student data (edit with your real group members) ----
        List<Student> members = new ArrayList<>();
        members.add(new Student("S001", "Sopheak Chan", "Male",   "Phnom Penh"));
        members.add(new Student("S002", "Dara Meas",    "Male",   "Kandal"));
        members.add(new Student("S003", "Srey Pov Kim", "Female", "Battambang"));
        members.add(new Student("S004", "Vanna Sok",    "Female", "Siem Reap"));

        // ================= Requirement 1: TextFile =================
        System.out.println("===== 1. TextFile: Mydata1.txt =====");
        TextFile textFile = new TextFile();
        textFile.write(members, "Mydata1.txt");          // 1.1 write
        List<Student> fromText = textFile.read("Mydata1.txt"); // 1.2 read
        System.out.println("--- Data read from Mydata1.txt ---");
        for (Student s : fromText) {
            System.out.println(s);
        }

        // ================= Requirement 2: BinaryFile =================
        System.out.println("\n===== 2. BinaryFile: Mydata2.bin =====");
        BinaryFile binaryFile = new BinaryFile();
        binaryFile.write(members, "Mydata2.bin");             // 2.1 write
        List<Student> fromBinary = binaryFile.read("Mydata2.bin"); // 2.2 read
        System.out.println("--- Data read from Mydata2.bin ---");
        for (Student s : fromBinary) {
            System.out.println(s);
        }

        // ================= Requirement 3: Append from keyboard =================
        System.out.println("\n===== 3. Append data from keyboard =====");
        System.out.print("Choose target file type (1 = Adata.txt, 2 = Adata.bin): ");
        String choice = scanner.nextLine().trim();

        System.out.print("Enter code: ");
        String code = scanner.nextLine().trim();
        System.out.print("Enter name: ");
        String name = scanner.nextLine().trim();
        System.out.print("Enter price: ");
        double price = Double.parseDouble(scanner.nextLine().trim());

        AppendRecord record = new AppendRecord(code, name, price);

        String usedFile;
        if (choice.equals("2")) {
            usedFile = "Adata.bin";
            binaryFile.append(record, usedFile);
        } else {
            usedFile = "Adata.txt";
            textFile.append(record, usedFile);
        }

        // ================= Requirement 4: Read appended data back =================
        System.out.println("\n===== 4. Read data from " + usedFile + " =====");
        List<AppendRecord> appended;
        if (usedFile.endsWith(".bin")) {
            appended = binaryFile.readAppended(usedFile);
        } else {
            appended = textFile.readAppended(usedFile);
        }
        for (AppendRecord r : appended) {
            System.out.println(r);
        }

        scanner.close();
    }
}
