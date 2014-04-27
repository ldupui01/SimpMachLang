package sml;


/**
 * This class ....
 * 
 * @author someone
 */

public class LinInstruction extends Instruction {
	private int register;
	private int value;

	/*completely unnecessary code ?
	public LinInstruction(String label, String opcode) {
		super(label, opcode);
	}
	*/

	public LinInstruction(String label, int register, int value) {
		super(label, "lin");
		this.register = register;
		this.value = value;

	}

	@Override
	public void execute(MachineInterface m) {
		m.getRegisters().setRegister(register, value);
	}

	@Override
	public String toString() {
		return super.toString() + " register " + register + " value is "
				+ value;
	}
}
