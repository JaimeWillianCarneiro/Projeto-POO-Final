public class AtvLazer extends Atividade{
    
    private String nome = "Atividade de Lazer";

    AtvLazer(int duracao, int satisfacao, int dia, int semana, int mes){
        super(duracao, satisfacao, dia, semana, mes);
    }

    public double defineGastodeEnergia(){
        return duracao * 1;
    }

    public String getNome(){
        return nome;
    }

}
