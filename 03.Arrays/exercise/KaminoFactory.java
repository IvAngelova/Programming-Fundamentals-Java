package T3Arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class KaminoFactory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int sequenceLength = Integer.parseInt(scan.nextLine());
        String command = scan.nextLine();

        int currentSampleNumber = 0;
        int bestSampleNumber = 0;
        int bestSubsequenceLength = 0;
        int bestIndex = sequenceLength;
        int bestSequenceSum = 0;
        int[] bestDNA = new int[sequenceLength];


        while (!command.equals("Clone them!")) {
            int[] currentDNA = Arrays.stream(command.split("!+"))
                    .mapToInt(e -> Integer.parseInt(e)).toArray();
            currentSampleNumber++;
            int currentBestSubSequenceLength = 0;
            int currentSequenceSum = 0;
            int currentBestIndex = 0;

            for (int i = 0; i <= sequenceLength - 1; i++) {
                currentSequenceSum += currentDNA[i];
                int currentElement = currentDNA[i];
                if (currentElement == 0) {
                    continue;
                }
                int currentSubsequenceLength = 1;
                for (int j = i + 1; j < currentDNA.length; j++) {
                    if (currentDNA[j] == 1) {
                        currentSubsequenceLength++;
                    } else {
                        break;
                    }
                }
                if (currentSubsequenceLength > currentBestSubSequenceLength) {
                    currentBestSubSequenceLength = currentSubsequenceLength;
                    currentBestIndex = i;
                }
            }

            if (currentBestSubSequenceLength > bestSubsequenceLength) {
                bestSubsequenceLength = currentBestSubSequenceLength;
                bestIndex = currentBestIndex;
                bestDNA = currentDNA;
                bestSampleNumber = currentSampleNumber;
                bestSequenceSum = currentSequenceSum;
            } else if (currentBestSubSequenceLength == bestSubsequenceLength) {
                if (currentBestIndex < bestIndex) {
                    bestSubsequenceLength = currentBestSubSequenceLength;
                    bestIndex = currentBestIndex;
                    bestDNA = currentDNA;
                    bestSampleNumber = currentSampleNumber;
                    bestSequenceSum = currentSequenceSum;

                } else if (currentBestIndex == bestIndex) {
                    if (currentSequenceSum > bestSequenceSum) {
                        bestSubsequenceLength = currentBestSubSequenceLength;
                        bestIndex = currentBestIndex;
                        bestDNA = currentDNA;
                        bestSampleNumber = currentSampleNumber;
                        bestSequenceSum = currentSequenceSum;
                    }
                }
            }


            command = scan.nextLine();
        }
        System.out.printf("Best DNA sample %d with sum: %d.%n", bestSampleNumber, bestSequenceSum);
        for (int i = 0; i <= bestDNA.length - 1; i++) {
            System.out.print(bestDNA[i] + " ");
        }
    }
}
