public class Aranha extends Npc
{
    public Aranha() 
    {
        super("Aranha", 6, 5);
        this.vidaMax = 6;
    }

    @Override
    public int atacar()
    {
        return this.dano;
    }

    @Override
    public void receberDano(int d)
    {
        this.vida -= d;
        if(this.vivo())
        {
            System.out.println("Aranha recebeu "+d+" de dano!");
        }
    }
}