package PoductManagerment;

import PoductManagerment.InterFace.I_Command;

import java.io.FileNotFoundException;

public class CallMethod {
    private I_Command command;
    public CallMethod(I_Command command){
        this.command = command;
    }
    public void runMethod() throws FileNotFoundException {
        if(this.command != null)
        this.command.excute();
    }
}
