package com.sapient.qa.Analyzer;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class MyTransformer implements IAnnotationTransformer {


    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod)

    {

        annotation.setRetryAnalyzer(RetryAnalyzer.class);


    }

}