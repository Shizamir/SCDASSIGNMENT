package login;

/**
 *
 * @author Dell
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Login extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    private UserDao userDao;

    public Login(UserDao userDao) {
        this.userDao = userDao;

        setTitle("Login ");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel usernameLabel = new JLabel("Username:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(usernameLabel, gbc);

        usernameField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(usernameField, gbc);

        JLabel passwordLabel = new JLabel("Password:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(passwordLabel, gbc);

        passwordField = new JPasswordField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(passwordField, gbc);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                User user = userDao.getUserByUsername(username);
                if (user != null && user.getPassword().equals(password)) {
                    JOptionPane.showMessageDialog(null, "Login successful! Welcome, " + user.getUsername() + "!");
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid credentials. Please try again.");
                }
            }
        });
        
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(loginButton, gbc);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();
        SwingUtilities.invokeLater(() -> new Login(userDao));
    }
}

interface UserDao {
    User getUserByUsername(String username);
}

class UserDaoImpl implements UserDao {
    @Override
    public User getUserByUsername(String username) {
      
        if (username.equals("Alex")) {
            return new User("Alex", "password123");
        } else if (username.equals("jane")) {
            return new User("jhon", "password456");
        }
        return null;
    }
}

class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
