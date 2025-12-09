public abstract class Npc 
{
    protected String nome;
    protected int vida;
    protected int vidaMax;
    protected int dano;

    public Npc(String n, int v, int d)
    {
        this.nome = n;
        this.vida = v;
        this.dano = d;
    }

    public boolean vivo()
    {
        return this.vida > 0;
    }

    public abstract int atacar();

    public abstract void receberDano(int d);

    //gets
    public int getVida()
    {
        return this.vida;
    }

    public int getVidaMax()
    {
        return this.vidaMax;
    }

    public String getNome()
    {
        return this.nome;
    }
}