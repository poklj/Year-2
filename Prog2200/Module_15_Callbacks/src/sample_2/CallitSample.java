package sample_2;

public class CallitSample {

    public static void main(String[] args) {
        CallerClass1 caller1 = new CallerClass1();
        CallerClass2 caller2 = new CallerClass2();
        ChangeSize callBack = new IhaveaCallback();
        caller1.register(callBack);
        caller2.register(callBack);
       
        caller1.start();
        caller2.start();
    }
} 
