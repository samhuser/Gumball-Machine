package edu.iu.habahram.GumballMachine.model;

public class SoldState implements IState{
    IGumballMachine gumballMachine;
    public SoldState(IGumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
    @Override
    public TransitionResult insertQuarter() {
        String message = "The Machine is dispensing";
        boolean succeeded = false;
        return new TransitionResult(succeeded, message, gumballMachine.getTheStateName(),gumballMachine.getCount());
    }
    @Override
    public TransitionResult ejectQuarter() {
        String message = "The machine is dispensing please wait";
        boolean succeeded = false;
        return new TransitionResult(succeeded, message, gumballMachine.getTheStateName(), gumballMachine.getCount());
    }
    @Override
    public TransitionResult turnCrank() {
        String message = "Please wait, machine is ejecting";
        boolean succeeded = false;
        return new TransitionResult(succeeded, message, gumballMachine.getTheStateName(), gumballMachine.getCount());
    }
    @Override
    public TransitionResult dispense() {
        String message = "Here is the gumball!";
        boolean succeeded = true;
        int count = gumballMachine.getCount();
        count -= 1;
        if(count > 0){
            gumballMachine.changeTheStateTo(GumballMachineState.NO_QUARTER);
        }else{
            gumballMachine.changeTheStateTo(GumballMachineState.OUT_OF_GUMBALLS);
        }
        return new TransitionResult(succeeded, message, gumballMachine.getTheStateName(), count);
    }
    @Override
    public String getTheName() {
        return GumballMachineState.OUT_OF_GUMBALLS.name();
    }
}
