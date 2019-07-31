package sistema;
public class Turma extends Bacharelado {
	private Aluno classificados[], matriculados[];
	private String turno, campus, turma;
	
	protected boolean verificar150(int matriculasRecebidas, int vagas)
	{
		double resultado = matriculasRecebidas/vagas;
		if(resultado >=1.5)
			return true;			
		else
			return false;		
	}
	//metodos
		//receber se � BI ou p�s BI -> recebe informa��es do Bacharelado
		//verificar se qtde de vagas ultrapassa 150% -> receber quantidade de vagas pelo banco de dados da turma
		//classificar por: reserva, turno, CP e CR -> receber informa��es da classe aluno
		//gerar lista ligada de classificados e inscritos.
		//retornar ordem de lista ligada para csv, em inscritos, indicar omotivos de chute da disciplina
	

}
