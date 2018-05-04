package psychedelicLeaves;

import java.util.HashMap;

import processing.core.PConstants;
import processing.core.PImage;

public class LeafEntity implements Cloneable, PMimic {
	
	private static int idcounter = 0; 
	
	int id;
	HashMap<String, Object> savedValues;
	PImage leafImage;
	int locX;
	int locY;
	float size = 1;

	float pivotX;
	float pivotY;

	float rotation;
	float rotationRange;
	float rotationRate;

	float offsetAngle;
	float offsetRadius;
	float turnRate;

	float swingPhase;
	float turnPhase;

	@Override
	public String toString() {
		return "LeafImage [locX=" + locX + ", locY=" + locY + ", size=" + size + ", pivotX=" + pivotX + ", pivotY="
				+ pivotY + ", rotation=" + rotation + ", rotationRange=" + rotationRange + ", rotationRate="
				+ rotationRate + ", offsetAngle=" + offsetAngle + ", offsetRadius=" + offsetRadius + ", turnRate="
				+ turnRate + "]";
	}

	{
		id = idcounter++;
		savedValues = new HashMap<>();
	}

	public LeafEntity(PImage image, int x, int y) {
		leafImage = image;
		locX = x;
		locY = y;

		pivotX = leafImage.width / 2;
		pivotY = leafImage.height / 3;

		savedValues.put("locX", x);
		savedValues.put("locY", y);
	}

	public LeafEntity(PImage image, int x, int y, int offsetCircleRadius) {
		this.leafImage = image;
		locX = x;
		locY = y;
		this.offsetRadius = offsetCircleRadius;

		pivotX = 0;// leafImage.width * 3.0f/4;
		pivotY = 0;// leafImage.height/2;

		savedValues.put("locX", x);
		savedValues.put("locY", y);
		savedValues.put("offsetRadius", offsetRadius);
	}

	public LeafEntity(PImage leafImage, int locX, int locY, float size, float pivotX, float pivotY, float rotation,
			float rotationRange, float rotationRate, float offsetAngle, float offsetRadius, float turnRate) {
		super();
		this.leafImage = leafImage;
		this.locX = locX;
		this.locY = locY;
		this.size = size;
		this.pivotX = pivotX;
		this.pivotY = pivotY;
		this.rotation = rotation;
		this.rotationRange = rotationRange;
		this.rotationRate = rotationRate;
		this.offsetAngle = offsetAngle;
		this.offsetRadius = offsetRadius;
		this.turnRate = turnRate;

		save();
	}

	public void save() {
		savedValues.clear();
		savedValues.put("locX", locX);
		savedValues.put("locY", locY);
		savedValues.put("size", size);
		savedValues.put("pivotX", pivotX);
		savedValues.put("pivotY", pivotY);
		savedValues.put("rotation", rotation);
		savedValues.put("rotationRange", rotationRange);
		savedValues.put("rotationRate", rotationRate);
		// savedValues.put("offsetAngle", offsetAngle);
		savedValues.put("offsetRadius", offsetRadius);
		savedValues.put("turnRate", turnRate);
	}

	public void restore() {
		locX = (int) savedValues.get("locX");
		locY = (int) savedValues.get("locY");
		offsetRadius = (float) savedValues.get("offsetRadius");
		size = (float) savedValues.get("size");
		pivotX = (float) savedValues.get("pivotX");
		pivotY = (float) savedValues.get("pivotY");
		rotation = (float) savedValues.get("rotation");
		rotationRange = (float) savedValues.get("rotationRange");
		setRotationRate((float) savedValues.get("rotationRate"));
		// offsetAngle = (float) savedValues.get("offsetAngle");
		offsetRadius = (float) savedValues.get("offsetRadius");
		setTurnRate((float) savedValues.get("turnRate"));
	}

	public void draw() {
		pushMatrix();
		float offsetX = cos(offsetAngle) * offsetRadius;
		float offsetY = sin(offsetAngle) * offsetRadius;
		offsetAngle = millis() * turnRate;

		noStroke();
		translate(locX, locY);
		fill(255, 255, 0);

		// rotating then translating causes the apparent slowdown in turning
		rotate(rotationFunction(rotation, rotationRange, rotationRate, millis()));
		translate(offsetX, offsetY);

		scale(size);
		image(leafImage, -pivotX, -pivotY);
		popMatrix();
	}

