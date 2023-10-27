
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Solution2 {
	public static void main(String[] args) {
		// создаем объект Scanner для получения путей файлов с аргументами
		Scanner sc = new Scanner(System.in);
		
		// считываем путь для каждого файла
		String fpath1 = sc.nextLine();
		String fpath2 = sc.nextLine();
		// закрываем Scanner 
		sc.close();
		
		float x0 = 0;
        float y0 = 0;
        float r = 0;
		
		// считываем координаты центра окружности и её радиус из file1, присвоим их переменным
		try {
            File file1 = new File(fpath1);
            //создаем объект Scanner для объекта File
            Scanner fr = new Scanner(new FileReader(file1));
       
            x0 = fr.nextFloat();
            y0 = fr.nextFloat();
            r = fr.nextFloat();
            
            fr.close();
        } catch (FileNotFoundException e) {      
        }
		
		// объявляем массивы для координат точек
		float [] x = new float [100];
		float [] y = new float [100];
		int count = 0;
		
		// считаем координаты точек из file2 и запишем их в массивы x и y
		try {
			File file2 = new File(fpath2);
			
            Scanner fr = new Scanner(new FileReader(file2));
            for (int i = 0; fr.hasNextLine(); i++) {

                x[i] = fr.nextFloat();
                y[i] = fr.nextFloat();
                count++;
                
            }
            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
		
		// цикл проверки нахождения точки относительно окружности 
		for (int i = 0; i < count ; i++) {
			if ((Math.pow((x0-x[i]) , 2) + Math.pow((y0-y[i]),2)) == r*r)
				System.out.print("0\n");//вывод результата согласно тз
			else if ((Math.pow((x0-x[i]) , 2) + Math.pow((y0-y[i]),2)) < r*r)
				System.out.print("1\n");
			else if ((Math.pow((x0-x[i]) , 2) + Math.pow((y0-y[i]),2)) > r*r)
				System.out.print("2\n");    
        }
	}

}
