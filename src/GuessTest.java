import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.util.ArrayList;

public class GuessTest extends Frame implements ActionListener {

    //declare text field component

    private final TextField tfResolted;
    private final TextField tfentered;
    private final TextField tfStill;
    private final TextField tfNumber;
   // JLabel tfNumbe = new JLabel("sample text");
   // Label lblTitle;
    //declare Buttons
    private final Button btnNumber;
    private int  count = 0;
    //declare a Label

    //declare array to show up entered numbers
    ArrayList<Integer> element = new ArrayList<>();
    int randomNumber = (int) (Math.random() * 100) + 1;

    // Constructor to setup GUI components and event handlers
    public GuessTest() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowOpened(e);
                dispose();
            }
        });
         setLayout(new FlowLayout());// "super" Frame, which is a Container, sets its layout to FlowLayout to arrange
        // the components from left-to-right, and flow to next row from top-to-bottom.
// Declare a Label component
        Label  LbTitle = new Label("you have random");
        add(LbTitle);
        LbTitle.setVisible(true);
        //LbTitle.setBounds(200,70,200,100);
        //LbTitle.setFont(new Font(LbTitle.getName(), Font.PLAIN, 18));


       //Label lblTitle  = new Label("you have choice it");
        //add(lblTitle);

       //  lblTitle.setVisible(true);
       // lblTitle.setFont(new Font(lblTitle.getName(), Font.PLAIN, 18));



        tfResolted = new TextField("" + "", 10);
        tfResolted.setBounds(50, 50, 150, 20);
        tfResolted.setEditable(true);
        add(tfResolted);

        tfentered = new TextField("" + "", 10);
        tfentered.setBounds(50, 150, 210, 20);
        tfentered.setEditable(false);
        add(tfentered);

        tfStill = new TextField("" + "",10);
        tfStill.setBounds(50,200,150,20);
        tfStill.setEditable(false);
        add(tfStill);

        tfNumber = new TextField( "", 10);// construct the TextField component with initial text
        tfNumber.setBounds(50, 100, 150, 20);
        tfNumber.setEditable(false);// set to read-only
        add(tfNumber);// "super" Frame container adds Button component
// Declare a Button component
        btnNumber = new Button("Press");
        btnNumber.setBounds(220, 45, 50, 30);
        add(btnNumber);// "super" Frame container adds Button component
        btnNumber.addActionListener(this);
        // "btnCount" is the source object that fires an ActionEvent when clicked.
        // The source add "this" instance as an ActionEvent listener, which provides
        //   an ActionEvent handler called actionPerformed().
        // Clicking "btnCount" invokes actionPerformed().

//setTitle("guess counter,randomly number from 1 to 100");// "super" Frame sets its title
        setSize(400, 300);// "super" Frame sets its initial window size
        setLayout(null);
        setVisible(true);// "super" Frame shows

    }

    // The entry main() method
    public static void main(String[] args) {
        // Invoke the constructor to setup the GUI, by allocating an instance
        //new GuessTest();
        // or simply "new AWTCounter();" for an anonymous instance
        GuessTest mylabele = new GuessTest();
        mylabele.setTitle("Random numbers from 1 to 100, you have 10 choices");
        mylabele.setFont(new Font(mylabele.getName(), Font.PLAIN, 14));
        mylabele.setSize(500,500);
        mylabele.setVisible(true);
    }

    // ActionEvent handler - Called back upon button-click.
    @Override
    public void actionPerformed(ActionEvent evt) {


                            String tfr = tfResolted.getText();
                            int a = Integer.parseInt(tfr);

                            String str0 = "Wow!, you won!";
                            String str1 = "Bigger than that";
                            String str2 = "Smaller than that";
                            String str3 = "You lost";
                            if (evt.getSource() == btnNumber && randomNumber > a && count < 10) {
                                tfNumber.setText(str1);

                            } else if (evt.getSource() == btnNumber && randomNumber < a && count < 10) {
                                tfNumber.setText(str2);

                            } else if (evt.getSource() == btnNumber && randomNumber == a && count < 10) {
                                tfNumber.setText(str0);

                            }
                            else{
                                tfStill.setText(str3);
                               
                            }
                            element.add(a) ;
                            tfentered.setText(element.toString().replace("[", "").replace("]", ""));

            count++;                // Display the text and entered numbers  on the TextField tfentered
        }
    }
