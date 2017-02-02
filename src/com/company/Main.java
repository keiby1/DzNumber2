package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static boolean checkNumber(String key) {
        Pattern p = Pattern.compile("[0-9]");
        Matcher m = p.matcher(key);
        return m.matches();
    }

    public static String Avatar() { //метод для проверки, является ли строка числом
        Scanner sc = new Scanner(System.in);
        Pattern num = Pattern.compile("[0-9]");
        System.out.println("Выбирите аватар(введите число, например 2): ");
        for (int i = 1; i < 4; i++) {
            System.out.println("№" + i);
            ShowPict("smile" + i + ".txt");
        }
        String numbA;
        while (true) {
            numbA = sc.nextLine(); //номер аватара
            Matcher m = num.matcher(numbA);
            if (m.matches())
                break;
            else
                System.out.println("Вы ввели не число! Введите еще раз!");
        }
        return numbA;
    }

    public static String preob(final String line) {
        return Character.toUpperCase(line.charAt(0)) + line.substring(1).toLowerCase();
    }

    public static String[] FIO() {
        String[] str = new String[3];
        Scanner sc = new Scanner(System.in);
        Pattern p = Pattern.compile("^[а-яА-ЯёЁa-zA-Z]+$");
        while (true) {
            System.out.println("Введите имя(только буквы, рус или англ): ");
            str[0] = sc.nextLine();
            Matcher m = p.matcher(str[0]);
            if (m.matches())
                break;
            else
                System.out.println("Не соответствует формату! Введите еще раз!");
        }
        str[0] = preob(str[0]);
        while (true) {
            System.out.println("Введите фамилию(только буквы, рус или англ): ");
            str[1] = sc.nextLine();
            Matcher m = p.matcher(str[1]);
            if (m.matches())
                break;
            else
                System.out.println("Не соответствует формату! Введите еще раз!");
        }
        str[1] = preob(str[1]);
        while (true) {
            System.out.println("Введите отчество(только буквы, рус или англ): ");
            str[2] = sc.nextLine();
            Matcher m = p.matcher(str[2]);
            if (m.matches())
                break;
            else
                System.out.println("Не соответствует формату! Введите еще раз!");
        }
        str[2] = preob(str[2]);
        return str;
    }

    public static String Home() {   //метод для проверки корректноти введеного адреса дома
        System.out.println("Введите № дома(например 152 или 18а): ");
        Pattern p = Pattern.compile("\\d+\\w*");
        Scanner sc = new Scanner(System.in);
        String home;
        while (true) {
            home = sc.nextLine();
            Matcher m = p.matcher(home);
            if (m.matches())
                break;
            else
                System.out.println("Не соответствует формату! Введите еще раз!");
        }
        return home;
    }

    public static String Phone() {   //метод для проверки корректноти введеного номера телефона
        System.out.println("Введите номер телефона(только цифры(11 цифр вместе с 8кой), начиная с 8ки): ");
        Pattern p = Pattern.compile("^8\\d{10}");
        Scanner sc = new Scanner(System.in);
        String phone;
        while (true) {
            phone = sc.nextLine();
            Matcher m = p.matcher(phone);
            if (m.matches())
                break;
            else
                System.out.println("Не соответствует формату! Введите еще раз!");
        }
        return phone;
    }

    public static String Site() {   //метод для проверки корректноти введеного адреса сайта
        System.out.println("Введите адрес личного сайта (например abcd.com): ");
        Scanner sc = new Scanner(System.in);
        Pattern p = Pattern.compile("-|^([a-zA-Z0-9]([a-zA-Z0-9\\-]{0,61}[a-zA-Z0-9])?\\.)+[a-zA-Z]{2,6}$"); //пример: - или http://vk.com/lushin
        String site;
        while (true) {
            site = sc.nextLine();
            Matcher m = p.matcher(site);
            if (m.matches())
                break;
            else
                System.out.println("Не соответствует формату! Введите еще раз!");
        }
        return site;
    }

    public static String Pasport() {
        Scanner sc = new Scanner(System.in);
        String pasp;
        Pattern pPasport = Pattern.compile("[0-9]{2} [0-9]{2} [0-9]{6}");
        System.out.println("Введите паспортные данные(формат: ii ii iiiiii): ");
        while (true) {
            pasp = sc.nextLine();
            Matcher m = pPasport.matcher(pasp);
            if (m.matches())
                break;
            else
                System.out.println("Введенная строка не соответствует формату! Введите еще раз.");
        }
        return pasp;
    }

    public static String Pasport2() { //кем и когда выдан
        Scanner sc = new Scanner(System.in);
        Pattern p = Pattern.compile("(^[а-яА-ЯёЁa-zA-Z*\\s]+$)");
        String[] str = new String[2];
        while (true) {
            System.out.println("Введите информацию о том кем (Текст, пробелы)");
            str[0] = sc.nextLine();
            Matcher m = p.matcher(str[0]);
            if (m.matches())
                break;
            else
                System.out.println("Не соответствует формату! Введите еще раз!");
        }
        str[0] = Abbreviat(str[0]);
        p = Pattern.compile("(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d");
        while (true) {
            System.out.println("Введите информацию о том  и когда выдан паспорт (Дата в формате дд/мм/гггг):");
            str[1] = sc.nextLine();
            Matcher m = p.matcher(str[1]);
            if (m.matches())
                break;
            else
                System.out.println("Не соответствует формату! Введите еще раз!");
        }
        str[0] = Abbreviat(str[0]);
        return " " + str[0] + " " + str[1];
    }

    private static String Abbreviat(String s) {
        s = s.replace("увд", "УВД");
        s = s.replace("гровд", "ГРОВД");
        s = s.replace("ровд", "РОВД");
        return s;
    }

    public static String Mail() {
        Scanner sc = new Scanner(System.in);
        String mail;
        Pattern p = Pattern.compile("^[-\\w.]+@([A-z0-9][-A-z0-9]+\\.)+[A-z]{2,4}$");
        System.out.println("Введите адрес эл.почты(): ");
        while (true) {
            mail = sc.nextLine();
            Matcher m = p.matcher(mail);
            if (m.matches())
                break;
            else
                System.out.println("Не соответствует формату! Введите еще раз!");
        }
        return mail;
    }

    public static String[] CityAndStreet() {
        Scanner sc = new Scanner(System.in);
        Pattern p = Pattern.compile("^[а-яА-ЯёЁa-zA-Z]+$");
        String[] str = new String[2];

        while (true) {
            System.out.println("Введите город(Только буквы): ");
            str[0] = sc.nextLine();
            Matcher m = p.matcher(str[0]);
            if (m.matches())
                break;
            else
                System.out.println("Не соответствует формату! Введите еще раз!");
        }

        while (true) {
            System.out.println("Введите улицу(только буквы): ");
            str[1] = sc.nextLine();
            Matcher m = p.matcher(str[1]);
            if (m.matches())
                break;
            else
                System.out.println("Не соответствует формату! Введите еще раз!");
        }
        return str;
    }

    public static String[] PositionAndDopInfo() {
        Scanner sc = new Scanner(System.in);
        Pattern p = Pattern.compile("-|(^[а-яА-ЯёЁa-zA-Z]+$)");
        String[] str = new String[2];

        while (true) {
            System.out.println("Введите должность(Только текст, либо - ): ");
            str[0] = sc.nextLine();
            Matcher m = p.matcher(str[0]);
            if (m.matches())
                break;
            else
                System.out.println("Не соответствует формату! Введите еще раз!");
        }
        p = Pattern.compile("-|(^[а-яА-ЯёЁa-zA-Z-,.;:*\\s]+$)");
        while (true) {
            System.out.println("Введите дополнительную информацию(Текст, пробелы и знаки препинания)");
            str[1] = sc.nextLine();
            Matcher m = p.matcher(str[1]);
            if (m.matches())
                break;
            else
                System.out.println("Не соответствует формату! Введите еще раз!");
        }
        return str;
    }

    public static void delete(String nameFile) { //метод для удаления файла с информацией о владельце страницы
        new File(nameFile).delete();
    }

    public static void ShowPict(String img) { //метод отображающий аватар (аватары в хранятся в текстовых файлах)
        try (BufferedReader r = new BufferedReader(new FileReader(img))) {
            String tmp;
            while ((tmp = r.readLine()) != null) {
                System.out.println(tmp);
            }
            System.out.println();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void Show(String s) { //метод отображения страницы пользователя
        System.out.println(s);
        try (BufferedReader r = new BufferedReader(new FileReader(s + ".txt"))) {
            String tmp;
            while ((tmp = r.readLine()) != null) {
                if (s.equals(tmp)) {
                    String img = r.readLine();
                    ShowPict(img);
                    for (int i = 0; i < 12; i++) {
                        System.out.println(r.readLine());
                    }
                    while ((tmp = r.readLine()) != null) {//выводит дополнительную информацию
                        System.out.println(tmp);
                    }
                    break;
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static void Chg(String s) { //метод изменения информации на странице
        String numbA = Avatar();
        String[] str = FIO();
        String name = str[0],
                fam = str[1],
                otc = str[2];
        String mail = Mail();
        String[] tmp = CityAndStreet();
        String city = tmp[0],
                street = tmp[1];
        String home = Home();
        String pasp = Pasport();
        pasp += Pasport2();
        String phone = Phone();
        String site = Site();
        tmp = PositionAndDopInfo();
        String dol = tmp[0],
                dop = tmp[1];

        try (FileWriter fw = new FileWriter(s + ".txt", false)) {
            fw.write(s + "\r\n");
            fw.write("smile" + numbA + ".txt\r\n");
            fw.write(fam + "\r\n");
            fw.write(name + "\r\n");
            fw.write(otc + "\r\n");
            fw.write(mail + "\r\n");
            fw.write(city + "\r\n");
            fw.write(street + "\r\n");
            fw.write(home + "\r\n");
            fw.write(pasp + "\r\n");
            fw.write(phone + "\r\n");
            fw.write(site + "\r\n");
            fw.write(dol + "\r\n");
            fw.write(dop + "\r\n");
            fw.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void del(String s) {      //метод удаления страницы
       /*Из файла с логинами логины записываются в список, из списка удаляется используемый
       в двнный момент логин, и список перезаписывается в файл. Затем происходит удаление файла с
       информацией о владельце страницы
        */
        ArrayList<String> list = new ArrayList();
        try (BufferedReader r = new BufferedReader(new FileReader("login.txt"))) {
            String t;
            while ((t = r.readLine()) != null) {
                list.add(t);
            }
            r.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try (FileWriter fw = new FileWriter("login.txt", false)) {
            list.remove(s);
            for (int i = 0; i < list.size(); i++) {
                fw.write(list.get(i) + "\r\n");
            }
            fw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        delete(s + ".txt");
    }

    public static void head(String login) {
        //метод отображающий меню действий, которые может совершить "авторизованный" пользователь
        System.out.println("Welcome!");
        System.out.println("1-Посмотреть страницу");
        System.out.println("2-Изменить");
        System.out.println("3-Удалить");
        Scanner sc = new Scanner(System.in);
        String key = sc.next();
        if (checkNumber(key) == true)
            switch (key) {
                case "1": {
                    Show(login);        //вызов метода отображения информации
                    break;
                }
                case "2": {
                    Chg(login);         //вызов метода изменения информации
                    break;
                }
                case "3": {
                    del(login);         //вызов метода удаления страницы
                    break;
                }
                default: {
                    head(login);
                    break;
                }
            }
        else
            System.out.println("Вы ввели не число!");
    }

    public static void register() {
        //метод регистрации
        //Логин введеный пользователем сохраняется в файл с логинами,
        // затем вызывается метод изменения информации, с помощью которого создается файл с информацией о пользователе
        System.out.println("Регистрация:\nВведите логин: ");
        Scanner sc = new Scanner(System.in);
        String login = sc.nextLine();
        try (FileWriter fw = new FileWriter("login.txt", true)) {
            fw.append(login + "\r\n");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        Chg(login);

    }

    public static void welc() {
       /*метод для авторизации. Проверяет существует ли введенный логин в базе,
       если нет то вызывается метод регистрации*/
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите логин: ");
        String s = sc.next();
        Boolean flag = false;
        try (BufferedReader r = new BufferedReader(new FileReader("login.txt"))) {
            String tmp;
            while ((tmp = r.readLine()) != null) {
                if (s.equals(tmp)) {
                    head(s);
                    flag = true;
                    break;
                }
            }
            if (flag == false) {
                System.out.println("Логин не найден, зарегистрируйтесь!");
                register();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static void quest() {
       /*Метод с "Главным меню". Используется для предоставления пользователю выбора - регистрация или вход*/
        System.out.println("1-Регистрация\n2-Вход");
        Scanner sc = new Scanner(System.in);
        String key = sc.next();
        if (checkNumber(key))
            switch (key) {
                case "1": {
                    register();
                    break;
                }
                case "2": {
                    welc();
                    break;
                }
                default:
                    quest();
            }
        else
            System.out.println("Вы ввели не число!");
    }

    public static void main(String[] args) {
        quest();    //вызывает метод, для отображения главного меню
    }
}

