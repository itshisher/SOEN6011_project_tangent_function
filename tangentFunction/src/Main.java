import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        // Run the GUI creation on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    // Method to create and display the GUI
    private static void createAndShowGUI() {
        // Create the main frame (window)
        JFrame frame = new JFrame("Transcendental Function Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 350);

        // Create the main panel with padding
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        panel.setLayout(new GridBagLayout());

        // Create UI components
        JLabel welcomeLabel = new JLabel("Welcome to the Transcendental Function Calculator", JLabel.CENTER);
        JLabel valueLabel = new JLabel("Enter the value for the Tangent Function:");
        JTextField valueField = new JTextField(10);
        JLabel angleTypeLabel = new JLabel("Is this value in degrees or radians? (D/R):");
        JTextField angleTypeField = new JTextField(2);
        JButton calculateButton = new JButton("Calculate");
        JButton exitButton = new JButton("Exit");
        JLabel resultLabel = new JLabel("", JLabel.CENTER);
        resultLabel.setPreferredSize(new Dimension(400, 30));

        // Layout constraints for GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Padding around components
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Span 2 columns
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Add components to the panel with layout constraints
        panel.add(welcomeLabel, gbc);

        gbc.gridy++; // Move to the next column
        gbc.gridwidth = 1; // Reset to span 1 column
        panel.add(valueLabel, gbc); // Add field at this position

        gbc.gridx++;
        panel.add(valueField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(angleTypeLabel, gbc);

        gbc.gridx++;
        panel.add(angleTypeField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2; // Span 2 columns
        panel.add(calculateButton, gbc);

        gbc.gridy++;
        panel.add(resultLabel, gbc);

        // Add exit button below the result label
        gbc.gridy++;
        panel.add(exitButton, gbc);

        // Add panel to the frame
        frame.add(panel);

        // Action listener for the calculate button
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Parse the input value
                    double value = Double.parseDouble(valueField.getText());
                    char angleType = angleTypeField.getText().toUpperCase().charAt(0);

                    // Convert degrees to radians if necessary
                    if (angleType == 'D') {
                        value = Math.toRadians(value);
                    } else if (angleType != 'R') {
                        // Handle invalid angle type input
                        resultLabel.setText("Invalid input for angle type. Please enter 'D' or 'R'.");
                        return;
                    }

                    try {
                        // Calculate the tangent and display the result
                        double tangent = Tangent.calculateTangent(value);
                        resultLabel.setText("The value of tan(" + value + " in " + (angleType == 'D' ? "degrees" : "radians") + ") is: " + tangent);
                    } catch (ArithmeticException ex) {
                        // Handle cases where tangent is undefined
                        resultLabel.setText("The tangent is undefined for this value.");
                    }
                } catch (NumberFormatException ex) {
                    // Handle invalid numeric input
                    resultLabel.setText("Invalid input. Please enter a numeric value.");
                } catch (StringIndexOutOfBoundsException ex) {
                    // Handle missing angle type input
                    resultLabel.setText("Please enter an angle type (D/R).");
                }
            }
        });

        // Action listener for the exit button
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Display goodbye message
                JOptionPane.showMessageDialog(frame, "Thanks for using the Transcendental Function Calculator!\nGoodbye!");
                // Exit the application
                System.exit(0);
            }
        });

        // Center the frame on the screen
        frame.setLocationRelativeTo(null);

        // Display the window
        frame.setVisible(true);
    }
}
