package test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Iterator;

import org.mockito.Mock;

import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;

import sml.Labels;
import sml.MachineInterface;
import sml.RegistersInterface;
import sml.BnzInstruction;
import sml.AddInstruction;
import sml.Instruction;

public class BnzInstructionTest {
	Instruction bnz;
	Instruction inst1;
	Instruction inst2;
	@Mock
	private MachineInterface m;
	@Mock
	private RegistersInterface r;
	@Mock 
	private Labels l;
	@Mock
	private ArrayList<Instruction> instAL;
	String example;
	@Before
	public void setUp() throws Exception {
		initMocks(this);
		this.bnz = new BnzInstruction("L1",10,"L3");
		this.inst1 = new AddInstruction("L2", 5, 1, 2);
		this.inst2 = new AddInstruction("L3", 20, 1, 2);
		instAL.add(bnz);
		instAL.add(inst1);
		instAL.add(inst2);
		l.addLabel("L1");
		l.addLabel("L2");
		l.addLabel("L3");
		example = bnz.toString();
	}

	@Test
	public final void testToString() {
		String expected = "L1: bnz next label being called is L3 until register 10 is 0";
		String input = example;
		assertEquals("ToString Overriding not working properly or not implemented", expected, input);
	}
	
	@Test
	public final void testExecute() {
		when(m.getRegisters()).thenReturn(r);
		when(m.getProg()).thenReturn(instAL);
		when(r.getRegister(10)).thenReturn(1);
		when(r.getRegister(5)).thenReturn(100);
		when(r.getRegister(1)).thenReturn(10);
		when(r.getRegister(2)).thenReturn(10);
		when(m.getLabels().indexOf("L3")).thenReturn(2);
		when(m.getLabels().indexOf("L2")).thenReturn(1);
		bnz.execute(m);
		verify(m.getRegisters()).setRegister(20, 20);
	}

	@Test
	public final void testBnzInstruction() {
		String[] expected = new String[3];
		expected[0] = "L1:";
		expected[1] = "10";
		expected[2] = "L2";
		String[] exampleArray = example.split(" ");
		String[] input = new String[3];
		input[0] = exampleArray[0];
		input[1] = exampleArray[2];
		input[2] = exampleArray[3];
		
		assertTrue("BnzInstruction is not an instance of instruction", bnz instanceof Instruction);
		assertArrayEquals("label, register and parameter are not being translated properly",expected, input);
	}
	
	@Test
	public final void testInstruction() {
		String[] expected = new String[2];
		expected[0] = "L1:";
		expected[1] = "bnz";
		String[] exampleArray = example.split(" ");
		String[] input = new String[2];
		input[0] = exampleArray[0];
		input[1] = exampleArray[1];
		
		assertTrue("BnzInstruction is not an instance of instruction", bnz instanceof Instruction);
		assertArrayEquals("label and opcode are not being translated properly",expected, input);
	}
	
}
