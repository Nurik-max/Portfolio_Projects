package smarthome.interfaces;

public interface ISwitchable {
    void turnOn(); //Метод включения
    void turnOff();//Метод выключения

    //Методы логирования ошибок
static void logError(String massage, String name){

    System.out.println("Error: " + massage);
}

static void logInfo(String massage){

    System.out.println("Info: " + massage);
}


}
