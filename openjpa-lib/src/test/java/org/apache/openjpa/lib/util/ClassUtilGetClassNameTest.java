package org.apache.openjpa.lib.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(value= Parameterized.class)
public class ClassUtilGetClassNameTest {

    private String classPath ;

    @Parameterized.Parameters
    public static Collection<Object[]> getTestParameters() {
        return Arrays.asList(new Object[][]{


                { ClassUtilGetClassNameTest.class.toString() },
                { null }


        });

    }


    public ClassUtilGetClassNameTest( String classPath ){


        this.classPath = classPath;


    }


    @Test
    public void getClassName() {

        String expectedName ;

        String className = ClassUtil.getClassName(classPath);

        if(classPath == null){

            expectedName = null ;

        }else{

            int lastDot = classPath.toString().lastIndexOf('.');

            expectedName = lastDot > -1 ? classPath.substring(lastDot + 1) : classPath;
        }


        assertEquals( className, expectedName);

    }
}