package sistema;
public class Turma extends Materia{
    private String turno, codTurma;
    private int vagas;

    public Turma(String nomeDis, String codDis, String codTurma, String turno, String vagas) {
        super(nomeDis, codDis);
        this.turno = turno;
        this.codTurma = codTurma;
        this.vagas = (Integer.parseInt(vagas.trim()));
    }
    
    public Turma(String nomeDis, String codDis, String codTurma, String turno, int vagas) {
        super(nomeDis, codDis);
        this.turno = turno;
        this.codTurma = codTurma;
        this.vagas = vagas;
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
    
    public static double maiorCp(Aluno a) {
        if(a != null) {
            double x = a.getCp1();
            double y = a.getCp2();
            double z = a.getCp3();
         
            if (x > y && x > z) return x;
            else if (y > x && y > z) return y;
            else if(z > x && z > y) return z;
            else return x;
        }
        return 0;
    }
        
    @Override
    public Aluno[] ordenarCr(Aluno[] v) {
        int n = v.length;
        
        for (int i = 0; i < n-1; i++) {  
            int min_idx = i; 
            
            for (int j = i+1; j < n; j++) { 
                if (v[j]!=null && v[min_idx]!=null && v[j].getCr() < v[min_idx].getCr()) 
                    min_idx = j;
            }
            
            Aluno temp = v[min_idx]; 
            v[min_idx] = v[i]; 
            v[i] = temp; 
        }
        return v;
    }

    @Override
    public Aluno[] ordenarCp(Aluno[] v) {
        int n = v.length;
        
        for (int i = 0; i < n-1; i++) {  
            int min_idx = i; 
            
            for (int j = i+1; j < n; j++) {
                if (maiorCp(v[j]) < maiorCp(v[min_idx])) 
                    min_idx = j;
            }
            
            Aluno temp = v[min_idx]; 
            v[min_idx] = v[i]; 
            v[i] = temp; 
        }
        return v;
    }
    
    @Override
    public boolean temOblim(Aluno a) {
        if(a != null) {
            for(int i=0; i<this.getRelacaoCurso()[0].length; i++) {
                if(this.getRelacaoCurso()[0][i].equals(a.getOp1()))
                    if(this.getRelacaoCurso()[1][i].equals("Obrigatoria") || this.getRelacaoCurso()[1][i].equals("Limitada"))
                        return true;
                if(this.getRelacaoCurso()[0][i].equals(a.getOp2()))
                    if(this.getRelacaoCurso()[1][i].equals("Obrigatoria") || this.getRelacaoCurso()[1][i].equals("Limitada"))
                        return true;
                if(this.getRelacaoCurso()[0][i].equals(a.getOp3()))
                    if(this.getRelacaoCurso()[1][i].equals("Obrigatoria") || this.getRelacaoCurso()[1][i].equals("Limitada"))
                        return true;
            }
        }
        return false;
    }
    
    public boolean verificar150(int matriculasRecebidas){
		double resultado = ((double)matriculasRecebidas)/this.vagas;
		if(resultado >=1.5)
			return true;			
		else
			return false;		
	}
}
