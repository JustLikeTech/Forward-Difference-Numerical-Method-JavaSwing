import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ForwardDifferenceUI {
    // Method to set up the GUI
    public static void createAndShowGUI() {
        // Create the main frame
        JFrame frame = new JFrame("Forward Difference Method");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // Create the panel to hold components
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Padding for components

        // Create input fields and labels
        JLabel lblLowerBound = new JLabel("Bottom Limit (a):");
        JTextField txtLowerBound = new JTextField(10);
        JLabel lblUpperBound = new JLabel("Upper Limit (b):");
        JTextField txtUpperBound = new JTextField(10);
        JLabel lblStepSize = new JLabel("Step Value (h):");
        JTextField txtStepSize = new JTextField(10);

        // Create a button to trigger the calculation
        JButton btnCalculate = new JButton("Process");

        // Create a text area to display the results
        JTextArea textAreaResults = new JTextArea(10, 40);
        textAreaResults.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textAreaResults);

        // Place components in the panel using GridBagLayout
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(lblLowerBound, gbc);
        gbc.gridx = 1;
        panel.add(txtLowerBound, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(lblUpperBound, gbc);
        gbc.gridx = 1;
        panel.add(txtUpperBound, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(lblStepSize, gbc);
        gbc.gridx = 1;
        panel.add(txtStepSize, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(btnCalculate, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        panel.add(scrollPane, gbc);

        // Add the panel to the frame
        frame.add(panel);

        // Add action listener to the "Hitung" button
        btnCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Get the user inputs
                    double a = Double.parseDouble(txtLowerBound.getText());
                    double b = Double.parseDouble(txtUpperBound.getText());
                    double h = Double.parseDouble(txtStepSize.getText());

                    // Perform the forward difference calculation
                    StringBuilder results = new StringBuilder();
                    results.append(String.format("%-10s %-10s %-15s %-15s %-15s%n", "x", "f(x)", "Approx f'(x)",
                            "Exact f'(x)", "Error"));

                    double totalError = 0;
                    int count = 0;

                    for (double x = a; x <= b; x += h) {
                        var fx = f(x); // f(x) = e^(-x) * sin(2x) + 1
                        // double approxDerivative = forwardDifference(x, h);
                        double approxDerivative = f(x+h);
                        double exactDerivative = (approxDerivative-fx) / h;
                        double error = Math.abs(exactDerivative);

                        // Append result with 3 decimal places formatting
                        results.append(String.format("%-10.3f %-10.3f %-15.3f %-15.3f %-15.3f%n", x, fx,
                                approxDerivative, exactDerivative, error));

                        totalError += error;
                        count++;
                    }

                    // Display the results in the text area
                    textAreaResults.setText(results.toString());

                    // Calculate and display the average error in a message dialog
                    double averageError = totalError / count;
                    JOptionPane.showMessageDialog(frame, "Error Average : " + averageError, "Average Error",
                            JOptionPane.INFORMATION_MESSAGE);

                } catch (NumberFormatException ex) {
                    // Show an error message if the input is not valid
                    JOptionPane.showMessageDialog(frame, "Please enter valid numbers for a, b, and h.", "Input Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
            
            private double f(double x) {
                return x * x;
            }

            private double fEksak(double x) {
                return x * 2;
            }
        });

        // Display the frame
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Run the GUI in the event-dispatching thread for thread safety
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
