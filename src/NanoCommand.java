import javax.swing.*;
import java.io.*;

public class NanoCommand implements CommandHandler {
    private JTextArea outputArea;
    private CommandProcessor processor;

    public NanoCommand(JTextArea outputArea, CommandProcessor processor) {
        this.outputArea = outputArea;
        this.processor = processor;
    }

    @Override
    public void execute(String args) {
        if (args.isEmpty()) {
            outputArea.append("\nUsage: nano <filename>");
            return;
        }

        try {
            File file = new File(processor.getCurrentDirectory(), args);
            if (!file.exists()) {
                outputArea.append("\nFile does not exist. Creating a new file...");
                file.createNewFile();
            }
            // Open the file in Notepad (simulating nano)
            new ProcessBuilder("notepad.exe", file.getAbsolutePath()).start();
        } catch (IOException e) {
            outputArea.append("\nError opening file: " + e.getMessage());
        }
    }
}
