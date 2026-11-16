package com.pf2.tasks;

import com.pf2.model.CentralSoldadura;
import com.pf2.model.CintaTransportadora;
import com.pf2.model.SupervisorCentral;

public class RobotTask implements Runnable{

    private int num;
    private boolean cer = false;
    private volatile String estado = "Libre";
    CentralSoldadura sol = new CentralSoldadura();
    CintaTransportadora cinta = new CintaTransportadora();
    SupervisorCentral supervisor = new SupervisorCentral();

    public RobotTask(int num, CentralSoldadura sol, CintaTransportadora cinta, SupervisorCentral supervisor){
        this.num = num;
        this.sol = sol;
        this.cinta = cinta;
        this.supervisor = supervisor;
    }

    public String getEstado(){
        return estado;
    }

    public int getNum(){
        return num;
    }

    public void setEstado(String estado){
        this.estado = estado;
    }

    @Override 
    public void run(){
        
        try{
            Thread.sleep(2000);
            estado = "Comprovando emergencia";
            supervisor.comprobar();

            Thread.sleep(1000);
            estado = "Esperando estacion";
            sol.sem.acquire();
            try{
                estado = "Buscando bateria";
                cinta.dec();

                if(cinta.bol) {
                    estado = "Soldando";
                    cer = true;

                    Thread.sleep(2000);

                    estado = "Soldadura terminada";
                }else{
                    estado = "Sin baterias";
                }
        }finally{
            sol.sem.release();
        }
        
        if(cer) {
            estado = "Esperando tablero";
            sol.mutex.acquire();

            try{
                estado = "Firmando certificado";

                Thread.sleep(1000);
            }finally{
                sol.mutex.release();
            }
        }

        estado = "Finalizado";
    
        }catch(InterruptedException e){
            e.getMessage();
            estado = "Interrumpido";
        }
    }
}