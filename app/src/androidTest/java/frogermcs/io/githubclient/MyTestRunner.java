package frogermcs.io.githubclient;

import android.app.Application;
import android.content.Context;
import android.support.test.runner.AndroidJUnitRunner;

import frogermcs.io.githubclient.inject.ApplicationMock;

/**
 * Created by Irina Ivanova on 24.05.19.
 */
public class MyTestRunner extends AndroidJUnitRunner {

    @Override
    public Application newApplication(ClassLoader cl, String className, Context context)
            throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return super.newApplication(cl, ApplicationMock.class.getName(), context);
    }
}
