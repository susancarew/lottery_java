package com.susan;

import java.io.*;
import java.util.*;
import java.lang.*;


public class Main {
    public static void main(String[] args) {

        int[][] lottery = new int[20][6];
        int[] lotterySort = new int[6];
        int[] lotteryResults = new int[6];

        boolean yn = false;
        boolean ynAgain = true;
        String answerAgain = " ";
        boolean fileSave = false;
        String fileSaveAnswer = " ";
        String fileReplaceAnswer = " ";
        String nameOfFile = "";

        int quickpicklines = 0;
        int randomNum;
        int nol = 0;
        int x = 0;
        int z = 0;
        int lineNo = 0;
        int replaceFile = 0;


        Scanner scanner = new Scanner(System.in);

        System.out.println("Do you wish to enter your own numbers: yes or no");
        String decision = scanner.next();
        yn = decision.toLowerCase().equals("yes");

        if (yn) {

            //   enter and validate  the six numbers - as many times as you want

            do {
                int tracker = 0;
                while (true) {
                    System.out.print("Numbers " + (tracker + 1) + ": ");
                    int numIn = scanner.nextInt();
                    if (isWithinRange(numIn) && !containedInArray(numIn, lottery[nol])) {
                        lottery[nol][tracker] = numIn;
                        tracker++;
                    } else {
                        System.out.println("Number should be between 1 and 48 and unique");
                    }
                    if(tracker >= 6) {
                        break;
                    }
                }
                // print out the numbers entered
                System.out.print("Your numbers are: ");
                for (int i = 0; i < 6; i++)
                    System.out.print(lottery[nol][i] + " , ");
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

                    do {
                        randomNum = (int) (Math.random() * 48);
                    } while (randomNum < 1);


                    for (x = 0; x < i; x++) {
                        if (lottery[y][x] == randomNum) {
                            do {
                                randomNum = (int) (Math.random() * 48);
                            } while (randomNum < 1);
                            x--;
                        }
                    }
                    lottery[y][i] = randomNum;
                    lotterySort[i] = randomNum;
                    lineNo = y + 1;
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

            do {
                System.out.println("What file name would you like to save to: ");
                nameOfFile = scanner.next();
                File f = new File(nameOfFile + ".txt");
                if (f.exists()) {
                    System.out.println("This File already exists, Do you want to overwrite it?  yes or no");
                    fileReplaceAnswer = scanner.next();

                    if ("yes".equals(fileReplaceAnswer) || "Yes".equals(fileReplaceAnswer)) {
                        replaceFile = +1;
                        File file = new File(nameOfFile + ".txt");
                        file.delete();
                    }
                } else
                    replaceFile = +1;
            } while (replaceFile < 1);

            for (int b = 0; b < lineNo; b++) {
                String recordForFile = Arrays.toString(lottery[b]);
                System.out.println(recordForFile);

                try {
                    FileWriter pwriterfile = new FileWriter(nameOfFile + ".txt", true);
                    PrintWriter pwriter = new PrintWriter(pwriterfile);
                    pwriter.println(recordForFile);
                    pwriter.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

            //  System.out.println("Your File is created " + nameOfFile + ".txt");

        }

// get the draw results
        for (int r = 0; r < 6; r++) {

            do {
                randomNum = (int) (Math.random() * 48);
            } while (randomNum < 1);

            for (z = 0; z < r; z++) {
                if (lotteryResults[z] == randomNum) {
                    do {
                        randomNum = (int) (Math.random() * 48);
                    } while (randomNum < 1);
                    z--;
                }
            }
            lotteryResults[r] = randomNum;
        }
        Arrays.sort(lotteryResults);
        System.out.println(" ");
        System.out.print("Lotto Results: ");
        for (int a = 0; a < 6; a++)
            System.out.print(lotteryResults[a] + " ");
        Date date = new Date();
        try {
            FileWriter pwriterfile = new FileWriter("LottoResults.txt", true);
            PrintWriter pwriter = new PrintWriter(pwriterfile);
            pwriter.println(Arrays.toString(lotteryResults) + " on " + date);
            pwriter.close();

        } catch (IOException ex) {
            System.out.println("Error %s\n" + ex);

        }

        // compare   numbers  to draw and print results

        System.out.println(" ");
        System.out.println("        - Check Your Lines - ");
        for(int i = 0; i < lottery.length; i++){
            printOutMatches(lotteryResults, lottery[i]);
        }
    }

    public static boolean containedInArray(int intToCheck, int[] intArray){
        boolean result = false;
        for(int i = 0; i< intArray.length; i++){
            if(intArray[i] == intToCheck){
                result = true;
                break;
            }
        }
        return result;
    }

    public static boolean isWithinRange(int numToCheck){
        return numToCheck > 0 && numToCheck < 49;
    }

    public static void printOutMatches(int[] results, int[] lineToCheck){
        List<Integer> matchedNumbers = new ArrayList<>();
        for(int i = 0; i < results.length; i++){
            if(containedInArray(results[i], lineToCheck)){
                matchedNumbers.add(results[i]);
            }
        }
        Arrays.sort(lineToCheck);
        StringBuilder stringBuilder = new StringBuilder(Arrays.toString(lineToCheck));
        if(!matchedNumbers.isEmpty()) {
            for(Integer in : matchedNumbers){
                stringBuilder.append(" *" );
                stringBuilder.append(in);
            }
            stringBuilder.append(" - Numbers Matched Total - ");
            stringBuilder.append(matchedNumbers.size());
        }
        System.out.println(stringBuilder.toString());
    }
}
