package br.com.rafael.usercases;

import static org.junit.jupiter.api.Assertions.assertEquals;

import br.com.rafael.persistences.models.ProbeModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProbeServiceTest {
	
	@Autowired
	private ProbeUserCase subject;
	
	@Test
	public void should_change_probe_direction_from_N_To_W_when_receive_the_command_L() {
		ProbeModel probeModel = new ProbeModel();
		probeModel.setDirection('N');
		subject.applyCommandToProbe(probeModel, 'L');
		assertEquals('W', probeModel.getDirection());
	}
	
	@Test
	public void should_change_probe_direction_from_W_To_S_when_receive_the_command_L() {
		ProbeModel probeModel = new ProbeModel();
		probeModel.setDirection('W');
		subject.applyCommandToProbe(probeModel, 'L');
		assertEquals('S', probeModel.getDirection());
	}
	
	@Test
	public void should_change_probe_direction_from_S_To_E_when_receive_the_command_L() {
		ProbeModel probeModel = new ProbeModel();
		probeModel.setDirection('S');
		subject.applyCommandToProbe(probeModel, 'L');
		assertEquals('E', probeModel.getDirection());
	}
	
	@Test
	public void should_change_probe_direction_from_E_To_N_when_receive_the_command_L() {
		ProbeModel probeModel = new ProbeModel();
		probeModel.setDirection('E');
		subject.applyCommandToProbe(probeModel, 'L');
		assertEquals('N', probeModel.getDirection());
	}
	
	@Test
	public void should_change_probe_direction_from_N_To_E_when_receive_the_command_R() {
		ProbeModel probeModel = new ProbeModel();
		probeModel.setDirection('N');
		subject.applyCommandToProbe(probeModel, 'R');
		assertEquals('E', probeModel.getDirection());
	}
	
	@Test
	public void should_change_probe_direction_from_E_To_S_when_receive_the_command_R() {
		ProbeModel probeModel = new ProbeModel();
		probeModel.setDirection('E');
		subject.applyCommandToProbe(probeModel, 'R');
		assertEquals('S', probeModel.getDirection());
	}
	
	@Test
	public void should_change_probe_direction_from_S_To_W_when_receive_the_command_R() {
		ProbeModel probeModel = new ProbeModel();
		probeModel.setDirection('S');
		subject.applyCommandToProbe(probeModel, 'R');
		assertEquals('W', probeModel.getDirection());
	}
	
	@Test
	public void should_change_probe_direction_from_W_To_N_when_receive_the_command_R() {
		ProbeModel probeModel = new ProbeModel();
		probeModel.setDirection('W');
		subject.applyCommandToProbe(probeModel, 'R');
		assertEquals('N', probeModel.getDirection());
	}

	@Test
	public void should_change_probe_position_from_1_1_N_To_1_2_N_when_receive_the_command_M() {
		ProbeModel probeModel = new ProbeModel();
		probeModel.setX(1);
		probeModel.setY(1);
		probeModel.setDirection('N');
		subject.applyCommandToProbe(probeModel, 'M');
		assertEquals(2, probeModel.getY());
		assertEquals(1, probeModel.getX());
		assertEquals('N', probeModel.getDirection());
	}
	
	@Test
	public void should_change_probe_position_from_1_1_S_To_1_0_S_when_receive_the_command_M() {
		ProbeModel probeModel = new ProbeModel();
		probeModel.setX(1);
		probeModel.setY(1);
		probeModel.setDirection('S');
		subject.applyCommandToProbe(probeModel, 'M');
		assertEquals(0, probeModel.getY());
		assertEquals(1, probeModel.getX());
		assertEquals('S', probeModel.getDirection());
	}
	
	@Test
	public void should_change_probe_position_from_1_1_W_To_0_1_W_when_receive_the_command_M() {
		ProbeModel probeModel = new ProbeModel();
		probeModel.setX(1);
		probeModel.setY(1);
		probeModel.setDirection('W');
		subject.applyCommandToProbe(probeModel, 'M');
		assertEquals(0, probeModel.getX());
		assertEquals(1, probeModel.getY());
		assertEquals('W', probeModel.getDirection());
	}
	
	@Test
	public void should_change_probe_position_from_1_1_E_To_2_1_E_when_receive_the_command_M() {
		ProbeModel probeModel = new ProbeModel();
		probeModel.setX(1);
		probeModel.setY(1);
		probeModel.setDirection('E');
		subject.applyCommandToProbe(probeModel, 'M');
		assertEquals(2, probeModel.getX());
		assertEquals(1, probeModel.getY());
		assertEquals('E', probeModel.getDirection());
	}
}
