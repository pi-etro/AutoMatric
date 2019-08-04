package sistema;

public class Aluno {
	private int ra;
	private double cr, cp1, cp2, cp3;
	private String turno, bi, pbi, op1, op2, op3;
    
//	//construtor com os valores direto
//	public Aluno(int ra, double cr, String turno, String bi, String pbi, String op1, double cp1, String op2, double cp2, String op3, double cp3) {
//	    this.ra = ra;
//	    this.cr = cr;
//	    this.turno = turno;
//	    this.bi = bi;
//	    this.pbi = pbi;
//	    this.op1 = op1;
//	    this.cp1 = cp1;
//	    this.op2 = op2;
//	    this.cp2 = cp2;
//	    this.op3 = op3;
//	    this.cp3 = cp3;
//	}
	
	//construtores com conversao de string, util para o opencsv
	public Aluno(String ra, String cr, String turno, String bi, String pbi, String op1, String cp1, String op2, String cp2, String op3, String cp3) {
        this.ra = Integer.parseInt(ra.trim());
        this.cr = Double.parseDouble(cr.trim());
        this.turno = turno;
        this.bi = bi;
        this.pbi = pbi;
        this.op1 = op1;
        this.cp1 = Double.parseDouble(cp1.trim());
        this.op2 = op2;
        this.cp2 = Double.parseDouble(cp2.trim());
        this.op3 = op3;
        this.cp3 = Double.parseDouble(cp3.trim());
    }
	
	//getters e setters
	public int getRa() {
        return ra;
    }
    public void setRa(int ra) {
        this.ra = ra;
    }
    public double getCr() {
        return cr;
    }
    public void setCr(double cr) {
        this.cr = cr;
    }
    public double getCp1() {
        return cp1;
    }
    public void setCp1(double cp1) {
        this.cp1 = cp1;
    }
    public double getCp2() {
        return cp2;
    }
    public void setCp2(double cp2) {
        this.cp2 = cp2;
    }
    public double getCp3() {
        return cp3;
    }
    public void setCp3(double cp3) {
        this.cp3 = cp3;
    }
    public String getTurno() {
        return turno;
    }
    public void setTurno(String turno) {
        this.turno = turno;
    }
    public String getBi() {
        return bi;
    }
    public void setBi(String bi) {
        this.bi = bi;
    }
    public String getPbi() {
        return pbi;
    }
    public void setPbi(String pbi) {
        this.pbi = pbi;
    }
    public String getOp1() {
        return op1;
    }
    public void setOp1(String op1) {
        this.op1 = op1;
    }
    public String getOp2() {
        return op2;
    }
    public void setOp2(String op2) {
        this.op2 = op2;
    }
    public String getOp3() {
        return op3;
    }
    public void setOp3(String op3) {
        this.op3 = op3;
    }
}
