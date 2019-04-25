import org.junit.Assert;
import org.junit.Test;

public class TestMain {

    @Test
    public void testMain1(){
        Main main = new Main("Test program end","program end");
        Assert.assertEquals(main.getSuccess(),true);
    }


    @Test
    public void testMain2(){
        Main main = new Main("Test","program go 5 end");
        Assert.assertEquals(main.getSuccess(),true);
    }


    @Test
    public void testMain3(){
        Main main = new Main("Test","program go 1 turn 10 go 2 turn 20 go 3 turn 30 go 4 turn 40 end");
        Assert.assertEquals(main.getSuccess(),true);
    }


    @Test
    public void testMain4(){
        Main main = new Main("Test","program repeat 4 go 10 turn 10 end end");
        Assert.assertEquals(main.getSuccess(),true);
    }


    @Test
    public void testMain5(){
        Main main = new Main("Test","program repeat 4 go 10 turn 10  repeat 3 go 20  turn 20 end end turn 30  end");
        Assert.assertEquals(main.getSuccess(),true);
    }


    @Test
    public void testMain6(){
        Main main = new Main("Test","program turn 10 repeat 2 turn 20 go 10 end go 10 repeat 3 turn 30 go 30 end go 40 end");
        Assert.assertEquals(main.getSuccess(),true);
    }
}
