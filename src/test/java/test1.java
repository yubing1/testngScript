import org.testng.Assert;
import org.testng.annotations.Test;

public class test1 {

    @Test
    public void testOne(){
        System.out.println("aabbcc");
    }

    @Test
    public void testSecond(){
        System.out.println("bbccdd");
    }

    @Test
    public void testThrid(){
        Assert.assertEquals(1,1);
    }
}
