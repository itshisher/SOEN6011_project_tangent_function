package com.soen6011.project;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;

/**
 * Main class to set up and display the GUI for the Transcendental Function Calculator.
 */
public class Main {

    // Private constructor to prevent instantiation
    private Main() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static void main(String[] args) {
        // Run the GUI creation on the Event Dispatch Thread
        SwingUtilities.invokeLater(Main::createAndShowGUI);
    }

    /**
     * Creates and displays the GUI components.
     */
    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Transcendental Function Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 350);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel welcomeLabel = new JLabel("Welcome to the Transcendental Function Calculator", JLabel.CENTER);
        panel.add(welcomeLabel, gbc);

        JLabel valueLabel = new JLabel("Enter the value for the Tangent Function:");
        gbc.gridy++;
        gbc.gridwidth = 1;
        panel.add(valueLabel, gbc);

        JTextField valueField = new JTextField(10);
        gbc.gridx++;
        panel.add(valueField, gbc);

        JLabel angleTypeLabel = new JLabel("Is this value in degrees or radians? (D/R):");
        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(angleTypeLabel, gbc);

        JTextField angleTypeField = new JTextField(2);
        gbc.gridx++;
        panel.add(angleTypeField, gbc);

        JButton calculateButton = new JButton("Calculate");
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        panel.add(calculateButton, gbc);

        JLabel resultLabel = new JLabel("", JLabel.CENTER);
        resultLabel.setPreferredSize(new Dimension(400, 30));
        gbc.gridy++;
        panel.add(resultLabel, gbc);

        JButton exitButton = new JButton("Exit");
        gbc.gridy++;
        panel.add(exitButton, gbc);

        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        calculateButton.addActionListener(e -> processCalculation(valueField, angleTypeField, resultLabel));
        exitButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Thanks for using the Transcendental Function Calculator!\nGoodbye!");
            System.exit(0);
        });
    }

    /**
     * Handles the calculation and display of the tangent value.
     */
    private static void processCalculation(JTextField valueField, JTextField angleTypeField, JLabel resultLabel) {
        try {
            double value = Double.parseDouble(valueField.getText());

            // Ensure the angle type input is not empty
            String angleTypeInput = angleTypeField.getText().toUpperCase(Locale.ROOT);
            if (angleTypeInput.isEmpty()) {
                resultLabel.setText("Please enter an angle type (D/R).");
                return;
            }

            char angleType = angleTypeInput.charAt(0);

            if (angleType == 'D') {
                value = Math.toRadians(value);
            } else if (angleType != 'R') {
                resultLabel.setText("Invalid input for angle type. Please enter 'D' or 'R'.");
                return;
            }

            double tangent = Tangent.calculateTangent(value);
            resultLabel.setText("The value of tan(" + value + " in " + (angleType == 'D' ? "degrees" : "radians") + ") is: " + tangent);
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid input. Please enter a numeric value.");
        } catch (ArithmeticException ex) {
            resultLabel.setText(ex.getMessage());
        }
    }

}
