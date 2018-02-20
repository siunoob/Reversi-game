package reversi;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.ByteArrayInputStream;

@RunWith(JUnitParamsRunner.class)
public class ReversiTest {

    @Test
    @Parameters({
            "f5\r\nf6\r\ne6\r\nf4\r\nf3\r\nd6\r\ne7\r\nd3\r\nc6\r\nb6\r\nc5\r\nc7\r\nd7\r\nf2\r\nb8\r\nc8\r\nd8\r\nf7\r\ne8\r\nc4\r\nb5\r\na5\r\na6\r\na7\r\na4\r\na3\r\nb7\r\na8\r\nb4\r\nf8\r\ng8\r\nh8\r\ng7\r\nh7\r\nb3\r\nc3\r\ne3\r\ne2\r\ng6\r\nh6\r\ng5\r\nh5\r\ng4\r\nh4\r\nh3\r\ng3\r\nh2\r\nh1\r\nf1\r\ng2\r\ng1\r\ne1\r\nd2\r\nc1\r\nd1\r\nc2\r\nb1\r\na1\r\na2\r\nb2",
            "e6\r\nf4\r\nc3\r\nc6\r\nd6\r\nf6\r\ne7\r\nd3\r\nc4\r\nb5\r\nd7\r\nd8\r\nc5\r\nf5\r\nf7\r\nb4\r\ne8\r\nf8\r\nb3\r\nc2\r\ng5\r\nh5\r\ng6\r\nh6\r\ne3\r\ne2\r\na5\r\na3\r\nd2\r\nc1\r\ng4\r\nf3\r\na6\r\nb6\r\ng7\r\ng8\r\nh8\r\nh7\r\nc8\r\nb2\r\na1\r\nb1\r\na7\r\nb7\r\nh4\r\ng3\r\nf1\r\nf2\r\nc7\r\na8\r\na4\r\nb8\r\na2",
            "f5\r\nf6\r\ne6\r\nd6\r\nc3\r\ng4\r\ng5\r\nf4\r\nc5\r\nh6\r\nh3\r\ne3\r\nf3\r\nc4\r\nd3\r\nc6\r\nb4\r\ne2\r\nd2\r\ng6\r\nb6\r\nb5\r\nf7\r\ne7\r\nb3\r\nf2\r\nh5\r\nc1\r\nc2\r\na4\r\ne8\r\nh4\r\nd7\r\nh2\r\nc7\r\na3\r\nd1\r\ne1\r\na5\r\ng8\r\nf8\r\nd8\r\nc8\r\nb8\r\ng7\r\na6\r\nb2\r\na2\r\na1\r\nb1\r\na7\r\nb7\r\ng2\r\nh1\r\nf1\r\ng1\r\ng3\r\nh7\r\na8",
            "d3\r\nc3\r\nc4\r\ne3\r\nf4\r\nd6\r\nc6\r\nc5\r\nb4\r\nb5\r\nf6\r\nb6\r\nf2\r\ng4\r\nb3\r\ne6\r\nd7\r\ne7\r\nf3\r\ng5\r\nc7\r\na3\r\na4\r\nc2\r\nd2\r\nd1\r\nf5\r\nf7\r\ng6\r\na5\r\nh3\r\ne2\r\nh5\r\nh4\r\ne8\r\ng3\r\ne1\r\nf1\r\nh6\r\ng7\r\nc1\r\na2\r\ng1\r\ng8\r\na6\r\nf8\r\na1\r\nb1\r\nb2\r\nh1\r\nh8\r\nh7\r\nd8\r\nc8\r\nb8\r\nb7\r\na7\r\na8\r\ng2\r\nh2",
            "e6\r\nf6\r\nf5\r\nf4\r\ne3\r\nc5\r\nc6\r\nd6\r\ne7\r\nd7\r\nc3\r\nc7\r\ng3\r\ne2\r\nf7\r\nc4\r\nb3\r\nb4\r\nf3\r\ng6\r\nd2\r\nd3\r\ng5\r\nf2\r\nc2\r\nh4\r\na5\r\nh5\r\nb6\r\nb5\r\ng4\r\na6\r\nh3\r\nd8\r\nf8\r\na4\r\nb8\r\nh2\r\ne1\r\ng2\r\na3\r\nc1\r\nd1\r\nc8\r\ne8\r\nf1\r\nh6\r\nh7\r\nb2\r\na2\r\na1\r\nb1\r\nb7\r\na8\r\na7\r\ng8\r\nh1\r\ng1\r\nh8\r\ng7",
            "e6\r\nf6\r\nf5\r\nf4\r\ne3\r\nc5\r\nc4\r\nd6\r\nb5\r\nd3\r\nc3\r\ne2\r\nf2\r\nc2\r\nf1\r\nb4\r\nc6\r\nb3\r\nc1\r\na6\r\nd7\r\ne7\r\nf3\r\nb6\r\na3\r\nd2\r\nd1\r\ne1\r\nc7\r\ng4\r\nh5\r\nc8\r\ng3\r\ng5\r\nh6\r\nh3\r\nh4\r\nh7\r\ng7\r\ng6\r\nd8\r\ng1\r\nh1\r\nh8\r\nf7\r\nb1\r\na1\r\nb8\r\na8\r\nb7\r\ng8\r\na2\r\na4\r\nb2\r\na5\r\na7\r\ng2\r\nh2",
            "e6\r\nf4\r\nd3\r\nc4\r\nc3\r\nd6\r\nf6\r\nd2\r\nc6\r\nf5\r\nc5\r\ne7\r\ne2\r\nb5\r\nb4\r\na3\r\nf7\r\nb6\r\ng5\r\ng6\r\nd8\r\nb3\r\nf3\r\ne3\r\nd7\r\nf1\r\nc7\r\nf8\r\ne8\r\nc8\r\nh5\r\ng3\r\na5\r\na6\r\na4\r\ng4\r\nh4\r\nh3\r\nh2\r\ng8\r\ng2\r\nf2\r\nc1\r\nh1\r\nd1\r\ne1\r\nb2\r\nh6\r\ng7\r\nc2\r\na2\r\na1\r\nb1\r\nh8\r\nh7\r\npa\r\nb8\r\na8\r\ng1\r\nb7\r\na7",
            "e6\r\nf4\r\nd3\r\ne7\r\nf3\r\ne3\r\nf2\r\nc3\r\nc5\r\ne2\r\ng4\r\nc4\r\ne1\r\nf5\r\nf6\r\ng3\r\nd2\r\nd6\r\ng5\r\nc6\r\nh4\r\nc2\r\nb1\r\ng6\r\nb3\r\nd1\r\nc1\r\ng1\r\nh7\r\nh5\r\nh6\r\nh3\r\nh2\r\na3\r\nf7\r\nf8\r\nd8\r\ne8\r\ng8\r\ng7\r\nb5\r\nb4\r\nh8\r\na6\r\nb2\r\ng2\r\nh1\r\na2\r\na4\r\na5\r\nf1",
    })
    public void Reversi(String steps) {
        try {
            System.setIn(new ByteArrayInputStream(steps.getBytes()));
            new Reversi().start();
        } finally {
            System.setIn(System.in);
        }
    }
}