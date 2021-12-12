package T4Methods.exercise;

import java.util.*;

public class ArrayManipulator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = Arrays.stream(scan.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();
        String command = scan.nextLine();
        while (!command.equals("end")) {
            String[] inputArray = command.split(" ");
            String type = inputArray[0];
            switch (type) {
                case "exchange":
                    int exchangeIndex = Integer.parseInt(inputArray[1]);
                    if (ValidateIndex(exchangeIndex, numbers.length)) {
                        int[] exchangedArray = exchange(numbers, exchangeIndex);
                        numbers = exchangedArray;
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "max":
                    if (inputArray[1].equals("even")) {
                        int maxEvenNumberIndex = maxEvenElementIndex(numbers);
                        if (maxEvenNumberIndex == -1) {
                            System.out.println("No matches");
                        } else {
                            System.out.println(maxEvenNumberIndex);
                        }
                    } else if (inputArray[1].equals("odd")) {
                        int maxOddNumberIndex = maxOddElementIndex(numbers);
                        if (maxOddNumberIndex == -1) {
                            System.out.println("No matches");
                        } else {
                            System.out.println(maxOddNumberIndex);
                        }
                    }
                    break;
                case "min":
                    if (inputArray[1].equals("even")) {
                        int minEvenNumberIndex = minEvenElementIndex(numbers);
                        if (minEvenNumberIndex == numbers.length) {
                            System.out.println("No matches");
                        } else {
                            System.out.println(minEvenNumberIndex);
                        }
                    } else if (inputArray[1].equals("odd")) {
                        int minOddNumberIndex = minOddElementIndex(numbers);
                        if (minOddNumberIndex == numbers.length) {
                            System.out.println("No matches");
                        } else {
                            System.out.println(minOddNumberIndex);
                        }
                    }
                    break;
                case "first":
                    int countFirst = Integer.parseInt(inputArray[1]);
                    if (countFirst > numbers.length) {
                        System.out.println("Invalid count");
                    } else {
                        if (inputArray[2].equals("even")) {
                            printFirstCountEvenElements(numbers, countFirst);
                        } else if (inputArray[2].equals("odd")) {
                            printFirstCountOddElements(numbers, countFirst);
                        }
                    }
                    break;
                case "last":
                    int countLast = Integer.parseInt(inputArray[1]);
                    if (countLast > numbers.length) {
                        System.out.println("Invalid count");
                    } else {
                        if (inputArray[2].equals("even")) {
                            printLastCountEvenElements(numbers, countLast);
                        } else if (inputArray[2].equals("odd")) {
                            printLastCountOddElements(numbers, countLast);
                        }
                    }
                    break;
            }
            command = scan.nextLine();
        }
        System.out.println(Arrays.toString(numbers));
    }

    private static int[] exchange(int[] numbers, int exchangeIndex) {
        int[] numbersToExchangeIndex = new int[exchangeIndex + 1];
        int[] numbersAfterExchangeIndex = new int[numbers.length - (exchangeIndex + 1)];
        for (int i = 0; i <= exchangeIndex; i++) {
            int currentNumber = numbers[i];
            numbersToExchangeIndex[i] = currentNumber;
        }
        for (int i = exchangeIndex + 1; i <= numbers.length - 1; i++) {
            int currentNumber = numbers[i];
            numbersAfterExchangeIndex[i - exchangeIndex - 1] = currentNumber;
        }
        int[] exchangedArray = new int[numbers.length];
        //numbersAfterExchangeIndex + numbersToExchangeIndex
        for (int i = 0; i <= numbersAfterExchangeIndex.length - 1; i++) {
            exchangedArray[i] = numbersAfterExchangeIndex[i];
        }
        for (int i = numbersAfterExchangeIndex.length; i <= exchangedArray.length - 1; i++) {
            exchangedArray[i] = numbersToExchangeIndex[i - numbersAfterExchangeIndex.length];
        }
        return exchangedArray;
    }

    private static void printLastCountOddElements(int[] numbers, int count) {
        List<Integer> output = new ArrayList<>();
        for (int i = numbers.length - 1; i >= 0; i--) {
            int currentNumber = numbers[i];
            if (currentNumber % 2 == 1) {
                output.add(currentNumber);
                count--;
            }
            if (count == 0) {
                break;
            }
        }
        Collections.reverse(output);
        System.out.println(output);
    }

    private static void printLastCountEvenElements(int[] numbers, int count) {
        List<Integer> output = new ArrayList<>();
        for (int i = numbers.length - 1; i >= 0; i--) {
            int currentNumber = numbers[i];
            if (currentNumber % 2 == 0) {
                output.add(currentNumber);
                count--;
            }
            if (count == 0) {
                break;
            }
        }
        Collections.reverse(output);
        System.out.println(output);
    }

    private static void printFirstCountOddElements(int[] numbers, int count) {
        List<Integer> output = new ArrayList<>();
        for (int i = 0; i <= numbers.length - 1; i++) {
            int currentNumber = numbers[i];
            if (currentNumber % 2 == 1) {
                output.add(currentNumber);
                count--;
            }
            if (count == 0) {
                break;
            }
        }
        System.out.println(output);
    }

    private static void printFirstCountEvenElements(int[] numbers, int count) {
        List<Integer> output = new ArrayList<>();
        for (int i = 0; i <= numbers.length - 1; i++) {
            int currentNumber = numbers[i];
            if (currentNumber % 2 == 0) {
                output.add(currentNumber);
                count--;
            }
            if (count == 0) {
                break;
            }
        }
        System.out.println(output);
    }

    private static int minOddElementIndex(int[] numbers) {
        int minOddElement = Integer.MAX_VALUE;
        int minIndex = numbers.length;
        for (int i = 0; i <= numbers.length - 1; i++) {
            if (numbers[i] % 2 == 1 && numbers[i] <= minOddElement) {
                minOddElement = numbers[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    private static int minEvenElementIndex(int[] numbers) {
        int minEvenElement = Integer.MAX_VALUE;
        int minIndex = numbers.length;
        for (int i = 0; i <= numbers.length - 1; i++) {
            if (numbers[i] % 2 == 0 && numbers[i] <= minEvenElement) {
                minEvenElement = numbers[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    private static int maxOddElementIndex(int[] numbers) {
        int maxOddElement = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int i = 0; i <= numbers.length - 1; i++) {
            if (numbers[i] % 2 == 1 && numbers[i] >= maxOddElement) {  //rightmost!!
                maxOddElement = numbers[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    private static int maxEvenElementIndex(int[] numbers) {
        int maxEvenElement = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int i = 0; i <= numbers.length - 1; i++) {
            if (numbers[i] % 2 == 0 && numbers[i] >= maxEvenElement) {
                maxEvenElement = numbers[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    static boolean ValidateIndex(int index, int length) {
        return index >= 0 && index <= length - 1;
        /*if (index >= 0 && index <= length - 1) {
            return true;
        } else {
            return false;
        }*/
    }
}
