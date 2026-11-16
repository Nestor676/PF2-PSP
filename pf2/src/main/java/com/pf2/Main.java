package com.pf2;

import java.util.ArrayList;
import java.util.List;

import com.pf2.model.CentralSoldadura;
import com.pf2.model.CintaTransportadora;
import com.pf2.model.SupervisorCentral;
import com.pf2.tasks.AGVTask;
import com.pf2.tasks.RobotTask;
import com.pf2.ui.DashboardTask;

public class Main {
    public static void main(String[] args) throws InterruptedException{
        CentralSoldadura cs = new CentralSoldadura();
        CintaTransportadora cinta = new CintaTransportadora();
        SupervisorCentral supervisor = new SupervisorCentral();
        List<RobotTask> robots = new ArrayList<>();

        int num = (int) (Math.random() * 2);

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
        
        RobotTask r1 = new RobotTask(1, cs, cinta, supervisor);
        Thread tr1 = new Thread(r1);

        RobotTask r2 = new RobotTask(2, cs, cinta, supervisor);
        Thread tr2 = new Thread(r2);

        RobotTask r3 = new RobotTask(3, cs, cinta, supervisor);
        Thread tr3 = new Thread(r3);

        RobotTask r4 = new RobotTask(4, cs, cinta, supervisor);
        Thread tr4 = new Thread(r4);

        robots.add(r1);
        robots.add(r2);
        robots.add(r3);
        robots.add(r4);

        DashboardTask dashboardTask = new DashboardTask(cs, cinta, robots);
        Thread tdash = new Thread(dashboardTask);

        tdash.start();

        tr1.start();
        tr2.start();
        tr3.start();
        tr4.start();

        supervisor.activar(num);

        if(num == 1) {
            Thread.sleep(5000);
            supervisor.desactivar();
        }

        tr1.join();
        tr2.join();
        tr3.join();
        tr4.join();

        tdash.interrupt();
        tdash.join();
    }
}