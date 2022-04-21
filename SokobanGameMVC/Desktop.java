import java.io.Serializable;

public class Desktop implements Serializable {
    private static final long serialVersionUID = 1L;
    private int[][] desktop;

    public Desktop(int[][] desktop) {
        this.desktop = desktop;
    }

    public Desktop() {
    }

    public int[][] getDesktop() {
        return desktop;
    }
}
