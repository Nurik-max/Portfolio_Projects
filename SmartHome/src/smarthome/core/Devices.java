package smarthome.core;

import smarthome.interfaces.ISwitchable;

//Родительский класс обычных устройств
public class Devices implements ISwitchable {
    private Wifi wifi;
    private Bluetooth bluetooth;
    private boolean status;

    protected String name;
    public Devices(String name) {
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
    public boolean isStatus(){
        return status;
    }


}


