package ru.unn.agile.vectors;

import org.junit.Test;
import ru.unn.agile.vectors.model.Vector;

import static org.junit.Assert.assertNotNull;

public class VectorTest {

    @Test()
    public void canCreateVectorwithPositiveCoordinates() {
        Vector vect = new Vector(1, 2, 3);
        assertNotNull(vect);
    }

    @Test()
    public void canCreateVectorwithNegativeCoordinates() {
        Vector vect = new Vector(-1, -2, -3);
        assertNotNull(vect);
    }
}
