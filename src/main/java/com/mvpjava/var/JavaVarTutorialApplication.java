package com.mvpjava.var;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaVarTutorialApplication  implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(JavaVarTutorialApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        var varDemo = new VarDemo(); // Yes, I used "var"!
        varDemo.simplePrimitiveVarDemo();
        varDemo.diamondOperatorVSvar();
        varDemo.collectionsVarDemo();
        varDemo.reallyBadVarExample();
        varDemo.JavaVarGoodloopExample();
        varDemo.JavaVarGoodExampleLongClassNames();
    }
}
