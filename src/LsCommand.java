import javax.swing.*;
import java.io.File;

public class LsCommand implements CommandHandler {
    private JTextArea outputArea;
    private CommandProcessor processor;

    public LsCommand(JTextArea outputArea, CommandProcessor processor) {
        this.outputArea = outputArea;
        this.processor = processor;
    }

    @Override
    public void execute(String args) {
        File dir = new File(processor.getCurrentDirectory());
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                outputArea.append("\n" + (file.isDirectory() ? "[DIR] " : "") + file.getName());
            }
        } else {
            outputArea.append("\nUnable to list files.");
        }
    }
}
