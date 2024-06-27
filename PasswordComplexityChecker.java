import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class PasswordComplexityChecker{

private static JFrame f = new JFrame();
private static JButton b = new JButton("Check");
private static JLabel l = new JLabel("Enter Password:");
private static JPasswordField tf = new JPasswordField(10);


public static void PasswordStrengthChecker() {
        String p = new String(tf.getPassword());
        if(!p.isEmpty())
        {
        tf.setText("");
        int u=0,l=0,s=0,d=0;
        if(p.length()>=8)
        {
            for(int i=0;i<p.length();i++)
            {
                char ch = p.charAt(i);
                if((int)ch>=65 && (int)ch<=90)
                    u++;
                else if((int)ch>=97 && (int)ch<=122)
                    l++;
                else if((int)ch>=48 && (int)ch<=57)
                    d++;
                else if(ch=='!' || ch=='$' || ch=='@' || ch=='#' || ch=='~' || ch=='%' || ch=='^' || ch=='&' || ch=='*')
                    s++;
                if(u==1 && l==1 && s==1 && d==1)
                break;
            }
            if(u>=1 && l>=1 && s>=1 && d>=1)
            JOptionPane.showMessageDialog(null, "Password is strong");
            else if(s>=1 && d>=1 && (l>=1 || u>=1))
            JOptionPane.showMessageDialog(null, "Password is medium");
            else
            JOptionPane.showMessageDialog(null, "Password is weak");
        }
        else
        JOptionPane.showMessageDialog(null, "Password is short");
}
else {
    tf.setText("");
    JOptionPane.showMessageDialog(null, "Enter a valid password");
}
}
    
    public static void main(String args[])
    {
        f.setTitle("Password Complexity Checker");
        f.setSize(400,400);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setBackground(Color.BLACK);
        l.setForeground(Color.WHITE);
        f.add(l);
        f.add(tf);
        f.add(b);
        b.addActionListener(e-> PasswordStrengthChecker());
        f.setLayout(new FlowLayout(FlowLayout.CENTER,80,50));
        f.setVisible(true);
    }
}