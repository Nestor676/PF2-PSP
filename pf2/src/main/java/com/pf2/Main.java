package com.pf2;

import com.pf2.model.CentralSoldadura;
import com.pf2.tasks.RobotTask;

public class Main {
    public static void main(String[] args) throws InterruptedException{
        CentralSoldadura cs = new CentralSoldadura();
        
        RobotTask r1 = new RobotTask(1, cs);
        Thread tr1 = new Thread(r1);

        RobotTask r2 = new RobotTask(2, cs);
        Thread tr2 = new Thread(r2);

        RobotTask r3 = new RobotTask(3, cs);
        Thread tr3 = new Thread(r3);

        RobotTask r4 = new RobotTask(4, cs);
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