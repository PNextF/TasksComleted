package task1;

import java.util.Scanner;

public class Solution1 {
	public static void main(String[] args) {
		// ввод аргументов n и m
		Scanner r = new Scanner(System.in);
		int n = r.nextInt();
		int m = r.nextInt();
		r.close();
		// объявление и заполнение массива
		int [] rarra = new int[n];
		for (int i = 0; i < n; i++) {
            rarra[i] = i + 1;
        }
		int path = 0;
		// цикл передвижения с интервалом m
		do {
			System.out.print(rarra[path]); // последовательный вывод пути
			path = (path+m-1)%n;// формула нахождения пути прохода
		} while (path != 0);
	}
}
