package main;

import java.util.Random;

public class Controle{
	//==========SENSORES==========
	public class Sensor {
		private int temperatura;
		private int pressao;
		private int id;
		private float confiabilidade;
		private boolean habilitado;
		private boolean alerta;
		private boolean valvula;

		public Sensor(int id) {
			temperatura = 0;
			pressao = 0;
			this.id = id;
			confiabilidade = 0;
			habilitado = false;
			alerta = false;
			valvula = false;
		}
		
		public int getTemperatura() {return temperatura;}
		public void setTemperatura(int temperatura) {this.temperatura = temperatura;}
		public int getPressao() {return pressao;}
		public void setPressao(int pressao) {this.pressao = pressao;}
		public boolean getValvula() {return valvula;}
		public void setValvula(boolean b) {valvula = b;}
		
		public boolean setH() {
			if (habilitado)
				return false;
			habilitado = true;
			return true;
		}

		public boolean resetH() {
			if (!habilitado)
				return false;
			habilitado = false;
			return true;
		}
		
		public void setR(float r) {confiabilidade = r;}
		public boolean getH() {return habilitado;}

		public boolean setAlerta() {
			if (alerta && !habilitado)
				return false;
			Random r = new Random();
			float chance = r.nextFloat();
			if (chance < confiabilidade) {
				setH();
				alerta(id);
				return true;
			}
			return false;
		}

		public boolean resetAlerta() {// A especificacao desse metodo ta
										// estranha
			if (!alerta)
				return false;
			setH();
			// notifica Controle
			return true;
		}

		public boolean getAlerta() {return alerta;}
	}
	
	//==========CONTROLE==========
	public Sensor[] sensores;

	public Controle() {
		sensores = new Sensor[10];
		for (int i = 0; i < 10; i++) {
			sensores[i] = new Sensor(i);
		}
	}

	public boolean setH(int s) {
		boolean res = sensores[s].setH();
		return res;
	}

	public boolean resetH(int s) {
		boolean res = sensores[s].resetH();
		return res;
	}
	
	public void alerta(int s) {open(s);}
	public void resetAlerta(int s) {fecha(s);}
	public void open(int s) {sensores[s].setValvula(true);}
	public void fecha(int s) {sensores[s].setValvula(false);}
	public boolean getV(int s) {return sensores[s].getValvula();}
}
