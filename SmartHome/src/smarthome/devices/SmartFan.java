package smarthome.devices;

import smarthome.core.SmartDevices;
import smarthome.interfaces.ITemperature;
//Класс наследник - Наследует класс SmartDevice
public class SmartFan extends SmartDevices implements ITemperature {

    public SmartFan(String name){
        super(name);
    }
    //Метод для включения устройства, вайфай и блютуз. Все из родительского класса
    public void turnOn() {
        System.out.println("Smart fan: " + name + " is ON!");
        super.turnOn();

    }
    //Метод для выключения устройства, вайфай и блютуз. Все из родительского класса
    @Override
    public void turnOff() {
        System.out.println("Smart fan: " + name + " is OFF!");
        super.turnOff();

    }

    @Override
    public void adjustTemp(int level) {
        System.out.println("Fan temperature level: " + level);
    }

}
