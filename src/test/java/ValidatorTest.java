import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidatorTest {
    private ID_Validator validator;
    String idnumber;

    @Before
    public void setup() {
        validator = new ID_Validator();
    }

    @Test
    public void test_higher_length() {
        String ID = "ABC1234567";
        assertFalse(validator.validate(ID));
    }

    @Test
    public void test_lower_length() {
        String ID = "ABC12345";
        assertFalse(validator.validate(ID));
    }

    @Test
    public void test_ID_not_starting_with_3_letters() {
        String ID = "A0A000000";
        assertFalse(validator.validate(ID));
    }

    @Test
    public void test_ID_not_ending_with_6_numbers() {
        String ID = "AAA0A0A0A";
        assertFalse(validator.validate(ID));
    }

    @Test
    public void test_correct_ID() {
        String ID = "AAV898996";
        assertTrue(validator.validate(ID));
    }

    @Test
    public void test_incorrect_ID() {
        String ID = "AAA100000";
        assertFalse(validator.validate(ID));
    }
}
