package psychedelicLeaves;

import java.util.ArrayList;

import controlP5.ControlP5;
import processing.core.PConstants;
import processing.core.PImage;
import processing.core.PVector;
import processing.event.MouseEvent;

public class LeafMaker implements PMimic, PConstants {

	enum State {
		OFF, NOTACTIVE, SIZE, ROTATION, SWINGRANGE, SWINGRATE, OFFSETRADIUS, TURNRATE
	}
	
	State previousState = State.NOTACTIVE;
	State currentState = State.NOTACTIVE;
	
	LeafEntity leafBrush;
	ArrayList<LeafEntity> leafsToAdd;
	
	boolean applyTargeting;
	boolean towardsTarget;
	PVector target;
	
	boolean placementInProcess;

	int brushOriginX;
	int brushOriginY;
	int pointerX;
	int pointerY;
	
	float offsetangle;

	float size;
	float rotation;
	float swingrange;
	float swingrate;
	float offsetradius;
	float turnrate;
	
	//guard circle
	//if the pointer is inside this circle, no changes are made
	float guardCircleRadius = 30.0f;
	PVector guardCircleCentre = new PVector();
	boolean isInsideGuardCircle;
	PVector settingOrigin = new PVector(); //the origin at which to base values to apply on the brush
	
	PsychedelicLeaves pleaves;

	LeafMakerGUI leafMakerGUI;
	
	public LeafMaker(PsychedelicLeaves pleaves, PImage image, ControlP5 cp5) {
		this.pleaves = pleaves;
		float pivotX = image.width/3f;
		float pivotY = image.height/2f;
		leafBrush = new LeafEntity(image, 500, 500, 1, pivotX, pivotY, 0, 0, 0, 0, 0, 0);
		leafsToAdd = new ArrayList<>();
	}
	
	public void setLeafMakerGUI(LeafMakerGUI gui) {
		leafMakerGUI = gui;
	}
	
	public boolean isActive() {
		return currentState != State.NOTACTIVE;
	}
	
    int undoPointer = 0;

    public void undo() {
    	if(undoPointer > 0) {
            undoPointer--;   
        }
    }

    public void redo() {
        if(undoPointer < leafsToAdd.size()) {
            undoPointer++;   
        }
    }
    
	public void draw() {
		
    	for(int i = undoPointer - 1; i >= 0; i--) {
    		LeafEntity leaf = leafsToAdd.get(i);
    		leaf.draw();
    	}
		leafBrush.draw();
		leafBrush.debugDraw();

		
		if(currentState != State.NOTACTIVE) {
			ellipseMode(CENTER);
			if(isInsideGuardCircle) {
				noFill();
				stroke(255, 100);
				strokeWeight(3);
				ellipse(guardCircleCentre.x, guardCircleCentre.y, guardCircleRadius*2, guardCircleRadius*2);
			} else {
				fill(0, 255, 0, 200);
				noStroke();
				ellipse(settingOrigin.x, settingOrigin.y, 4, 4);
			}
			//draw guard circle and settingOrigin
		}
	}
	
