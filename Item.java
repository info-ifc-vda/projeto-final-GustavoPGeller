public abstract class Item 
{
    protected String nome;
    
    public Item (String n)
    {
        this.nome = n;
    }

    public String getNome()
    {
        return this.nome;
    }

    public abstract void usar(Personagem p);
}
