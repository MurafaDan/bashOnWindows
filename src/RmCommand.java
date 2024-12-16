import javax.swing.*;
import java.io.File;

public class RmCommand implements CommandHandler {
    private JTextArea outputArea;
    private CommandProcessor processor;

    public RmCommand(JTextArea outputArea, CommandProcessor processor) {
        this.outputArea = outputArea;
        this.processor = processor;
    }

    @Override
    public void execute(String args) {
        if (args.isEmpty()) {
            outputArea.append("\nUsage: rm <filename>");
            return;
        }

        File file = new File(processor.getCurrentDirectory(), args);
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                outputArea.append("\nFile " + args + " deleted.");
            } else {
                outputArea.append("\nFailed to delete file: " + args);
            }
        } else {
            outputArea.append("\nFile not found: " + args);
        }
    }
}
