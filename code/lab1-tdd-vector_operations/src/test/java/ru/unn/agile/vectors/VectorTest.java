package ru.unn.agile.vectors;

import org.junit.Test;
import ru.unn.agile.vectors.model.Vector;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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

    @Test()
    public void canCreateTwoEqualVectorswithPositiveCoordinates() {
        Vector z1 = new Vector(1, 2, 3);
        Vector z2 = new Vector(1, 2, 3);
        boolean tmp = Vector.isEqual(z2, z1);
        assertTrue(tmp);
    }

    @Test()
    public void canCreateTwoEqualVectorswithNegativeCoordinates() {
        Vector z1 = new Vector(-1, -2, -3);
        Vector z2 = new Vector(-1, -2, -3);
        boolean tmp = Vector.isEqual(z2, z1);
        assertTrue(tmp);
    }
}
