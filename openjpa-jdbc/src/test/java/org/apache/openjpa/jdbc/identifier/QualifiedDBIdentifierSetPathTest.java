package org.apache.openjpa.jdbc.identifier;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;


import static org.junit.Assert.*;

@RunWith(value= Parameterized.class)
public class QualifiedDBIdentifierSetPathTest {


    private boolean expectedResult;
    private DBIdentifier i1, i2 ;


    @Parameterized.Parameters
    public static Collection<Object[]> getTestParameters() {
        return Arrays.asList(new Object[][]{


                {false , null , null},
                {true  , DBIdentifier.newSchema("Schema_1"), DBIdentifier.newTable("Table_1")},
                {false , DBIdentifier.NULL , DBIdentifier.NULL }


        });

    }


    public QualifiedDBIdentifierSetPathTest(boolean expectedResult , DBIdentifier i1 , DBIdentifier i2 ){


        this.expectedResult = expectedResult;
        this.i1 = i1;
        this.i2 = i2;

    }


    @Test
    public void setPathTest() {


        QualifiedDBIdentifier qDBI = QualifiedDBIdentifier.newPath(DBIdentifier.newTable("Table1"));

        qDBI.setPath(i1,i2);

        String expectedName;

        if(expectedResult == true){

             expectedName = i1.getName() + "." + i2.getName() ;

        }else {

             expectedName = "Table1" ;

        }

        assertEquals(expectedName , qDBI.getName());

    }

}