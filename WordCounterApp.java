package Java_GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class WordCounterApp extends JFrame {
    private JTextArea textArea;
    private JLabel wordCountLabel;
    private JLabel charCountLabel;
    private JLabel paragraphCountLabel;
    public WordCounterApp() {
        setTitle("Word Counter App");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        JButton countButton = new JButton("Count Words");
        countButton.addActionListener(new CountButtonListener());
        wordCountLabel = new JLabel("Word Count: 0");
        charCountLabel = new JLabel("Character Count: 0");
        paragraphCountLabel = new JLabel("Paragraph Count: 0");
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));
        panel.add(scrollPane);
        panel.add(countButton);
        panel.add(wordCountLabel);
        panel.add(charCountLabel);
        panel.add(paragraphCountLabel);
        add(panel);
        setVisible(true);
    }
    private class CountButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String text = textArea.getText();
            int wordCount = countWords(text);
            int charCount = text.length();
            int paragraphCount = countParagraphs(text);
            wordCountLabel.setText("Word Count: " + wordCount);
            charCountLabel.setText("Character Count: " + charCount);
            paragraphCountLabel.setText("Paragraph Count: " + paragraphCount);
        }
        private int countWords(String text) {
            String[] words = text.trim().split("\\s+");
            return words.length;
        }
        private int countParagraphs(String text) {
            String[] paragraphs = text.split("\\n+");
            return paragraphs.length;
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new WordCounterApp();
        });
    }
}