import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String str1, str2;
        boolean silent;
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the first string: ");
        str1 = sc.next();
        System.out.print("Enter the second string: ");
        str2 = sc.next();

        String answer;
        System.out.print("Print out matrix? (y/n): ");
        answer = sc.next();
        silent = answer.toLowerCase().contains("n");


        System.out.println(levenshtein(str1, str2, silent));
    }

    public static int levenshtein(String s1, String s2, boolean silent){
        int[] row1 = new int[s2.length()+1], row2 = new int[s2.length()+1];
        for(int i = 0; i < row1.length; i++){
            row1[i] = i;
        }
        if(!silent) System.out.println();
        if(!silent) {
            System.out.print("     ");
            for(char c : s2.toCharArray()){
                System.out.print(" | " + c);
            }
            System.out.println();
        }
        int len = s1.length()+1;
        for(int i = 1; i < len; i++){
            row2[0] = i;
            for(int j = 1; j < row1.length; j++){
                row2[j] = Math.min(
                        row1[j-1] + (s2.charAt(j-1) == s1.charAt(i-1) ? 0 : 1),
                        Math.min(row2[j-1]+1, row1[j] + 1)
                );
            }
            if(!silent) {
                if(i > 1)
                    System.out.print(s1.charAt(i-2));
                else System.out.print(" ");
                show(row1);
            }
            row1 = row2.clone();
        }
        if(!silent) {
            System.out.print(s1.charAt(s1.length()-1));
            show(row1);
        }
        if(!silent) System.out.println();
        return row2[row2.length-1];
    }
    public static void show(int[] arr){
        for(int el : arr){
            System.out.print(" | " + el);
        }
        System.out.println();
    }
}