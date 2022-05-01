package example_decorator.refactoring_guru_decorator;

import java.io.*;

public class FileDataSource implements DataSource{
    private final String name;

    public FileDataSource(String name) {
        this.name = name;
    }

    @Override
    public void writeData(String data) {
        File file = new File(name);
        try (OutputStream fos = new FileOutputStream(file)) {
            fos.write(data.getBytes(), 0, data.length());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public String readData() {
        char[] buffer = null;
        File file = new File(name);
        try (FileReader reader = new FileReader(file)) {
            buffer = new char[(int) file.length()];
            int read = reader.read(buffer);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        assert buffer != null;
        return new String(buffer);
    }
}
