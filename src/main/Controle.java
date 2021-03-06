package main;

import java.util.Random;

public class Controle {
	// ==========SENSORES==========
	public class Sensor {
		private int valor;
		private int id;
		private float confiabilidade;
		private boolean habilitado;
		private boolean alerta;
		private boolean valvula;

		public Sensor(int id) {
			valor = 0;
			this.id = id;
			confiabilidade = 0;
			habilitado = false;
			alerta = false;
			valvula = false;
		}

		public int getValor() {
			return valor;
		}

		public void setValor(int valor) {
			this.valor = valor;
		}

		public boolean getValvula() {
			return valvula;
		}

		public void setValvula(boolean b) {
			valvula = b;
		}

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

		public void setR(float r) {
			confiabilidade = r;
		}

		// Nao se encontra nos requisitos, mas facilita os testes
		public float getR() {
			return confiabilidade;
		}

		public boolean getH() {
			return habilitado;
		}

		public boolean setAlerta() {
			if (alerta || !habilitado)
				return false;
			Random r = new Random();
			float chance = r.nextFloat();
			if (chance < confiabilidade) {
				alerta(id);
				return true;
			}
			return false;
		}

		public boolean resetAlerta() {
			if (!alerta)
				return false;
			Controle.this.resetAlerta(id);
			return true;
		}

		public boolean getAlerta() {
			return alerta;
		}
	}

	// ==========CONTROLE==========
	public Sensor temperatura;
	public Sensor pressao;

	public Controle() {
		Random r = new Random();
		temperatura = new Sensor(1);
		temperatura.setR(r.nextInt());
		pressao = new Sensor(2);
		pressao.setR(r.nextInt());
	}

	public boolean setH(int s) {
		boolean res = false;
		if (s == 1)
			return res = temperatura.setH();
		else if (s == 2)
			return res = pressao.setH();
		else
			return res;
	}

	public boolean resetH(int s) {
		boolean res = false;
		if (s == 1)
			return res = temperatura.resetH();
		else if (s == 2)
			return res = pressao.resetH();
		return res;
	}

	public void alerta(int s) {
		open(s);
	}

	public void resetAlerta(int s) {
		fecha(s);
	}

	public void open(int s) {
		if (s == 1) {
			temperatura.setValvula(true);
			return;
		}
		if (s == 2) {
			pressao.setValvula(true);
			return;
		}
	}

	public void fecha(int s) {
		if (s == 1) {
			temperatura.setValvula(false);
			return;
		}
		if (s == 2) {
			pressao.setValvula(false);
			return;
		}
	}

	public boolean getV(int s) throws Exception {
		if (s == 1) {
			return temperatura.getValvula();
		}
		if (s == 2) {
			return pressao.getValvula();
		}
		throw new Exception();
	}
}
