import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyFrame extends JFrame implements ActionListener, KeyListener {

    // Color RGB's
    // Blue: 62,66,100
    //Green: 186,206,187
    //Grey: 241, 235, 227

    JFrame frame;
    JTextField textField;
    JButton[] numButtons = new JButton[10];
    Font myFont = new Font("Comic Sans",Font.BOLD,40);
    JButton[] functionButton= new JButton[10];
    JButton addButton,subButton,mulButton,divButton,decButton,equButton,delButton,clrButton,negButton,modeButton;
    JPanel panel;
    ImageIcon logo;
    double num1=0.0, num2=0.0, result=0.0;
    char operator;


    MyFrame() {

        logo= new ImageIcon("src/gigachad.png");

        //Creating the window  our components will be seen in
        frame= new JFrame("Calculator");
        frame.setSize(520,600);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.addKeyListener(this);
        frame.getContentPane().setBackground(new Color(186,206,187 ));
        //Makes the frame open center of the screen
        frame.setLocationRelativeTo(null);
        //I didn't write setVisible(true) here because if I did it here
        //when you open the app it opens just a blank frame, so I wrote it at the ... line


        //Creating the area that our numbers will be seen
        textField = new JTextField();
        textField.setBounds(50,25,400,50);
        textField.setEditable(false);
        textField.setFont(myFont);
        textField.setVisible(true);
        textField.setFocusable(false);


        //Giving the buttons their numbers and shaping them in one for loop
        //If you don't set the opacity true, It messes up the keyboard input
        for(int i=0; i<10;i++){

            numButtons[i] = new JButton(String.valueOf(i));
            numButtons[i].setFont(myFont);
            numButtons[i].addActionListener(this);
            numButtons[i].setFocusable(false);
            numButtons[i].setOpaque(true);
            numButtons[i].setBackground(new Color(62,66,100));
            numButtons[i].setForeground(new Color(241, 235, 227 ));
            numButtons[i].setBorder(BorderFactory.createRaisedBevelBorder());

        }

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("x");
        divButton = new JButton("÷");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("DEL");
        clrButton = new JButton("C");
        negButton = new JButton("(-)");
        modeButton= new JButton("%");

        //Doing this just for the for loop
        functionButton[0] = addButton;
        functionButton[1] = subButton;
        functionButton[2] = mulButton;
        functionButton[3] = divButton;
        functionButton[4] = decButton;
        functionButton[5] = equButton;
        functionButton[6] = delButton;
        functionButton[7] = clrButton;
        functionButton[8] = negButton;
        functionButton[9] = modeButton;

        for(int i=0; i<10;i++){

            functionButton[i].addActionListener(this);
            functionButton[i].setFocusable(false);
            functionButton[i].setFont(myFont);
            functionButton[i].setBackground(new Color(62,66,100));
            functionButton[i].setForeground(new Color(241, 235, 227 ));
            functionButton[i].setOpaque(true);
            functionButton[i].setBorder(BorderFactory.createRaisedBevelBorder());
        }
        //When I checked after the loop, DEL was so big compared to the button that it said  "..."
        //on the button. So I lowered the font size
        functionButton[6].setFont(new Font("Comic Sans",Font.BOLD,25));

        //Creating the panel for holding the buttons
        panel = new JPanel();
        panel.setBounds(50,100,400,400);
        panel.setLayout(new GridLayout(5,4,10,10));
        panel.setBackground(new Color(186,206,187));
        panel.setOpaque(true);

        panel.add(modeButton);
        panel.add(divButton);
        panel.add(clrButton);
        panel.add(delButton);

        panel.add(numButtons[7]);
        panel.add(numButtons[8]);
        panel.add(numButtons[9]);
        panel.add(addButton);

        panel.add(numButtons[4]);
        panel.add(numButtons[5]);
        panel.add(numButtons[6]);
        panel.add(subButton);

        panel.add(numButtons[1]);
        panel.add(numButtons[2]);
        panel.add(numButtons[3]);
        panel.add(mulButton);

        panel.add(negButton);
        panel.add(numButtons[0]);
        panel.add(decButton);
        panel.add(equButton);



        frame.add(panel);
        frame.add(textField);
        frame.setIconImage(logo.getImage());
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //Giving the values to number buttons
        for(int i=0; i<10;i++){

            if(e.getSource() == numButtons[i])
                textField.setText(textField.getText().concat(String.valueOf(i)));

        }

        //I've tried to use switch-case here but e.getSource returns an object so you cant use switch case here
        if(e.getSource() == decButton)
            textField.setText(textField.getText().concat("."));

        if(e.getSource() == addButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText((""));
        }
        if(e.getSource() == subButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }if(e.getSource() == mulButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if(e.getSource() == divButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if(e.getSource()==modeButton){
            num1= Double.parseDouble(textField.getText());
            operator = '%';
            textField.setText(" ");
        }
        if(e.getSource() == clrButton)
            textField.setText("");

        if(e.getSource() == delButton){

            String string = textField.getText();
            textField.setText("");

            for(int i=0; i<string.length()-1; i++){

                textField.setText(textField.getText()+string.charAt(i));

            }

        }
        if(e.getSource() == negButton){

            double temp = Double.parseDouble(textField.getText());
            temp*=-1;
            textField.setText(String.valueOf(temp));

        }

        if(e.getSource() == equButton){

            num2=Double.parseDouble(textField.getText());
            switch(operator){

                case '+':
                    result=num1+num2;
                    break;
                case '-':
                    result=num1-num2;
                    break;
                case '*':
                    result=num1*num2;
                    break;
                case '/':
                    result=num1/num2;
                    break;
                case '%':
                    result=num1%num2;
                default:
                    textField.setText("ERROR");
                    break;

            }

            textField.setText(String.valueOf(result));
            num1=result;
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {


    }

    @Override
    public void keyPressed(KeyEvent e) {
        //At first, I've tried to do this with e.getKeyCode() but the thing is you can't.
        //Because if you do it that way, you cant separate 7 and / , 4 and +, 5 and % ...
        switch (e.getKeyChar()){
            case '0':
                textField.setText(textField.getText().concat("0"));
                break;
            case '1':
                textField.setText(textField.getText().concat("1"));
                break;
            case '2':
                textField.setText(textField.getText().concat("2"));
                break;
            case '3':
                textField.setText(textField.getText().concat("3"));
                break;
            case '4':
                textField.setText(textField.getText().concat("4"));
                break;
            case '5':
                textField.setText(textField.getText().concat("5"));
                break;
            case '6':
                textField.setText(textField.getText().concat("6"));
                break;
            case '7':
                textField.setText(textField.getText().concat("7"));
                break;
            case '8':
                textField.setText(textField.getText().concat("8"));
                break;
            case '9':
                textField.setText(textField.getText().concat("9"));
                break;
            case '.':
                textField.setText(textField.getText().concat("."));
                break;
            case '+':
                num1 = Double.parseDouble(textField.getText());
                operator = '+';
                textField.setText("");
                break;
            case'-':
                num1 = Double.parseDouble(textField.getText());
                operator = '-';
                textField.setText("");
                break;
            case '*':
                num1 = Double.parseDouble(textField.getText());
                operator = '*';
                textField.setText("");
                break;
            case '/':
                num1 = Double.parseDouble(textField.getText());
                operator = '/';
                textField.setText("");
                break;
            case '%':
                num1= Double.parseDouble(textField.getText());
                operator = '%';
                textField.setText(" ");
                break;
            case 'c','C':
                textField.setText("");
                break;
            case 'n','N':
                double temp = Double.parseDouble(textField.getText());
                temp*=-1;
                textField.setText(String.valueOf(temp));
                break;

        }
        if(e.getKeyCode()==8){
            String string = textField.getText();
            textField.setText("");
            for(int i=0; i<string.length()-1; i++){

                textField.setText(textField.getText()+string.charAt(i));

            }

        }
        if(e.getKeyCode()==10){
            num2=Double.parseDouble(textField.getText());
            switch(operator){

                case '+':
                    result=num1+num2;
                    break;
                case '-':
                    result=num1-num2;
                    break;
                case '*':
                    result=num1*num2;
                    break;
                case '/':
                    result=num1/num2;
                    break;
                case '%':
                    result=num1%num2;
                default:

                    break;

            }

            textField.setText(String.valueOf(result));
            num1=result;
        }


    }

    @Override
    public void keyReleased(KeyEvent e) {




    }
}
