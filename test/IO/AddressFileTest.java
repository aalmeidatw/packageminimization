package IO;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class AddressFileTest {

    @Test
    public void shouldReturnFileAdress() throws Exception {
        assertThat(new AddressFile().getAddressFile(), is("src/file/file.txt"));
    }
}