package psychedelicLeaves;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import controlP5.Accordion;
import controlP5.Button;
import controlP5.ControlEvent;
import controlP5.ControlP5;
import controlP5.ControlP5Constants;
import controlP5.Controller;
import controlP5.Group;
import controlP5.Slider;
import controlP5.Textlabel;
import controlP5.Toggle;
import processing.core.PConstants;
import processing.core.PVector;
import processing.event.MouseEvent;

public class LeafMakerGUI implements PMimic, PConstants {
	
	boolean enabled;
	
	ControlP5 cp5;
	
	Accordion accordion;

	Group mainSliderGroup;
	Group followGroup;
	Group randomizeGroup;

	Textlabel stateLabel;
	Button addPendingLeavesButton;
	
	Slider rotationSlider;
	Slider swingRangeSlider;
	Slider swingRateSlider;
	Slider orbitRadiusSlider;
	Slider orbitRateSlider;
	Slider sizeSlider;

	Toggle followToggle;
	Button placeFollowButton;
	Toggle pointAwayToggle;

	Toggle enableRandomizeToggle;
	Button randomizeButton;
	Toggle rotationRandomToggle;
	Toggle swingRangeRandomToggle;
	Toggle swingRateRandomToggle;
	Toggle orbitRadiusRandomToggle;
	Toggle orbitRateRandomToggle;
	Toggle sizeRandomToggle;
	
	Slider rotationRandomSlider;
	Slider swingRangeRandomSlider;
	Slider swingRateRandomSlider;
	Slider orbitRadiusRandomSlider;
	Slider orbitRateRandomSlider;
	Slider sizeRandomSlider;

	public LeafMaker leafMaker;
	
