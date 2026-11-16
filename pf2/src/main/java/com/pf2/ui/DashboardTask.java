package com.pf2.ui;

import java.util.ArrayList;
import java.util.List;

import com.pf2.model.CentralSoldadura;
import com.pf2.model.CintaTransportadora;
import com.pf2.tasks.RobotTask;

public class DashboardTask implements Runnable{
    CentralSoldadura sol;
    CintaTransportadora cinta;
    List<RobotTask> robots = new ArrayList<>();

    public DashboardTask(CentralSoldadura sol, CintaTransportadora cinta, List<RobotTask> robots){
        this.sol = sol;
        this.cinta = cinta;
        this.robots = robots;
    }

    @Override 
    public void run(){
        while(true) {
            IO.println("Dashboard:");
            IO.println("Baterias disponibles: " + cinta.getBaterias());
            IO.println("Estaciones libres: " + sol.getEstacionesLibres());
            IO.println("Estaciones ocupadas: " + sol.getEstacionesOcupadas());
            for(RobotTask r : robots){
                IO.println("Robot: " + r.getNum() + " , estado: " + r.getEstado());
            }
            IO.println("-------------------------------");

            try{
                Thread.sleep(2000);
            }catch(InterruptedException e){
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