	public void update() {
		if(isInsideGuardCircle) {
			if(!isPointerInsideGuard()) {
				isInsideGuardCircle = false;
				settingOrigin = makeGuardExitPoint();
			}
		} else {
			//NOTACTIVE, SIZE, ROTATION, SWINGRANGE, SWINGRATE, OFFSETRADIUS, TURNRATE
			if(currentState == State.OFFSETRADIUS) {
				float radius = sqrt(pow(pointerX - settingOrigin.x, 2) + pow(pointerY - settingOrigin.y, 2));
				if(abs(radius) < 5.0f) {
					radius = 0;
				}
				leafBrush.setOffsetRadius(radius);
			} else if(currentState == State.TURNRATE) {
				float turnRate = sqrt(pow(pointerX - settingOrigin.x, 2) + pow(pointerY - settingOrigin.y, 2));
				if(turnRate < 5) { turnRate = 0f; }
				float turnRateFactor = 1f/50000;
				leafBrush.setTurnRate(turnRate * turnRateFactor);
			} else if(currentState == State.ROTATION) {
				float angle = atan2(pointerY-leafBrush.locY, pointerX-leafBrush.locX);
				leafBrush.setRotation(angle);
			} else if(currentState == State.SWINGRANGE) {
				float swingRange = sqrt(pow(pointerX - settingOrigin.x, 2) + pow(pointerY - settingOrigin.y, 2));
				float swingRangeFactor = 0.01f;
				leafBrush.setRotationRange(swingRange * swingRangeFactor);
			} else if(currentState == State.SWINGRATE) {
				float swingRate = sqrt(pow(pointerX - settingOrigin.x, 2) + pow(pointerY - settingOrigin.y, 2));
				if(swingRate < 5) { swingRate = 0f; }
				float swingRateFactor = 1f/50000;
				leafBrush.setRotationRate(swingRate * swingRateFactor);
			} else if(currentState == State.SIZE) {
				float size = sqrt(pow(pointerX - settingOrigin.x, 2) + pow(pointerY - settingOrigin.y, 2));
				float sizeFactor = 0.01f;
				leafBrush.setSize(size * sizeFactor);
			} else if(currentState == State.NOTACTIVE) {
				leafBrush.locY = pointerY;
				leafBrush.locX = pointerX;
			} 
		}
	}
	
	public void addLeaf(LeafEntity leafEntity) {
		leafsToAdd.add(leafEntity);
        undoPointer++;
	}
	
	public void mouseEvent(MouseEvent event) {
		int x = event.getX();
		int y = event.getY();
    	if(event.getAction() == MouseEvent.CLICK && event.getButton() == RIGHT) {
            while(undoPointer < leafsToAdd.size() && leafsToAdd.get(undoPointer) != null) {
            	leafsToAdd.remove(undoPointer);
            }
            
            addLeaf(leafBrush.clone());
            
            leafMakerGUI.randomizeMainSliders();
    		
    		previousState = currentState;
    		currentState = State.NOTACTIVE;
    	} else if(event.getAction() == MouseEvent.MOVE) {
    		pointerX = x;
    		pointerY = y;
    	}
	}
	
	public void switchToNextState() {
		previousState = currentState;
		currentState = getNextState(currentState);
		leafMakerGUI.setStateLabel(currentState.toString());
		
		brushOriginX = pointerX;
		brushOriginY = pointerY;
		
		guardCircleCentre.set(pointerX, pointerY);
		isInsideGuardCircle = true;
		
		leafBrush.save();
	}
	
	public void switchToInactiveState() {
		leafBrush.restore();
		previousState = currentState;
		isInsideGuardCircle = false;
		currentState = State.NOTACTIVE;
	}
	
	public void appendPendingLeavesAndClear() {
		leafsToAdd.stream().forEach(leaf -> pleaves.addLeaf(leaf));
		leafsToAdd.clear();
		undoPointer = 0;
	}
	
	public boolean isPointerInsideGuard() {
		return dist(pointerX, pointerY, guardCircleCentre.x, guardCircleCentre.y) < guardCircleRadius;
	}
	
	public PVector makeGuardExitPoint() {
		PVector v = PVector.sub(new PVector(pointerX, pointerY), guardCircleCentre);
		return v.setMag(guardCircleRadius).add(guardCircleCentre);
	}
	
	public State getNextState(State in) {
		switch (in) {
		case NOTACTIVE: return State.ROTATION;
		case ROTATION: return State.SWINGRANGE;
		case SWINGRANGE: return State.SWINGRATE;
		case SWINGRATE: return State.OFFSETRADIUS;
		case OFFSETRADIUS: return State.TURNRATE;
		case TURNRATE: return State.SIZE;
		case SIZE: return State.ROTATION;
		default: return State.NOTACTIVE;
		}
	}
	
	
	public void cancel() {
		leafBrush.restore();
	}
	
	public static class ControlEvent {
		
	}
	
}
