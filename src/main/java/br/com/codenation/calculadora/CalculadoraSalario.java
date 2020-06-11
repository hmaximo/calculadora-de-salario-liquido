package br.com.codenation.calculadora;


public class CalculadoraSalario {

	public long calcularSalarioLiquido(double salarioBase) {
		
		//Retorno 0 para salário menor que o salário mínimo:
		if (salarioBase < 1039) 
			return 0;
		
		//Calculadora para salários maiores que o salário mínimo:
		double salarioLiquido = 0;
		double salarioMenosInss = salarioBase - calcularInss(salarioBase); 
		int pagaIrfp = 0; //Variável de distinção/controle entre isentos e não-isentos do IRPF
		if (salarioMenosInss > 3000)
			pagaIrfp = 1;
		salarioLiquido = salarioMenosInss - (pagaIrfp * calcularIrpf(salarioMenosInss));
		return Math.round(salarioLiquido);
	}
	
	//Cálculo do desconto de INSS:
	private double calcularInss(double salarioBase) {
		double descontoInss = 0;
		double percentualDescInss = 0;
		if (salarioBase <= 4000) {
			if (salarioBase <= 1500)
				percentualDescInss = 0.08;
			else
				percentualDescInss = 0.09;
		}
		else 
			percentualDescInss = 0.11;
		descontoInss = salarioBase * percentualDescInss;
		return descontoInss;
	}

	//Cálculo do desconto de IRPF:
	private double calcularIrpf(double salarioMenosInss) {
		double descontoIrpf = 0;
		double percentualDescIrpf = 0;
		if (salarioMenosInss <= 6000) 
			percentualDescIrpf = 0.075;
		else
			percentualDescIrpf = 0.15;
		descontoIrpf = salarioMenosInss * percentualDescIrpf;
		return descontoIrpf;
	}

}