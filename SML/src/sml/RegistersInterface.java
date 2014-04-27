package sml;

public interface RegistersInterface {

	public int[] getRegisters();

	public void setRegisters(int[] registers);

	/* (non-Javadoc)
	 * @see sml.RegistersInterface#setRegister(int, int)
	 */
	public void setRegister(int i, int v);

	/* (non-Javadoc)
	 * @see sml.RegistersInterface#getRegister(int)
	 */
	public int getRegister(int i);

}