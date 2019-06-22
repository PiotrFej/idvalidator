import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please get the ID number: ");
        String id_number = scanner.nextLine();
        scanner.close();

        ID_Validator id_validator = new ID_Validator();

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Your ID Number is ");

        if (id_validator.validate(id_number)) {
            stringBuilder.append("correct");
        } else {
            stringBuilder.append("incorrect");
        }
        System.out.println(stringBuilder.toString());


    }
}
