package smarthome.manager;
import smarthome.core.Devices;
import smarthome.core.SmartDevices;
import smarthome.devices.*;
import smarthome.interfaces.ISwitchable;

import java.util.ArrayList;
//Класс Manager - отвечает за всю логику взаимодействия и вывода информации
public class Manager  {

    //Коллекция для списка Умных устройств
private ArrayList<SmartDevices> devices = new ArrayList<>();
    // Коллекция для списка обычных устройств
    private ArrayList<Devices> difDevices = new ArrayList<>();

    //Метод для добавления обычных устройств
    public void addDevices1(Devices... difDevices) {
        for (Devices device1 : difDevices) {
            this.difDevices.add(device1);
        }


    }
    //Метод для вызова всех обычных устройств
    public void turnAllDevices() {

        for (Devices device1 : difDevices) {
            device1.turnOn();
            //Выводит имя и статус устройства
            System.out.println(device1.getName() + " status: " + device1.isStatus() + "\n");
        }
    }
    //Метод для вызова конкретного устройства по имени
    public void turnOneDifDevice(String name, boolean status){
        boolean found = false; /*Флаг для будущего выяснения, сейчас она ложная то есть нужный
        девайс пока еще не найден*/
        for (Devices device1 : difDevices) {
            if (device1.getName().equals(name)) {
                found = true;//Меняем на true потому что нужный девайс найден
                if (status) { // проверяем статус девайса который совпал по типу и поимени
                    device1.turnOn();// выполняем метод для вывода девайса
                    System.out.println("\t");
                    break;

                }

                else {
                    device1.turnOff();//выключаем если статус мы изменили
                    System.out.println("\t");
                    break;
                }

            }


        }
        if(!found) { // если не нашли девайс выводим сообщение

            //System.out.println("Device with name: " + name + " not listed");
            ISwitchable.logError("This device not listed", name);
            ISwitchable.logInfo("Try again");

        }

    }


    //Метод для регулирования температуры у обычных устройств
    public void difAdjustTemp(String name, int level) {
        boolean found = false;

        for (Devices device1 : difDevices) {
            // Проверка типа и имени
            if (device1 instanceof Thermostat && device1.getName().equals(name)) {
                found = true;

                if (device1.isStatus()) {
                    ((Thermostat) device1).adjustTemp(level);
                    System.out.println("\n");
                } else {
                    System.out.println("Device " + name + " is OFF! Turn ON device!" + "\n");

                }

                break; // Выход, так как устройство найдено и обработано
            }
        }

        if (!found) {
            //System.out.println("Device with name " + name + " does not have such functions" + "\n");
            ISwitchable.logError("This device not listed", name);
            ISwitchable.logInfo("Try again");
        }
    }



    //Метод для добавления Умных устройств
    public void addDevices(SmartDevices... devices) {
        for (SmartDevices device : devices) {
            this.devices.add(device);
        }
    }

//Метод для вывода и включения всех умных устройств
public void turnAllOnSmart(){
    for (SmartDevices device : devices) {
        device.turnOn();
        System.out.println("\n");
    }

}
//Метод для вывода и выключения всех умных устройств
public void turnAllOffSmart(){
    for (SmartDevices device : devices) {
        device.turnOff();
        System.out.println("\n");
    }
}
//Метод для вывода и выключения конкретного умного устройства
public void turnOneDevice(String name, boolean status){
        boolean found = false;
        for (SmartDevices device : devices) {
            if (device.getName().equals(name)) {
                found = true;
                if (status) {
                    device.turnOn();
                    System.out.println("\n");
                    break;
                }

                else {
                device.turnOff();
                    System.out.println("\n");
                break;
                  }

            }


        }
    if(!found) {

        ISwitchable.logError("This device not listed", name);
        ISwitchable.logInfo("Try again");
        //System.out.println("Device with name: " + name + " not listed");
    }

    }



//Метод для регулировки яркости умных устройств
public void adjustLight(String name, int level){
    for (SmartDevices device : devices) {
        if(device.getName().equals(name)) {
            if(device.isStatus()) {
                if (device instanceof SmartLamp || device instanceof SmartCamera) {/*Проверка типа на то что типом является
                класс Умная лампа и Умная камера*/
                    device.adjustLight(level);
                    System.out.println("\n");
                    break;
                } else System.out.println("Device with name " + name + " does not have such functions");
            }
            if(!device.isStatus()){
                ISwitchable.logError("This device not listed", name);
                ISwitchable.logInfo("Try again");
            }
                //System.out.println("Devise " + name + " is OFF! Turn ON device!");
        }
    }
}
//Метод для регулировки температуры умных устройств
public void adjustTemp(String name, int level){
boolean found = false;
    for (SmartDevices device : devices) {
        if (device instanceof SmartFan && device.getName().equals(name)) {

            found = true;
            if (device.isStatus()) {
                ((SmartFan) device).adjustTemp(level);
                System.out.println("\n");

            } else {
                System.out.println("Devise " + name + " is OFF! Turn ON device!" + "\n");
            }
            break;
        }


    }
    if (!found) {
        //System.out.println("Device with name " + name + " does not have such functions" + "\n");
        ISwitchable.logError("This device not listed", name);
        ISwitchable.logInfo("Try again");

    }
}
//Метод для регулировки звука умных устройств
    public void adjustVolume(String name, int level){
        boolean found = false;
        for (SmartDevices device : devices) {
            if (device instanceof SmartColumn && device.getName().equals(name)) {

                found = true;
                if (device.isStatus()) {
                    ((SmartColumn) device).adjustVolume(level);
                    System.out.println("\n");

                } else {
                    System.out.println("Devise " + name + " is OFF! Turn ON device!" + "\n");
                }
                break;
            }


        }
        if (!found) {
            //System.out.println("Device with name " + name + " does not have such functions" + "\n");
            ISwitchable.logError("This device not listed", name);
            ISwitchable.logInfo("Try again");

        }
    }
//Анонимный объект
    SmartDevices smartStove = new SmartDevices("Lenovo"){
        @Override
        public void turnOn() {
            super.turnOn();
            System.out.println("Smart stove: " + name + " is active");
        }

        @Override
        public void adjustTemp(int level) {
            super.adjustTemp(level);
            System.out.println("Smart stove temperature: " + level);
        }
        public String getName(){
            return name;
        }
    };
public void turnSmartStove(int level) {

smartStove.turnOn();
smartStove.adjustTemp(level);
String name = smartStove.getName();
}

}
