package tests;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import tests.Frame.TestFrame;
import tests.JsonClasses.JsonClass;

import javax.swing.*;
import java.io.*;


public class TestMain {
    public static void main(String[] args) {
        try {
            String json = read();

            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            JsonClass jsonClass = gson.fromJson(json, JsonClass.class);

            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            new TestFrame().updateComboBox(jsonClass.getVersions());
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static String read() throws IOException {
        StringBuilder sb = new StringBuilder();

        File file = new File("versions.json");
        if (!file.exists()) {
            throw  new FileNotFoundException(file.getName());
        }


        try (BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()))) {
            String s;
            while ((s = in.readLine()) != null) {
                sb.append(s);
                sb.append("\n");
            }
        }

        return sb.toString();
    }
}
