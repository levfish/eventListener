package com.lev;


import java.util.*;
/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        //System.out.println( "Hello World!" );
        Initiator initiator = new Initiator();
        Responder responder = new Responder();
        initiator.addListener(responder);
        initiator.sayHello();  // Prints "Hello!!!" and "Hello there...
    }

}
    // An interface to be implemented by everyone interested in "Hello" events
    interface HelloListener {
        void someoneSaidHello();
    }

    // Someone who says "Hello"
    class Initiator {
        private List<HelloListener> listeners = new ArrayList<HelloListener>();

        public void addListener(HelloListener toAdd) {
            listeners.add(toAdd);
        }

        public void sayHello() {
            System.out.println("Hello!!");

            // Notify everybody that may be interested.
            for (HelloListener hl : listeners)
                hl.someoneSaidHello();
        }
    }

    // Someone interested in "Hello" events
    class Responder implements HelloListener {
        @Override
        public void someoneSaidHello() {
            System.out.println("Hello there...");
        }
    }

