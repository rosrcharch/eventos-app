package com.example.festaseeventos;

import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;

@RunWith(MockitoJUnitRunner.class)
public class MockitoJUnitRunner extends Runner{


    @Override
    public Description getDescription() {
        return null;
    }

    @Override
    public void run(RunNotifier notifier) {

    }
}
