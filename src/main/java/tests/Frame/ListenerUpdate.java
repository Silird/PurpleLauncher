package tests.Frame;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import tests.JsonClasses.JsonClass;
import tests.TestMain;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListenerUpdate implements ActionListener {
    private TestFrame frame;

    public ListenerUpdate(TestFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String json = TestMain.read();

            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            JsonClass jsonClass = gson.fromJson(json, JsonClass.class);

            frame.updateComboBox(jsonClass.getVersions());
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
