package test.java;
import main.XandO;
import org.junit.*;

public class XandOtest
{
    XandO game;
    @Before
    public void SetUpInstance()
    {
        game = new XandO();
    }

    @Test
    public void checkWin()
    {

        game.setCell(0, 0, 'X');
        game.setCell(0, 1, 'X');
        game.setCell(0, 2, 'X');
        Assert.assertTrue(game.checkWin('X'));

        game.reset();
        game.setCell(0, 0, 'O');
        game.setCell(1, 0, 'O');
        game.setCell(2, 0, 'O');
        Assert.assertTrue(game.checkWin('O'));

        game.reset();
        game.setCell(0, 0, 'X');
        game.setCell(1, 1, 'X');
        game.setCell(2, 2, 'X');
        Assert.assertTrue(game.checkWin('X'));

        game.reset();
        game.setCell(0, 0, 'X');
        game.setCell(1, 1, 'O');
        game.setCell(2, 2, 'X');
        Assert.assertFalse(game.checkWin('X'));
    }

    @Test
    public void CheckDraw()
    {
        game.reset();
        game.setCell(0, 0, 'X');
        game.setCell(0, 1, 'O');
        game.setCell(0, 2, 'X');
        game.setCell(1, 0, 'X');
        game.setCell(1, 1, 'O');
        game.setCell(1, 2, 'O');
        game.setCell(2, 0, 'O');
        game.setCell(2, 1, 'X');
        game.setCell(2, 2, 'X');
        Assert.assertTrue(game.draw());
    }

    @Test
    public void CheckReset()
    {
        game.setCell(0, 0, 'X');
        game.setCell(0, 1, 'O');
        game.setCell(0, 2, 'X');
        game.reset();
        char cellValue = game.getCell(0, 0);
        char currentPlayer = game.getCurrentPlayer();
        Assert.assertFalse(cellValue == 'X' || cellValue == 'O');
        Assert.assertEquals('X', currentPlayer);
    }
}
