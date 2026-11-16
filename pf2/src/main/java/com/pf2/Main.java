package com.pf2;

import com.pf2.model.CentralSoldadura;
import com.pf2.model.CintaTransportadora;
import com.pf2.tasks.AGVTask;
import com.pf2.tasks.RobotTask;

public class Main {
    public static void main(String[] args) throws InterruptedException{
        CentralSoldadura cs = new CentralSoldadura();
        CintaTransportadora cinta = new CintaTransportadora();

        AGVTask a1 = new AGVTask(cinta);
        Thread ta1 = new Thread(a1);

        AGVTask a2 = new AGVTask(cinta);
        Thread ta2 = new Thread(a2);

        AGVTask a3 = new AGVTask(cinta);
        Thread ta3 = new Thread(a3);

        ta1.start();
        ta2.start();
        ta3.start();

        ta1.join();
        ta2.join();
        ta3.join();
        
        RobotTask r1 = new RobotTask(1, cs, cinta);
        Thread tr1 = new Thread(r1);

        RobotTask r2 = new RobotTask(2, cs, cinta);
        Thread tr2 = new Thread(r2);

        RobotTask r3 = new RobotTask(3, cs, cinta);
        Thread tr3 = new Thread(r3);

        RobotTask r4 = new RobotTask(4, cs, cinta);
        Thread tr4 = new Thread(r4);

        tr1.start();
        tr2.start();
        tr3.start();
        tr4.start();

        tr1.join();
        tr2.join();
        tr3.join();
        tr4.join();
    }
}