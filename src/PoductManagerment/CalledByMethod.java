package PoductManagerment;

import java.io.FileNotFoundException;

public class CalledByMethod {
    private I_Command command;
    public CalledByMethod(I_Command command){
        this.command = command;
    }
    public void runMethod() throws FileNotFoundException {
        if(this.command != null)
        this.command.excute();
    }
}
