
public class ID_Validator implements I_Validator {

    @Override
    public boolean validate(String id_number) {

        String id_without_spaces = id_number.trim().replaceAll(" ", "");
        System.out.println(id_without_spaces);

        if (id_without_spaces.length() != 9) {
            System.out.println("This is not correct ID format.");
            return false;
        }

        char[] chars = id_number.toCharArray();

        for (int i = 0; i < 2; i++) {
            if (!Character.isLetter(chars[i])) ;
            {
                return false;
            }
        }

        for (int i = 3; i < 8; i++) {
            if (!Character.isDigit(chars[i])) {
                return false;
            }
        }

        return true;
    }
}
