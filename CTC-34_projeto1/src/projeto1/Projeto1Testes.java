package projeto1;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import projeto1.Aresta;
import projeto1.Projeto1;

public class Projeto1Testes {
    
    public Projeto1Testes() {
    }
    
//    @Test
//    public void InicioAutomato(){
//        Projeto1 automato = new Projeto1(0,1,"ab+(b+c)*");        
//        assertEquals("0->1[style=bold,label=\"ab+(b+c)*\"];", automato.getGraph().get(0));
//    }
    
    @Test
    public void PrimeiraRegExp(){
        Projeto1 automato = new Projeto1(0,1,"ab+(b+c)*");
        ArrayList<Aresta> Graph = new ArrayList<Aresta>();
        automato.AtualizaNFA();
        Graph=automato.getGraph();
        
        assertEquals("ab", Graph.get(1).getLabel());
    }
    
    @Test
    public void PrimeiraRegExp2(){
        Projeto1 automato = new Projeto1(0,1,"ab+(b+c)*");
        ArrayList<Aresta> Graph = new ArrayList<Aresta>();
        automato.AtualizaNFA();
        Graph=automato.getGraph();
        
        assertEquals("(b+c)*", Graph.get(2).getLabel());
    }
    
    @Test
    public void PrimeiraRegExp3(){
        Projeto1 automato = new Projeto1(0,1,"ab+(b+c)*");
        ArrayList<Aresta> Graph = new ArrayList<Aresta>();
        automato.AtualizaNFA();
        Graph=automato.getGraph();
        
        assertEquals("a", Graph.get(3).getLabel());
    }
    
    @Test
    public void PrimeiraRegExp4(){
        Projeto1 automato = new Projeto1(0,1,"ab+(b+c)*");
        ArrayList<Aresta> Graph = new ArrayList<Aresta>();
        automato.AtualizaNFA();
        Graph=automato.getGraph();
        
        assertEquals("b", Graph.get(4).getLabel());
    }
    
    @Test
    public void PrimeiraRegExp5(){
        Projeto1 automato = new Projeto1(0,1,"ab+(b+c)*");
        ArrayList<Aresta> Graph = new ArrayList<Aresta>();
        automato.AtualizaNFA();
        Graph=automato.getGraph();
        
        assertEquals("b+c", Graph.get(5).getLabel());
    }
    
}
