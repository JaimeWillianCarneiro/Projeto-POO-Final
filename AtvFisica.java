public class AtvFisica extends Atividade{
    
    private String nome = "Atividade Fisica";
    private int intensidade;

    AtvFisica(int duracao, int satisfacao, int intensidade, int dia, int semana, int mes){
        super(duracao, satisfacao, dia, semana, mes);
        this.intensidade = intensidade;
    }

    public double defineGastodeEnergia(){
        return intensidade * duracao * 3;
    }

    public String getNome(){
        return nome;
    }

    public int getIntensidade(){
        return intensidade;
    }

    public void setIntensidade(int intensidade){
        this.intensidade = intensidade;
    }
    
}
