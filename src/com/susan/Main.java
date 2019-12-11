package com.susan;

import java.io.*;
import java.util.Date;
import java.util.Scanner;
import java.util.Arrays;
import java.lang.*;



public class Main {
    public static void main(String[] args) {

        int[][] lottery = new int[6][20];
        int[] lotterySort = new int[6];
        int[] lotteryResults = new int[6];
        int[][] lotteryWinner = new int[6][20];
        int[] lineWinner = new int [20];

        boolean yn = false;
        boolean ynAgain = true;
        String answer = " ";
        String answerAgain = " ";
        boolean fileSave = false;
        String fileSaveAnswer = " ";
        boolean fileReplace = false;
        String fileReplaceAnswer = " ";
        String nameOfFile = "";

        int quickpicklines = 0;
        int randomNum;
        int nol = 0;
        int x = 0;
        int z = 0;
        int k = 0;
        int e = 0;
        int lineNo = 0;
        int replaceFile = 0;



        Scanner scanner = new Scanner(System.in);
        //   ScannerWrapper scannerWrapper = new ScannerWrapper();
        //  String decision;
        //     yn = scannerWrapper.nextYes();

        System.out.println("Do you wish to enter your own numbers: yes or no");
        answer = scanner.next();
        if ("yes".equals(answer) || "Yes".equals(answer)) {
            yn = true;
        }
        if (yn) {

            //   enter and validate  the six numbers - as many times as you want

            do {

                while (true) {
                    System.out.print("Numbers 1: ");
                    lottery[0][nol] = scanner.nextInt();
                    if (lottery[0][nol] >= 1 && lottery[0][nol] <= 48)
                        break;
                    System.out.println("Number should be between 1 and 48");
                }
                while (true) {
                    System.out.print("Numbers 2: ");
                    lottery[1][nol] = scanner.nextInt();
                    if ((lottery[1][nol] >= 1 && lottery[1][nol] <= 48)
                            && (lottery[0][nol] < lottery[1][nol] || lottery[0][nol] > lottery[1][nol]))
                        break;
                    System.out.println("Number should be between 1 and 48 and unique");
                }
                while (true) {
                    System.out.print("Numbers 3: ");
                    lottery[2][nol] = scanner.nextInt();
                    if ((lottery[2][nol] >= 1 && lottery[2][nol] <= 48)
                            && (lottery[0][nol] < lottery[2][nol] || lottery[0][nol] > lottery[2][nol])
                            && (lottery[1][nol] < lottery[2][nol] || lottery[1][nol] > lottery[2][nol]))
                        break;
                    System.out.println("Number should be between 1 and 48 and unique");
                }
                while (true) {
                    System.out.print("Numbers 4: ");
                    lottery[3][nol] = scanner.nextInt();
                    if ((lottery[3][nol] >= 1 && lottery[3][nol] <= 48)
                            && (lottery[0][nol] < lottery[3][nol] || lottery[0][nol] > lottery[3][nol])
                            && (lottery[1][nol] < lottery[3][nol] || lottery[1][nol] > lottery[3][nol])
                            && (lottery[2][nol] < lottery[3][nol] || lottery[2][nol] > lottery[3][nol]))
                        break;
                    System.out.println("Number should be between 1 and 48 and unique");
                }
                while (true) {
                    System.out.print("Numbers 5: ");
                    lottery[4][nol] = scanner.nextInt();
                    if ((lottery[4][nol] >= 1 && lottery[4][nol] <= 48)
                            && (lottery[0][nol] < lottery[4][nol] || lottery[0][nol] > lottery[4][nol])
                            && (lottery[1][nol] < lottery[4][nol] || lottery[1][nol] > lottery[4][nol])
                            && (lottery[2][nol] < lottery[4][nol] || lottery[2][nol] > lottery[4][nol])
                            && (lottery[3][nol] < lottery[4][nol] || lottery[3][nol] > lottery[4][nol]))
                        break;
                    System.out.println("Number should be between 1 and 48 and unique");
                }
                while (true) {
                    System.out.print("Numbers 6: ");
                    lottery[5][nol] = scanner.nextInt();
                    if ((lottery[5][nol] >= 1 && lottery[5][nol] <= 48)
                            && (lottery[0][nol] < lottery[5][nol] || lottery[0][nol] > lottery[5][nol])
                            && (lottery[1][nol] < lottery[5][nol] || lottery[1][nol] > lottery[5][nol])
                            && (lottery[2][nol] < lottery[5][nol] || lottery[2][nol] > lottery[5][nol])
                            && (lottery[3][nol] < lottery[5][nol] || lottery[3][nol] > lottery[5][nol])
                            && (lottery[4][nol] < lottery[5][nol] || lottery[4][nol] > lottery[5][nol]))
                        break;
                    System.out.println("Number should be between 1 and 48 and unique");
                }
                // print out the numbers entered
                System.out.print("Your numbers are: ");
               for (int i = 0; i < 6; i++)
                   System.out.print(lottery[i][nol] + " , ");
                               System.out.println(" ");


                ynAgain = false;
                System.out.println("Do you want to enter another line:");
                answerAgain = scanner.next();

                if ("yes".equals(answerAgain) || "Yes".equals(answerAgain)) {
                    ynAgain = true;
                    nol++;
                }

            } while (ynAgain);
            lineNo = nol + 1;
        }
            // choose a quick pick and choose how many lines - numbers picked at random
           else {
            while (true) {
                System.out.println("How many quick picks would you like? - must be between 4 and 20");
                quickpicklines = scanner.nextInt();
                if (quickpicklines >= 4 && quickpicklines <= 20)
                    break;
                System.out.println("Number should be between 4 and 20");

            }
            System.out.println("Your numbers are:");
            for (int y = 0; y < quickpicklines; y++) {

                for (int i = 0; i < 6; i++) {

                do { randomNum = (int) (Math.random() * 48);
                } while (randomNum < 1);


                    for (x = 0; x < i; x++) {
                        if (lottery[x][y] == randomNum) {
                            do {
                                randomNum = (int) (Math.random() * 48);
                            } while (randomNum < 1);
                            x--;
                        }
                    }
                    lottery[i][y] = randomNum;
                    lotterySort[i] = randomNum;
                    lineNo = y +1;
                }
                Arrays.sort(lotterySort);
                int count = y + 1;
                System.out.print("Line: " + count + " = ");
        //        for (int s = 0; s < 6; s++)
        //            System.out.print(lotterySort[s] + " ");
        //        System.out.println(" ");
                System.out.println(Arrays.toString(lotterySort));

            }

        }


// output to a file

  System.out.println("Do you wish to add these numbers to a file: yes or no");
    fileSaveAnswer = scanner.next();

            if ("yes".equals(fileSaveAnswer) || "Yes".equals(fileSaveAnswer)) {
        fileSave = true;
    }
            if (fileSave) {

                do{
                    System.out.println("What file name would you like to save to: ");
                    nameOfFile = scanner.next();
                    File f = new File(nameOfFile + ".txt");
                    if (f.exists()) {
                        System.out.println("This File already exists, Do you want to overwrite it?  yes or no");
                        fileReplaceAnswer = scanner.next();

                        if ("yes".equals(fileReplaceAnswer) || "Yes".equals(fileReplaceAnswer)) {
                            replaceFile = +1;
                            File file = new File (nameOfFile +".txt");
                            file.delete();
                        }
                    } else
                         replaceFile = +1;
                } while(replaceFile < 1);

        for (int b = 0; b < lineNo; b++) {
            String recordForFile1 = String.valueOf(lottery[0][b]);
            String recordForFile3 = String.valueOf(lottery[2][b]);
            String recordForFile4 = String.valueOf(lottery[3][b]);
            String recordForFile2 = String.valueOf(lottery[1][b]);
            String recordForFile5 = String.valueOf(lottery[4][b]);
            String recordForFile6 = String.valueOf(lottery[5][b]);
            String recordForFile = (recordForFile1 + "," + recordForFile2 + ","
                    + recordForFile3 + "," + recordForFile4 + "," + recordForFile5 + "," + recordForFile6);

          System.out.println(recordForFile);

            try {
                FileWriter pwriterfile = new FileWriter(nameOfFile + ".txt", true );
                PrintWriter pwriter = new PrintWriter(pwriterfile);
                pwriter.println(recordForFile);
                pwriter.close();
            } catch (IOException ex) {
                System.out.println("Error %s\n" + ex);

            }
        }

       //  System.out.println("Your File is created " + nameOfFile + ".txt");

            }

// get the draw results
        for (int r = 0; r < 6; r++) {

            do {
                randomNum = (int) (Math.random() * 48);
            } while (randomNum < 1);

            for ( z = 0; z < r; z++) {
               if (lotteryResults[z] == randomNum) {
                   do {
                       randomNum = (int) (Math.random() * 48);
                   } while (randomNum < 1);
                    z--;
                }
            }
            lotteryResults[r] = randomNum;
        }
         Arrays.sort (lotteryResults);
        System.out.println(" ");
        System.out.print("Lotto Results: ");
        for (int a = 0; a < 6; a++ )
            System.out.print(lotteryResults[a] + " ");
            Date date = new Date();
        try {
            FileWriter pwriterfile = new FileWriter("LottoResults.txt", true );
            PrintWriter pwriter = new PrintWriter(pwriterfile);
     //       pwriter.println(lotteryResults[0] + ", " +  lotteryResults[1]
      //              + ", " + lotteryResults[2] + ", " +  lotteryResults[3]
     //               + ", " + lotteryResults[4] + ", " +  lotteryResults[5] + " on  " + date);
            pwriter.println(Arrays.toString(lotteryResults) + " on " +date);
            pwriter.close();

        } catch (IOException ex) {
            System.out.println("Error %s\n" + ex);

        }

        // compare   numbers  to draw and print results

        for (int c = 0; c<6; c++)
            for (int d=0; d<6; d++)
                for ( e=0; e<lineNo; e++)
                if (lotteryResults[c] == lottery[d][e]) {
                    lotteryWinner[d][e] = lottery[d][e];
                    lineWinner[e] = lineWinner[e] + 1;

                     }


        System.out.println(" ");
        System.out.println("        - Check Your Lines - ");

        for ( e = 0; e < lineNo; e++){
        for (int s = 0; s < 6; s++)
            System.out.print(lottery[s][e] + " ");
        for (int r = 0; r < 6; r++) {
            if (lotteryWinner[r][e] > 0) {
                System.out.print(" *" + lotteryWinner[r][e] + " ");

            }
        }
        if (lineWinner[e] > 0)
        System.out.print(" - Numbers Matched Total - " + lineWinner[e] );

        System.out.println(" ");

        }




    }
}
