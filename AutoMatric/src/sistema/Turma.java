package sistema;
public class Turma extends Materia implements Classificar{
    private String turno, codTurma;
    private int vagas;

    public Turma(String nomeDis, String codDis, String codTurma, String turno, String vagas) {
        super(nomeDis, codDis);
        this.turno = turno;
        this.codTurma = codTurma;
        this.vagas = Integer.parseInt(vagas);
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getCodTurma() {
        return codTurma;
    }

    public void setCodTurma(String codTurma) {
        this.codTurma = codTurma;
    }

    public int getVagas() {
        return vagas;
    }

    public void setVagas(int vagas) {
        this.vagas = vagas;
    }
    
//    protected boolean verificar150(int matriculasRecebidas, int vagas)
//	{
//		double resultado = matriculasRecebidas/vagas;
//		if(resultado >=1.5)
//			return true;			
//		else
//			return false;		
//	}
}
