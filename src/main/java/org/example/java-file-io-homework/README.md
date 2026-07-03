# Java File I/O Homework

Covers all 4 requirements from the whiteboard:

| # | Requirement | Where it's done |
|---|---|---|
| 1.1 | Write student data (code, name, gender, address) to `Mydata1.txt` with `FileWriter` | `TextFile.write()` |
| 1.2 | Read it back and print with `BufferedReader`/`FileReader` | `TextFile.read()` |
| 2.1 | Write the same data to `Mydata2.bin` with `FileOutputStream` + `DataOutputStream` | `BinaryFile.write()` |
| 2.2 | Read it back with `FileInputStream` + `DataInputStream` | `BinaryFile.read()` |
| 3 | Append data (code, name, price) typed from the keyboard to `Adata.txt` or `Adata.bin` | `TextFile.append()` / `BinaryFile.append()` |
| 4 | Read the appended data back and display it | `TextFile.readAppended()` / `BinaryFile.readAppended()` |

## Files
- `Student.java` — model for code/name/gender/address
- `AppendRecord.java` — model for code/name/price (part 3 & 4)
- `TextFile.java` — text-mode read/write/append
- `BinaryFile.java` — binary-mode read/write/append
- `Main.java` — runs everything end-to-end, prompts you on the keyboard for part 3

## How to run
```bash
javac *.java
java Main
```
You'll be prompted to pick `1` (Adata.txt) or `2` (Adata.bin), then enter a code, name, and price.

Edit the sample student list near the top of `Main.java` (`members` list) to put in
your own group's real names/genders/addresses before submitting.
