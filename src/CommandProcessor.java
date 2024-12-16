import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class CommandProcessor {
    private String currentDirectory = System.getProperty("user.dir");
    private JTextArea outputArea;
    private JScrollPane scrollPane;
    private Map<String, CommandHandler> commandRegistry;

    public CommandProcessor(JTextArea outputArea, JScrollPane scrollPane) {
        this.outputArea = outputArea;
        this.scrollPane = scrollPane;
        this.commandRegistry = new HashMap<>();

        // Register commands
        commandRegistry.put("exit", new ExitCommand());
        commandRegistry.put("pwd", new PwdCommand(outputArea, this));
        commandRegistry.put("ls", new LsCommand(outputArea, this));
        commandRegistry.put("clear", new ClearCommand(outputArea));
        commandRegistry.put("help", new HelpCommand(outputArea));
        commandRegistry.put("cat", new CatCommand(outputArea, this));
        commandRegistry.put("mkdir", new MkdirCommand(outputArea, this));
        commandRegistry.put("cd", new CdCommand(outputArea, this));
        commandRegistry.put("nano", new NanoCommand(outputArea, this));
        commandRegistry.put("rm", new RmCommand(outputArea, this));
    }

    public void processCommand(String input) {
        outputArea.append("\n" + currentDirectory + " > " + input);
        String[] parts = input.split("\\s+", 2);
        String command = parts[0];
        String args = parts.length > 1 ? parts[1] : "";

        CommandHandler handler = commandRegistry.get(command);

        if (handler != null) {
            handler.execute(args);
        } else {
            outputArea.append("\nUnknown command: " + command);
        }

        scrollToBottom();
        outputArea.append("\n" + currentDirectory + " > ");
    }

    public void setCurrentDirectory(String newDir) {
        currentDirectory = newDir;
    }

    public String getCurrentDirectory() {
        return currentDirectory;
    }

    private void scrollToBottom() {
        SwingUtilities.invokeLater(() -> {
            JScrollBar vertical = scrollPane.getVerticalScrollBar();
            vertical.setValue(vertical.getMaximum());
        });
    }
}
