import org.junit.Test;

import java.math.BigInteger;

/**
 * Created by mx on 2019/3/7.
 */
public class LeetCode {

    @Test
    public void multiply(){
        BigInteger n1 = new BigInteger("123");
        BigInteger n2 = new BigInteger("456");

        System.out.println( n1.multiply(n2).toString());
    }
}
