
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
        System.out.println("random number before reset button pressed"+  + randomNumber);
// Declare a Label component
       // Label  LbTitle = new Label("you have random");
       // add(LbTitle);
        //setSize(400, 300);// "super" Frame sets its initial window size
       // "super" Frame shows

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

        //initialise button resset
      resset = new Button("Resset");
      resset.setBounds(220,95,60,30);
      add(resset);
      resset.addActionListener(this);
      setLayout(null);
      setVisible(true);
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
       // mylabele.add(mylabele.resset);
    }

    // ActionEvent handler - Called back upon button-click.
    @Override
    public void actionPerformed(ActionEvent evt) {

        String tfr = tfResolted.getText();
        int a = Integer.parseInt(tfr);
        System.out.println("a before reset button pressed"+ a);

                              if(evt.getSource() == resset){
                                  clearfields();
                                  element.clear();



                               System.out.println("a and random  after reset pressed"+ a + ""+ randomNumber);
                              }


                            String str0 = "Wow!, you won!";
                            String str1 = "Bigger than that";
                            String str2 = "Smaller than that";
                            String str3 = "You lost";
                            String str4 = "Number out of range,must between 1 and 100";
                            if (evt.getSource() == btnNumber && randomNumber > a && count < 10 && a < 100 && a > 0) {
                                tfNumber.setText(""+str1);

                            } else if (evt.getSource() == btnNumber && randomNumber < a && count < 10 && a < 100 && a > 0) {
                                tfNumber.setText(""+str2);

                            } else if (evt.getSource() == btnNumber && randomNumber == a && count < 10 ) {
                                tfStill.setText(""+str0);

                            }
                            else if( a < 0 || a > 100){
                                tfStill.setText(str4);
                            }
                            else if( count == 10 && randomNumber != a && a < 100 && a > 0){
                                tfStill.setText(""+str3);

                            }

                            element.add(a);
                            tfentered.setText(element.toString().replace("[", "").replace("]", ""));

            count++;
            // Display the text and entered numbers  on the TextField tfentered
        }

        private void clearfields( ){
           // this.remove(element.this);
             tfResolted.setText("");
             tfentered.setText("");
             tfStill.setText("");
             tfNumber.setText("");


         }
        }

