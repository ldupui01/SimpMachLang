package sml;


/**
 * This class ....
 * 
 * @author someone
 */

public class BnzInstruction extends Instruction {
	private int register;
	private String nextLabel;

	/*completely unnecessary code ?
	public OutInstruction(String label, String opcode) {
		super(label, opcode);
	}
	*/

	

	public BnzInstruction(String label, int s1, String nextLabel) {
		super(label, "bnz");
		this.register = s1;
		this.nextLabel = nextLabel;
	}

	@Override
	public void execute(MachineInterface m) {
		int value1 = m.getRegisters().getRegister(register);
		if(value1 != 0){
			m.setPc(m.getLabels().indexOf(nextLabel));
		}
	}

	@Override
	public String toString() {
		return super.toString() + " next label being called is " + nextLabel + " until register " + register + " is 0";
	}
}
