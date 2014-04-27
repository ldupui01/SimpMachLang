/**
 * 
 */
package test;

import static org.junit.Assert.*;

import org.junit.Test;

import sml.Machine;

/**
 * @author Guilherme
 *
 */
public class MachineTest {

	/**
	 * Test method for {@link sml.Machine#hashCode()}.
	 */
	@Test
	public final void testHashCode() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link sml.Machine#main(java.lang.String[])}.
	 */
	@Test(timeout = 1000)
	public final void testMain() {
		String[] textArray = new String[2];
		textArray[0] = "testMML.txt";
		textArray[1] = "testMML2.txt";//note : is this how the registers should be referenced ? as integers? that would make sense
		Machine.main(textArray);
	}

	/**
	 * Test method for {@link sml.Machine#toString()}.
	 */
	@Test
	public final void testToString() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link sml.Machine#execute()}.
	 */
	@Test
	public final void testExecute() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link sml.Machine#getLabels()}.
	 */
	@Test
	public final void testGetLabels() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link sml.Machine#getProg()}.
	 */
	@Test
	public final void testGetProg() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link sml.Machine#getRegisters()}.
	 */
	@Test
	public final void testGetRegisters() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link sml.Machine#getPc()}.
	 */
	@Test
	public final void testGetPc() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link sml.Machine#setLabels(Labels)}.
	 */
	@Test
	public final void testSetLabels() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link sml.Machine#setProg(ArrayList)}.
	 */
	@Test
	public final void testSetProg() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link sml.Machine#setRegisters(Registers)}.
	 */
	@Test
	public final void testSetRegisters() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link sml.Machine#setPc(int)}.
	 */
	@Test
	public final void testSetPc() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link sml.Machine#equals(java.lang.Object)}.
	 */
	@Test
	public final void testEqualsObject() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link sml.Machine#canEqual(java.lang.Object)}.
	 */
	@Test
	public final void testCanEqual() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link sml.Machine#Machine()}.
	 */
	@Test
	public final void testMachine() {
		fail("Not yet implemented"); // TODO
	}

}
