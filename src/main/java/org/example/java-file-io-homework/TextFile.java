import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Requirement 1: TextFile class
 *  1.1 write(...)  -> writes student data to a .txt file using FileWriter
 *  1.2 read(...)   -> reads student data back using BufferedReader/FileReader
 *
 * Also reused for Requirement 3 & 4 (appending / reading AppendRecord data
 * to/from a text file such as Adata.txt).
 */
public class TextFile {

    // 1.1 Write the whole list of students to a text file (overwrite)
    public void write(List<Student> students, String fileName) {
        // FileWriter is one valid option mentioned on the board
        try (FileWriter fw = new FileWriter(fileName)) {
            for (Student s : students) {
                fw.write(s.toCsvLine());
                fw.write(System.lineSeparator());
            }
            System.out.println("Wrote " + students.size() + " student(s) to " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing " + fileName + ": " + e.getMessage());
        }
    }

    // 1.2 Read student data back and display on screen
    public List<Student> read(String fileName) {
        List<Student> result = new ArrayList<>();
        // BufferedReader wrapping FileReader is the classic combo from the board
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.isBlank()) {
                    result.add(Student.fromCsvLine(line));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading " + fileName + ": " + e.getMessage());
        }
        return result;
    }

    // --- Requirement 3 & 4: append / read AppendRecord (code, name, price) ---

    // Append one record from the keyboard to a text file, keeping existing content
    public void append(AppendRecord record, String fileName) {
        try (FileWriter fw = new FileWriter(fileName, true)) { // true = append mode
            fw.write(record.toCsvLine());
            fw.write(System.lineSeparator());
            System.out.println("Appended record to " + fileName);
        } catch (IOException e) {
            System.out.println("Error appending to " + fileName + ": " + e.getMessage());
        }
    }

    // Read appended records back from a text file
    public List<AppendRecord> readAppended(String fileName) {
        List<AppendRecord> result = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.isBlank()) {
                    result.add(AppendRecord.fromCsvLine(line));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading " + fileName + ": " + e.getMessage());
        }
        return result;
    }
}
