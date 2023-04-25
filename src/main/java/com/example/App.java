package com.example;


import java.io.*;

public class App {
    public static void main(String[] args) {
        App app = new App();
        /* Task 1 */
        // Step 1: inside task1_throws_null_pointer_exception() write a code segment that will throw a NullPointerException
        // Step 2: inside task1_handle_null_pointer() handle that exception using a try-catch block

        app.task1_handle_null_pointer();

        /* Task 2 */
        // Step 1: inside task2_throws_arithmetic_exception() write a code segment that will throw an ArithmeticException
        // Step 2: inside task2_handle_arithmetic_exception() handle that exception using a try-catch block
        app.task2_handle_arithmetic_exception();

        /* Task 3 */
        // Step 1: inside task3_handle_multiple_exceptions() handle possible exception cases using a multi-catch block
        // Step 2: inside main call task3_handle_multiple_exceptions() with different array_size and divisor values
        // Step 3: Discussion: which catch blocks are executed and why?

        app.task3_handle_multiple_exceptions(4, 2);
        app.task3_handle_multiple_exceptions(30, 0);
        app.task3_handle_multiple_exceptions(-4, 10);
        //app.task3_handle_multiple_exceptions(30, 10);


        /* Task 4 */
        // Step 1: Uncomment task4_readFile() function and fix its errors by using Try-Catch-Finally Blocks. Afterwards call task4_readFile("/file.txt") in main method
        // Step 2: Discussion: which statement belongs in which block and why?
        app.task4_readFile("/file2.txt");

        /* Task 5 */
        // Step 1: Uncomment task5_readFile function. Instead of handling checked exceptions with try/catch declare possible exceptions in method signature
        // Step 2: Call task5_readFile("/file.txt") in main method -> handle exceptions in main
        // Step 2: Discussion: why and when would you declare exceptions? when not?
        try {app.task5_readFile("/file2.txt");
        }catch (Exception e){
            System.out.println("ups8");
        }
    }

    public static void task1_throws_null_pointer_exception(){
        // Step 1: Write a code segment that will throw a NullPointerException

            String s = null;
            s.length();
    }

    public void task1_handle_null_pointer(){
        // Task 1 Step 2: handle NullPointerException using a try-catch block
        try{
            task1_throws_null_pointer_exception();
        }catch (NullPointerException e){
            System.out.println("ups1");
        }
    }

    public static int task2_throws_arithmetic_exception(){
        // Task 2 Step 1: write a code segment that will throw an ArithmeticException

        return 10/0;
    }

    public int task2_handle_arithmetic_exception() {
        try {
            task2_throws_arithmetic_exception();
        } catch (ArithmeticException e){

            System.out.println("ups2");
        } return 0;
    }

    public void task3_handle_multiple_exceptions(int array_size, int divisor){
        // Task 3: handle possible exception cases using a multi-catch block
        try{
            int a[]=new int[array_size];
            a[5]=30/divisor;
            System.out.println("result: " + a[5]);
        }catch (ArithmeticException e){
            System.out.println("ups4");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("ups3");
        }catch (Exception e){
            System.out.println("ups5");
        }

    }

    public void task4_readFile(String filename) {
        // Task 4: fix compilation errosrs of this function
        InputStream inputStream = null;
        try {
            File file = new File(getClass().getResource(filename).getFile());
            inputStream = new FileInputStream(file);
            String text = readFromInputStream(inputStream);
            System.out.println(text);
        }catch (Exception e){
            System.out.println("ups6");
        }finally{
            try {
                inputStream.close();
            } catch (IOException | NullPointerException e){
                System.out.println("ups7");
            }
        }
    }


    public void task5_readFile(String filename) throws IOException {
        // Task 5: declare excpetions that might be thrown here
        InputStream inputStream = null;
        File file = new File(getClass().getResource(filename).getFile());
        inputStream = new FileInputStream(file);
        String text = readFromInputStream(inputStream);
        System.out.println(text);
        inputStream.close();
    }



    private String readFromInputStream(InputStream inputStream) throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
    }
}
