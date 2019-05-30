package ru.ivanova.githubclient.data;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Irina Ivanova on 22.04.19.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface UserScope {
}