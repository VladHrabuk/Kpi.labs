import java.util.Arrays;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Lab4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size_of_list, size_of_name_of_enterprise = 4, size_of_name_of_balls = 13, size_of_name_of_barbells = 16, temp = 1;/*Змінна size_of_list - це кількість
        об'єктів класу, size_of_name_of_enterprise, size_of_name_of_balls, size_of_name_of_barbells - змінні для гарного виводу таблиці з даними об'єктів класу,
        temp - змінна для визначення напряму сортування*/
        String name_of_balls, name_of_barbells, name_of_enterprise, parameter1;/*name_of_balls, name_of_barbells, name_of_enterprises - змінні для вводу імені
        м'ячів, штанг та компанії, відповідно; parameter1 - для перевірки атрибуту, за яким відбуватиметься сортування*/
        int quantity_of_balls, quantity_of_barbells;// змінні для задання атрибутів об'єктів
        while (true) {//Блок для вводу даних про кількість об'єктів
            try {
                System.out.print("Enter quantity of enterprises, where you want to deliver inventory: ");//Просимо ввести кількість об'єктів
                size_of_list = sc.nextInt();
                if (size_of_list <= 0) {//Перевірка, щоб кількість не була від'ємна
                    System.out.println("Quantity of enterprises cannot be less than 1!");
                    continue;
                }
                break;
            } catch (InputMismatchException exc) {//Обробка помилки при вводі даних неправильного типу
                System.out.println("It must be an integer, try again...");
                sc.next();
            }
        }
        Sport_Inventory[] list_of_enterprises = new Sport_Inventory[size_of_list];//Задаємо масив об'єктів класу
        for (int i = 0; i < size_of_list; i++) {//Блок для вводу даних про атрибути класу
            try {
                System.out.printf("Enter data about %d enterprise:\n", i + 1);//Просимо вводити користувача дані
                System.out.print("Enter name of enterprise: ");//Просимо ввести користувача ім'я компанії
                name_of_enterprise = sc.nextLine();/*Цей ввід слугує для того, щоб наступний nextLine() зміг працювати,
                бо nextInt() одразу не читає новий рядок після натискання на Enter*/
                name_of_enterprise = sc.nextLine();
                if (name_of_enterprise.length() > size_of_name_of_enterprise) {//Визначаємо довжину найбільшого імені для гарного виводу даних
                    size_of_name_of_enterprise = name_of_enterprise.length();
                }
                System.out.print("Enter name of company that produces balls: ");//Просимо ввести ім'я компанії виробників м'ячів
                name_of_balls = sc.nextLine();
                if (name_of_balls.length() > size_of_name_of_balls) {//Визначаємо довжину найбільшого імені для гарного виводу даних
                    size_of_name_of_balls = name_of_balls.length();
                }
                System.out.print("Enter quantity of balls you need: ");//Просимо ввести к-сть м'ячів
                quantity_of_balls = sc.nextInt();
                if (quantity_of_balls < 0) {//Перевірка на те, щоб кількість м'ячів не була від'ємною
                    System.out.println("Quantity of balls cannot be less than 0!");
                    i--;
                    continue;
                }
                System.out.print("Enter name of company that produces barbells: ");//Просимо ім'я компанії виробника штанг
                name_of_barbells = sc.nextLine();
                name_of_barbells = sc.nextLine();
                if (name_of_barbells.length() > size_of_name_of_barbells) {//Визначаємо довжину найбільшого імені для гарного виводу даних
                    size_of_name_of_barbells = name_of_barbells.length();
                }
                System.out.print("Enter quantity of barbells: ");//Просимо ввести кількість штанг
                quantity_of_barbells = sc.nextInt();
                if (quantity_of_barbells < 0) {//Перевірка на те, щоб кількість штанг не була від'ємною
                    System.out.println("Quantity of barbells cannot be less than 0!");
                    i--;
                    continue;
                }
                list_of_enterprises[i] = new Sport_Inventory(name_of_balls, quantity_of_balls, name_of_barbells, quantity_of_barbells, name_of_enterprise);//Визначаємо об'єкт класу
            } catch (InputMismatchException exc) {//Перевірка на ввід даних правильного типу
                System.out.println("Invalid type, try again...");
                i--;
                sc.next();
            }
        }
        Printing_List(list_of_enterprises, size_of_name_of_enterprise, size_of_name_of_balls, size_of_name_of_barbells);// Вивід за допомогою функції(див. нижче)
        System.out.println("\nList of parameters: enterprise, company:balls, balls, company:barbells, barbells");// Список параметрів, за якими відбуватиметься сортування
        parameter1 = sc.nextLine();//Цей ввід слугує для того, щоб наступний nextLine() зміг працювати, бо nextInt() одразу не читає новий рядок після натискання на Enter
        while (true) {//Блок для вводу параметру і перевірки його на відповідність заданим
            System.out.println("Enter parameter to sort objects:");//Просимо ввести користувача параметр
            parameter1 = sc.nextLine();
            if (parameter1.equals("enterprise") || parameter1.equals("company:balls") || parameter1.equals("balls") || parameter1.equals("company:barbells") || parameter1.equals("barbells")) {//Перевірка на відповідність параметра
                Sort(list_of_enterprises, parameter1, temp, size_of_name_of_enterprise, size_of_name_of_balls, size_of_name_of_barbells);//Викликаємо функцію, яка сортуватиме масив даних
                break;
            } else {
                System.out.println("Invalid parameter. Try again...");
            }
        }
        temp = 2;//Визначаємо для функції сортування, що це буде зворотнє сортування
        while (true) {//Блок для вводу параметру і перевірки його на відповідність заданим
            System.out.println("Enter parameter to sort objects in reverse order:");//Просимо ввести користувача параметр
            parameter1 = sc.nextLine();
            if (parameter1.equals("enterprise") || parameter1.equals("company:balls") || parameter1.equals("balls") || parameter1.equals("company:barbells") || parameter1.equals("barbells")) {//Перевірка на відповідність параметра
                Sort(list_of_enterprises, parameter1, temp, size_of_name_of_enterprise, size_of_name_of_balls, size_of_name_of_barbells);//Викликаємо функцію, яка сортуватиме масив даних
                break;
            } else {
                System.out.println("Invalid parameter. Try again...");
            }
        }
    }

    public static void Printing_List(Sport_Inventory[] enterprises, int size_of_name_of_enterprise, int size_of_name_of_balls, int size_of_name_of_barbells) {//Фунція для гарного виводу даних
        System.out.printf("%" + size_of_name_of_enterprise + "s | %" + size_of_name_of_balls + "s | Balls | %" + size_of_name_of_barbells + "s | Barbells\n" + "*".repeat(size_of_name_of_balls + size_of_name_of_barbells + size_of_name_of_enterprise + 13 + 3 * 4) + "\n", "Name", "Company:balls", "Company:barbells");
        for (Sport_Inventory enterprise : enterprises) {
            System.out.printf("%" + size_of_name_of_enterprise + "s | %" + size_of_name_of_balls + "s | %5d | %" + size_of_name_of_barbells + "s | %8d\n" + "*".repeat(size_of_name_of_balls + size_of_name_of_barbells + size_of_name_of_enterprise + 13 + 3 * 4) + "\n", enterprise.getName_of_enterprise(),
                    enterprise.getName_of_balls(), enterprise.getQuantity_of_balls(), enterprise.getName_of_barbell(), enterprise.getQuantity_of_barbells());//Використовуємо методи класу, що поветають значення відповідних атрибутів
        }
    }

    public static void Sort(Sport_Inventory[] enterprises, String parameter, int stat, int size_of_name_of_enterprise, int size_of_name_of_balls, int size_of_name_of_barbells) {//Фунція сортування
        if (stat == 1) {//Перевірка на те, який напрямок сортування
            if (parameter.equals("enterprise")) {
                Arrays.sort(enterprises, Comparator.comparing(Sport_Inventory::getName_of_enterprise));//За допомогою класу Arrays сортуємо масив даних; За допомогою Comparator.comparing() визначаємо, як сортуємо; :: - означає посилання на метод, тобто повертає ім'я кожного об'єкту
                Printing_List(enterprises, size_of_name_of_enterprise, size_of_name_of_balls, size_of_name_of_barbells);
            }
            if (parameter.equals("company:balls")) {
                Arrays.sort(enterprises, Comparator.comparing(Sport_Inventory::getName_of_balls));//За допомогою класу Arrays сортуємо масив даних; За допомогою Comparator.comparing() визначаємо, як сортуємо; :: - означає посилання на метод, тобто поветає ім'я кожного об'єкту
                Printing_List(enterprises, size_of_name_of_enterprise, size_of_name_of_balls, size_of_name_of_barbells);
            }
            if (parameter.equals("balls")) {
                Arrays.sort(enterprises, Comparator.comparing(Sport_Inventory::getQuantity_of_balls));//За допомогою класу Arrays сортуємо масив даних; За допомогою Comparator.comparing() визначаємо, як сортуємо; :: - означає посилання на метод, тобто поветає значення кожного об'єкту
                Printing_List(enterprises, size_of_name_of_enterprise, size_of_name_of_balls, size_of_name_of_barbells);
            }
            if (parameter.equals("company:barbells")) {
                Arrays.sort(enterprises, Comparator.comparing(Sport_Inventory::getName_of_barbell));//За допомогою класу Arrays сортуємо масив даних; За допомогою Comparator.comparing() визначаємо, як сортуємо; :: - означає посилання на метод, тобто поветає ім'я кожного об'єкту
                Printing_List(enterprises, size_of_name_of_enterprise, size_of_name_of_balls, size_of_name_of_barbells);
            }
            if (parameter.equals("barbells")) {
                Arrays.sort(enterprises, Comparator.comparing(Sport_Inventory::getQuantity_of_barbells));//За допомогою класу Arrays сортуємо масив даних; За допомогою Comparator.comparing() визначаємо, як сортуємо; :: - означає посилання на метод, тобто поветає значення кожного об'єкту
                Printing_List(enterprises, size_of_name_of_enterprise, size_of_name_of_balls, size_of_name_of_barbells);
            }
        } else if (stat == 2) {
            if (parameter.equals("enterprise")) {
                Arrays.sort(enterprises, Comparator.comparing(Sport_Inventory::getName_of_enterprise).reversed());//За допомогою класу Arrays сортуємо масив даних; За допомогою Comparator.comparing() визначаємо, як сортуємо; :: - означає посилання на метод, тобто поветає ім'я кожного об'єкту
                Printing_List(enterprises, size_of_name_of_enterprise, size_of_name_of_balls, size_of_name_of_barbells);
            }
            if (parameter.equals("company:balls")) {
                Arrays.sort(enterprises, Comparator.comparing(Sport_Inventory::getName_of_balls).reversed());//За допомогою класу Arrays сортуємо масив даних; За допомогою Comparator.comparing() визначаємо, як сортуємо; :: - означає посилання на метод, тобто поветає ім'я кожного об'єкту
                Printing_List(enterprises, size_of_name_of_enterprise, size_of_name_of_balls, size_of_name_of_barbells);
            }
            if (parameter.equals("balls")) {
                Arrays.sort(enterprises, Comparator.comparing(Sport_Inventory::getQuantity_of_balls).reversed());//За допомогою класу Arrays сортуємо масив даних; За допомогою Comparator.comparing() визначаємо, як сортуємо; :: - означає посилання на метод, тобто поветає значення кожного об'єкту
                Printing_List(enterprises, size_of_name_of_enterprise, size_of_name_of_balls, size_of_name_of_barbells);
            }
            if (parameter.equals("company:barbells")) {
                Arrays.sort(enterprises, Comparator.comparing(Sport_Inventory::getName_of_barbell).reversed());//За допомогою класу Arrays сортуємо масив даних; За допомогою Comparator.comparing() визначаємо, як сортуємо; :: - означає посилання на метод, тобто поветає ім'я кожного об'єкту
                Printing_List(enterprises, size_of_name_of_enterprise, size_of_name_of_balls, size_of_name_of_barbells);
            }
            if (parameter.equals("barbells")) {
                Arrays.sort(enterprises, Comparator.comparing(Sport_Inventory::getQuantity_of_barbells).reversed());//За допомогою класу Arrays сортуємо масив даних; За допомогою Comparator.comparing() визначаємо, як сортуємо; :: - означає посилання на метод, тобто поветає значення кожного об'єкту
                Printing_List(enterprises, size_of_name_of_enterprise, size_of_name_of_balls, size_of_name_of_barbells);
            }
        }
    }
}
