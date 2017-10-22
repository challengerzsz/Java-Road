import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class MyFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField txtResult;
    private JButton btnZero, btnOne, btnTwo, btnThree, btnFour, btnFive,
            btnSix, btnSeven, btnEight, btnNine, btnPlus, btnMinus, btnTimes,
            btnDivided, btnEqual, btnPoint, btnC, btnCE, btnRightKh, btnLeftKh;


    StringBuffer str;

    public MyFrame() {
        super("计算器");
        this.setSize(600, 550);
        this.setLocation(600, 250);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLayout(new GridLayout(1, 1));// 网格布局
        JPanel panel = new JPanel(new GridLayout(6, 1));// 面板 网格布局6行1列
        this.add(panel);

        txtResult = new JTextField("0");
        txtResult.setFont(new Font("宋体",Font.BOLD,20));
        Color BackColor = new Color(255, 255, 255);
        Color ForeColor = new Color(0, 0, 0);
        txtResult.setBackground(BackColor);
        txtResult.setForeground(ForeColor);

        panel.add(txtResult);
        txtResult.setHorizontalAlignment(JTextField.RIGHT);
        txtResult.setEnabled(false);
        // text.setEnabled(true);

        JPanel panel_1 = new JPanel(new GridLayout(1, 4));
        panel.add(panel_1);

        btnRightKh = new JButton(")");

        panel_1.add(btnRightKh);
        btnRightKh.addActionListener(e ->
        {
            addOp(")");
            txtResult.setText(mInput);
        });//在这里加有效性判断 要是无效就不加符号到mInput
        btnLeftKh = new JButton("(");
        panel_1.add(btnLeftKh);
        btnLeftKh.addActionListener(e ->{
            addOp("(");
            txtResult.setText(mInput);
        });
        btnCE = new JButton("CE");
        panel_1.add(btnCE);
        btnCE.addActionListener(e -> {
            txtResult.setText("");
        });
        btnC = new JButton("C");
        panel_1.add(btnC);
        btnC.addActionListener(e -> {
            txtResult.setText("");
        });

        JPanel panel_2 = new JPanel(new GridLayout(1, 4));
        panel.add(panel_2);

        btnSeven = new JButton("7");
        panel_2.add(btnSeven);
        btnSeven.addActionListener(e ->{
            addOp("7");
            txtResult.setText(mInput);
        });
        btnEight = new JButton("8");
        panel_2.add(btnEight);
        btnEight.addActionListener(e -> {
            addOp("8");
            txtResult.setText(mInput);
        });
        btnNine = new JButton("9");
        panel_2.add(btnNine);
        btnNine.addActionListener(e -> {
            addOp("9");
            txtResult.setText(mInput);
        });
        btnDivided = new JButton("/");
        panel_2.add(btnDivided);
        btnDivided.addActionListener(e -> {
            addOp("/");
            txtResult.setText(mInput);
        });

        JPanel panel_3 = new JPanel(new GridLayout(1, 4));
        panel.add(panel_3);

        btnFour = new JButton("4");
        panel_3.add(btnFour);
        btnFour.addActionListener(e -> {
            addOp("4");
            txtResult.setText(mInput);
        });
        btnFive = new JButton("5");
        panel_3.add(btnFive);
        btnFive.addActionListener(e -> {
            addOp("5");
            txtResult.setText(mInput);
        });
        btnSix = new JButton("6");
        panel_3.add(btnSix);
        btnSix.addActionListener(e -> {
            addOp("6");
            txtResult.setText(mInput);
        });
        btnTimes = new JButton("*");
        panel_3.add(btnTimes);
        btnTimes.addActionListener(e -> {
            addOp("*");
            txtResult.setText(mInput);
        });

        JPanel panel_4 = new JPanel(new GridLayout(1, 4));
        panel.add(panel_4);


        btnOne = new JButton("1");
        panel_4.add(btnOne);
        btnOne.addActionListener(e -> {
            addOp("1");
            txtResult.setText(mInput);
        });
        btnTwo = new JButton("2");
        panel_4.add(btnTwo);
        btnTwo.addActionListener(e -> {
            addOp("2");
            txtResult.setText(mInput);
        });
        btnThree = new JButton("3");
        panel_4.add(btnThree);
        btnThree.addActionListener(e -> {
            addOp("3");
            txtResult.setText(mInput);
        });
        btnMinus = new JButton("-");
        panel_4.add(btnMinus);
        btnMinus.addActionListener(e -> {
            addOp("-");
            txtResult.setText(mInput);
        });

        JPanel panel_5 = new JPanel(new GridLayout(1, 4));
        panel.add(panel_5);

        btnZero = new JButton("0");
        panel_5.add(btnZero);
        btnZero.addActionListener(e ->{
            addOp("0");
            txtResult.setText(mInput);
        });
        btnPoint = new JButton(".");
        panel_5.add(btnPoint);
        btnPoint.addActionListener(e -> {
            addOp(".");
            txtResult.setText(mInput);
        });
        btnEqual = new JButton("=");
        panel_5.add(btnEqual);
        btnEqual.addActionListener(e -> {
            System.out.println(mInput);
            Calculator calculator = new Calculator();
            String expression = calculator.changeMidToAfter(mInput);
            System.out.println(calculator.expressionCalculating(expression));
            txtResult.setText(String.valueOf(calculator.expressionCalculating(expression)));
        });
        btnPlus = new JButton("+");
        panel_5.add(btnPlus);
        btnPlus.addActionListener(e -> {
            addOp("+");
            txtResult.setText(mInput);
        });

        str = new StringBuffer();

        this.setVisible(true);

    }

    String mInput = "";

    private void addOp(String s) {
        mInput = mInput + s;
    }


}
