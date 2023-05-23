package Typed_text;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TypedText extends JFrame implements ActionListener {
    private TextArea textArea;
    private Button saveButton;
    public TypedText() {
        super();
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        textArea = new TextArea();
        add(textArea, BorderLayout.CENTER);
        saveButton = new Button("Save");
        saveButton.addActionListener(this);
        add(saveButton, BorderLayout.SOUTH);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == saveButton) {
            String text = textArea.getText();
            try {
                FileWriter writer = new FileWriter("text.txt");
                BufferedWriter bufferedWriter = new BufferedWriter(writer);
                bufferedWriter.write(text);
                bufferedWriter.close();
                System.out.println("Текст сохранен в файле text.txt");
            } catch (IOException ex) {
                System.out.println("Ошибка при сохранении файла");
            }
        }
    }
    public static void main(String[] args) {
        new TypedText();
    }
}