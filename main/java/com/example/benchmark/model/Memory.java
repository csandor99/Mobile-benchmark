package com.example.benchmark.model;

import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class Memory {
    private static Context context;
    public Memory(Context context) {
        this.context = context;
    }

    private static int[] createArray(int n){
        int[] array = new int[1000001];
        for (int i = 1; i <= n; i++) {
            array[i] =new Random().nextInt(array.length);
        }
        return array;
    }

    private static int partition(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            if (arr[j] < pivot)
            {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }

    private static void quickSort(int arr[], int low, int high)
    {
        if (low < high)
        {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
        }
    }

    public static String generateString() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 1000000;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();

        return generatedString;
    }

    private static void fileReader(Context context){
        String data;
        String file = "Benchmark_dump_file.txt";
        FileOutputStream fileOutputStream = null;
        try{
            fileOutputStream = context.openFileOutput(file,Context.MODE_PRIVATE);
            String fileContent = generateString();
            fileOutputStream.write(fileContent.getBytes());
        } catch (FileNotFoundException e) {
            // exception handling
        } catch (IOException e) {
            // exception handling
        }

        FileInputStream fileInputStream = null;
        try{
            fileInputStream = context.openFileInput(file);
            int ch = fileInputStream.read();
            while(ch != -1) {
                ch = fileInputStream.read();
            }
        } catch (FileNotFoundException e) {
            // exception handling
        } catch (IOException e) {
            // exception handling
        }

    }

    public static long memScore() {
        long finalTime = 0;
        long initTime = System.currentTimeMillis();

        int[] a = createArray(1000000);
        quickSort(a,0, 999999);
        fileReader(context);

        finalTime = finalTime + (System.currentTimeMillis() - initTime);
        return finalTime;
    }
}
