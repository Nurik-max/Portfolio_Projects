package smarthome.devices;

import smarthome.core.SmartDevices;
import smarthome.interfaces.IBrightness;
//Класс наследник - Наследует класс SmartDevice
public class SmartCamera extends SmartDevices implements IBrightness {
    public SmartCamera(String name){
        super(name);
    }

    //Метод для включения устройства, вайфай и блютуз. Все из родительского класса
    @Override
    public void turnOn() {
        System.out.println( "Smart camera: " + name + " is ON!");
        super.turnOn();

    }
    //Метод для выключения устройства, вайфай и блютуз. Все из родительского класса
    @Override
    public void turnOff() {
        System.out.println("Smart camera: " + name + " is OFF!");
        super.turnOff();

    }
    @Override
    public void adjustLight(int level) {
        System.out.println("Level brightness: " + level);
    }

}
