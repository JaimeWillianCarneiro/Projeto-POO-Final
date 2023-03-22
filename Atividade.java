public abstract class Atividade {
    
    protected int duracao;
    protected int satisfacao;
    protected double gastoEnergia;
    protected double bem_estar;
    protected int id = 0;


    protected int dia;
    protected int semana;
    protected int mes;

    public abstract double defineGastodeEnergia();
    
    public Atividade(int duracao, int satisfacao, int dia, int semana, int mes) {
        this.duracao = duracao;
        this.satisfacao = satisfacao;
        this.dia = dia;
        this.semana = semana;
        this.mes = mes;
        
    }

    public int getDuracao() {
        return duracao;
    }

    public int getSatisfacao() {
        return satisfacao;
    }

    public double getBemEstar(){
        return defineGastodeEnergia() * satisfacao / 360;
    }
   

    public int getId() {
        return id;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public void setSatisfacao(int satisfacao) {
        this.satisfacao = satisfacao;
    }

    public void setmes(int mes) {
        this.mes = mes;
    }

    public void setsemana(int semana) {
        this.semana = semana;
    }

    public void setdia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public int getSemana() {
        return semana;
    }

    public int getDia() {
        return dia;
    }

    public void setId(int id) {
        this.id = id;
    }
    //Cadastro das Atividades



}
