
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
		//receber se é BI ou pós BI -> recebe informações do Bacharelado
		//verificar se qtde de vagas ultrapassa 150% -> receber quantidade de vagas pelo banco de dados da turma
		//classificar por: reserva, turno, CP e CR -> receber informações da classe aluno
		//gerar lista ligada de classificados e inscritos.
		//retornar ordem de lista ligada para csv, em inscritos, indicar omotivos de chute da disciplina
	

}
