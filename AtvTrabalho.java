public class AtvTrabalho extends Atividade{
    
    private String nome = "Atividade de Trabalho";
    private int dificuldade;

    AtvTrabalho(int duracao, int satisfacao, int dificuldade, int dia, int semana, int mes){
        super(duracao, satisfacao, dia, semana, mes);
        this.dificuldade = dificuldade;
    }

    public double defineGastodeEnergia(){
        return duracao * dificuldade * 2;
    }

    public String getNome(){
        return nome;
    }

    public int getDificuldade(){
        return dificuldade;
    }

    public void setDificuldade(int dificuldade){
        this.dificuldade = dificuldade;
    }

}
