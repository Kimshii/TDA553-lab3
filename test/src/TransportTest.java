package src;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import src.modell.*;

public class TransportTest {
    
    @Test
    public void shouldReturnTrue() {
        Transport transportTest = new Transport(2, 375, 0, Color.green, "Transport", 0, 0, false, false, 0, 0);
        transportTest.setrampDownTrue();
        assertTrue(transportTest.getRampPosition());

    }

    @Test
    public void shouldReturnFalse() {
        Transport transportTest = new Transport(2, 375, 0, Color.green, "Transport", 0, 0, false, false, 0, 0);
        assertFalse(transportTest.getRampPosition());
    }

    @Test
    public void canLoadCars() {
        Transport transportTest = new Transport(2, 375, 0, Color.green, "Transport", 1, 1, false, false, 1, 0);
        Scania testScania = new Scania(2, 375, 0, Color.green, "Scania", 0, 0, false, false, 0, 70);
        transportTest.setrampDownTrue();
        transportTest.loadCars(testScania);
        List<Car> testList = new ArrayList<Car>();
        testList.add(testScania);
        assertEquals(testList, transportTest.getCurrentLoadedCars());
    }

    @Test
    public void canUnloadCars() {
        Transport transportTest = new Transport(2, 375, 0, Color.green, "Transport", 1, 1, false, false, 2, 0);
        Scania testScania = new Scania(2, 375, 0, Color.green, "Scania", 0, 0, false, false, 0, 70);
        Car testVolvo = new Volvo240(4, 100, 0, Color.black, "Volvo240", 3, 7, false, false);
        transportTest.setrampDownTrue();
        transportTest.loadCars(testScania);
        transportTest.loadCars(testVolvo);
        List<Car> testList = new ArrayList<Car>();
        testList.add(testScania);
        transportTest.unLoadCar();
        assertEquals(testList, transportTest.getCurrentLoadedCars());
    }

}
