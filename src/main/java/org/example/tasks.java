package org.example;
import java.io.*;
import java.util.Scanner;
import java.util.logging.*;
import com.github.cliftonlabs.json_simple.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;

public class tasks {
    static void task1() throws IOException { //============================================================// ЗАДАЧА №1
        System.out.print("Задача 1");
        System.out.println();
        Logger LOG = Logger.getLogger(tasks.class.getName());  //  logging
        LOG.setLevel(Level.ALL);
        FileHandler fh = new FileHandler("log_task1.txt");
        LOG.addHandler(fh);
        //LOG.addHandler(ch);
        SimpleFormatter sf = new SimpleFormatter();
        fh.setFormatter(sf);

        int[] int_arr = new int[12];                    // создаю массив

        System.out.print("[ ");
        for (int i = 0; i < int_arr.length; i++) {      // наполнил массив значениями + печать
            int_arr[i] = (int) (Math.random() * 100);
            System.out.print(int_arr[i]);
            System.out.print(", ");
        }
        System.out.print("]");
        int count = 0;                                 // сортировка + logging writer
        for (int i = 0; i < int_arr.length; i++) {
            for (int j = 0; j < int_arr.length - 1; j++) {
                count++;
                LOG.info(String.format("%d) итерация. Все в норме", count));
                if (int_arr[j] > int_arr[j + 1]) {
                    int p = int_arr[j];
                    int_arr[j] = int_arr[j + 1];
                    int_arr[j + 1] = p;
                }
            }
        }
        System.out.println();                        // печать исходного массива
        System.out.print("[ ");
        for (int i : int_arr) {
            System.out.print(i);
            System.out.print(", ");
        }
        System.out.print("]");
    }

    static void task2() throws FileNotFoundException { // --------------------------------------------------//ЗАДАЧА №2
        System.out.print("Задача 2 v0.1");
        System.out.println();

        StringBuilder file_gson = new StringBuilder(); // запишу в StringBuilder содержимое файла json

        try (FileReader reader = new FileReader("file.json")) {
            int z;                           // запись файла в StringBuilder
            while ((z = reader.read()) != -1) {
                file_gson.append((char) z);

            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        int count_json = 0;
        for (int i = 0; i < file_gson.length(); i++) {      // считает количество { json } в файле
            char q = file_gson.charAt(i);
            String qq = Character.toString(q);
            if (qq.equals("{")) {
                count_json++;
            }
        }
        //System.out.print(file_gson);
        StringBuilder[] arr_json = new StringBuilder[count_json];

        StringBuilder add = new StringBuilder(); // для добавления в массив arr_json по отдельности { json }
        int go_to_the_arr_js = -1;
        for (int j = 0; j < file_gson.length(); j++) {
            char q = file_gson.charAt(j);
            String qq = Character.toString(q);

            if (qq.equals("{")) {
                go_to_the_arr_js++;
                add = new StringBuilder();
            }else if (qq.equals("}")) {
                arr_json[go_to_the_arr_js] = add;
                add = new StringBuilder();
            }else {
                add.append(file_gson.charAt(j));
            }
        }

        StringBuilder[][] super_arr_json = new StringBuilder[count_json][3];   // распаковка {json} в двумерный массив

        for (int i = 0; i < super_arr_json.length; i++) {              // запись super_arr_json
            String[] l = arr_json[i].toString().split(",");
            for (int j = 0; j < super_arr_json[i].length; j++) {
                super_arr_json[i][j] = new StringBuilder(l[j].trim());
                    }
          }

        for (int i = 0; i < super_arr_json.length; i++) {                // печать желаемого результата
            System.out.println(String.format("Ученни(к)ца%s по предмету%s имеет отметку%s",
                    super_arr_json[i][0].toString().split(":")[1].replaceAll("\"", ""),
                    super_arr_json[i][2].toString().split(":")[1].replaceAll("\"", ""),
                    super_arr_json[i][1].toString().split(":")[1].replaceAll("\"", "")));

        }



        System.out.print("Задача 2 v0.2");
            try {
                Reader t = Files.newBufferedReader(Paths.get("file.json")); // считывает файл

                JsonArray s = (JsonArray) Jsoner.deserialize(t);  // десериализирует в json массив

                System.out.println();
                for (int i = 0; i < s.size(); i++) {

                    JsonObject a = s.getMap(i);    // в json обьект

                    String num = (String) a.get("оценка");
                    String pr = (String) a.get("предмет");
                    String name = (String) a.get("фамилия");

                    String result_string = String.format("Ученни(к)ца %s по предмету" +
                            " %s имеет отметку %s", name, pr, num);
                    System.out.print(result_string);
                    System.out.println();
                }
                t.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
           }
        static String getType(Object o){
            return o.getClass().getSimpleName();
        }
    static void task3(){ // --------------------------------------------------------------------------------//ЗАДАЧА №3
        System.out.println();

        System.out.println("Задача 3");
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите слово:  ");

        StringBuilder chars = new StringBuilder(scan.nextLine()); // слово
        StringBuilder srahc = new StringBuilder();                // будующее слово в обратном порядке


        for (int i = chars.length() - 1; i > -1; i--) {
            srahc.append(chars.charAt(i));
        }

        System.out.println(chars.toString().equals(srahc.toString()));

    }

    static void task4() throws IOException {
        Logger LOG = Logger.getLogger(tasks.class.getName());  //  logging
        LOG.setLevel(Level.ALL);
        FileHandler fh = new FileHandler("log_task4.txt");
        LOG.addHandler(fh);
        //LOG.addHandler(ch);
        SimpleFormatter sf = new SimpleFormatter();
        fh.setFormatter(sf);

        try {
            Scanner a = new Scanner(System.in);
            System.out.println("Введите оператор + или - :  ");
            String ch = a.nextLine();
            LOG.info(String.format("Все в норме"));
            System.out.println("Введите число 1:  ");
            int num1 = a.nextInt();
            LOG.info(String.format("Все в норме"));
            System.out.println("Введите число 2:  ");
            int num2 = a.nextInt();
            LOG.info(String.format("Все в норме"));
            if (ch.equals("+")) {
                System.out.printf("%d + %d = %d", num1, num2, num1 + num2);
            } else {
                System.out.printf("%d - %d = %d", num1, num2, num1 - num2);
            }
            a.close();
            LOG.info(String.format("Все в норме"));
        } catch (Exception e) {
            LOG.warning("Чтото не так!!!");
        }
    }
}


