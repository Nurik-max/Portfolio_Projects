package smarthome.devices;

import smarthome.core.SmartDevices;

import smarthome.interfaces.IBrightness;
//Класс наследник - Наследует класс SmartDevice
public class SmartLamp extends SmartDevices implements IBrightness {

    public SmartLamp(String name){
        super(name);
    }

    //Метод для включения устройства, вайфай и блютуз. Все из родительского класса
    @Override
    public void turnOn() {
        System.out.println("Smart lamp: " + name + " is ON!");
        super.turnOn();

    }
    //Метод для выключения устройства, вайфай и блютуз. Все из родительского класса
    @Override
    public void turnOff() {
        System.out.println("Smart lamp: " + name + " is OFF!");
        super.turnOff();

    }

    @Override
    public void adjustLight(int level) {
        System.out.println("Level brightness: " + level);
    }

//    @Override
//    public String getName() {
//        return super.getName();
    //}
}