	public LeafMakerGUI(ControlP5 cp5, LeafMaker leafMaker) {
		this.leafMaker = leafMaker;

		int accordionX = 10;
		int accordionY = 100;

		mainSliderGroup = cp5.addGroup("mainSliderGroup").setPosition(0,60)
                .setBackgroundColor(color(0,230)).setSize(205, 290);
		randomizeGroup = cp5.addGroup("randomizeGroup").setPosition(0,280)
                .setBackgroundColor(color(0,230)).setSize(230, 245);
		followGroup = cp5.addGroup("followGroup").setPosition(0,540)
                .setBackgroundColor(color(0,230)).setSize(230, 100);


       int deltaY = 35; 
       float i = 1.4f;
		stateLabel = cp5.addTextlabel("stateLabel")
				.setPosition(0,0).setText("Current state: ").setGroup("mainSliderGroup");
		addPendingLeavesButton = cp5.addButton("addPendingLeavesButton").setPosition(0, 20)
				.setSize(20,20).setGroup("mainSliderGroup").setLabel("Add Leaves");
		addPendingLeavesButton.getCaptionLabel().align(ControlP5.RIGHT_OUTSIDE, ControlP5.CENTER);
		rotationSlider = cp5.addSlider("rotationSlider").setPosition(0,deltaY*i++).setSize(200, 20)
    			.setRange(0,TWO_PI).setGroup("mainSliderGroup");
		rotationSlider.getCaptionLabel().setText("Rotation").align(ControlP5.RIGHT, ControlP5.BOTTOM_OUTSIDE).setPadding(0, 0);

		swingRangeSlider = cp5.addSlider("swingRangeSlider").setPosition(0,deltaY*i++).setSize(200, 20)
    			.setRange(0,TWO_PI).setGroup("mainSliderGroup");
    	swingRangeSlider.getCaptionLabel().setText("Swing Range").align(ControlP5.RIGHT, ControlP5.BOTTOM_OUTSIDE).setPadding(0, 0);

		swingRateSlider = cp5.addSlider("swingRateSlider").setPosition(0,deltaY*i++).setSize(200, 20)
    			.setRange(0,1000).setGroup("mainSliderGroup");
    	swingRateSlider.getCaptionLabel().setText("Swing Rate").align(ControlP5.RIGHT, ControlP5.BOTTOM_OUTSIDE).setPadding(0, 0);

		orbitRadiusSlider = cp5.addSlider("orbitRadiusSlider").setPosition(0,deltaY*i++).setSize(200, 20)
    			.setRange(0,300).setGroup("mainSliderGroup");
    	orbitRadiusSlider.getCaptionLabel().setText("Orbit Radius").align(ControlP5.RIGHT, ControlP5.BOTTOM_OUTSIDE).setPadding(0, 0);

		orbitRateSlider = cp5.addSlider("orbitRateSlider").setPosition(0,deltaY*i++).setSize(200, 20)
    			.setRange(0,1000).setGroup("mainSliderGroup");
    	orbitRateSlider.getCaptionLabel().setText("Orbit Rate").align(ControlP5.RIGHT, ControlP5.BOTTOM_OUTSIDE).setPadding(0, 0);

		sizeSlider = cp5.addSlider("sizeSlider").setPosition(0,deltaY*i++).setSize(200, 20)
    			.setRange(0,5).setGroup("mainSliderGroup");
    	sizeSlider.getCaptionLabel().setText("Size").align(ControlP5.RIGHT, ControlP5.BOTTOM_OUTSIDE).setPadding(0, 0);

        i = 0;
    	followToggle = cp5.addToggle("followToggle").setPosition(0,deltaY*i).setSize(20,20).setGroup("followGroup").setLabel("Enable");
		placeFollowButton = cp5.addButton("placeFollowButton").setPosition(50, deltaY*i).setSize(20,20).setGroup("followGroup");
		placeFollowButton.getCaptionLabel().setText("Place (P or Drag)").align(ControlP5.LEFT, ControlP5.BOTTOM_OUTSIDE);
    	pointAwayToggle = cp5.addToggle("pointAwayToggle").setPosition(150,deltaY*i).setSize(20,20).setGroup("followGroup").setLabel("Point Away");


		i = 0;
		enableRandomizeToggle = cp5.addToggle("enableRandomizeToggle").setPosition(0,deltaY*i).setSize(20,20).setGroup("randomizeGroup").setLabelVisible(false);
		randomizeButton = cp5.addButton("randomizeButton").setPosition(50,deltaY*i++).setSize(20,20).setGroup("randomizeGroup");
		rotationRandomToggle = cp5.addToggle("rotationRandomToggle").setColorActive(0xFF22AA33).setPosition(0,deltaY*i++).setSize(20,20).setGroup("randomizeGroup").setLabelVisible(false);
		swingRangeRandomToggle = cp5.addToggle("swingRangeRandomToggle").setColorActive(0xFF22AA33).setPosition(0,deltaY*i++).setSize(20,20).setGroup("randomizeGroup").setLabelVisible(false);
		swingRateRandomToggle = cp5.addToggle("swingRateRandomToggle").setColorActive(0xFF22AA33).setPosition(0,deltaY*i++).setSize(20,20).setGroup("randomizeGroup").setLabelVisible(false);
		orbitRadiusRandomToggle = cp5.addToggle("orbitRadiusRandomToggle").setColorActive(0xFF22AA33).setPosition(0,deltaY*i++).setSize(20,20).setGroup("randomizeGroup").setLabelVisible(false);
		orbitRateRandomToggle = cp5.addToggle("orbitRateRandomToggle").setColorActive(0xFF22AA33).setPosition(0,deltaY*i++).setSize(20,20).setGroup("randomizeGroup").setLabelVisible(false);
		sizeRandomToggle = cp5.addToggle("sizeRandomToggle").setColorActive(0xFF22AA33).setPosition(0,deltaY*i++).setSize(20,20).setGroup("randomizeGroup").setLabelVisible(false);
		
		randomizeButton.getCaptionLabel().setText("Randomize (R)").align(ControlP5.RIGHT_OUTSIDE, ControlP5.CENTER).setPadding(5, 0);
		
		i = 1;
		rotationRandomSlider = cp5.addSlider("rotationRandomSlider").setPosition(25,deltaY*i++).setSize(200,20).setGroup("randomizeGroup");
		swingRangeRandomSlider = cp5.addSlider("swingRangeRandomSlider").setPosition(25,deltaY*i++).setSize(200,20).setGroup("randomizeGroup");
		swingRateRandomSlider = cp5.addSlider("swingRateRandomSlider").setPosition(25,deltaY*i++).setSize(200,20).setGroup("randomizeGroup");
		orbitRadiusRandomSlider = cp5.addSlider("orbitRadiusRandomSlider").setPosition(25,deltaY*i++).setSize(200,20).setGroup("randomizeGroup");
		orbitRateRandomSlider = cp5.addSlider("orbitRateRandomSlider").setPosition(25,deltaY*i++).setSize(200,20).setGroup("randomizeGroup");
		sizeRandomSlider = cp5.addSlider("sizeRandomSlider").setPosition(25,deltaY*i++).setSize(200,20).setGroup("randomizeGroup").setLabel("Size random range");
		
		rotationRandomSlider.getCaptionLabel().setText("Rotation").align(ControlP5.RIGHT, ControlP5.BOTTOM_OUTSIDE).setPadding(0, 0);
		swingRangeRandomSlider.getCaptionLabel().setText("Swing Range").align(ControlP5.RIGHT, ControlP5.BOTTOM_OUTSIDE).setPadding(0, 0);
		swingRateRandomSlider.getCaptionLabel().setText("Swing Rate").align(ControlP5.RIGHT, ControlP5.BOTTOM_OUTSIDE).setPadding(0, 0);
		orbitRadiusRandomSlider.getCaptionLabel().setText("Orbit Radius").align(ControlP5.RIGHT, ControlP5.BOTTOM_OUTSIDE).setPadding(0, 0);
		orbitRateRandomSlider.getCaptionLabel().setText("Orbit Rate").align(ControlP5.RIGHT, ControlP5.BOTTOM_OUTSIDE).setPadding(0, 0);
		sizeRandomSlider.getCaptionLabel().setText("Size").align(ControlP5.RIGHT, ControlP5.BOTTOM_OUTSIDE).setPadding(0, 0);
		

		accordion = cp5.addAccordion("acc")
		                 .setPosition(accordionX,accordionY)
		                 .setWidth(230)
		                 .setCollapseMode(ControlP5Constants.MULTI)
		                 .addItem(mainSliderGroup)
		                 .addItem(randomizeGroup)
		                 .addItem(followGroup)
		                 .open();

		getControllers().stream().forEach(controller -> controller.plugTo(this));
		
		
		initializeValues(); 
	}
	
