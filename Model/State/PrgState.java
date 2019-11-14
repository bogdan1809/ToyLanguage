package Model.State;

import Model.Data.MyIDictionary;
import Model.Data.MyIList;
import Model.Data.MyIStack;
import Model.Statements.IStmt;
import Model.Values.Value;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PrgState {
    private MyIStack<IStmt> exeStack;
    private MyIDictionary<String, Value> symTable;
    private MyIList<Value> out;
    private IStmt originalProgram;

    private static Object deepCopy(Object object) {
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ObjectOutputStream outputStrm = new ObjectOutputStream(outputStream);
            outputStrm.writeObject(object);
            ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
            ObjectInputStream objInputStream = new ObjectInputStream(inputStream);
            return objInputStream.readObject();
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public PrgState(MyIStack<IStmt> stk, MyIDictionary<String,Value> symtbl, MyIList<Value> ot, IStmt prg){
        this.exeStack=stk;

        this.symTable=symtbl;
        this.out=ot;
        //this.originalProgram=(IStmt) deepCopy(prg);
        stk.push(prg);
    }

    public MyIList<Value> getOut(){
        return this.out;
    }

    public MyIDictionary<String,Value> getSymTable(){
        return this.symTable;
    }

    public MyIStack<IStmt> getExeStack(){
        return this.exeStack;
    }

    public void setExeStack(MyIStack<IStmt> newStk){
        this.exeStack=newStk;
    }

    public void setSymTable(MyIDictionary<String,Value> newSym){
        this.symTable=newSym;
    }

    public void setOut(MyIList<Value> newOut){
        this.out=newOut;
    }

    public IStmt getOriginalProgram(){
        return this.originalProgram;
    }

    public void setOriginalProgram(IStmt newOrig){
        this.originalProgram=newOrig;
    }

    @Override
    public String toString(){
        return "Execution Stack:\n"+getExeStack().toString()+"Symbol Table:\n"+getSymTable().toString()+"Output:\n"+getOut();
    }




}
