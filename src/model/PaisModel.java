package model;

public class PaisModel {
    private String nome;
    private int numeroDeMedalhas;
    private boolean competidor;

    public PaisModel(String nome, int numeroDeMedalhas, boolean competidor) {
        this.nome = nome;
        this.numeroDeMedalhas = numeroDeMedalhas;
        this.competidor = competidor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumeroDeMedalhas() {
        return numeroDeMedalhas;
    }

    public void setNumeroDeMedalhas(int numeroDeMedalhas) {
        this.numeroDeMedalhas = numeroDeMedalhas;
    }

    public boolean isCompetidor() {
        return competidor;
    }

    public void setCompetidor(boolean competidor) {
        this.competidor = competidor;
    }

    @Override
    public String toString() {
        return "nome = '" + nome + '\'' +
                ", numeroDeMedalhas = " + numeroDeMedalhas +
                ", status = " + (competidor ? "competindo" : "não competindo");
    }

}
