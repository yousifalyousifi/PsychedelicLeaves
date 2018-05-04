package psychedelicLeaves;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import controlP5.CallbackEvent;
import controlP5.CallbackListener;
import controlP5.ControlEvent;
import controlP5.ControlP5;
import controlP5.Group;
import controlP5.Slider;
import controlP5.Toggle;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;
import processing.event.KeyEvent;
import processing.event.MouseEvent;

public class PsychedelicLeaves implements CallbackListener, PMimic {
	
	PApplet p;

	ControlP5 cp5;

	LeafMaker leafMaker;
	LeafMakerGUI leafMakerGUI;

	PImage leafImage;
	HashMap<String, PImage> leafImages;

	ArrayList<LeafEntity> leafEntities;


	Toggle showHideToggle;
	Slider globalSwingRateFactor;
	Slider globalSwingRangeFactor;
	Slider globalPull;

	int undoPointer = 0;
	
	int mouseX = 0;
	int mouseY = 0;
	
	PsychedelicLeaves(PApplet p) {
		this.p = p;
		
		cp5 = new ControlP5(p);
		cp5.setAutoDraw(false);

		showHideToggle = cp5.addToggle("showHideToggle").setPosition(0,0).setSize(20,20).setValue(1f).setLabel(" Show/Hide GUI").plugTo(this);
		showHideToggle.getCaptionLabel().align(ControlP5.RIGHT_OUTSIDE, ControlP5.CENTER);
		globalSwingRateFactor = cp5.addSlider("globalSwingRateFactor").setLabel("Swing Rate Factor")
				.setBroadcast(false).setPosition(10, 30).setSize(500, 20).setRange(0, 50)
				.setValue(1f).setBroadcast(true).plugTo(this);
		globalSwingRangeFactor = cp5.addSlider("globalSwingRangeFactor").setLabel("Swing Range Factor")
				.setBroadcast(false).setPosition(10, 50).setSize(500, 20)
				.setRange(0, 10).setValue(1f).setBroadcast(true).plugTo(this);
		globalPull = cp5.addSlider("globalPull").setLabel("Factor Pull")
				.setBroadcast(false).setPosition(10, 70).setSize(500, 20)
				.setRange(-100,100).setValue(0f).setBroadcast(true).addCallback(this).plugTo(this);

		leafImages = new HashMap<>();
		leafImages.put("leaf", loadImage("leaf2.png"));

		leafImage = leafImages.get("leaf"); // loadImage("leaf.png");
		leafEntities = new ArrayList<>();

		leafMaker = new LeafMaker(this, leafImage, cp5);
		leafMakerGUI = new LeafMakerGUI(cp5, leafMaker);
		leafMaker.setLeafMakerGUI(leafMakerGUI);

		registerMethod("mouseEvent", leafMakerGUI);
//
		registerMethod("mouseEvent", leafMaker);

		registerMethod("mouseEvent", this);
		registerMethod("keyEvent", this);

		leafMaker.appendPendingLeavesAndClear();
	}
	
	public void showHideToggle(ControlEvent event) {
		boolean show = event.getValue() == 1;
		showHideToggle.setLabelVisible(show);
		leafMakerGUI.toggleAllVisibility(show);
		globalPull.setVisible(show);
		globalSwingRateFactor.setVisible(show);
		globalSwingRangeFactor.setVisible(show);
	}

	HashMap<Integer, Float> rateMap = new HashMap<>();
	HashMap<Integer, Float> rangeMap = new HashMap<>();
	public void globalSwingRateFactor(ControlEvent event) {
		for (int i = undoPointer - 1; i >= 0; i--) {
			LeafEntity leaf = leafEntities.get(i);
			if(rateMap.get(leaf.id)==null) {
				//leaf.restore();
				rateMap.put(leaf.id, leaf.rotationRate);
			}
			leaf.setRotationRate(rateMap.get(leaf.id) * event.getValue());
		}
	}

	public void globalSwingRangeFactor(ControlEvent event) {
		for (int i = undoPointer - 1; i >= 0; i--) {
			LeafEntity leaf = leafEntities.get(i);
			if(rangeMap.get(leaf.id)==null) {
				//leaf.restore();
				rangeMap.put(leaf.id, leaf.rotationRange);
			}
			leaf.setRotationRange(rangeMap.get(leaf.id) * event.getValue());
		}
	}

	float[] pastValues = new float[2];
	public void globalPull(ControlEvent event) {
		float e = 1 + 1f * event.getValue() / 100;
		globalSwingRateFactor.setValue(pastValues[0] * e);
		globalSwingRangeFactor.setValue(pastValues[1] * e);
	}

	@Override
	public void controlEvent(CallbackEvent e) {
		if(e.getAction() == ControlP5.ACTION_RELEASE 
				||e.getAction() == ControlP5.ACTION_RELEASE_OUTSIDE) {
			if(e.getController().getName() == "globalPull") {
				globalPull.setBroadcast(false).setValue(0).setBroadcast(true);
			}
		} else if(e.getAction() == ControlP5.ACTION_PRESS) {
			if(e.getController().getName() == "globalPull") {
				pastValues[0] = globalSwingRateFactor.getValue();
				pastValues[1] = globalSwingRangeFactor.getValue();
				globalPull.setBroadcast(false).setValue(0).setBroadcast(true);
			}
		}
	}
	
	public void draw() {
		
		for (int i = undoPointer - 1; i >= 0; i--) {
			LeafEntity leaf = leafEntities.get(i);
			if (mouseFollow) {
				float angle = atan2(mouseY - leaf.locY, mouseX - leaf.locX) + PConstants.PI / 2;
				leaf.rotation = angle;
			}
			leaf.draw();
		}

		leafMaker.update();
		leafMaker.draw();
		leafMakerGUI.draw();

	}
	
