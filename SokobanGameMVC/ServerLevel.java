import java.io.Serializable;

public class ServerLevel extends Desktop {
	private int[][] desktop;

	public ServerLevel() {
		desktop = new int[][] {
				{0, 0, 2, 2, 2, 2, 0, 0},
				{0, 0, 2, 4, 4, 2, 0, 0},
				{0, 2, 2, 0, 4, 2, 2, 0},
				{0, 2, 0, 0, 3, 4, 2, 0},
				{2, 2, 0, 3, 0, 0, 2, 2},
				{2, 0, 0, 2, 3, 3, 0, 2},
				{2, 0, 0, 1, 0, 0, 0, 2},
				{2, 2, 2, 2, 2, 2, 2, 2}
		};
	}

	public int[][] getDesktop() {
		return desktop;
	}
}