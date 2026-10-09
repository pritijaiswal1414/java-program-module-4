
import java.awt.*;
import java.awt.event.*;

class q6 extends Frame implements ActionListener {

    Label title, l1, l2, l3, l4, l5, l6, l7;
    TextField name, father, age;
    Checkbox male, female, drawing, singing, music, others;
    CheckboxGroup gender;
    Choice course;
    TextArea address;
    Button save, clear;

    q6() {
        setTitle("User Registration Form");
        setSize(950, 600);
        setLayout(null);
        setBackground(new Color(52, 58, 72));

        title = new Label("Registration Form");
        title.setBounds(260, 15, 300, 35);
        title.setForeground(Color.YELLOW);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        add(title);

        Font f = new Font("Arial", Font.PLAIN, 16);

        l1 = new Label("Name");
        l2 = new Label("Father Name");
        l3 = new Label("Age");
        l4 = new Label("Gender");
        l5 = new Label("Course");
        l6 = new Label("Hobbies");
        l7 = new Label("Address");

        Label[] labels = {l1, l2, l3, l4, l5, l6, l7};

        int y = 70;
        for (Label l : labels) {
            l.setBounds(230, y, 130, 30);
            l.setForeground(Color.WHITE);
            l.setFont(f);
            add(l);
            y += 48;
        }

        name = new TextField("Ram");
        father = new TextField("Kumar");
        age = new TextField("23");

        name.setBounds(375, 68, 385, 30);
        father.setBounds(375, 116, 385, 30);
        age.setBounds(375, 164, 385, 30);

        add(name);
        add(father);
        add(age);

        gender = new CheckboxGroup();

        male = new Checkbox("Male", gender, true);
        female = new Checkbox("Female", gender, false);

        male.setBounds(375, 215, 90, 25);
        female.setBounds(470, 215, 100, 25);

        male.setForeground(Color.WHITE);
        female.setForeground(Color.WHITE);
        male.setBackground(getBackground());
        female.setBackground(getBackground());

        add(male);
        add(female);

        course = new Choice();
        course.add("Java");
        course.add("Python");
        course.add("C++");
        course.add("Web Development");
        course.setBounds(375, 260, 385, 28);
        add(course);

        drawing = new Checkbox("Drawing");
        singing = new Checkbox("Singing");
        music = new Checkbox("Music");
        others = new Checkbox("Others");

        Checkbox[] hobbies = {drawing, singing, music, others};
        int x = 375;

        for (Checkbox c : hobbies) {
            c.setBounds(x, 310, 90, 25);
            c.setForeground(Color.WHITE);
            c.setBackground(getBackground());
            add(c);
            x += 95;
        }

        drawing.setState(true);

        address = new TextArea(
                "234 - 1d First Street,\nAnna Main Road\nNamakkkal",
                3, 30, TextArea.SCROLLBARS_BOTH
        );
        address.setBounds(375, 355, 385, 95);
        add(address);

        save = new Button("Save Details");
        clear = new Button("Clear All");

        save.setBounds(375, 480, 145, 30);
        clear.setBounds(530, 480, 145, 30);

        save.setBackground(Color.BLUE);
        save.setForeground(Color.WHITE);

        clear.setBackground(Color.RED);
        clear.setForeground(Color.WHITE);

        add(save);
        add(clear);

        save.addActionListener(this);
        clear.addActionListener(this);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == save) {
            String g = gender.getSelectedCheckbox().getLabel();

            String h = "";
            if (drawing.getState()) h += "Drawing ";
            if (singing.getState()) h += "Singing ";
            if (music.getState()) h += "Music ";
            if (others.getState()) h += "Others ";

            String details =
                    "Registration Successful!\n\n" +
                            "Name: " + name.getText() + "\n" +
                            "Father Name: " + father.getText() + "\n" +
                            "Age: " + age.getText() + "\n" +
                            "Gender: " + g + "\n" +
                            "Course: " + course.getSelectedItem() + "\n" +
                            "Hobbies: " + h + "\n" +
                            "Address: " + address.getText();

            MessageBox(details);
        }

        if (e.getSource() == clear) {
            name.setText("");
            father.setText("");
            age.setText("");
            gender.setSelectedCheckbox(male);
            course.select(0);
            drawing.setState(false);
            singing.setState(false);
            music.setState(false);
            others.setState(false);
            address.setText("");
        }
    }

    void MessageBox(String message) {
        Dialog d = new Dialog(this, "Registration Details", true);
        d.setLayout(new BorderLayout());

        TextArea output = new TextArea(message, 8, 35,
                TextArea.SCROLLBARS_VERTICAL_ONLY);
        output.setEditable(false);
        d.add(output, BorderLayout.CENTER);

        Button ok = new Button("OK");
        Panel p = new Panel();
        p.add(ok);
        d.add(p, BorderLayout.SOUTH);

        ok.addActionListener(e -> d.dispose());

        d.setSize(400, 300);
        d.setLocationRelativeTo(this);
        d.setVisible(true);
    }

    public static void main(String[] args) {
        new q6();
    }
}