	public void remove() {
		accordion.remove();
//		mainSliderGroup.remove();
//		randomizeGroup.remove();
//		followGroup.remove();
	}

	public ArrayList<Controller> getControllers() {
		Controller[] controllers = {addPendingLeavesButton,
									rotationSlider,
									swingRangeSlider,
									swingRateSlider,
									orbitRadiusSlider,
									orbitRateSlider,
									sizeSlider,
									followToggle,
									placeFollowButton,
									enableRandomizeToggle,
									randomizeButton,
									rotationRandomToggle,
									swingRangeRandomToggle,
									swingRateRandomToggle,
									orbitRadiusRandomToggle,
									orbitRateRandomToggle,
									sizeRandomToggle,
									rotationRandomSlider,
									swingRangeRandomSlider,
									swingRateRandomSlider,
									orbitRadiusRandomSlider,
									orbitRateRandomSlider,
									sizeRandomSlider};
		ArrayList<Controller> c = new ArrayList<>(Arrays.asList(controllers));
		return c;
	}
	
	private void initializeValues() {
//		getAllControllers().stream().forEach(controller -> controller.setBroadcast(false));
		rotationSlider.setValue(0f);
		swingRangeSlider.setValue(PI/4);
		swingRateSlider.setValue(0f);
		orbitRadiusSlider.setValue(0f);
		orbitRateSlider.setValue(0f);
		sizeSlider.setValue(1f);
		saveMainSliders();
		
		rotationRandomToggle.setValue(0f);
		swingRangeRandomToggle.setValue(0f);
		swingRateRandomToggle.setValue(0f);
		orbitRadiusRandomToggle.setValue(0f);
		orbitRateRandomToggle.setValue(0f);
		
		enableRandomizeToggle.setValue(0f);
		
		
		followToggle.setValue(0f);
	}

	public void showHideToggle(ControlEvent event) {
		boolean show = event.getValue() > 0.5f;
		toggleVisibility(show);
	}

	public void toggleAllVisibility(boolean show) {
		mainSliderGroup.setVisible(show);
		followGroup.setVisible(show);
		randomizeGroup.setVisible(show);
	}
	
	public void toggleVisibility(boolean show) {
		mainSliderGroup.setVisible(show);
		followGroup.setVisible(show);
		randomizeGroup.setVisible(show);
	}
	
