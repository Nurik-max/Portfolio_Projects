package smarthome.devices;

import smarthome.core.SmartDevices;
import smarthome.interfaces.IVolume;
//Класс наследник - Наследует класс SmartDevice
public class SmartColumn extends SmartDevices implements IVolume {

    public SmartColumn(String name){
        super(name);
    }

    //Метод для включения устройства, вайфай и блютуз. Все из родительского класса
    @Override
    public void turnOn() {
        System.out.println("Smart column: " + name + " is ON!");
        super.turnOn();

    }
    //Метод для выключения устройства, вайфай и блютуз. Все из родительского класса
    @Override
    public void turnOff() {
        System.out.println("Smart column: " + name + " is OFF!");
        super.turnOff();

    }

    @Override
    public void adjustVolume(int level) {
        System.out.println("Column volume level: " + level);
    }
}
