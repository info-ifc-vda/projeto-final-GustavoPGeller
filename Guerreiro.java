
public class Guerreiro extends Personagem
{
    public Guerreiro(String n)
    {
        super(n, 15, 5);
        this.dano = 5;
        this.defesa = 2;
        this.tipo = 1;
        this.vidaMax = 15;
    }

    @Override
    public void receberDano(int deh)
    {
        this.vida -= (deh - this.defesa);
        if(this.vivo())
        {
            System.out.println(this.nome+" recebeu "+deh+" de dano mas bloqueou uma parte ("+this.defesa+")!");
        }
    }

    @Override
    public int atacar()
    {
        System.out.println(this.nome+" dá um golpe com a espada!");
        return this.dano;
    }    
}