	public void rotationSlider(ControlEvent event) {
	    float value = event.getValue();
		if(followToggle.getBooleanValue() == true) {
			float sliderValue = event.getValue();
			float angle;
			if(pointAwayToggle.getBooleanValue() == false) {
				angle = atan2(followTarget.y - pointer_y, followTarget.x - pointer_x);
			} else {
				angle = atan2(pointer_y - followTarget.y, pointer_x - followTarget.x);
			}
			leafMaker.leafBrush.setRotation(angle + sliderValue);
		} else {
			leafMaker.leafBrush.setRotation(value);	
		}
		mainSlidersMemory.put(rotationSlider.getName(), event.getValue());
	}
	public void swingRangeSlider(ControlEvent event) {
	    float value = event.getValue();
	    leafMaker.leafBrush.setRotationRange(value);
		mainSlidersMemory.put(swingRangeSlider.getName(), event.getValue());
	}
	public void swingRateSlider(ControlEvent event) {
	    float value = event.getValue();
		float swingRateFactor = 1f/50000;
	    leafMaker.leafBrush.setRotationRate(value * swingRateFactor);
		mainSlidersMemory.put(swingRateSlider.getName(), event.getValue());
	}
	public void orbitRadiusSlider(ControlEvent event) {
	    float value = event.getValue();
	    leafMaker.leafBrush.setOffsetRadius(value);
		mainSlidersMemory.put(orbitRadiusSlider.getName(), event.getValue());
		
	}
	public void orbitRateSlider(ControlEvent event) {
	    float value = event.getValue();
		float turnRateFactor = 1f/50000;
	    leafMaker.leafBrush.setTurnRate(value * turnRateFactor);
		mainSlidersMemory.put(orbitRateSlider.getName(), event.getValue());
	}
	public void sizeSlider(ControlEvent event) {
	    float value = event.getValue();
	    leafMaker.leafBrush.setSize(value);
		mainSlidersMemory.put(sizeSlider.getName(), event.getValue());
	}
	
	float rotationSliderMemory = 0f;
	boolean followTargetPlacementInProgress = false;
	public void followToggle(ControlEvent event) {
		if(event.getValue() > 0.5f) {
			placeFollowButton.unlock();
		} else {
			placeFollowButton.lock();
		}
		float swap = rotationSlider.getValue();
		rotationSlider.setValue(rotationSliderMemory);
		rotationSliderMemory = swap;
	}

	public void placeFollowButton(ControlEvent event) {
		followTargetPlacementInProgress = true;
	}
	
	public void draw() {
		fill(255,255,0);
		//ellipse(followTarget.x, followTarget.y, 5, 5);
	}
	
	PVector followTarget = new PVector(500, 200);
	int pointer_x = 0;
	int pointer_y = 0;
	public void mouseEvent(MouseEvent event) {
		if(event.getAction() == MouseEvent.MOVE) {
			pointer_x = event.getX();
			pointer_y = event.getY();
			if(followToggle.getBooleanValue() == true) {
				float sliderValue = rotationSlider.getValue();
				float angle;
				if(pointAwayToggle.getBooleanValue() == false) {
					angle = atan2(followTarget.y - pointer_y, followTarget.x - pointer_x);
				} else {
					angle = atan2(pointer_y - followTarget.y, pointer_x - followTarget.x);
				}
    			leafMaker.leafBrush.setRotation(angle + sliderValue);
			}
		} else if(event.getAction() == MouseEvent.RELEASE && event.getButton() == LEFT) {
			if(followTargetPlacementInProgress) {
				followTarget.set(event.getX(), event.getY());
				followTargetPlacementInProgress = false;
			}
		} else if(event.getAction() == MouseEvent.PRESS && event.getButton() == RIGHT) {
			followTargetPlacementInProgress = false;
		}
	}
	
	public void addPendingLeavesButton(ControlEvent event) {
		leafMaker.appendPendingLeavesAndClear();
	}

	public void placeFollowTargetOnMouse() {
		if(followToggle.getBooleanValue() == true) {
			followTarget.set(pointer_x, pointer_y);
			followTargetPlacementInProgress = false;
		}
	}
	
	HashMap<String, Float> randomToggleMemory = new HashMap<>();
	private void saveRandomToggleMemory() {
		randomToggleMemory.clear();
		randomToggleMemory.put(rotationRandomToggle.getName(), rotationRandomToggle.getValue());
		randomToggleMemory.put(swingRangeRandomToggle.getName(), swingRangeRandomToggle.getValue());
		randomToggleMemory.put(swingRateRandomToggle.getName(), swingRateRandomToggle.getValue());
		randomToggleMemory.put(orbitRadiusRandomToggle.getName(), orbitRadiusRandomToggle.getValue());
		randomToggleMemory.put(orbitRateRandomToggle.getName(), orbitRateRandomToggle.getValue());
		randomToggleMemory.put(sizeRandomToggle.getName(), sizeRandomToggle.getValue());
	}

