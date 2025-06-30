import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.looksaw.ST.BinarySearchST;
import org.looksaw.ST.ST;
import org.looksaw.ST.SerialST;

public class TestST {
    @Test
    public void TestSerialST(){
        ST<Integer,Integer> st = new SerialST<>();
        st.put(1,1);
        st.put(2,2);
        st.put(3,3);
        st.put(4,4);
        assertEquals(1,st.get(1));
        assertEquals(2,st.get(2));
        assertEquals(4,st.size());
        assertEquals(true,st.contains(3));
        st.delete(3);
        assertEquals(3,st.size());
        assertEquals(false,st.contains(3));
    }


    @Test
    public void TestBinarySearchST(){
        ST<Integer,Integer> st = new BinarySearchST<>(100);
        st.put(1,1);
        st.put(2,2);
        st.put(3,3);
        st.delete(2);
        assertEquals(2,st.size());

    }
}
