package ru.unn.agile.vectors;

import org.junit.Test;
import ru.unn.agile.vectors.model.Vector;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class VectorTest {

    @Test()
    public void canCreateVectorWithPositiveCoordinates() {
        Vector vect = new Vector(1, 2, 3);
        assertNotNull(vect);
    }

    @Test()
    public void canCreateVectorWithNegativeCoordinates() {
        Vector vect = new Vector(-1, -2, -3);
        assertNotNull(vect);
    }

    @Test()
    public void canCreateTwoEqualVectorsWithPositiveCoordinates() {
        Vector v1 = new Vector(1, 2, 3);
        Vector v2 = new Vector(1, 2, 3);
        boolean tmp = Vector.isEqual(v2, v1);
        assertTrue(tmp);
    }

    @Test()
    public void canCreateTwoEqualVectorsWithNegativeCoordinates() {
        Vector v1 = new Vector(-1, -2, -3);
        Vector v2 = new Vector(-1, -2, -3);
        boolean tmp = Vector.isEqual(v2, v1);
        assertTrue(tmp);
    }

    @Test()
    public void canFindTheLengthNormWithPositiveCoordinates() {
        Vector vect = new Vector(1, 2, 3);
        double tmp = 3.7416573867739413;
        double len = Vector.lengthNorm(vect);
        assertEquals(len, tmp);
    }

    @Test()
    public void canFindTheLengthNormWithNegativeCoordinates() {
        Vector vect = new Vector(-1, -2, -3);
        double tmp = 3.7416573867739413;
        double len = Vector.lengthNorm(vect);
        assertEquals(len, tmp);
    }

    @Test()
    public void canCheckIsOrtogonal() {
        Vector v1 = new Vector(0, 1, 0);
        Vector v2 = new Vector(0, 0, 1);
        boolean tmp = Vector.isOrthogonal(v2, v1);
        assertTrue(tmp);
    }
}
