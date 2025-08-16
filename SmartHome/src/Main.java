import smarthome.core.SmartDevices;
import smarthome.devices.*;
import smarthome.manager.Manager;
//Класс Main здесь выступает как пользоватль который вызывает то что ему нужно
// Остальное сделает класс Manager
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        Manager controller = new Manager();
        controller.addDevices(new SmartLamp("Alica"),new SmartFan("Midea"),
                new SmartCamera("Iphone"), new SmartColumn("Siri"));
        controller.turnAllOnSmart();
        controller.turnAllOffSmart();
        controller.turnOneDevice("Alica", true);
        controller.turnOneDevice("Siri", true);
        controller.turnOneDevice("Midea", true);
        controller.adjustLight("Siri",70);
        controller.adjustTemp("Midea",27);

        controller.addDevices1(new Thermostat("LG"));
        controller.turnAllDevices();
        controller.turnOneDifDevice("LG", true);
        controller.turnAllDevices();
        controller.difAdjustTemp("LG",45);
        controller.turnOneDevice("Siri", true);
        controller.adjustVolume("Alica",50);

        controller.turnSmartStove(40);




    }
}