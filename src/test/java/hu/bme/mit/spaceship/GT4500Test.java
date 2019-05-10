package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class GT4500Test {
    private TorpedoStore primary;
	private TorpedoStore secondary;
    private GT4500 ship;

  @BeforeEach
  public void init(){
	primary = mock(TorpedoStore.class);
	secondary= mock(TorpedoStore.class);
    this.ship = new GT4500(primary,secondary);
  }

  @Test
  public void fireTorpedo_Single_Success(){
    // Arrange
	when(primary.getTorpedoCount()).thenReturn(10);
	when(secondary.getTorpedoCount()).thenReturn(10);
	when(primary.isEmpty()).thenReturn(false);
	when(secondary.isEmpty()).thenReturn(false);
	when(primary.fire(1)).thenReturn(true);
	when(secondary.fire(1)).thenReturn(true);

    // Act
    boolean result = ship.fireTorpedo(FiringMode.SINGLE);

    // Assert
	verify(primary, times(1)).fire(1);
	verify(secondary, times(0)).fire(1);
    assertEquals(true, result);
  }

  @Test
  public void fireTorpedo_All_Success(){
    // Arrange
	when(primary.getTorpedoCount()).thenReturn(10);
	when(secondary.getTorpedoCount()).thenReturn(10);
	when(primary.isEmpty()).thenReturn(false);
	when(secondary.isEmpty()).thenReturn(false);
	when(primary.fire(1)).thenReturn(true);
	when(secondary.fire(1)).thenReturn(true);

    // Act
    boolean result = ship.fireTorpedo(FiringMode.ALL);

    // Assert
    assertEquals(true, result);
  }

}
