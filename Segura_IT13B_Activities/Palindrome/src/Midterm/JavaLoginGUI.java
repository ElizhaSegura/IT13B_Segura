
package Midterm;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author elizh
 */

public class JavaLoginGUI {
    public static void main(String[] args) {
        
        JFrame jFrame = new JFrame("Login");
        JTextField jTextFieldUsername = new JTextField();
        JPasswordField jPasswordPassword = new JPasswordField();
        JLabel jLabelUsername = new JLabel("     Username:");
        JLabel jLabelPassword = new JLabel("     Password:");
        JButton jButtonLogin = new JButton("Login");

        jLabelUsername.setForeground(Color.blue);
        jLabelUsername.setForeground(Color.blue);
        jButtonLogin.setForeground(Color.blue);
        jButtonLogin.setBackground(Color.skyblue);
        
      jFrame.setLayout(new GridLayout(3, 2));
        jFrame.getContentPane().add(jLabelUsername);
        jFrame.getContentPane().add(jTextFieldUsername);
        jFrame.getContentPane().add(jLabelPassword);
        jFrame.getContentPane().add(jPasswordPassword);
         jFrame.add(new JLabel(""));       
        jFrame.getContentPane().add(jButtonLogin);

        
       
       jFrame.setBounds(600, 300, 400, 250);
jFrame.setVisible(true);
jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    
     
        
        jButtonLogin.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String enteredUsername = jTextFieldUsername.getText();
                String enteredPassword = new String(jPasswordPassword.getPassword());
                
                try {
                    BufferedReader reader = new BufferedReader(new FileReader("UserCredentials.txt"));
                    String line;
                    boolean loginSuccess = false;
                    
                    while ((line = reader.readLine()) != null){
                        String[] parts = line.split(",");
                        if (parts.length >= 2) {
                            String storedUsername = parts[0].trim();
                            String storedEncryptedPassword = parts[1].trim();                                                       
                           String encryptedEnteredPassword = encrypt(enteredPassword);
                            
                           System.out.println("--- Debug ---");
                    System.out.println("Entered Username: " + enteredUsername);
                    System.out.println("Stored Username: " + storedUsername);
                    System.out.println("Entered Password (encrypted): " + encryptedEnteredPassword);
                    System.out.println("Stored Password (encrypted): " + storedEncryptedPassword);

                           
                            if (enteredUsername.equals(storedUsername) && enteredPassword.equals(storedEncryptedPassword)) {
                                loginSuccess = true;
                                break;
                            }
                        }
                    }
                    reader.close();
                    
                    if (loginSuccess) {
                        JOptionPane.showMessageDialog(jFrame, "Login Successful!");
                    } else {
                        JOptionPane.showMessageDialog(jFrame, "Try again");
                    }
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(jFrame, "Error");
                    ex.printStackTrace();
                }
            }
        
                });

             } 
        

private static String encrypt(String text) {
        StringBuilder encrypted = new StringBuilder();
        for (char c : text.toCharArray()) {
            encrypted.append((char)(c + 3));
        }
        return encrypted.toString();
    }
}
