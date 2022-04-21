import javax.swing.JPanel;
import java.awt.*;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Canvas extends JPanel {
	private Model model;
	private Image imageGamer;
	private Image imageWall;
	private Image imageBox;
	private Image imageGoal;

	public Canvas(Model model) {
		this.model = model;
		setBackground(Color.BLACK);
		setOpaque(true);
		File fileNameImageGamer = new File("SokobanGameMVC\\images\\gamer.png");
		File fileNameImageWall = new File("SokobanGameMVC\\images\\wall.png");
		File fileNameImageBox = new File("SokobanGameMVC\\images\\box.png");
		File fileNameImageGoal = new File("SokobanGameMVC\\images\\goal.png");
		try {
			imageGamer = ImageIO.read(fileNameImageGamer);
			imageWall = ImageIO.read(fileNameImageWall);
			imageBox = ImageIO.read(fileNameImageBox);
			imageGoal = ImageIO.read(fileNameImageGoal);
		} catch (IOException ioe) {
			System.out.println(ioe);
		}
	}


	public void paint(Graphics g) {
		super.paint(g);
		if (model.isErrorState()) {
			drawError(g);
			return;
		}
		drawDesktop(g);
	}

	private void drawDesktop(Graphics g) {
		super.paint(g);
		int start = 50;
		int x = start;
		int y = start;
		int width = 50;
		int height = 50;

		int[][] desktop = model.getDesktop();
		for (int i = 0; i < desktop.length; i++) {
			for (int j = 0; j < desktop[i].length; j++) {
				if (desktop[i][j] == 1) {
					g.drawImage(imageGamer, x, y, null);
				} else if (desktop[i][j] == 2) {
					g.drawImage(imageWall, x, y, null);
				} else if (desktop[i][j] == 3) {
					g.drawImage(imageBox, x, y, null);
				} else if (desktop[i][j] == 4) {
					g.drawImage(imageGoal, x, y, null);
				}
				x = x + width;
			}
			x = start;
			y = y + height;
		}

	}

	private void drawError(Graphics g) {
		g.setFont(new Font("Verdana", Font.BOLD, 25));
		g.setColor(Color.RED);
		g.drawRect(70, 160, 495, 60);
		g.drawString("Error! Level has an incorrect structure!", 86, 200);
	}
}
