
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GuessTest extends Frame implements ActionListener {

    //declare text field component

    private final TextField tfResolted;
    private final TextField tfentered;
    private final TextField tfStill;
    private final TextField tfNumber;

    //declare Buttons
    private final Button btnNumber;
    private final Button resset;

    //track entry numbers
    private int  count = 0;
    private  int ctr = 0;
    //declare array to show up entered numbers
    ArrayList<Integer> element = new ArrayList<>();

    //produce a random number to be guessed
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
        System.out.println("random number before reset button pressed"+  + randomNumber);
// Declare a Label component

        // Declare and add Text Fields
        tfResolted = new TextField("" + "", 10);
        tfResolted.setBounds(50, 50, 150, 20);
        tfResolted.setEditable(true);
        add(tfResolted);

        tfentered = new TextField("" + "", 10);
        tfentered.setBounds(50, 150, 255, 20);
        tfentered.setEditable(false);
        add(tfentered);

        tfStill = new TextField("" + "",10);
        tfStill.setBounds(50,200,390,20);
        tfStill.setEditable(false);
        add(tfStill);

        tfNumber = new TextField( "", 10);// construct the TextField component with initial text
        tfNumber.setBounds(50, 100, 150, 20);
        tfNumber.setEditable(false);// set to read-only
        add(tfNumber);// "super" Frame container adds Button component

// Declare a Button component
        btnNumber = new Button("Enter");
        btnNumber.setBounds(220, 45, 55, 30);
        add(btnNumber);// "super" Frame container adds Button component
        btnNumber.addActionListener(this);
        // "btnCount" is the source object that fires an ActionEvent when clicked.
        // The source add "this" instance as an ActionEvent listener, which provides
        //   an ActionEvent handler called actionPerformed().
        // Clicking "btnCount" invokes actionPerformed().

        //initialise button reset
      resset = new Button("Reset");
      resset.setBounds(220,95,60,30);
      add(resset);
      resset.addActionListener(this);
      setLayout(null);
      setVisible(true);
    }

    // The entry main() method
    public static void main(String[] args) {
        // Invoke the constructor to setup the GUI, by allocating an instance
        // or simply "new Guess" for an anonymous instance
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
        String  str5 = "Illegal entry, must to be numbers";
        while (tfr.matches("[a-zA-Z]") && evt.getSource() == btnNumber ) {
            tfStill.setText(str5);
            tfr = "";
            }
            int a = Integer.parseInt(tfr);
            System.out.println("a before reset button pressed" + a);

            if (evt.getSource() == resset) {
                clearfields();
                System.out.println("a and random  after reset pressed" + a + "" + randomNumber);
            }

             String str4 = "Number out of range ,must between 1 and 100";
            String str0 = "Wow!, you won!, press reset for new game";
            String str1 = "Bigger than that";
            String str2 = "Smaller than that";
            String str3 = "You lost, press reset for new game." + " the number was:" + " " + randomNumber;

            if (evt.getSource() == btnNumber && randomNumber > a && count < 10 && a < 100 && a > 0 ) {
                tfNumber.setText( str1);
                element.add(a);
                if (ctr != 0 || !tfr.equals("")) {
                    tfStill.setText("");
                }

            } else if (evt.getSource() == btnNumber && randomNumber < a && count < 10 && a < 100 && a > 0) {
                tfNumber.setText("" + str2);
                element.add(a);
                if (ctr != 0 || !tfr.equals("")) {
                    tfStill.setText("");
                }

            } else if (evt.getSource() == btnNumber && randomNumber == a && count < 10) {
                tfStill.setText( str0);
                tfResolted.setEditable(false);

            } else if (evt.getSource() == btnNumber && a < 1 || a > 100) {
                tfStill.setText(str4);
                ctr++;

            } else if (evt.getSource() == btnNumber && count == 10 && randomNumber != a && a < 100 && a > 0) {
                tfStill.setText( str3);
                element.add(a);
                tfResolted.setEditable(false);
            }
            tfentered.setText(element.toString().replace("[", "").replace("]", ""));
            count++;
            // Display the text and entered numbers  on the TextField tfentered

    }
        private void clearfields () {
            randomNumber = (int) (Math.random() * 100) + 1;
            tfResolted.setText("");
            tfentered.setText("");
            tfStill.setText("");
            tfNumber.setText("");
            ctr++;
            element.clear();
            count = 0;
            tfResolted.setEditable(true);

        }

        }

