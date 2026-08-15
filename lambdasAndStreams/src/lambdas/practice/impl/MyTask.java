package lambdas.practice.impl;

import lambdas.practice.interfaces.Task;

public class MyTask implements Task {
    @Override
    public void execute() {
        System.out.println("Execute");
    }
}
