package Repository;

import Model.State.PrgState;

public interface RepoInterface {
    PrgState getCrtPrg();
    void addProgram(PrgState newProgram);
}
