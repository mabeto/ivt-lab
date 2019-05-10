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
  public void  primaryfire(){
    // Arrange
	when(primary.getTorpedoCount()).thenReturn(10);
	when(primary.isEmpty()).thenReturn(false);
	when(primary.fire(1)).thenReturn(true);

    // Act
    boolean result = ship.fireTorpedo(FiringMode.SINGLE);

    // Assert
	verify(primary, times(1)).fire(1);
	verify(secondary, times(0)).fire(1);
    assertEquals(true, result);
  }
  
   @Test
  public void secondaryfire(){
    // Arrange
	when(primary.getTorpedoCount()).thenReturn(0);
	when(secondary.getTorpedoCount()).thenReturn(10);
	when(primary.isEmpty()).thenReturn(true);
	when(secondary.isEmpty()).thenReturn(false);
	when(secondary.fire(1)).thenReturn(true);

    // Act
    boolean result = ship.fireTorpedo(FiringMode.SINGLE);
	 boolean result1 = ship.fireTorpedo(FiringMode.SINGLE);

    // Assert
	verify(primary, times(0)).fire(1);
	verify(secondary, times(2)).fire(1);
    assertEquals(true, result);
  }
  
   @Test
  public void third (){
    // Arrange
	when(primary.isEmpty()).thenReturn(false);
	when(secondary.isEmpty()).thenReturn(true);
	when(primary.fire(1)).thenReturn(true);

    // Act
    boolean result = ship.fireTorpedo(FiringMode.SINGLE);

    // Assert
	verify(primary, times(1)).fire(1);
	verify(secondary, times(0)).fire(1);
    assertEquals(true, result);
  }
  
   @Test
  public void fourd(){
    // Arrange
	

    // Act
   

    // Assert
	

  }
  
  
   @Test
  public void fifth(){
    // Arrange
	

    // Act
  

    // Assert
  }

  @Test
  public void fireTorpedo_All_Success(){
    // Arrange

    // Act


    // Assert
 
  }

}
