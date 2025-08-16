package smarthome.core;

import smarthome.interfaces.IBrightness;
import smarthome.interfaces.ISwitchable;
import smarthome.interfaces.ITemperature;
//Родительский класс умных устройств
public class SmartDevices implements ISwitchable, IBrightness, ITemperature {
    private Wifi wifi;
    private Bluetooth bluetooth;
    private boolean status;

    protected String name;
    public SmartDevices(String name) {
        this.name = name;
        this.wifi = new Wifi();
        this.bluetooth = new Bluetooth();
    }
    public String getName() {
       // System.out.println(name);
        return name;
    }



    @Override
    public void turnOn() {
        status = true;
        wifi.connected();
        bluetooth.enable();
    }

    @Override
    public void turnOff() {
    status = false;
    wifi.disconnected();
    bluetooth.disable();
    }

    @Override
    public void adjustLight(int level) {

    }

    public boolean isStatus(){ //Метод возвращения статуса
        return status;
    }

    @Override
    public void adjustTemp(int level) {

    }
}
