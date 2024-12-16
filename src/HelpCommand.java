import javax.swing.*;

public class HelpCommand implements CommandHandler {
    private JTextArea outputArea;

    public HelpCommand(JTextArea outputArea) {
        this.outputArea = outputArea;
    }

    @Override
    public void execute(String args) {
        outputArea.append("\nAvailable commands:");
        outputArea.append("\n  exit    - Exit the shell");
        outputArea.append("\n  pwd     - Print the current directory");
        outputArea.append("\n  ls      - List files in the current directory");
        outputArea.append("\n  cat <file>   - Display the contents of a file");
        outputArea.append("\n  mkdir <directory>  - Create a new directory");
        outputArea.append("\n  cd <path>   - Change directory");
        outputArea.append("\n  nano <filename> - Open a file in Notepad (simulating nano)");
        outputArea.append("\n  rm <file>   - Delete a file");
        outputArea.append("\n  clear  - Clear the terminal output");
        outputArea.append("\n  help   - Show this help message");
    }
}
