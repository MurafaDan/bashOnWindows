import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShellUI {
    private static String currentDirectory = System.getProperty("user.dir");
    private JFrame frame;
    private JTextArea outputArea;
    private JTextField commandField;
    private JScrollPane scrollPane;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ShellUI::new);
    }

    public ShellUI() {
        frame = new JFrame("MiniShell");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Output area
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setBackground(Color.BLACK);
        outputArea.setForeground(Color.WHITE);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        scrollPane = new JScrollPane(outputArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Input field and button
        JPanel inputPanel = new JPanel(new BorderLayout());
        commandField = new JTextField();
        JButton executeButton = new JButton("Execute");

        inputPanel.add(commandField, BorderLayout.CENTER);
        inputPanel.add(executeButton, BorderLayout.EAST);
        frame.add(inputPanel, BorderLayout.SOUTH);

        CommandProcessor commandProcessor = new CommandProcessor(outputArea, scrollPane);

        // Action listeners
        ActionListener commandListener = e -> {
            String command = commandField.getText().trim();
            if (!command.isEmpty()) {
                commandProcessor.processCommand(command);
                commandField.setText("");
            }
        };

        commandField.addActionListener(commandListener);
        executeButton.addActionListener(commandListener);

        // Initial prompt
        outputArea.append(currentDirectory + " > ");
        frame.setVisible(true);
    }
}
