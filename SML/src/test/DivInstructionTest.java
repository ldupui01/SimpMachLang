package test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

import sml.MachineInterface;
import sml.RegistersInterface;
import sml.DivInstruction;
import sml.Instruction;

public class DivInstructionTest {
	Instruction div;
	String example;
	@Mock 
	private MachineInterface m;
	@Mock
	private RegistersInterface r;
	@Before
	public void setUp() throws Exception {
		div = spy(new DivInstruction("L1",0,0,1));
		example = div.toString();
		initMocks(this);
	}

	@Test
	public final void testToString() {
		String expected = "L1: div 0 / 1 to 0";
		String input = example;
		System.out.println(example);
		assertEquals("ToString Overriding not working properly or not implemented", expected, input);
	}
	
	@Test
	public final void testExecute() {
		//mocking
		//MachineInterface m = mock(MachineInterface.class);
		//RegistersInterface r = mock(RegistersInterface.class);
		when(r.getRegister(0)).thenReturn(10);//simulate register 0 has the value of 10
		when(r.getRegister(1)).thenReturn(5);//simulate register 1 has the value of 5
		when(m.getRegisters()).thenReturn(r);
	
		//input
		div.execute(m);
		
		//test
		verify(m.getRegisters()).setRegister(0, 2);
	}

	@Test
	public final void testDivInstruction() {
		String[] expected = new String[3];
		expected[0] = "L1:";
		expected[1] = "0";
		expected[2] = "/";
		String[] exampleArray = example.split(" ");
		String[] input = new String[3];
		input[0] = exampleArray[0];
		input[1] = exampleArray[2];
		input[2] = exampleArray[3];
		
		assertTrue("DivInstruction is not an instance of instruction", div instanceof Instruction);
		assertArrayEquals("label, register and parameter are not being translated properly",expected, input);
	}
	
	@Test
	public final void testInstruction() {
		String[] expected = new String[2];
		expected[0] = "L1:";
		expected[1] = "div";
		String[] exampleArray = example.split(" ");
		String[] input = new String[2];
		input[0] = exampleArray[0];
		input[1] = exampleArray[1];
		
		assertTrue("DivInstruction is not an instance of instruction", div instanceof Instruction);
		assertArrayEquals("label and opcode are not being translated properly",expected, input);
	}
	
}
