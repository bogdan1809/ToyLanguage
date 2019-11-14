package View;

import Controller.Controller;
import Model.Data.*;
import Model.Exception.MyException;
import Model.Expressions.ArithExp;
import Model.Expressions.ValueExp;
import Model.Expressions.VarExp;
import Model.State.PrgState;
import Model.Statements.*;
import Model.Types.BoolType;
import Model.Types.IntType;
import Model.Values.BoolValue;
import Model.Values.IntValue;
import Model.Values.Value;
import Repository.RepoInterface;
import Repository.Repository;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws MyException {


        IStmt ex1 = new CompStmt(new VarDeclStmt("v", new IntType()),
                new CompStmt(new AssignStmt("v", new ValueExp(new IntValue(2))),
                        new PrintStmt(new VarExp("v"))));
        IStmt ex2 = new CompStmt(new VarDeclStmt("a", new IntType()),
                new CompStmt(new VarDeclStmt("b", new IntType()),
                        new CompStmt(new AssignStmt("a", new ArithExp(1, new ValueExp(new IntValue(2)),
                                new ArithExp(3, new ValueExp(new IntValue(3)), new ValueExp(new IntValue(5))))),
                                new CompStmt(new AssignStmt("b", new ArithExp(1, new VarExp("a"), new ValueExp(new IntValue(1)))), new PrintStmt(new VarExp("b"))))));
        IStmt ex3 = new CompStmt(new VarDeclStmt("a", new BoolType()),
                new CompStmt(new VarDeclStmt("v", new IntType()),
                        new CompStmt(new AssignStmt("a", new ValueExp(new BoolValue(true))),
                                new CompStmt(new IfStmt(new VarExp("a"), new AssignStmt("v", new ValueExp(new IntValue(2))),
                                        new AssignStmt("v", new ValueExp(new IntValue(3)))), new PrintStmt(new VarExp("v"))))));

        MyIDictionary<String, Value> dictionary = new MyDictionary<String, Value>();
        MyIStack<IStmt> stack = new MyStack<IStmt>();
        MyIList<Value> list = new MyList<Value>();
        PrgState program = null;

        //RepoInterface repository = new Repository();
        //repository.addProgram(program);

        Scanner keyboard = new Scanner(System.in);
        System.out.println("1) int v; v=2; print(v)");
        System.out.println("2) int a; int b; a=2+3*5; b=a+1; print(b)");
        System.out.println("3) bool a; int v; a=true; (if a then v=2 else v=3); print(v)");
        int opt = keyboard.nextInt();

        if (opt == 1) {
            program = new PrgState(stack, dictionary, list, ex1);
        }
        if (opt == 2) {
            program = new PrgState(stack, dictionary, list, ex2);
        }
        if (opt == 3) {
            program = new PrgState(stack, dictionary, list, ex3);
        }

        RepoInterface repository = new Repository();
        repository.addProgram(program);
        Controller controller = new Controller(repository);

        System.out.println("1- OneStep\n 2- AllStep");
        int opt2 = keyboard.nextInt();

        if (opt2 == 1) {
            System.out.println(program.toString());
            while (true) {
                try {
                    System.out.println("1- Continue\n 2-Exit");
                    int opt3 = keyboard.nextInt();
                    if (opt3 == 1) {
                        controller.oneStep(program);

                    } else break;
                } catch (MyException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        if (opt2 == 2) {
            try {
                System.out.println(program.toString());
                controller.allStep();
            } catch (MyException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}

