package org.apache.openjpa.lib.util;

import com.sun.javafx.util.Logging;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(value= Parameterized.class)
public class ClassUtilToClassTest {



    private boolean expectedResult;
    private String path ;
    private boolean resolve ;
    private String loader;


    @Parameterized.Parameters
    public static Collection<Object[]> getTestParameters() {
        return Arrays.asList(new Object[][]{


                {false , null , true , null},
                {true  , "org.apache.openjpa.lib.util.ClassUtilToClassTest" , false , "validLoader" } ,
                {false , "org.apache.openjpa.lib.util.NotAnExistingClass" , false , "notValidLoader" }


        });

    }


    public ClassUtilToClassTest(boolean expectedResult, String path, boolean resolve, String loader ){


        this.expectedResult = expectedResult;
        this.path = path;
        this.resolve = resolve;
        this.loader = loader;


    }


    @Test
    public void toCLass() {

        ClassLoader cL = null ;

        if(loader == "validLoader"){

            cL = this.getClass().getClassLoader();

        }else if (loader == "notValidLoader"){

            cL = Logging.class.getClassLoader();
        }

        if(expectedResult==true){

            Class theClass = ClassUtil.toClass(path,resolve,cL);

            assertEquals(this.getClass(),theClass);

        }else{

            boolean result = true ;
            try{
                ClassUtil.toClass(path,resolve,cL);
            }catch(Exception e){

                e.printStackTrace();
                result = false;
            }

            assertEquals( expectedResult , result);
        }




    }
}