
import Enums.Zona;
import java.util.LinkedList;
import java.util.List;

public class DAOBotes {
    private List<Bote> listaBotes;

    public DAOBotes(){
        this.listaBotes = new LinkedList<>();
        int id;
        for(int i=1; i <= 40; i++){
            id = i;
            int zona;
            if(i % 10==0){
                zona = i/10 - 1;
            }
            else{
                zona = i/10;
            }
            Bote b = new Bote(i, 5, Zona.values()[zona]);
            this.listaBotes.add(b);
        }
    }
    
    public boolean botesLLenos(){
        boolean llenos = false;
        int cont=0;
        for(int i=0; i < this.listaBotes.size();i++){
            if(listaBotes.get(i).lleno()){
                cont++;
            }
        }
        return llenos;
    }
    public List<Bote> getBotesZona(Zona zona){
        List<Bote> listaBotes = new LinkedList<>();
        for(int i=0; i < this.listaBotes.size(); i++){
            if(this.listaBotes.get(i).getZona().equals(zona)){
                listaBotes.add(this.listaBotes.get(i));
            }
        }
        return listaBotes;
    }
    public String toString(){
        String texto = "";
        for(int i = 0; i < this.listaBotes.size(); i++){
            texto += this.listaBotes.get(i).toString();
        }
        return texto;
    }
}
