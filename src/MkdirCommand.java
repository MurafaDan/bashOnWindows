import javax.swing.*;
import java.io.File;

public class MkdirCommand implements CommandHandler {
    private JTextArea outputArea;
    private CommandProcessor processor;

    public MkdirCommand(JTextArea outputArea, CommandProcessor processor) {
        this.outputArea = outputArea;
        this.processor = processor;
    }

    @Override
    public void execute(String args) {
        if (args.isEmpty()) {
            outputArea.append("\nUsage: mkdir <directory>");
            return;
        }

        File dir = new File(processor.getCurrentDirectory(), args);
        if (dir.mkdir()) {
            outputArea.append("\nDirectory created: " + dir.getAbsolutePath());
        } else {
            outputArea.append("\nFailed to create directory: " + args);
        }
    }
}