	private void restoreRandomToggleMemory() {
		rotationRandomToggle.setValue(randomToggleMemory.get(rotationRandomToggle.getName()));
		swingRangeRandomToggle.setValue(randomToggleMemory.get(swingRangeRandomToggle.getName()));
		swingRateRandomToggle.setValue(randomToggleMemory.get(swingRateRandomToggle.getName()));
		orbitRadiusRandomToggle.setValue(randomToggleMemory.get(orbitRadiusRandomToggle.getName()));
		orbitRateRandomToggle.setValue(randomToggleMemory.get(orbitRateRandomToggle.getName()));
		sizeRandomToggle.setValue(randomToggleMemory.get(sizeRandomToggle.getName()));
	}

	HashMap<String, Float> mainSlidersMemory = new HashMap<>();
	public void saveMainSliders() {
		mainSlidersMemory.clear();
		mainSlidersMemory.put(rotationSlider.getName(), rotationSlider.getValue());
		mainSlidersMemory.put(swingRangeSlider.getName(), swingRangeSlider.getValue());
		mainSlidersMemory.put(swingRateSlider.getName(), swingRateSlider.getValue());
		mainSlidersMemory.put(orbitRadiusSlider.getName(), orbitRadiusSlider.getValue());
		mainSlidersMemory.put(orbitRateSlider.getName(), orbitRateSlider.getValue());
		mainSlidersMemory.put(sizeSlider.getName(), sizeSlider.getValue());
	}
	public void restoreMainSliders() {
		rotationSlider.setValue(mainSlidersMemory.get(rotationSlider.getName()));
		swingRangeSlider.setValue(mainSlidersMemory.get(swingRangeSlider.getName()));
		swingRateSlider.setValue(mainSlidersMemory.get(swingRateSlider.getName()));
		orbitRadiusSlider.setValue(mainSlidersMemory.get(orbitRadiusSlider.getName()));
		orbitRateSlider.setValue(mainSlidersMemory.get(orbitRateSlider.getName()));
		sizeSlider.setValue(mainSlidersMemory.get(sizeSlider.getName()));
	}
	public void randomizeMainSliders() {
		if(enableRandomizeToggle.getBooleanValue() == true) {
			System.out.println("Randomizing");
			//save current values to restore at the end of this call
			float rotationValue = mainSlidersMemory.get(rotationSlider.getName());
			float swingRangeValue = mainSlidersMemory.get(swingRangeSlider.getName());
			float swingRateValue = mainSlidersMemory.get(swingRateSlider.getName());
			float orbitRadiusValue = mainSlidersMemory.get(orbitRadiusSlider.getName());
			float orbitRateValue = mainSlidersMemory.get(orbitRateSlider.getName());
			float sizeValue = mainSlidersMemory.get(sizeSlider.getName());

			//get the range of the main slider and divide by two (just because).
			//convert the randomSlider into a percentage
			//then multiply together
			float rotationRandomRange = rotationRandomSlider.getValue() * 0.01f * ((rotationSlider.getMax() - rotationSlider.getMin()) / 2);
			float swingRangeRandomRange = swingRangeRandomSlider.getValue() * 0.01f * ((swingRangeSlider.getMax() - swingRangeSlider.getMin()) / 2);
			float swingRateRandomRange = swingRateRandomSlider.getValue() * 0.01f * ((swingRateSlider.getMax() - swingRateSlider.getMin()) / 2);
			float orbitRadiusRandomRange = orbitRadiusRandomSlider.getValue() * 0.01f * ((orbitRadiusSlider.getMax() - orbitRadiusSlider.getMin()) / 2);
			float orbitRateRandomRange = orbitRateRandomSlider.getValue() * 0.01f * ((orbitRateSlider.getMax() - orbitRateSlider.getMin()) / 2);
			float sizeRandomRange = sizeRandomSlider.getValue() * 0.01f * ((sizeSlider.getMax() - sizeSlider.getMin()) / 2);
			
			float rotationRandomValue = random( -rotationRandomRange, rotationRandomRange);
			float swingRangeRandomValue = random( -swingRangeRandomRange, swingRangeRandomRange);
			float swingRateRandomValue = random( -swingRateRandomRange, swingRateRandomRange);
			float orbitRadiusRandomValue = random( -orbitRadiusRandomRange, orbitRadiusRandomRange);
			float orbitRateRandomValue = random( -orbitRateRandomRange, orbitRateRandomRange);
			float sizeRandomValue = random( -sizeRandomRange, sizeRandomRange);

			rotationRandomValue = (rotationRandomToggle.getBooleanValue()) ? rotationRandomValue : 0f;
			swingRangeRandomValue = (swingRangeRandomToggle.getBooleanValue()) ? swingRangeRandomValue : 0f;
			swingRateRandomValue = (swingRateRandomToggle.getBooleanValue()) ? swingRateRandomValue : 0f;
			orbitRadiusRandomValue = (orbitRadiusRandomToggle.getBooleanValue()) ? orbitRadiusRandomValue : 0f;
			orbitRateRandomValue = (orbitRateRandomToggle.getBooleanValue()) ? orbitRateRandomValue : 0f;
			sizeRandomValue = (sizeRandomToggle.getBooleanValue()) ? sizeRandomValue : 0f;

			rotationSlider.setValue(rotationValue + rotationRandomValue);
			swingRangeSlider.setValue(swingRangeValue + swingRangeRandomValue);
			swingRateSlider.setValue(swingRateValue + swingRateRandomValue);
			orbitRadiusSlider.setValue(orbitRadiusValue + orbitRadiusRandomValue);
			orbitRateSlider.setValue(orbitRateValue + orbitRateRandomValue);
			sizeSlider.setValue(sizeValue + sizeRandomValue);
			System.out.println("Randomized");

			//because setValue() will change the value in the mainSlidersMemory map
			//we need to restore the values in there.
			mainSlidersMemory.put(rotationSlider.getName(), rotationValue);
			mainSlidersMemory.put(swingRangeSlider.getName(), swingRangeValue);
			mainSlidersMemory.put(swingRateSlider.getName(), swingRateValue);
			mainSlidersMemory.put(orbitRadiusSlider.getName(), orbitRadiusValue);
			mainSlidersMemory.put(orbitRateSlider.getName(), orbitRateValue);
			mainSlidersMemory.put(sizeSlider.getName(), sizeValue);
		}
	}

