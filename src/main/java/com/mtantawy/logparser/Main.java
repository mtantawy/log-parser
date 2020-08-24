package com.mtantawy.logparser;

public class Main {
    public static void main(String[] args) throws Exception {
        if (args.length < 2) {
            System.out.println("Missing arguments, must be: parser-type file-path");
            return;
        }

        Application application = new Application(args[0], args[1]);
        application.run();
    }
}
