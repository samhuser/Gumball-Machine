package edu.iu.habahram.GumballMachine.model;

public class HasQuarterState implements IState{
    IGumballMachine gumballMachine;
    public HasQuarterState(IGumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }
    @Override
    public TransitionResult insertQuarter() {
        String message = "There is already a quarter";
        boolean succeeded = false;
        return new TransitionResult(succeeded, message, gumballMachine.getTheStateName(),gumballMachine.getCount());
    }
    @Override
    public TransitionResult ejectQuarter() {
        gumballMachine.changeTheStateTo(GumballMachineState.NO_QUARTER);
        String message = "Ejecting Quartered";
        boolean succeeded = true;
        return new TransitionResult(succeeded, message, gumballMachine.getTheStateName(), gumballMachine.getCount());
    }
    @Override
    public TransitionResult turnCrank() {
        String message = "You turned the crank dispensing!";
        gumballMachine.changeTheStateTo(GumballMachineState.GUMBALL_SOLD);
        boolean succeeded = true;
        return new TransitionResult(succeeded, message, gumballMachine.getTheStateName(), gumballMachine.getCount());
    }
    @Override
    public TransitionResult dispense() {
        String message = "You to turn the crank first";
        boolean succeeded = false;
        return new TransitionResult(succeeded, message, gumballMachine.getTheStateName(), gumballMachine.getCount());

    }
    @Override
    public String getTheName() {
        return GumballMachineState.OUT_OF_GUMBALLS.name();
    }
}
