package sml;

import java.util.ArrayList;

public interface MachineInterface {

	public Labels getLabels();

	public int getPc();

	public ArrayList<Instruction> getProg();

	public RegistersInterface getRegisters();

	public void setLabels(Labels labels);

	public void setPc(int pc);

	public void setProg(ArrayList<Instruction> prog);

	public void setRegisters(Registers registers);

	public void execute();

}