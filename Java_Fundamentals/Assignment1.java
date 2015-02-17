import java.util.Scanner;

public class Assignment1{
    public static void main(String argv[]){

        int cnt = 0;
        char choice = 'y';
        Scanner input = new Scanner(System.in);

        while(choice != 'n'){
            System.out.print("How many asterisks? ");
            cnt = input.nextInt();

            for(int i = 0; i < cnt; i++){
                System.out.print("*");
            }

            System.out.println();
            System.out.print("Continue? (y/n) : ");
            choice = input.next().charAt(0);
        }
    }
}
