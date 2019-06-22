import java.util.HashMap;
import java.util.Map;

public class ID_Validator implements I_Validator {


    private static final Map<Character, Integer> VALUES = new HashMap<>();

    static {
        VALUES.put('A', 10);
        VALUES.put('B', 11);
        VALUES.put('C', 12);
        VALUES.put('D', 13);
        VALUES.put('E', 14);
        VALUES.put('F', 15);
        VALUES.put('G', 16);
        VALUES.put('H', 17);
        VALUES.put('I', 18);
        VALUES.put('J', 19);
        VALUES.put('K', 20);
        VALUES.put('L', 21);
        VALUES.put('M', 22);
        VALUES.put('N', 23);
        VALUES.put('O', 24);
        VALUES.put('P', 25);
        VALUES.put('Q', 26);
        VALUES.put('R', 27);
        VALUES.put('S', 28);
        VALUES.put('T', 29);
        VALUES.put('U', 30);
        VALUES.put('V', 31);
        VALUES.put('W', 32);
        VALUES.put('X', 33);
        VALUES.put('Y', 34);
        VALUES.put('Z', 35);
    }

    private static final int[] WEIGHT = {7, 3, 1, 9, 7, 3, 1, 7, 3};


    @Override
    public boolean validate(String id_number) {


        //Values_Of_Numbers values = new Values_Of_Numbers();

        String id_without_spaces = id_number.trim().replaceAll(" ", "");
        System.out.println(id_without_spaces);
        int first_value = 0;
        int second_value = 0;


        if (id_without_spaces.length() != 9) {
            System.out.println("Inorrect ID - length incorrect");
            return false;
        }

        char[] chars = id_number.toCharArray();

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(chars[i])) {
                System.out.println("Incorrect ID - number of characters incorrect");
                return false;
            }
        }

        for (int i = 3; i < 8; i++) {
            if (!Character.isDigit(chars[i])) {
                System.out.println("Incorrect ID - number of digits incorrect");
                return false;
            }
        }

        for (int i = 0; i < 3; i++) {
            first_value += WEIGHT[i] * VALUES.get(chars[i]);
        }

        for (int i = 3; i < chars.length; i++) {
            second_value += WEIGHT[i] * chars[i];
        }

        int sum = first_value + second_value;

        return sum % 10 == 0;
    }
}
