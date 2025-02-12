import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorApp extends Jframe
  implements ActionListener
  {
    private JTextField inputfield;
    private double num1,num2,result;
    private char operator;

    public CalculatorApp()
    {
      setTitle("Calculator");
      setSize(400,500);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLayout(new BorderLayout());

      inputField=new JTextField();
      inputField.setHorizontalAlignment(JtextField.RIGHT);
      inputField.setFont(newFont("Arial",Font.BOLD,30));
      add(inputField, BorderLayout.NORTH);

      JPanel buttonPanel = new JPanel();
      buttonPanel.setLayout(newGridLayout(4,4,10,10));
      String[] buttons = {
        "7","8","9","/",
        "4","5","6","*",
        "1","2","3","-",
        "C","0","=","+"
      };
      for(String text : buttons)
        {
          JButton button = new JButton(text);
          button.setFont(newFont("Arial",Font.BOLD,20));
          button.addActionListener(this);
          buttonPanel.add(button);
        }
      add(buttonPanel,BorderLayout.CENTER);
    }
    @Override
    public void
    actionPerformed(ActionEvent e)
    {
      String command = e.getActionCommand();

      if(command.charAt(0)>='0' && command.charAt(0)<='9')
      {

      inputField.setTesxt(inputField.getText()+command);
      }
      elseif(command.equals("C"))
        {
        inputField.setText("");
        num1 = num2 = result=0;
        opearotor = '\0';
      }
      elseif(command.equals("="))
        {
        num2=Double.parseDouble(inputField.getText());
        switch(operator)
          {
              case'+':
              result = num1 + num2;
              break;
              case'-':
              result = num1 - num2;
              break;
              case'*':
              result = num1 * num2;
              break;
              case'/':
              if(num2 !=0)
              {
                result = num1 / num2;
              }
              else{
                inputField.setText("ERROR");
                return;
              }
              break;
          }
        inputField.setText(String.valueOf(result));
      }
      else{
        operator = command.charAt(0);
        num1=Double.parseDouble(inputField.getText());
        inputField.setText("");
      }
    }
    public static void main(String[] args)
    {
      SwingUtilities.invokeLater(() -> {
        CalculatorApp calculator = new CalculatorApp();
        calculator.setVisible(true);
      });
    }
  }