	public void drawCp5() {
		cp5.draw();
	}

	public void undo() {
		if (undoPointer > 0) {
			undoPointer--;
		}
	}

	public void redo() {
		if (undoPointer < leafEntities.size()) {
			undoPointer++;
		}
	}

	public void addLeaf(LeafEntity leaf) {
		while (undoPointer < leafEntities.size() && leafEntities.get(undoPointer) != null) {
			LeafEntity removed = leafEntities.remove(undoPointer);
			rateMap.remove(removed.id);
			rangeMap.remove(removed.id);
		}
		leafEntities.add(leaf);// new LeafImage(leafImage, x, y, 10));
		undoPointer++;
	}

	public void mouseEvent(MouseEvent event) {
		mouseX = event.getX();
		mouseY = event.getY();
	}

	public void keyEvent(KeyEvent event) {
		if (event.getKey() == ']' && event.getAction() == KeyEvent.RELEASE) {
			System.out.println("Saving");
			saveLeavesToFile(leafEntities);
		} else if (event.getKey() == 'q' && event.getAction() == KeyEvent.RELEASE) {
			System.out.println("Loading");
			loadLeavesFile("data/leaves_04-28-2018_01-10-25.txt", leafImage);
		} else if (event.getKey() == 'z' && event.getAction() == KeyEvent.TYPE) {
			System.out.println("Undo");
			undo();
		} else if (event.getKey() == 'y' && event.getAction() == KeyEvent.TYPE) {
			System.out.println("Redo");
			redo();
		} else if (event.getKey() == 'c' && event.getAction() == KeyEvent.RELEASE) {
			leafEntities.stream().forEach(leaf -> leaf.save());
			mouseFollow = true;
		} else if (event.getKey() == 'v' && event.getAction() == KeyEvent.RELEASE) {
			mouseFollow = false;
			leafEntities.stream().forEach(leaf -> leaf.restore());
		}

		if(event.getKey() == '1' && event.getAction() == KeyEvent.RELEASE) {
			leafMaker.switchToNextState();
    	} else if(event.getKey() == '2' && event.getAction() == KeyEvent.RELEASE) {
    		leafMaker.switchToInactiveState();
    	} else if(event.getKey() == '3' && event.getAction() == KeyEvent.RELEASE) {
    		leafMaker.appendPendingLeavesAndClear();
        } else if(event.getKey() == 'r' && event.getAction() == KeyEvent.RELEASE) {
        	System.out.println("Randomizing.");
    		leafMakerGUI.randomizeMainSliders();
        } else if(event.getKey() == 'p' && event.getAction() == KeyEvent.RELEASE) {
        	leafMakerGUI.placeFollowTargetOnMouse();
		}
		
		if (event.getKey() == 'm' && event.getAction() == KeyEvent.RELEASE) {
			unregisterMethod("mouseEvent", leafMakerGUI);
			unregisterMethod("mouseEvent", leafMaker);
			leafMakerGUI.remove();
			leafMaker = new LeafMaker(this, leafImage, cp5);
			leafMakerGUI = new LeafMakerGUI(cp5, leafMaker);
			leafMaker.setLeafMakerGUI(leafMakerGUI);
			registerMethod("mouseEvent", leafMakerGUI);
			registerMethod("mouseEvent", leafMaker);
		}
	}

	boolean mouseFollow = false;

	public void saveLeavesToFile(ArrayList<LeafEntity> leafEntities) {
		try {
		    StringBuilder sb = new StringBuilder();
		    String s = new SimpleDateFormat("MM-dd-yyyy_HH-mm-ss").format(new Date());
		    BufferedWriter writer = new BufferedWriter(new FileWriter("data/leaves_"+s+".txt"));
			for (LeafEntity leaf : leafEntities) {
			    sb.append(leaf.toString()).append('\n');
			}
		    writer.append(sb.toString());
		    writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void loadLeavesFile(String path, PImage image) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File(path)));
			String line = null;
			ArrayList<LeafEntity> entities = new ArrayList<>();
			while ((line = reader.readLine()) != null) {
				LeafEntity leaf = loadLeafFromString2(line, image);
				entities.add(leaf);
			}
			leafEntities = entities;
			undoPointer = entities.size();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public LeafEntity loadLeafFromString2(String line, PImage image) {
		LeafEntity leaf = new LeafEntity(image, Integer.parseInt(getStringValue(line, "locX")),
				Integer.parseInt(getStringValue(line, "locY")), Float.parseFloat(getStringValue(line, "size")),
				Float.parseFloat(getStringValue(line, "pivotX")), Float.parseFloat(getStringValue(line, "pivotY")),
				Float.parseFloat(getStringValue(line, "rotation")),
				Float.parseFloat(getStringValue(line, "rotationRange")),
				Float.parseFloat(getStringValue(line, "rotationRate")),
				Float.parseFloat(getStringValue(line, "offsetAngle")),
				Float.parseFloat(getStringValue(line, "offsetRadius")),
				Float.parseFloat(getStringValue(line, "turnRate")));
		return leaf;
	}

	public String getStringValue(String line, String key) {
		int index = line.indexOf(key + "=");
		index += key.length() + 1;
		int endIndex = line.indexOf(',', index);
		char endingChar = endIndex != -1 ? ',' : ']';
		endIndex = line.indexOf(endingChar, index);
		String sub1 = line.substring(index, endIndex);
		return sub1;
	}

}
