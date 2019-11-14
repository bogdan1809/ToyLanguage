package Repository;


import Model.Data.MyList;
import Model.State.PrgState;

public class Repository implements RepoInterface {
    private MyList<PrgState> list;
    public Repository(){
        this.list= new MyList<PrgState>();
    }

   @Override
    public PrgState getCrtPrg(){
        return this.list.get(0);
    }

    @Override
    public void addProgram(PrgState newProgram){
        this.list.add(newProgram);
    }
}
