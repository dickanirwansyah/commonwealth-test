package id.dicka.testsegitiga;

import java.util.Scanner;

public class SegitigaChallange {

    public static void main(String[] args){
        System.out.println("Input Masukkan : ");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        System.out.println("Result : "+methodSegitiga(input));
    }

    static String methodSegitiga(int n){
        if (n >= 100){
            return "maaf angka melebihi kapasitas";
        }else{
            for (int i=1;i<=n;i++){
                for(int j=n;j>=i;j--){
                    System.out.print(" ");
                }
                for(int k=1;k<=i;k++){
                    System.out.print("#");
                }
                System.out.println();
            }
            return "success";
        }
    }
}
