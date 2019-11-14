package Controller;

import Model.Data.MyIStack;
import Model.Exception.MyException;
import Model.State.PrgState;
import Model.Statements.IStmt;
import Repository.RepoInterface;

public class Controller {
    private RepoInterface repo;

    public Controller(RepoInterface repo){
        this.repo=repo;
    }

    public PrgState oneStep(PrgState state) throws MyException{
        MyIStack<IStmt> stk=state.getExeStack();
        if(stk.isEmpty()) throw new MyException("PrgState stack is empty");
        else {
            IStmt crtStmt = stk.pop();
            PrgState progrSt=crtStmt.execute(state);
            System.out.println(progrSt.toString());
            return progrSt;
        }
    }

    public void allStep() throws MyException {
        PrgState prg=repo.getCrtPrg();
       // System.out.println(prg.toString());//make log
        while (!prg.getExeStack().isEmpty()){
            oneStep(prg);
          //  System.out.println(prg.toString());//make log
        }


    }
}
