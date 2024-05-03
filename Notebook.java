import java.util.Objects;

public class Notebook {
    private String model;
    private int  RAM;           
    private int storage;
    private String operatingSystem;
    private String color;

    public Notebook(int RAM, String model, int storage, String operatingSystem, String color) {  // Конструкторы
        this.model = model;
        this.RAM = RAM;
        this.storage = storage;
        this.operatingSystem = operatingSystem;
        this.color = color;
    }
    public int getRAM() {
        return RAM;
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    @Override      //toString- переопределение строки String.format(будет человеческий язык)
    public String toString() {
        return String.format("Модель: %s, ОЗУ: %d,  Хранилище: %d, Операционная система: %s, Цвет: %s", model, RAM,  storage, operatingSystem, color);  //формат и сами поля
    }
    @Override             //сравниваем обьекты
    public boolean equals(Object obj) {
        if (this == obj) {      //если this этот (наши элементы)=obj 
            return true;        //правда(равны)
        }
        if (obj == null || getClass() != obj.getClass()) { //null обьявили,но не инициализировали(пусто) или getClass (наш класс) не=obj.getClass(что мы сравниваем)
            return false;
        }
        Notebook notebook = (Notebook) obj;   //обьекты -коты
        return RAM == notebook.RAM &&   //сравниваем числа через ==
        model.equals(notebook.model) &&  //строки через .equals
                storage == notebook.storage &&
                operatingSystem.equals(notebook.operatingSystem) &&
                color.equals(notebook.color);
    }
    @Override
    public int hashCode() {
        return Objects.hash(RAM, model, storage, operatingSystem, color);
    }
}

