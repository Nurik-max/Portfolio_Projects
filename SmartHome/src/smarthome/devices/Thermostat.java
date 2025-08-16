package smarthome.devices;

import smarthome.core.Devices;
import smarthome.interfaces.ISwitchable;
import smarthome.interfaces.ITemperature;
//Класс наследник - Наследует класс Device
public class Thermostat extends Devices implements ISwitchable, ITemperature {


    public Thermostat(String name){
        super(name);

    }
//Методы включения и выключения
    @Override
    public void turnOn() {
        System.out.println("Thermostat " + name + " is ON!");
        super.turnOn();
    }

    @Override
    public void turnOff() {

        System.out.println("Thermostat " + name + " is OFF!");
        super.turnOff();
    }
    @Override
    public void adjustTemp(int level) {
        System.out.println("Thermostat " + name +  " level: " + level);
    }
}
