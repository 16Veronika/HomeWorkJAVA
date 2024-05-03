import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MainNotebook {
    /**
     * @param args
     */
    public static void main(String[] args) {
        // Создание множества ноутбуков
        Set<Notebook> notebooks = new HashSet<>();
        notebooks.add(new Notebook(8, "Lenovo", 512, "Windows", "Black"));
        notebooks.add(new Notebook(16, "HP", 1024, "Windows", "Gray"));
        notebooks.add(new Notebook(16, "MacBook", 512, "macOS", "White "));
        notebooks.add(new Notebook(32, "Lg", 512, "Windows", "Black"));
        notebooks.add(new Notebook(2, "HP", 2048, "Windows", "Silver"));
        notebooks.add(new Notebook(8, "MacBook", 512, "macOS", "Pink"));
        notebooks.add(new Notebook(16, "MacBook", 512, "macOS", "White "));
        notebooks.add(new Notebook(4, "Lg", 512, "Windows", "Black"));
        notebooks.add(new Notebook(128, "HP", 1024, "Windows", "Silver"));
        notebooks.add(new Notebook(64, "MacBook", 512, "macOS", "Pink"));
        notebooks.add(new Notebook(16, "Dell", 1024, "Windows", "Silver"));
        notebooks.add(new Notebook(8, "HP", 256, "Linux", "Blue"));
        notebooks.add(new Notebook(16, "Apple", 512, "MacOS", "Pink"));
        notebooks.add(new Notebook(12, "Asus", 512, "Windows", "Gold"));
        notebooks.add(new Notebook(32, "MSI", 1024, "Windows", "Gold"));

        try (// Запрос критериев фильтрации
                Scanner scanner = new Scanner(System.in)) {
            Map<String, Object> criteria = new HashMap<>();
            System.out.println("Введите цифру, соответствующую критерию фильтрации:");
            System.out.println("1 - Модель");
            System.out.println("2 - ОЗУ");
            System.out.println("3 - Хранилище");
            System.out.println("4 - Операционная система");
            System.out.println("5 - Цвет");
            System.out.println("6 - Все критерии");
            int selection = scanner.nextInt();
            switch (selection) {
                case 1:
                    System.out.print("Введите требуемую модель: ");
                    String model = scanner.next();
                    criteria.put("Модель", model);
                    break;
                case 2:
                    System.out.print("Введите минимальный объем ОЗУ (Гб): ");
                    int minRAM = scanner.nextInt();
                    criteria.put("ОЗУ", minRAM);
                    break;
                case 3:
                    System.out.print("Введите минимальный объем жесткого диска (Гб): ");
                    int minStorage = scanner.nextInt();
                    criteria.put("Хранилище", minStorage);
                    break;
                case 4:
                    System.out.print("Введите требуемую операционную систему: ");
                    String operatingSystem = scanner.next();
                    criteria.put("ОС", operatingSystem);
                    break;
                case 5:
                    System.out.print("Введите требуемый цвет: ");
                    String color = scanner.next();
                    criteria.put("Цвет", color);
                    break;
                case 6:
                    System.out.print("Введите требуемую модель: ");
                    String modelInput = scanner.next();
                    criteria.put("Модель", modelInput);
                    System.out.print("Введите минимальный объем ОЗУ (Гб): ");
                    int minRAMInput = scanner.nextInt();
                    criteria.put("ОЗУ", minRAMInput);
                    System.out.print("Введите минимальный объем жесткого диска (Гб): ");
                    int minStorageInput = scanner.nextInt();
                    criteria.put("Хранилище", minStorageInput);
                    System.out.print("Введите требуемую операционную систему: ");
                    String operatingSystemInput = scanner.next();
                    criteria.put("ОС", operatingSystemInput);
                    System.out.print("Введите требуемый цвет: ");
                    String colorInput = scanner.next();
                    criteria.put("Цвет", colorInput);
                    break;
                default:
                    System.out.println("Неверный выбор.");
                    return;
            }

            // Фильтрация ноутбуков
            Set<Notebook> res = filterNotebooks(notebooks, criteria);
            if (res.isEmpty()) {
                System.out.println("Ноутбуки не найдены.");
            } else {

                // Вывод результатов
                System.out.println("Найденные ноутбуки:");
                for (Notebook notebook : res) {
                    System.out.println(notebook);
                }
            }
        }
    }

    // Метод для фильтрации ноутбуков по критериям
    public static Set<Notebook> filterNotebooks(Set<Notebook> notebooks, Map<String, Object> criteria) {
        Set<Notebook> res = new HashSet<>();
        for (Notebook notebook : notebooks) {
            boolean matchesCriteria = true;
            for (Map.Entry<String, Object> entry : criteria.entrySet()) {
                String criteriaKey = entry.getKey();
                Object value = entry.getValue();
                switch (criteriaKey) {
                    case "Модель":
                        if (!notebook.getModel().equalsIgnoreCase((String) value)) {
                            matchesCriteria = false;
                        }
                        break;
                    case "ОЗУ":
                        if (notebook.getRAM() < (int) value) {
                            matchesCriteria = false;
                        }
                        break;
                    case "Хранилище":
                        if (notebook.getStorage() < (int) value) {
                            matchesCriteria = false;
                        }
                        break;
                    case "ОС":
                        if (!notebook.getOperatingSystem().equalsIgnoreCase((String) value)) {
                            matchesCriteria = false;
                        }
                        break;
                    case "Цвет":
                        if (!notebook.getColor().equalsIgnoreCase((String) value)) {
                            matchesCriteria = false;
                        }
                        break;
                    default:
                        System.out.println("Неверный критерий.");
                        return res;
                }
            }
            if (matchesCriteria) {
                res.add(notebook);
            }
        }
        return res;
    }
}
