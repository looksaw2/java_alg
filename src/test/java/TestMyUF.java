import org.junit.jupiter.api.Test;
import org.looksaw.UF.MyUF;
import org.looksaw.UF.MyUF2;
import org.looksaw.UF.UF;
import static org.junit.jupiter.api.Assertions.*;

public class TestMyUF {
    @Test
    public void TestMyUF() {
        UF uf = new MyUF(5);
        uf.union(1, 2);
        uf.union(2, 3);
        assertEquals(3,uf.count());
        assertEquals(true,uf.connected(1,3));
    }


    @Test
    public void TestMyUF2() {
        UF uf = new MyUF2(5);
        uf.union(1, 2);
        uf.union(2, 3);
        assertEquals(3,uf.count());
        assertEquals(true,uf.connected(1,3));
    }
}
