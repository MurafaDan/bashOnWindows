import javax.swing.*;

public class PwdCommand implements CommandHandler {
    private JTextArea outputArea;
    private CommandProcessor processor;

    public PwdCommand(JTextArea outputArea, CommandProcessor processor) {
        this.outputArea = outputArea;
        this.processor = processor;
    }

    @Override
    public void execute(String args) {
        outputArea.append("\n" + processor.getCurrentDirectory());
    }
}
