import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AttendanceManagementSystem extends JFrame implements ActionListener {
    private JLabel label1, label2, label3;
    private JTextField studentIDField, studentNameField;
    private JButton markAttendanceButton, viewAttendanceButton, clearButton, exitButton;
    private JPanel panel;
    private Map<String, ArrayList<String>> attendanceRecords = new HashMap<>();

    public AttendanceManagementSystem() {
        setTitle("Attendance Management System");
        setSize(600, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        label1 = new JLabel("Student ID");
        label2 = new JLabel("Student Name");
        label3 = new JLabel();

        studentIDField = new JTextField(10);
        studentNameField = new JTextField(20);

        markAttendanceButton = new JButton("Mark Attendance");
        viewAttendanceButton = new JButton("View Attendance");
        clearButton = new JButton("Clear");
        exitButton = new JButton("Exit");

        markAttendanceButton.addActionListener(this);
        viewAttendanceButton.addActionListener(this);
        clearButton.addActionListener(this);
        exitButton.addActionListener(this);

        panel = new JPanel(new GridLayout(5, 2));
        panel.add(label1);
        panel.add(studentIDField);
        panel.add(label2);
        panel.add(studentNameField);
        panel.add(markAttendanceButton);
        panel.add(viewAttendanceButton);
        panel.add(clearButton);
        panel.add(exitButton);
        panel.add(label3);

        add(panel);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == markAttendanceButton) {
            String studentID = studentIDField.getText();
            String studentName = studentNameField.getText();

            if (!studentID.isEmpty() && !studentName.isEmpty()) {
                ArrayList<String> attendanceList = attendanceRecords.getOrDefault(studentID, new ArrayList<>());
                attendanceList.add(studentName);
                attendanceRecords.put(studentID, attendanceList);

                JOptionPane.showMessageDialog(this, "Attendance marked for " + studentName);
                clearFields();
            } else {
                JOptionPane.showMessageDialog(this, "Please enter Student ID and Student Name");
            }
        } else if (e.getSource() == viewAttendanceButton) {
            String studentID = studentIDField.getText();
            ArrayList<String> attendanceList = attendanceRecords.get(studentID);

            if (attendanceList != null) {
                StringBuilder attendanceDetails = new StringBuilder("Attendance for Student ID: " + studentID + "\n");
                for (String student : attendanceList) {
                    attendanceDetails.append(student).append("\n");
                }
                label3.setText(attendanceDetails.toString());
            } else {
                JOptionPane.showMessageDialog(this, "No attendance found for the given Student ID");
            }
        } else if (e.getSource() == clearButton) {
            clearFields();
            label3.setText("");
        } else if (e.getSource() == exitButton) {
            System.exit(0);
        }
    }
    private void clearFields() {
        studentIDField.setText("");
        studentNameField.setText("");
    }
public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
        new AttendanceManagementSystem().setVisible(true);
    });
}
}