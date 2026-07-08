package org.example.Homework2;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.IOException;

// Helper class needed because ObjectOutputStream normally writes a stream
// header every time it is constructed. When appending Product objects to
// an existing .bin file that already has a header, we must skip writing
// a second header, otherwise ObjectInputStream will fail to read the file
// back correctly. Used by ReadObject.java and AppendObject.java.
public class AppendableObjectOutputStream extends ObjectOutputStream {
    public AppendableObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    @Override
    protected void writeStreamHeader() throws IOException {
        // do nothing -> avoids writing a new header when appending
        reset();
    }
}
