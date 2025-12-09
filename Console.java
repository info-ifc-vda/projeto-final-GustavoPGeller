public class Console { //essa classe serve pra ficar limpando o terminal, deixar bonito.

    public static void clear() 
    {
        try 
        {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } 
        
        catch (Exception e) 
        {
            System.out.println("Erro ao limpar console.");
        }
    }

    public static void pause()   //Aqui é um pausezinho
    {        
        System.out.println("\nPressione ENTER para continuar...");
        try 
        {
            System.in.read();
            // limpa o buffer caso tenha sobrado algo
            while (System.in.available() > 0) 
            {
                System.in.read();
            }
        } catch (Exception e) {}
    }
}