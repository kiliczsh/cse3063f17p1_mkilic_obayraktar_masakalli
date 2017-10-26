import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import junit.framework.Assert;

/**
 * @author 
 *
 */
public class Test {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("beforeclass");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		 System.out.println("afterclass");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		System.out.println("setup");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		 System.out.println("after");
	}

	@SuppressWarnings("deprecation")
	@org.junit.Test
	public void test() {
		GameBoard gameBoard = new GameBoard();
		Player player = new Player(100);
	    player.setPlayerName("TestPlayer");
	    Dice dice = new Dice();
	    dice.rollDice();
	    Square square = new Square(5,"TestSquare");
	    Assert.assertEquals(100, player.getPlayerID());
	    Assert.assertEquals("TestPlayer", player.getPlayerName());
	    Assert.assertTrue(gameBoard.squareList[0].getSquareName().equals(player.getCurrentposition().getSquareName()));
	    Assert.assertTrue(dice.rollDice()<=6 && dice.rollDice()>=1);
	    Assert.assertEquals(5, square.getSquareID());
	    Assert.assertEquals("TestSquare", square.getSquareName());
	    Assert.assertNotNull(square);
	    Assert.assertNotNull(dice);
	    Assert.assertNotNull(player);
	    Assert.assertNotNull(gameBoard);

	}
}
