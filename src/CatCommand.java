import javax.swing.*;
import java.io.*;

public class CatCommand implements CommandHandler {
    private JTextArea outputArea;
    private CommandProcessor processor;

    public CatCommand(JTextArea outputArea, CommandProcessor processor) {
        this.outputArea = outputArea;
        this.processor = processor;
    }

    @Override
    public void execute(String args) {
        if (args.isEmpty()) {
            outputArea.append("\nUsage: cat <filename>");
            return;
        }

        File file = new File(processor.getCurrentDirectory(), args);
        if (file.exists() && file.isFile()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    outputArea.append("\n" + line);
                }
            } catch (IOException e) {
                outputArea.append("\nError reading file: " + e.getMessage());
            }
        } else {
            outputArea.append("\nFile not found: " + args);
        }
    }
}
