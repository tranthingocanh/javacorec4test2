package bai1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner sc= new Scanner(System.in);
        try {
            System.out.println("Nhap A: ");
            int aNum = sc.nextInt();
            sc.nextLine();

            System.out.println("Nhap B: ");
            int bNum = sc.nextInt();
            sc.nextLine();

            int[][]  listNums = new int[aNum][bNum];
            for(int i = 0; i < aNum; i++){
                for(int j = 0; j < bNum; j++){
                    listNums[i][j] = j*i;
                }
            }
            for (int i = 0; i< aNum; i++){
               for (int j = 0; j < bNum; j ++){
                    System.out.print(listNums[i][j]);
                }
                System.out.print("\n");
            }
       }catch (Exception e){
            System.out.println("Du lieu dau vao phai  la so!!!!!");
        }

    }

}


