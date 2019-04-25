import language.InterpreterFacade;
import turtle.TurtleCanvas;

import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends Frame implements ActionListener {
    private TurtleCanvas canvas = new TurtleCanvas(400, 400);
    private InterpreterFacade facade = new InterpreterFacade(canvas);
    private TextField programTextField;

    private boolean success;

    // 构造
    public Main(String title, String text) {
        super(title);

        programTextField = new TextField(text);

        canvas.setExecutor(facade);

        setLayout(new BorderLayout()); // 布局

        programTextField.addActionListener(this);

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        add(programTextField, BorderLayout.NORTH);
        add(canvas, BorderLayout.CENTER);
        pack();
        parseAndExecute();
        show();
    }

    // ActionListener梡
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == programTextField) {
            parseAndExecute();
        }
    }

    private void parseAndExecute() {
        String programText = programTextField.getText();
        System.out.println("programText = " + programText);
        this.success = facade.parse(programText);
        canvas.repaint();
    }

    public boolean getSuccess(){
        return success;
    }

    public static void main(String[] args) {
        new Main("Interpreter Pattern Sample","program repeat 4 go 10 turn 10  repeat 3 go 20  turn 20 end end turn 30  end");
    }
}
