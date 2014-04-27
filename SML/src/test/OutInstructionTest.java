package test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import sml.Instruction;
import sml.OutInstruction;
import sml.MachineInterface;
import sml.RegistersInterface;

public class OutInstructionTest {
	Instruction out;
	String example;
	MachineInterface m; 
	RegistersInterface r;
	
	@Before
	public void setUp() throws Exception {
		out = spy(new OutInstruction("L1",0));
		//mocking
		m = mock(MachineInterface.class);
		r = mock(RegistersInterface.class);
		when(r.getRegister(0)).thenReturn(5);//simulate register 0 has the value of 5
		when(m.getRegisters()).thenReturn(r);
		//
		out.execute(m);
		example = out.toString();

	}

	@Test
	public final void testToString() {
		String expected = "L1: out register 0 value is 5";
		String input = example;
		assertEquals("ToString Overriding not working properly or not implemented", expected, input);
	}

	@Test
	public final void testExecute() {
		//mocking and expected taken care of at @Before
		//test
		verify(m.getRegisters()).getRegister(0);

	}

	@Test
	public final void testOutInstruction() {
		String[] expected = new String[3];
		expected[0] = "L1:";
		expected[1] = "0";
		expected[2] = "5";
		String[] exampleArray = example.split(" ");
		String[] input = new String[3];
		input[0] = exampleArray[0];
		input[1] = exampleArray[3];
		input[2] = exampleArray[6];

		assertTrue("OutInstruction is not an instance of instruction", out instanceof Instruction);
		assertArrayEquals("label, register and parameter are not being translated properly",expected, input);
	}

	@Test
	public final void testInstruction() {
		String[] expected = new String[2];
		expected[0] = "L1:";
		expected[1] = "out";
		String[] exampleArray = example.split(" ");
		String[] input = new String[2];
		input[0] = exampleArray[0];
		input[1] = exampleArray[1];


		assertTrue("OutInstruction is not an instance of instruction", out instanceof Instruction);
		assertArrayEquals("label and opcode are not being translated properly",expected, input);
	}

}
