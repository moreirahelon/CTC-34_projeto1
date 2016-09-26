package projeto1;

import java.util.ArrayList;


public class Projeto1 {
    Aresta ArestaInicio;
    No Nofinal;
    No inicio;
    int NumNos;
    ArrayList<Aresta> Graph = new ArrayList<Aresta>();
    
            
    public Projeto1(int nohInicio,int nohFinal, String RegEx){
        this.inicio = new No(nohInicio);
        this.Nofinal = new No(nohFinal);
        this.ArestaInicio = new Aresta(nohInicio,nohFinal,RegEx);
        Graph.add(ArestaInicio);
        this.NumNos=2;
    }
    
    //main -> printf [style=bold,label="100 times"];
    
    public ArrayList<Aresta> getGraph(){
        return Graph;       
    }
    
    public boolean NFA1(int GraphNum){
        int sizeRegExp = Graph.get(GraphNum).getLabel().length();
        String regexp=Graph.get(GraphNum).getLabel();
        int aux=0;
        int SomaParent=0;
        
        for(int i=1;i<sizeRegExp;i++){
            if(regexp.charAt(i)=='(' && regexp.charAt(i-1)=='+' && aux==0){
                Aresta novaAresta = new Aresta(Graph.get(GraphNum).getInicio(),Graph.get(GraphNum).getFinal(),regexp.substring(0, i-1));
                Graph.add(novaAresta);
                Aresta novaAresta2 = new Aresta(Graph.get(GraphNum).getInicio(),Graph.get(GraphNum).getFinal(),regexp.substring(i,Graph.get(GraphNum).getLabel().length()));
                Graph.add(novaAresta2);
                return true;
            }
            if(regexp.charAt(i)=='(')
                SomaParent+=1;
        } 
        if(SomaParent==0){
            for(int i=1;i<sizeRegExp;i++){
                if(regexp.charAt(i)=='+'){
                    Aresta novaAresta = new Aresta(Graph.get(GraphNum).getInicio(),Graph.get(GraphNum).getFinal(),regexp.substring(0, i));
                    Graph.add(novaAresta);
                    Aresta novaAresta2 = new Aresta(Graph.get(GraphNum).getInicio(),Graph.get(GraphNum).getFinal(),regexp.substring(i+1,Graph.get(GraphNum).getLabel().length()));
                    Graph.add(novaAresta2);
                    
                }
            }
            
        }
        
        return false;
    }
    
    
    public static void main(String[] args) {
        
    }
    
    public void Executar(int NumGraph){
   //     int sizeRegExp = Graph.get(NumGraph).getLabel().length();
   //     String regexp=Graph.get(NumGraph).getLabel();
        boolean aux = true;
        if(!Graph.get(NumGraph).getKleene())
            aux=NFA1(NumGraph);
        if(!aux){
            aux=NFA2(NumGraph); 
        }
        if(!aux && !Graph.get(NumGraph).getKleene()){
            aux=NFA3(NumGraph);
        }
    }
    
    public boolean NFA2(int GraphNum){
        int sizeRegExp = Graph.get(GraphNum).getLabel().length();
        String regexp=Graph.get(GraphNum).getLabel();
        int SomaParent=0;
        for(int i=0;i<sizeRegExp;i++){
            if(regexp.charAt(i)=='(')
                SomaParent+=1;
            if(SomaParent==1 && regexp.charAt(i)==')' && regexp.charAt(i+1)=='*'){
                Aresta novaAresta = new Aresta(this.NumNos+1,this.NumNos+1,regexp.substring(1, i-1));
                novaAresta.setKleene(true);
                Graph.add(novaAresta);
                Aresta novaAresta3 = new Aresta(Graph.get(GraphNum).getInicio(),this.NumNos+1,"&");
                Graph.add(novaAresta3);
                Aresta novaAresta4 = new Aresta(this.NumNos+1,Graph.get(GraphNum).getFinal(),"&");
                Graph.add(novaAresta4);
                NumNos+=1;
                return true;
            }
            
        }
        
        
        return false;
    }
    
    public boolean NFA3(int GraphNum){
        int sizeRegExp = Graph.get(GraphNum).getLabel().length();
        String regexp=Graph.get(GraphNum).getLabel();
    
        if(sizeRegExp>1){
            Aresta novaAresta5 = new Aresta(Graph.get(GraphNum).getInicio(),this.NumNos+1,regexp.substring(0, 1));
            Graph.add(novaAresta5);
            Aresta novaAresta6 = new Aresta(this.NumNos+1,Graph.get(GraphNum).getFinal(),regexp.substring(1,sizeRegExp ));
            Graph.add(novaAresta6);
        }
        
        
        return false;
    }
    
    public void AtualizaNFA(){
        boolean flag=true;
        int size;
        int i=0;
        
        while(flag){
            size=Graph.size();
            while( i<=size){
                if(Graph.get(i).getLabel().length()==1)
                    flag=false;
                if(Graph.get(i).getLabel().length()!=1){
                    Executar(i);
                    flag=true;
                }
                System.out.println(i);
                System.out.println(Graph.get(i).getLabel());
                System.out.println(" ");
                i++;
            }
            
        }
        
    }
}
