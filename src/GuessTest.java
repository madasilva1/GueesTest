import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GuessTest extends Frame implements ActionListener {

    //declare text field component
    private final TextField tfNumber;
    private final TextField tfResolted;
    private final TextField tfentered;
    //declare Buttons
    private final Button btnNumber;
    private int  count = 0;
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
        // setLayout(new FlowLayout());// "super" Frame, which is a Container, sets its layout to FlowLayout to arrange
        // the components from left-to-right, and flow to next row from top-to-bottom.
// Declare a Label component
        Label lblTitle = new Label("I have randomly number from 1 to 100, enter a Number");
        add(lblTitle);

        tfResolted = new TextField("" + "", 10);
        tfResolted.setBounds(50, 50, 150, 20);
        tfResolted.setEditable(true);
        add(tfResolted);

        tfentered = new TextField("" + "", 10);
        tfentered.setBounds(50, 150, 150, 20);
        tfentered.setEditable(false);
        add(tfentered);

        tfNumber = new TextField(count + "", 10);// construct the TextField component with initial text
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
        new GuessTest();
         
        // or simply "new AWTCounter();" for an anonymous instance
    }

    // ActionEvent handler - Called back upon button-click.
    @Override
    public void actionPerformed(ActionEvent evt) {


                            String tfr = tfResolted.getText();
                            int a = Integer.parseInt(tfr);

                            String str0 = "Wow!, you won!";
                            String str1 = "Bigger than that";
                            String str2 = "Smaller than that";

                            if (evt.getSource() == btnNumber && randomNumber > a) {
                                tfNumber.setText(str1);
                                // element.add(a) ;
                            } else if (evt.getSource() == btnNumber && randomNumber < a) {
                                tfNumber.setText(str2);
                                //element.add(a) ;
                            } else if (evt.getSource() == btnNumber && randomNumber == a) {
                                tfNumber.setText(str0);

                            }
                            element.add(a) ;
                            tfentered.setText(element.toString().replace("[", "").replace("]", ""));



                // Display the text str1 on the TextField tfNumber


        }
    }
