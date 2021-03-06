package com.mvpjava.var;

import java.io.*;
import java.time.Duration;
import java.util.*;
import java.util.function.BiFunction;

import jdk.jfr.Percentage;
import org.springframework.aop.config.SimpleBeanFactoryAwareAspectInstanceFactory;

import javax.validation.constraints.NotNull;

public class VarDemo {
    void simplePrimitiveVarDemo(){
        var myPage = 46;          // int
        var iWishIwasAge = "26";  // String

        // var can't be null but you'll see some weirdness after
        //  var whenIDieAge  = null;
    }

    void collectionsVarDemo(){
        var names = new ArrayList<>(); // Object
        var filenames = new ArrayList<String>(); // ArrayList of Strings (Not List!)
        var wordSearchResults = new HashMap<String, List<Integer>>(); // HashMap of <String,List<Integer>> (Not Map|)
    }

    void reallyBadVarExample (){
        var oxygenLeftInTank = calculateOxygenLeftInTank(); // in code review, would IDE be helping you? Maybe.
        System.out.println("You have " + oxygenLeftInTank +  " left of oxygen to breath");

    }

    void diamondOperatorVSvar() {
        // Java 5  and 6 (Generics) - most verbose option
        List<String> names = new ArrayList<String>();
        Map<String,List<Integer>>  wordSearchResults = new HashMap<String, List<Integer>>();

        // Java 7 - Diamond Operator - Type inference (cut down on boiler plate code)
        List<String> names2 = new ArrayList<>();
        Map<String,List<Integer>>  wordSearchResults2 = new HashMap<>();

        // Java 10+ with "var"
        var names3 = new ArrayList<String>();
        var wordSearchResults3 = new HashMap<String, List<Integer>>();

    }

    void JavaVarGoodloopExample() {
        // Map Data not included on purpose
        //  Most verbose way
        Map<Long, Customer> customerTable = new HashMap<Long, Customer>();

        for (Map.Entry<Long, Customer> entry :customerTable.entrySet()) {
            System.out.println("Customer: " + entry.getKey() + " - " + entry.getValue());
        }

        // Diamond Operator - Type Inference
        Map<Long, Customer> customerTable2 = new HashMap<>();

        for (Map.Entry entry :customerTable2.entrySet()) {
            System.out.println("Customer: " + entry.getKey() + " - " + entry.getValue());
        }

        // Java "var"
        var customerTable3 = new HashMap<Long, Customer>();

        for (var entry :customerTable3.entrySet()) {
            System.out.println("Customer: " + entry.getKey() + " - " + entry.getValue());
        }
    }

    void JavaVarGoodExampleLongClassNames() {
        // 1 . Before, without "var"
        SimpleBeanFactoryAwareAspectInstanceFactory simpleBeanFactoryAwareAspectInstanceFactory = new SimpleBeanFactoryAwareAspectInstanceFactory();

        // After "with var"
        var simpleBeanFactoryAwareAspectInstanceFactory2 = new SimpleBeanFactoryAwareAspectInstanceFactory();

        // 2 . Before, without "var"
        FileOutputStream fileOutputStream = new FileOutputStream(FileDescriptor.out);

        // After "with var"
        var fileOutputStream2 = new FileOutputStream(FileDescriptor.out);

    }

    void Java11VarSupport(){
        //formula: speed = distance / time

        // Without "var" but with Type info included
        BiFunction<Distance, Duration, Double> calculateSpeed = (Distance distance, Duration duration) -> (Speed.calculateSpeed(distance, duration));

        // Without "var" and using implicit Type inference
        BiFunction<Distance, Duration, Double> calculateSpeed2 = ( distance,  duration) -> (Speed.calculateSpeed(distance, duration));

        // With "var" .Nothing to be gained here
        BiFunction<Distance, Duration, Double> calculateSpeed3 = ( var distance,  var duration) -> (Speed.calculateSpeed(distance, duration));

        // With "var" with modifiers
        BiFunction<Distance, Duration, Double> calculateSpeed4 = (@NotNull var distance, var duration) -> (Speed.calculateSpeed(distance, duration));

        // Will not compile without implicit Type declared
        // BiFunction<Distance, Duration, Double> calculateSpeedNOCOMPILE = (@NotNull distance, duration) -> (Speed.calculateSpeed(distance, duration));

    }

        private Percentage calculateOxygenLeftInTank() {
        return null; // not good!!! "var" can't hold a null. I guess someone is gonna die!
    }
}
