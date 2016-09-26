package projeto1;

public class Aresta {
    private No nohInicio;
    private No nohFinal;
    private String label;
    
    public Aresta(int NohInic,int NohFinal,String label){
        this.label=label;
        this.nohInicio = new No(NohInic);
        this.nohFinal = new No(NohFinal);
    }
    
    public void setLabel(String label){
        this.label=label;
    }
    
    public String getLabel(){
        return this.label;
    }
    
    public void setInicio(int inicio){
        this.nohInicio.setNome(inicio);
    }
    
    public int getInicio(){
        return this.nohInicio.getNome();
    }
    
    public void setFinal(int NoFinal){
        this.nohFinal.setNome(NoFinal);
    }
    
    public int getFinal(){
        return this.nohFinal.getNome();
    }
    
    public void setKleene(boolean kleene){
        this.nohFinal.Kleene=kleene;
    }
    
    public boolean getKleene(){
        return this.nohFinal.Kleene;
    }
}
