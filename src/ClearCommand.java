import javax.swing.*;

public class ClearCommand implements CommandHandler {
    private JTextArea outputArea;

    public ClearCommand(JTextArea outputArea) {
        this.outputArea = outputArea;
    }

    @Override
    public void execute(String args) {
        outputArea.setText("");
    }
}
