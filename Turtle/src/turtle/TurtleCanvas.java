package turtle;

import language.Executor;
import language.ExecutorFactory;
import language.ExecuteException;
import java.awt.*;


/**
 * 海龟 画布
 */
public class TurtleCanvas extends Canvas implements ExecutorFactory {
//    final static int UNIT_LENGTH = 30;  //
//    final static int DIRECTION_UP = 0; //
//    final static int DIRECTION_RIGHT = 3; //
//    final static int DIRECTION_DOWN = 6; //
//    final static int DIRECTION_LEFT = 9; //
//    final static int RELATIVE_DIRECTION_RIGHT = 3; //
//    final static int RELATIVE_DIRECTION_LEFT = -3; //
    final static int RADIUS = 3; //
    private int direction = 0;
    private Point position;
    private Executor executor; // 任务执行器


    /**
     * 构造画布
     *
     * @param width
     * @param height
     */
    public TurtleCanvas(int width, int height) {
        setSize(width, height);
        initialize();
    }


    // set
    public void setExecutor(Executor executor) {
        this.executor = executor;
    }


    void setRelativeDirection(int relativeDirection) {
        setDirection(direction + relativeDirection);
    }


    void setDirection(int direction) {
        this.direction = (direction+360) % 360;
    }


    void go(int length) {
        int newx = position.x;
        int newy = position.y;

//        System.out.println("length:"+ length);
//
//        System.out.println("oldx:"+position.x +" oldy:"+position.y+" dir:"+direction);
//
//        System.out.println("cos():" + Math.sin((double)direction/180.0*Math.PI) + " sin:" + Math.sin((double)direction/180.0*Math.PI));

        double x = (double)newx + length*Math.cos((double)direction/180.0*Math.PI);
        double y = (double)newy + length*Math.sin((double)direction/180.0*Math.PI);

//        System.out.println("x:" + x + " y:" + y);

        newx = (int)Math.ceil(x);
        newy = (int)Math.ceil(y);

//        System.out.println("newx:"+ newx + " nexy:"+newy);

        Graphics g = getGraphics();
        if (g != null) {
            g.drawLine(position.x, position.y, newx, newy);
            g.fillOval(newx - RADIUS, newy - RADIUS, RADIUS * 2 + 1, RADIUS * 2 + 1);
        }
        position.x = newx;
        position.y = newy;
    }


    public Executor createExecutor(String name, int number) {
        if (name.equals("go")) {
            return new GoExecutor(this, number);
        } else if (name.equals("turn")) {
            return new DirectionExecutor(this, number);
        } else {
            return null;
        }
    }


    public void initialize() {
        Dimension size = getSize();
        position = new Point(size.width / 2, size.height / 2);
        direction = 0;
        setForeground(Color.red);
        setBackground(Color.white);
        Graphics g = getGraphics();
        if (g != null) {
            g.clearRect(0, 0, size.width, size.height);
        }
    }


    public void paint(Graphics g) {         
        initialize();                       
        if (executor != null) {             
            try {                           
                executor.execute();         
            } catch (ExecuteException e) {  
            }                               
        }                                   
    }                                       
}

abstract class TurtleExecutor implements Executor {
    protected TurtleCanvas canvas;
    protected int number;
    public TurtleExecutor(TurtleCanvas canvas, int number) {
        this.canvas = canvas;
        this.number = number;
    }
    public abstract void execute();
}

class GoExecutor extends TurtleExecutor {
    public GoExecutor(TurtleCanvas canvas, int number) {
        super(canvas, number);
    }
    public void execute() {
        canvas.go(number);
    }
}


class DirectionExecutor extends TurtleExecutor {
    private int relativeDirection;
    public DirectionExecutor(TurtleCanvas canvas, int relativeDirection) {
        super(canvas, 0);
        this.relativeDirection = relativeDirection;
    }
    public void execute() {
        canvas.setRelativeDirection(relativeDirection);
    }
}
