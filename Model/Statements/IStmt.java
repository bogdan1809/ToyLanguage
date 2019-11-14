package Model.Statements;

import Model.Exception.MyException;
import Model.State.PrgState;

public interface IStmt {

   public PrgState execute(PrgState state) throws MyException;
   public String toString();
}
