import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Requirement 2: BinaryFile class
 *  2.1 write(...) -> writes student data to a .bin file using
 *                    FileOutputStream + DataOutputStream
 *  2.2 read(...)  -> reads student data back using
 *                    FileInputStream + DataInputStream
 *
 * Also reused for Requirement 3 & 4 (appending / reading AppendRecord data
 * to/from a binary file such as Adata.bin).
 */
public class BinaryFile {

    // 2.1 Write the whole list of students to a binary file (overwrite)
    public void write(List<Student> students, String fileName) {
        try (DataOutputStream dos = new DataOutputStream(
                new FileOutputStream(fileName))) {
            dos.writeInt(students.size()); // store count first so we know when to stop reading
            for (Student s : students) {
                dos.writeUTF(s.getCode());
                dos.writeUTF(s.getName());
                dos.writeUTF(s.getGender());
                dos.writeUTF(s.getAddress());
            }
            System.out.println("Wrote " + students.size() + " student(s) to " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing " + fileName + ": " + e.getMessage());
        }
    }

    // 2.2 Read student data back and display on screen
    public List<Student> read(String fileName) {
        List<Student> result = new ArrayList<>();
        try (DataInputStream dis = new DataInputStream(
                new FileInputStream(fileName))) {
            int count = dis.readInt();
            for (int i = 0; i < count; i++) {
                String code = dis.readUTF();
                String name = dis.readUTF();
                String gender = dis.readUTF();
                String address = dis.readUTF();
                result.add(new Student(code, name, gender, address));
            }
        } catch (IOException e) {
            System.out.println("Error reading " + fileName + ": " + e.getMessage());
        }
        return result;
    }

    // --- Requirement 3 & 4: append / read AppendRecord (code, name, price) ---

    // Binary files don't support true in-place "append + keep old count" writes
    // easily, so we read existing records first, add the new one, then rewrite.
    public void append(AppendRecord record, String fileName) {
        List<AppendRecord> existing = readAppended(fileName); // empty list if file doesn't exist yet
        existing.add(record);
        try (DataOutputStream dos = new DataOutputStream(
                new FileOutputStream(fileName))) {
            dos.writeInt(existing.size());
            for (AppendRecord r : existing) {
                dos.writeUTF(r.getCode());
                dos.writeUTF(r.getName());
                dos.writeDouble(r.getPrice());
            }
            System.out.println("Appended record to " + fileName);
        } catch (IOException e) {
            System.out.println("Error appending to " + fileName + ": " + e.getMessage());
        }
    }

    // Read appended records back from a binary file
    public List<AppendRecord> readAppended(String fileName) {
        List<AppendRecord> result = new ArrayList<>();
        File f = new File(fileName);
        if (!f.exists()) return result;

        try (DataInputStream dis = new DataInputStream(
                new FileInputStream(fileName))) {
            int count = dis.readInt();
            for (int i = 0; i < count; i++) {
                String code = dis.readUTF();
                String name = dis.readUTF();
                double price = dis.readDouble();
                result.add(new AppendRecord(code, name, price));
            }
        } catch (IOException e) {
            System.out.println("Error reading " + fileName + ": " + e.getMessage());
        }
        return result;
    }
}