	public void enableRandomizeToggle(ControlEvent event) {
		boolean enabled = event.getValue() > 0.5f;
		if(enabled) {
			System.out.println("Randomize Enabled");
			saveMainSliders();
			restoreRandomToggleMemory();
			rotationRandomToggle.setLock(false);
			swingRangeRandomToggle.setLock(false);
			swingRateRandomToggle.setLock(false);
			orbitRadiusRandomToggle.setLock(false);
			orbitRateRandomToggle.setLock(false);
			sizeRandomToggle.setLock(false);
		} else {
			System.out.println("Randomize Disabled");
			restoreMainSliders();
			saveRandomToggleMemory();
			rotationRandomToggle.setValue(0f);
			swingRangeRandomToggle.setValue(0f);
			swingRateRandomToggle.setValue(0f);
			orbitRadiusRandomToggle.setValue(0f);
			orbitRateRandomToggle.setValue(0f);
			sizeRandomToggle.setValue(0f);
			rotationRandomToggle.setLock(true);
			swingRangeRandomToggle.setLock(true);
			swingRateRandomToggle.setLock(true);
			orbitRadiusRandomToggle.setLock(true);
			orbitRateRandomToggle.setLock(true);
			sizeRandomToggle.setLock(true);
		}
	}
	
	
	public void randomizeButton(ControlEvent event) {
		randomizeMainSliders();
	}
	public void rotationRandomToggle(ControlEvent event) {
		rotationRandomSlider.setLock(event.getValue() < 0.5f);
	}
	public void swingRangeRandomToggle(ControlEvent event) {
		swingRangeRandomSlider.setLock(event.getValue() < 0.5f);
	}
	public void swingRateRandomToggle(ControlEvent event) {
		swingRateRandomSlider.setLock(event.getValue() < 0.5f);
	}
	public void orbitRadiusRandomToggle(ControlEvent event) {
		orbitRadiusRandomSlider.setLock(event.getValue() < 0.5f);
	}
	public void orbitRateRandomToggle(ControlEvent event) {
		orbitRateRandomSlider.setLock(event.getValue() < 0.5f);
	}
	public void sizeRandomToggle(ControlEvent event) {
		sizeRandomSlider.setLock(event.getValue() < 0.5f);
	}

	public void setStateLabel(String string) {
		stateLabel.setText("Current state: " + string);
	}
	
}
