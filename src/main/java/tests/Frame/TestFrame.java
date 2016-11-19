package tests.Frame;

import tests.JsonClasses.VersionClass;

import javax.swing.*;
import java.util.List;
import java.util.Objects;

public class TestFrame extends JFrame {
    private JComboBox<VersionClass> comboBox;
    private JCheckBox checkBox;

    public TestFrame() {
        super();

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Какая-то тестовая форма");
        this.setContentPane(new JPanel());
        this.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        comboBox = new JComboBox<>();
        checkBox = new JCheckBox("Только релизы");

        JButton button = new JButton("Обновить");
        button.addActionListener(new ListenerUpdate(this));

        this.add(new JLabel("Какой-то комбобокс:"));
        this.add(comboBox);
        this.add(checkBox);
        this.add(button);

        this.pack();

        this.setVisible(true);
    }

    public void updateComboBox(List<VersionClass> list) {
        comboBox.removeAllItems();

        for (VersionClass version : list) {
            if (!checkBox.isSelected() || version.getType().equals("release")) {
                comboBox.addItem(version);
            }
        }
    }
}
