import javax.swing.*;
import java.io.File;

public class CdCommand implements CommandHandler {
    private JTextArea outputArea;
    private CommandProcessor processor;

    public CdCommand(JTextArea outputArea, CommandProcessor processor) {
        this.outputArea = outputArea;
        this.processor = processor;
    }

    @Override
    public void execute(String args) {
        if (args.isEmpty()) {
            outputArea.append("\nUsage: cd <path>");
            return;
        }

        File dir;
        if (args.equals("..")) {
            dir = new File(processor.getCurrentDirectory()).getParentFile();
        } else {
            dir = new File(processor.getCurrentDirectory(), args);
        }

        if (dir != null && dir.exists() && dir.isDirectory()) {
            processor.setCurrentDirectory(dir.getAbsolutePath());
            outputArea.append("\nChanged directory to: " + processor.getCurrentDirectory());
        } else {
            outputArea.append("\nDirectory not found: " + args);
        }
    }
}
