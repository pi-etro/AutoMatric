package sistema;

public abstract class Materia {
    private String nomeDis;
    private String codDis;
    private String[][] relacaoCurso = {{"Bct","Bcc","Info"},{"","",""}};
    
    public Materia(String nomeDis, String codDis){
        this.nomeDis = nomeDis;
        this.codDis = codDis;
    }

    public String getNomeDis() {
        return nomeDis;
    }

    public void setNomeDis(String nomeDis) {
        this.nomeDis = nomeDis;
    }

    public String getCodDis() {
        return codDis;
    }

    public void setCodDis(String codDis) {
        this.codDis = codDis;
    }

    public String[][] getRelacaoCurso() {
        return relacaoCurso;
    }

    public void setRelacaoCurso(String[] relacaoCurso) {
        for(int i=0; i<this.relacaoCurso.length; i++) {
            for(int j=0; j<this.relacaoCurso[0].length; j++) {
                this.relacaoCurso[i][j] = relacaoCurso[j];
            }
        }
    }
}
