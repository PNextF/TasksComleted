package Nums;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution4 {
	public static void main(String[] args) {
	// создаем объект Scanner для получения пути файла с аргументами
		Scanner sc = new Scanner(System.in);
		// считываем путь файла с целыми числами
		String fpath = sc.nextLine();
		sc.close();
		
		int sum = 0, count = 0, result = 0;
		
		// подсчет количества целых чисел в файле
		try {
	        BufferedReader lcount = new BufferedReader(new FileReader(fpath));   
			String l;
	            while ((l = lcount.readLine()) != null) {
	                count++;
	            }
	        lcount.close();
	    } catch (IOException e) {
	    	e.printStackTrace();
		}
		
		// объявляем массив n для полученного количества значенй 
		int [] nums = new int [count];
		
		// заполняем массив n числами из файла
		try {
			File file = new File(fpath);
			
            Scanner fr = new Scanner(new FileReader(file));
            for (int i = 0; fr.hasNextLine(); i++) {
                nums[i] = fr.nextInt();
                sum = sum + nums[i];//подсчет суммы чисел в файле
            }
            fr.close();
        } catch (FileNotFoundException e) {
        	e.printStackTrace();  
        }
		
		double med = fMed(nums, count);// нахождение медианы массива
		
		for (int i = 0; i < count; i++) {
			result = result + (Math.abs((int)med-nums[i]));// сложение разности элементов и округленного значения медианы
		}
		System.out.print(result);	
	}
	
	public static double fMed(int a[], int n)
    {
        // сортируем массив
        Arrays.sort(a);

        // проверяем количество элементов на четность/нечетность
        if (n % 2 != 0)
            return (double)a[n / 2];// возврат среднего элемента, если нечетное 
 
        return (double)(a[(n - 1) / 2] + a[n / 2]) / 2.0; // возврат среднего значения двух элементов посередине, если четное;
    }
}
