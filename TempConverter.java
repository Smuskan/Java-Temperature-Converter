import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class TempConverter extends JFrame {
   JTextField tempInput, tempOutput;
   JLabel inputLabel, convertLabel, outputLabel, authorLabel;
   JComboBox<String> comboBox1, comboBox2;
   JButton button;

   public TempConverter() {
      setTitle("Temperature Converter");
      setSize(450, 600);
      setResizable(false);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      
      Container c = getContentPane();
      c.setLayout(null);
      c.setBackground(new Color(240, 248, 255)); // Light cyan background

      // Header Panel
      JPanel panel = new JPanel();
      panel.setLayout(null);
      panel.setBackground(new Color(100, 149, 237)); // Cornflower blue
      panel.setBounds(0, 0, 450, 100);

      JLabel titleLabel = new JLabel("TEMPERATURE CONVERTER");
      titleLabel.setBounds(25, 15, 400, 50);
      titleLabel.setFont(new Font("Algerian", Font.BOLD, 24));
      titleLabel.setForeground(Color.WHITE);
      panel.add(titleLabel);
      c.add(panel);

      // Input Label
      inputLabel = new JLabel("Degrees:");
      inputLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
      inputLabel.setBounds(30, 120, 100, 25);
      c.add(inputLabel);

      // Type Label
      JLabel typeLabel = new JLabel("Convert From:");
      typeLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
      typeLabel.setBounds(240, 120, 150, 25);
      c.add(typeLabel);

      // Input Field
      tempInput = new JTextField(10);
      tempInput.setFont(new Font("Arial", Font.PLAIN, 16));
      tempInput.setBounds(30, 150, 100, 30);
      tempInput.addKeyListener(new KeyAdapter() {
         public void keyReleased(KeyEvent e) {
            c.setBackground(tempInput.getText().isEmpty() ? new Color(240, 248, 255) : new Color(230, 230, 250)); // Lavender
         }
      });
      c.add(tempInput);

      // ComboBox1 (Convert From)
      String[] options = { "Celsius", "Fahrenheit", "Kelvin" };
      comboBox1 = new JComboBox<>(options);
      comboBox1.setFont(new Font("Book Antiqua", Font.BOLD, 15));
      comboBox1.setBounds(240, 150, 150, 30);
      c.add(comboBox1);

      // Convert To Label
      convertLabel = new JLabel("Convert To:");
      convertLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
      convertLabel.setBounds(30, 210, 150, 25);
      c.add(convertLabel);

      // ComboBox2 (Convert To)
      comboBox2 = new JComboBox<>(options);
      comboBox2.setFont(new Font("Book Antiqua", Font.BOLD, 15));
      comboBox2.setBounds(240, 210, 150, 30);
      c.add(comboBox2);

      // Output Label
      outputLabel = new JLabel("Result:");
      outputLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
      outputLabel.setBounds(30, 270, 100, 25);
      c.add(outputLabel);

      // Output Field
      tempOutput = new JTextField(10);
      tempOutput.setFont(new Font("Arial", Font.PLAIN, 16));
      tempOutput.setBounds(240, 270, 150, 30);
      tempOutput.setEditable(false);
      c.add(tempOutput);

      // Convert Button
      button = new JButton("Convert");
      button.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
      button.setBackground(new Color(173, 216, 230)); // Light blue
      button.setBounds(50, 350, 350, 40);
      button.addActionListener(new ConvertButtonListener());
      c.add(button);

      // Author Label
      authorLabel = new JLabel("Developed by Muskan Shaikh");
      authorLabel.setFont(new Font("Serif", Font.ITALIC, 14));
      authorLabel.setBounds(140, 500, 200, 30);
      authorLabel.setForeground(Color.DARK_GRAY);
      c.add(authorLabel);

      setVisible(true);
   }

   private class ConvertButtonListener implements ActionListener {
      public void actionPerformed(ActionEvent e) {
         String from = (String) comboBox1.getSelectedItem();
         String to = (String) comboBox2.getSelectedItem();
         double inputTemp = Double.parseDouble(tempInput.getText());
         double result = 0;

         if (from.equals("Celsius")) {
            if (to.equals("Fahrenheit")) result = inputTemp * 1.8 + 32;
            else if (to.equals("Kelvin")) result = inputTemp + 273.15;
            else result = inputTemp;
         } else if (from.equals("Fahrenheit")) {
            if (to.equals("Celsius")) result = (inputTemp - 32) * 5 / 9;
            else if (to.equals("Kelvin")) result = (inputTemp - 32) * 5 / 9 + 273.15;
            else result = inputTemp;
         } else if (from.equals("Kelvin")) {
            if (to.equals("Celsius")) result = inputTemp - 273.15;
            else if (to.equals("Fahrenheit")) result = inputTemp * 9 / 5 - 459.67;
            else result = inputTemp;
         }

         tempOutput.setText(String.format("%.2f", result));
      }
   }

   public static void main(String[] args) {
      new TempConverter();
   }
}
