package psychedelicLeaves;

import controlP5.ControlP5;
import processing.core.PApplet;
import processing.event.KeyEvent;

public class App extends PApplet {

	public static PApplet p;

	int currentTime = 0;
	int currentFrame = 0;

	boolean isRendering = false;

	// debug stuff
	int m_textLine = 20;
	
	PsychedelicLeaves psychLeaves;

	{ // initialize
		System.out.println("P instantiating");
		p = this;
	}

	public static void main(String args[]) {
		PApplet.main(new String[] { "--location=2000,60", "psychedelicLeaves.App" });
	}

	public void settings() {
        size((int) (0.8f * displayWidth), (int) (0.9f * displayHeight), P3D);
	}

	public void setup() {
		hint(DISABLE_OPTIMIZED_STROKE); // https://github.com/processing/processing/issues/2410
		hint(ENABLE_KEY_REPEAT);
		frameRate(60);
		noCursor();
		
		psychLeaves = new PsychedelicLeaves(this);
		registerMethod("keyEvent", this);

	}

	@Override
	public int millis() {
		return currentTime;
	}

	@Override
	public void draw() {
		background(0);

		currentTime += 41;
		currentFrame += 1;
		psychLeaves.draw();
		if (isRendering)
			saveFrame("#####.png");

		drawCursor();
		psychLeaves.drawCp5();
		fill(0, 130);
		m_textLine = 0;
	}

	void drawCursor() {
		p.camera();
		p.ortho();
		p.strokeWeight(2);
		p.stroke(255, 255, 0, 250);
		float nearZ = ((height / 2.0f) / tan(PI * 60.0f / 360.0f)); // default
																	// ortho()
																	// nearZ is
																	// at
																	// default
																	// cameraZ
																	// from
																	// perspective()
		int mouseSize = 5;
		p.line(mouseX, mouseY - mouseSize, nearZ, mouseX, mouseY + mouseSize, nearZ);
		p.line(mouseX - mouseSize, mouseY, nearZ, mouseX + mouseSize, mouseY, nearZ);
	}

	void showFrameRate() {
		drawText(frameCount + "");
		drawText(frameRate + "");
	}

	void drawText(String text) {
		pushMatrix();
		camera(width / 2, height / 2, (height / 2) / tan(PI / 6), width / 2, height / 2, 0, 0, 1, 0);
		scale(1, 1);
		fill(125);
		text(text, 20, m_textLine);
		m_textLine += 20;
		popMatrix();
	}
	
	public void keyEvent(KeyEvent event) {
		if (event.getKey() == 'x' && event.getAction() == KeyEvent.RELEASE) {
				isRendering = !isRendering;
				System.out.println(isRendering);
			}
	}
}