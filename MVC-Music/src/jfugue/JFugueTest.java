package jfugue;
import org.jfugue.Player;
/**
 *
 * @author Papadakos Panagiotis
 */
public class JFugueTest {
    public static void main(String args[]) {
        Player player = new Player();
        player.play("C D E");
        // Τζοκόντα Χατζιδάκις (cello)
        player.play("I[Cello] E7 D7 E7 F7 D7 C7 D7 E7 E7 D7 E7 D7 C7i D7i B6 A6");
        player.play("[81] [83] [127]");
    }
}