	public void debugDraw() {
		int time = millis();
		pushMatrix();
		offsetAngle = time * turnRate + turnPhase;
		float offsetX = cos(offsetAngle) * offsetRadius;
		float offsetY = sin(offsetAngle) * offsetRadius;

		strokeWeight(2);
		stroke(100, 200, 255);
		translate(locX, locY);
		fill(255, 255, 0);
		noFill();
		// ellipse(0, 0, 5, 5);
		ellipseMode(PConstants.CENTER);
		// fill(255,0,0);
		ellipse(0, 0, offsetRadius * 2, offsetRadius * 2);

		int sizeDrawFactor = 50;
		stroke(255, 255, 0, 100);
		strokeWeight(0.5f);
		ellipse(0, 0, size * sizeDrawFactor, size * sizeDrawFactor);

		float rotation = this.rotation;// +  PConstants.PI / 2;

		float swingAngle = rotationFunction(rotation, rotationRange, rotationRate, time);

		int axisSize = 50;

		int rotLineLength = 50;
		rotate(rotation);
		strokeWeight(2);
		line(-axisSize, 0, axisSize, 0);
		line(0, axisSize, 0, -axisSize);

		strokeWeight(3);
		stroke(255, 0, 255, 200);
		arc(0, 0, rotLineLength * 2, rotLineLength * 2, -rotationRange, +rotationRange);
		rotate(-rotation);

		rotate(swingAngle);
		translate(offsetX, offsetY);
		line(0, 0, rotLineLength, 0);

		stroke(255, 102, 0);
		strokeWeight(1);
		line(-axisSize, 0, axisSize, 0);
		line(0, axisSize, 0, -axisSize);

		fill(255, 0, 0);
		noStroke();
		ellipse(0, 0, 10, 10);

		stroke(255, 0, 255);
		line(0, 0, rotLineLength, 0);

		translate(-offsetX, -offsetY);
		rotate(-swingAngle);

		popMatrix();
	}

	public void setRotationValues(float rotation, float rotationRange, float rotationRate) {
		this.rotation = rotation;
		this.rotationRange = rotationRange;
		this.rotationRate = rotationRate;

		if (savedValues.get("rotation") == null) {
			savedValues.put("rotation", rotation);
		}
		if (savedValues.get("rotationRange") == null) {
			savedValues.put("rotationRange", rotationRange);
		}
		if (savedValues.get("rotationRate") == null) {
			savedValues.put("rotationRate", rotationRate);
		}

	}

	public void setOffsetValues(float offsetRadius, float turnRate) {
		this.offsetRadius = offsetRadius;
		this.turnRate = turnRate;

		if (savedValues.get("offsetRadius") == null) {
			savedValues.put("offsetRadius", offsetRadius);
		}
		if (savedValues.get("turnRate") == null) {
			savedValues.put("turnRate", turnRate);
		}
	}

	public void setOffsetValues(float offsetRadius, float turnRate, float initialAngle) {
		this.offsetRadius = offsetRadius;
		this.turnRate = turnRate;
		this.offsetAngle = initialAngle;
	}

	public void setLocation(int x, int y) {
		locX = x;
		locY = y;
	}

	public void setSize(float size) {
		this.size = size;
	}

	public float getRotation() {
		return rotation;
	}

	public void setRotation(float rotation) {
		this.rotation = rotation;
	}

	public float getRotationRange() {
		return rotationRange;
	}

	public void setRotationRange(float rotationRange) {
		this.rotationRange = rotationRange;
	}

	public float getRotationRate() {
		return rotationRate;
	}

	public void setRotationRate(float rotationRate) {
		float curr = (millis() * this.rotationRate + swingPhase) %  PConstants.TWO_PI;
		float next = (millis() * rotationRate) %  PConstants.TWO_PI;
		swingPhase = curr - next;
		this.rotationRate = rotationRate;
	}

	public float getOffsetAngle() {
		return offsetAngle;
	}

	public void setOffsetAngle(float offsetAngle) {
		this.offsetAngle = offsetAngle;
	}

	public float getOffsetRadius() {
		return offsetRadius;
	}

	public void setOffsetRadius(float offsetRadius) {
		this.offsetRadius = offsetRadius;
	}

	public float getTurnRate() {
		return turnRate;
	}

	public void setTurnRate(float turnRate) {
		float curr = (millis() * this.turnRate + turnPhase) % PConstants.TWO_PI;
		float next = (millis() * turnRate) % PConstants.TWO_PI;
		turnPhase = curr - next;
		this.turnRate = turnRate;
	}

	public float getSize() {
		return size;
	}

	public float rotationFunction(float initial, float range, float rate, float time) {
		return initial + range * sin(time * rate + swingPhase);
	}

	public LeafEntity clone() {
		try {
			LeafEntity leaf = (LeafEntity) super.clone();
			leaf.savedValues = (HashMap<String, Object>) this.savedValues.clone();
			leaf.save();
			return leaf;
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}

}