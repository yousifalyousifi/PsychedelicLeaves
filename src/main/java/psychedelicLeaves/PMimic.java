package psychedelicLeaves;

import java.awt.Frame;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PGraphics;
import processing.core.PImage;
import processing.core.PMatrix;
import processing.core.PMatrix2D;
import processing.core.PMatrix3D;
import processing.core.PShape;
import processing.core.PStyle;
import processing.data.JSONArray;
import processing.data.JSONObject;
import processing.data.Table;
import processing.data.XML;
import processing.event.KeyEvent;
import processing.event.MouseEvent;
import processing.opengl.PGL;
import processing.opengl.PShader;

public interface PMimic {

	public static PApplet getPApplet() {
		return App.p;
	}

	default public void settings() {
		getPApplet().settings();
	}

	default public int sketchWidth() {
		return getPApplet().sketchWidth();
	}

	default public int sketchHeight() {
		return getPApplet().sketchHeight();
	}

	default public String sketchRenderer() {
		return getPApplet().sketchRenderer();
	}

	default public int sketchSmooth() {
		return getPApplet().sketchSmooth();
	}

	default public boolean sketchFullScreen() {
		return getPApplet().sketchFullScreen();
	}

	default public int sketchDisplay() {
		return getPApplet().sketchDisplay();
	}

	default public String sketchOutputPath() {
		return getPApplet().sketchOutputPath();
	}

	default public OutputStream sketchOutputStream() {
		return getPApplet().sketchOutputStream();
	}

	default public int sketchWindowColor() {
		return getPApplet().sketchWindowColor();
	}

	default public int sketchPixelDensity() {
		return getPApplet().sketchPixelDensity();
	}

	default public int displayDensity() {
		return getPApplet().displayDensity();
	}

	default/*static*/ public int displayDensity(int display) {
		return getPApplet().displayDensity(display);
	}

	default public void pixelDensity(int density) {
		getPApplet().pixelDensity(density);
	}

	default public void setSize(int width, int height) {
		getPApplet().setSize(width, height);
	}

	default public void smooth() {
		getPApplet().smooth();
	}

	default public void smooth(int level) {
		getPApplet().smooth(level);
	}

	default public void noSmooth() {
		getPApplet().noSmooth();
	}

	default public PGraphics getGraphics() {
		return getPApplet().getGraphics();
	}

	default public void orientation(int which) {
		getPApplet().orientation(which);
	}

	default public void start() {
		getPApplet().start();
	}

	default public void stop() {
		getPApplet().stop();
	}

	default public void pause() {
		getPApplet().pause();
	}

	default public void resume() {
		getPApplet().resume();
	}

	default public void registerMethod(String methodName, Object target) {
		getPApplet().registerMethod(methodName, target);
	}

	default public void unregisterMethod(String name, Object target) {
		getPApplet().unregisterMethod(name, target);
	}

	default public void setup() {
		getPApplet().setup();
	}

	default public void draw() {
		getPApplet().draw();
	}

	default public void fullScreen() {
		getPApplet().fullScreen();
	}

	default public void fullScreen(int display) {
		getPApplet().fullScreen(display);
	}

	default public void fullScreen(String renderer) {
		getPApplet().fullScreen(renderer);
	}

	default public void fullScreen(String renderer, int display) {
		getPApplet().fullScreen(renderer, display);
	}

	default public void size(int width, int height) {
		getPApplet().size(width, height);
	}

	default public void size(int width, int height, String renderer) {
		getPApplet().size(width, height, renderer);
	}

	default public void size(int width, int height, String renderer, String path) {
		getPApplet().size(width, height, renderer, path);
	}

	default public PGraphics createGraphics(int w, int h) {
		return getPApplet().createGraphics(w, h);
	}

	default public PGraphics createGraphics(int w, int h, String renderer) {
		return getPApplet().createGraphics(w, h, renderer);
	}

	default public PGraphics createGraphics(int w, int h, String renderer, String path) {
		return getPApplet().createGraphics(w, h, renderer, path);
	}

	default public PImage createImage(int w, int h, int format) {
		return getPApplet().createImage(w, h, format);
	}

	default public void handleDraw() {
		getPApplet().handleDraw();
	}

	default public boolean isLooping() {
		return getPApplet().isLooping();
	}

	default public void postEvent(processing.event.Event pe) {
		getPApplet().postEvent(pe);
	}

	default public void mousePressed() {
		getPApplet().mousePressed();
	}

	default public void mousePressed(MouseEvent event) {
		getPApplet().mousePressed(event);
	}

	default public void mouseReleased() {
		getPApplet().mouseReleased();
	}

	default public void mouseReleased(MouseEvent event) {
		getPApplet().mouseReleased(event);
	}

	default public void mouseClicked() {
		getPApplet().mouseClicked();
	}

	default public void mouseClicked(MouseEvent event) {
		getPApplet().mouseClicked(event);
	}

	default public void mouseDragged() {
		getPApplet().mouseDragged();
	}

	default public void mouseDragged(MouseEvent event) {
		getPApplet().mouseDragged(event);
	}

	default public void mouseMoved() {
		getPApplet().mouseMoved();
	}

	default public void mouseMoved(MouseEvent event) {
		getPApplet().mouseMoved(event);
	}

	default public void mouseEntered() {
		getPApplet().mouseEntered();
	}

	default public void mouseEntered(MouseEvent event) {
		getPApplet().mouseEntered(event);
	}

	default public void mouseExited() {
		getPApplet().mouseExited();
	}

	default public void mouseExited(MouseEvent event) {
		getPApplet().mouseExited(event);
	}

	default public void mouseWheel() {
		getPApplet().mouseWheel();
	}

	default public void mouseWheel(MouseEvent event) {
		getPApplet().mouseWheel(event);
	}

	default public void keyPressed() {
		getPApplet().keyPressed();
	}

	default public void keyPressed(KeyEvent event) {
		getPApplet().keyPressed(event);
	}

	default public void keyReleased() {
		getPApplet().keyReleased();
	}

	default public void keyReleased(KeyEvent event) {
		getPApplet().keyReleased(event);
	}

	default public void keyTyped() {
		getPApplet().keyTyped();
	}

	default public void keyTyped(KeyEvent event) {
		getPApplet().keyTyped(event);
	}

	default public void focusGained() {
		getPApplet().focusGained();
	}

	default public void focusLost() {
		getPApplet().focusLost();
	}

	default public int millis() {
		return getPApplet().millis();
	}

	default/*static*/ public int second() {
		return getPApplet().second();
	}

	default/*static*/ public int minute() {
		return getPApplet().minute();
	}

	default/*static*/ public int hour() {
		return getPApplet().hour();
	}

	default/*static*/ public int day() {
		return getPApplet().day();
	}

	default/*static*/ public int month() {
		return getPApplet().month();
	}

	default/*static*/ public int year() {
		return getPApplet().year();
	}

	default public void delay(int napTime) {
		getPApplet().delay(napTime);
	}

	default public void frameRate(float fps) {
		getPApplet().frameRate(fps);
	}

	default public void link(String url) {
		getPApplet().link(url);
	}

	default/*static*/ public Process launch(String... args) {
		return getPApplet().launch(args);
	}

	default/*static*/ public Process exec(String... args) {
		return getPApplet().exec(args);
	}

	default public void die(String what) {
		getPApplet().die(what);
	}

	default public void die(String what, Exception e) {
		getPApplet().die(what, e);
	}

	default public void exit() {
		getPApplet().exit();
	}

	default public boolean exitCalled() {
		return getPApplet().exitCalled();
	}

	default public void exitActual() {
		getPApplet().exitActual();
	}

	default public void dispose() {
		getPApplet().dispose();
	}

	default public void method(String name) {
		getPApplet().method(name);
	}

	default public void thread(String name) {
		getPApplet().thread(name);
	}

	default public void save(String filename) {
		getPApplet().save(filename);
	}

	default public void saveFrame() {
		getPApplet().saveFrame();
	}

	default public void saveFrame(String filename) {
		getPApplet().saveFrame(filename);
	}

	default public String insertFrame(String what) {
		return getPApplet().insertFrame(what);
	}

	default public void cursor(int kind) {
		getPApplet().cursor(kind);
	}

	default public void cursor(PImage img) {
		getPApplet().cursor(img);
	}

	default public void cursor(PImage img, int x, int y) {
		getPApplet().cursor(img, x, y);
	}

	default public void cursor() {
		getPApplet().cursor();
	}

	default public void noCursor() {
		getPApplet().noCursor();
	}

	default/*static*/ public void print(byte what) {
		getPApplet().print(what);
	}

	default/*static*/ public void print(boolean what) {
		getPApplet().print(what);
	}

	default/*static*/ public void print(char what) {
		getPApplet().print(what);
	}

	default/*static*/ public void print(int what) {
		getPApplet().print(what);
	}

	default/*static*/ public void print(long what) {
		getPApplet().print(what);
	}

	default/*static*/ public void print(float what) {
		getPApplet().print(what);
	}

	default/*static*/ public void print(double what) {
		getPApplet().print(what);
	}

	default/*static*/ public void print(String what) {
		getPApplet().print(what);
	}

	default/*static*/ public void print(Object... variables) {
		getPApplet().print(variables);
	}

	default/*static*/ public void println() {
		getPApplet().println();
	}

	default/*static*/ public void println(byte what) {
		getPApplet().println(what);
	}

	default/*static*/ public void println(boolean what) {
		getPApplet().println(what);
	}

	default/*static*/ public void println(char what) {
		getPApplet().println(what);
	}

	default/*static*/ public void println(int what) {
		getPApplet().println(what);
	}

	default/*static*/ public void println(long what) {
		getPApplet().println(what);
	}

	default/*static*/ public void println(float what) {
		getPApplet().println(what);
	}

	default/*static*/ public void println(double what) {
		getPApplet().println(what);
	}

	default/*static*/ public void println(String what) {
		getPApplet().println(what);
	}

	default/*static*/ public void println(Object... variables) {
		getPApplet().println(variables);
	}

	default/*static*/ public void println(Object what) {
		getPApplet().println(what);
	}

	default/*static*/ public void printArray(Object what) {
		getPApplet().printArray(what);
	}

	default/*static*/ public void debug(String msg) {
		getPApplet().debug(msg);
	}

	default/*static*/ public float abs(float n) {
		return getPApplet().abs(n);
	}

	default/*static*/ public int abs(int n) {
		return getPApplet().abs(n);
	}

	default/*static*/ public float sq(float n) {
		return getPApplet().sq(n);
	}

	default public float sqrt(float n) {
		return getPApplet().sqrt(n);
	}

	default/*static*/ public float log(float n) {
		return getPApplet().log(n);
	}

	default/*static*/ public float exp(float n) {
		return getPApplet().exp(n);
	}

	default/*static*/ public float pow(float n, float e) {
		return getPApplet().pow(n, e);
	}

	default/*static*/ public int max(int a, int b) {
		return getPApplet().max(a, b);
	}

	default/*static*/ public float max(float a, float b) {
		return getPApplet().max(a, b);
	}

	default/*static*/ public int max(int a, int b, int c) {
		return getPApplet().max(a, b, c);
	}

	default/*static*/ public float max(float a, float b, float c) {
		return getPApplet().max(a, b, c);
	}

	default/*static*/ public int max(int[] list) {
		return getPApplet().max(list);
	}

	default/*static*/ public float max(float[] list) {
		return getPApplet().max(list);
	}

	default/*static*/ public int min(int a, int b) {
		return getPApplet().min(a, b);
	}

	default/*static*/ public float min(float a, float b) {
		return getPApplet().min(a, b);
	}

	default/*static*/ public int min(int a, int b, int c) {
		return getPApplet().min(a, b, c);
	}

	default/*static*/ public float min(float a, float b, float c) {
		return getPApplet().min(a, b, c);
	}

	default/*static*/ public int min(int[] list) {
		return getPApplet().min(list);
	}

	default/*static*/ public float min(float[] list) {
		return getPApplet().min(list);
	}

	default/*static*/ public int constrain(int amt, int low, int high) {
		return getPApplet().constrain(amt, low, high);
	}

	default/*static*/ public float constrain(float amt, float low, float high) {
		return getPApplet().constrain(amt, low, high);
	}

	default/*static*/ public float sin(float angle) {
		return getPApplet().sin(angle);
	}

	default public float cos(float angle) {
		return getPApplet().cos(angle);
	}

	default/*static*/ public float tan(float angle) {
		return getPApplet().tan(angle);
	}

	default/*static*/ public float asin(float value) {
		return getPApplet().asin(value);
	}

	default/*static*/ public float acos(float value) {
		return getPApplet().acos(value);
	}

	default/*static*/ public float atan(float value) {
		return getPApplet().atan(value);
	}

	default/*static*/ public float atan2(float y, float x) {
		return getPApplet().atan2(y, x);
	}

	default/*static*/ public float degrees(float radians) {
		return getPApplet().degrees(radians);
	}

	default/*static*/ public float radians(float degrees) {
		return getPApplet().radians(degrees);
	}

	default/*static*/ public int ceil(float n) {
		return getPApplet().ceil(n);
	}

	default/*static*/ public int floor(float n) {
		return getPApplet().floor(n);
	}

	default/*static*/ public int round(float n) {
		return getPApplet().round(n);
	}

	default/*static*/ public float mag(float a, float b) {
		return getPApplet().mag(a, b);
	}

	default/*static*/ public float mag(float a, float b, float c) {
		return getPApplet().mag(a, b, c);
	}

	default/*static*/ public float dist(float x1, float y1, float x2, float y2) {
		return getPApplet().dist(x1, y1, x2, y2);
	}

	default/*static*/ public float dist(float x1, float y1, float z1, float x2, float y2, float z2) {
		return getPApplet().dist(x1, y1, z1, x2, y2, z2);
	}

	default/*static*/ public float lerp(float start, float stop, float amt) {
		return getPApplet().lerp(start, stop, amt);
	}

	default/*static*/ public float norm(float value, float start, float stop) {
		return getPApplet().norm(value, start, stop);
	}

	default/*static*/ public float map(float value, float start1, float stop1, float start2, float stop2) {
		return getPApplet().map(value, start1, stop1, start2, stop2);
	}

	default public float random(float high) {
		return getPApplet().random(high);
	}

	default public float randomGaussian() {
		return getPApplet().randomGaussian();
	}

	default public float random(float low, float high) {
		return getPApplet().random(low, high);
	}

	default public void randomSeed(long seed) {
		getPApplet().randomSeed(seed);
	}

	default public float noise(float x) {
		return getPApplet().noise(x);
	}

	default public float noise(float x, float y) {
		return getPApplet().noise(x, y);
	}

	default public float noise(float x, float y, float z) {
		return getPApplet().noise(x, y, z);
	}

	default public void noiseDetail(int lod) {
		getPApplet().noiseDetail(lod);
	}

	default public void noiseDetail(int lod, float falloff) {
		getPApplet().noiseDetail(lod, falloff);
	}

	default public void noiseSeed(long seed) {
		getPApplet().noiseSeed(seed);
	}

	default public PImage loadImage(String filename) {
		return getPApplet().loadImage(filename);
	}

	default public PImage loadImage(String filename, String extension) {
		return getPApplet().loadImage(filename, extension);
	}

	default public PImage requestImage(String filename) {
		return getPApplet().requestImage(filename);
	}

	default public PImage requestImage(String filename, String extension) {
		return getPApplet().requestImage(filename, extension);
	}

	default public XML loadXML(String filename) {
		return getPApplet().loadXML(filename);
	}

	default public XML loadXML(String filename, String options) {
		return getPApplet().loadXML(filename, options);
	}

	default public XML parseXML(String xmlString) {
		return getPApplet().parseXML(xmlString);
	}

	default public XML parseXML(String xmlString, String options) {
		return getPApplet().parseXML(xmlString, options);
	}

	default public boolean saveXML(XML xml, String filename) {
		return getPApplet().saveXML(xml, filename);
	}

	default public boolean saveXML(XML xml, String filename, String options) {
		return getPApplet().saveXML(xml, filename, options);
	}

	default public JSONObject parseJSONObject(String input) {
		return getPApplet().parseJSONObject(input);
	}

	default public JSONObject loadJSONObject(String filename) {
		return getPApplet().loadJSONObject(filename);
	}

	default/*static*/ public JSONObject loadJSONObject(File file) {
		return getPApplet().loadJSONObject(file);
	}

	default public boolean saveJSONObject(JSONObject json, String filename) {
		return getPApplet().saveJSONObject(json, filename);
	}

	default public boolean saveJSONObject(JSONObject json, String filename, String options) {
		return getPApplet().saveJSONObject(json, filename, options);
	}

	default public JSONArray parseJSONArray(String input) {
		return getPApplet().parseJSONArray(input);
	}

	default public JSONArray loadJSONArray(String filename) {
		return getPApplet().loadJSONArray(filename);
	}

	default/*static*/ public JSONArray loadJSONArray(File file) {
		return getPApplet().loadJSONArray(file);
	}

	default public boolean saveJSONArray(JSONArray json, String filename) {
		return getPApplet().saveJSONArray(json, filename);
	}

	default public boolean saveJSONArray(JSONArray json, String filename, String options) {
		return getPApplet().saveJSONArray(json, filename, options);
	}

	default public Table loadTable(String filename) {
		return getPApplet().loadTable(filename);
	}

	default public Table loadTable(String filename, String options) {
		return getPApplet().loadTable(filename, options);
	}

	default public boolean saveTable(Table table, String filename) {
		return getPApplet().saveTable(table, filename);
	}

	default public boolean saveTable(Table table, String filename, String options) {
		return getPApplet().saveTable(table, filename, options);
	}

	default public PFont loadFont(String filename) {
		return getPApplet().loadFont(filename);
	}

	default public PFont createFont(String name, float size) {
		return getPApplet().createFont(name, size);
	}

	default public PFont createFont(String name, float size, boolean smooth) {
		return getPApplet().createFont(name, size, smooth);
	}

	default public PFont createFont(String name, float size, boolean smooth, char[] charset) {
		return getPApplet().createFont(name, size, smooth, charset);
	}

	default public void selectInput(String prompt, String callback) {
		getPApplet().selectInput(prompt, callback);
	}

	default public void selectInput(String prompt, String callback, File file) {
		getPApplet().selectInput(prompt, callback, file);
	}

	default public void selectInput(String prompt, String callback, File file, Object callbackObject) {
		getPApplet().selectInput(prompt, callback, file, callbackObject);
	}

	default/*static*/ public void selectInput(String prompt, String callbackMethod, File file, Object callbackObject, Frame parent) {
		getPApplet().selectInput(prompt, callbackMethod, file, callbackObject, parent);
	}

	default public void selectOutput(String prompt, String callback) {
		getPApplet().selectOutput(prompt, callback);
	}

	default public void selectOutput(String prompt, String callback, File file) {
		getPApplet().selectOutput(prompt, callback, file);
	}

	default public void selectOutput(String prompt, String callback, File file, Object callbackObject) {
		getPApplet().selectOutput(prompt, callback, file, callbackObject);
	}

	default/*static*/ public void selectOutput(String prompt, String callbackMethod, File file, Object callbackObject, Frame parent) {
		getPApplet().selectOutput(prompt, callbackMethod, file, callbackObject, parent);
	}

	default public void selectFolder(String prompt, String callback) {
		getPApplet().selectFolder(prompt, callback);
	}

	default public void selectFolder(String prompt, String callback, File file) {
		getPApplet().selectFolder(prompt, callback, file);
	}

	default public void selectFolder(String prompt, String callback, File file, Object callbackObject) {
		getPApplet().selectFolder(prompt, callback, file, callbackObject);
	}

	default/*static*/ public void selectFolder(String prompt, String callbackMethod, File defaultSelection, Object callbackObject, Frame parentFrame) {
		getPApplet().selectFolder(	prompt, callbackMethod, defaultSelection, callbackObject,
									parentFrame);
	}

	default/*static*/ public String checkExtension(String filename) {
		return getPApplet().checkExtension(filename);
	}

	default public BufferedReader createReader(String filename) {
		return getPApplet().createReader(filename);
	}

	default/*static*/ public BufferedReader createReader(File file) {
		return getPApplet().createReader(file);
	}

	default/*static*/ public BufferedReader createReader(InputStream input) {
		return getPApplet().createReader(input);
	}

	default public PrintWriter createWriter(String filename) {
		return getPApplet().createWriter(filename);
	}

	default/*static*/ public PrintWriter createWriter(File file) {
		return getPApplet().createWriter(file);
	}

	default/*static*/ public PrintWriter createWriter(OutputStream output) {
		return getPApplet().createWriter(output);
	}

	default public InputStream createInput(String filename) {
		return getPApplet().createInput(filename);
	}

	default public InputStream createInputRaw(String filename) {
		return getPApplet().createInputRaw(filename);
	}

	default/*static*/ public InputStream createInput(File file) {
		return getPApplet().createInput(file);
	}

	default public byte[] loadBytes(String filename) {
		return getPApplet().loadBytes(filename);
	}

	default/*static*/ public byte[] loadBytes(InputStream input) {
		return getPApplet().loadBytes(input);
	}

	default/*static*/ public byte[] loadBytes(File file) {
		return getPApplet().loadBytes(file);
	}

	default/*static*/ public String[] loadStrings(File file) {
		return getPApplet().loadStrings(file);
	}

	default public String[] loadStrings(String filename) {
		return getPApplet().loadStrings(filename);
	}

	default/*static*/ public String[] loadStrings(InputStream input) {
		return getPApplet().loadStrings(input);
	}

	default/*static*/ public String[] loadStrings(BufferedReader reader) {
		return getPApplet().loadStrings(reader);
	}

	default public OutputStream createOutput(String filename) {
		return getPApplet().createOutput(filename);
	}

	default/*static*/ public OutputStream createOutput(File file) {
		return getPApplet().createOutput(file);
	}

	default public boolean saveStream(String target, String source) {
		return getPApplet().saveStream(target, source);
	}

	default public boolean saveStream(File target, String source) {
		return getPApplet().saveStream(target, source);
	}

	default public boolean saveStream(String target, InputStream source) {
		return getPApplet().saveStream(target, source);
	}

	default/*static*/ public boolean saveStream(File target, InputStream source) {
		return getPApplet().saveStream(target, source);
	}

	default/*static*/ public void saveStream(OutputStream target, InputStream source) throws IOException {
		getPApplet().saveStream(target, source);
	}

	default public void saveBytes(String filename, byte[] data) {
		getPApplet().saveBytes(filename, data);
	}

	default/*static*/ public void saveBytes(File file, byte[] data) {
		getPApplet().saveBytes(file, data);
	}

	default/*static*/ public void saveBytes(OutputStream output, byte[] data) {
		getPApplet().saveBytes(output, data);
	}

	default public void saveStrings(String filename, String data[]) {
		getPApplet().saveStrings(filename, data);
	}

	default/*static*/ public void saveStrings(File file, String data[]) {
		getPApplet().saveStrings(file, data);
	}

	default/*static*/ public void saveStrings(OutputStream output, String[] data) {
		getPApplet().saveStrings(output, data);
	}

	default public String sketchPath() {
		return getPApplet().sketchPath();
	}

	default public String sketchPath(String where) {
		return getPApplet().sketchPath(where);
	}

	default public File sketchFile(String where) {
		return getPApplet().sketchFile(where);
	}

	default public String savePath(String where) {
		return getPApplet().savePath(where);
	}

	default public File saveFile(String where) {
		return getPApplet().saveFile(where);
	}

	default/*static*/ public File desktopFile(String what) {
		return getPApplet().desktopFile(what);
	}

	default/*static*/ public String desktopPath(String what) {
		return getPApplet().desktopPath(what);
	}

	default public String dataPath(String where) {
		return getPApplet().dataPath(where);
	}

	default public File dataFile(String where) {
		return getPApplet().dataFile(where);
	}

	default/*static*/ public void createPath(String path) {
		getPApplet().createPath(path);
	}

	default/*static*/ public void createPath(File file) {
		getPApplet().createPath(file);
	}

	default/*static*/ public String getExtension(String filename) {
		return getPApplet().getExtension(filename);
	}

	default/*static*/ public String urlEncode(String str) {
		return getPApplet().urlEncode(str);
	}

	default/*static*/ public String urlDecode(String str) {
		return getPApplet().urlDecode(str);
	}

	default/*static*/ public byte[] sort(byte list[]) {
		return getPApplet().sort(list);
	}

	default/*static*/ public byte[] sort(byte[] list, int count) {
		return getPApplet().sort(list, count);
	}

	default/*static*/ public char[] sort(char list[]) {
		return getPApplet().sort(list);
	}

	default/*static*/ public char[] sort(char[] list, int count) {
		return getPApplet().sort(list, count);
	}

	default/*static*/ public int[] sort(int list[]) {
		return getPApplet().sort(list);
	}

	default/*static*/ public int[] sort(int[] list, int count) {
		return getPApplet().sort(list, count);
	}

	default/*static*/ public float[] sort(float list[]) {
		return getPApplet().sort(list);
	}

	default/*static*/ public float[] sort(float[] list, int count) {
		return getPApplet().sort(list, count);
	}

	default/*static*/ public String[] sort(String list[]) {
		return getPApplet().sort(list);
	}

	default/*static*/ public String[] sort(String[] list, int count) {
		return getPApplet().sort(list, count);
	}

	default/*static*/ public void arrayCopy(Object src, int srcPosition, Object dst, int dstPosition, int length) {
		getPApplet().arrayCopy(src, srcPosition, dst, dstPosition, length);
	}

	default/*static*/ public void arrayCopy(Object src, Object dst, int length) {
		getPApplet().arrayCopy(src, dst, length);
	}

	default/*static*/ public void arrayCopy(Object src, Object dst) {
		getPApplet().arrayCopy(src, dst);
	}

	default/*static*/ public void arraycopy(Object src, int srcPosition, Object dst, int dstPosition, int length) {
		getPApplet().arraycopy(src, srcPosition, dst, dstPosition, length);
	}

	default/*static*/ public void arraycopy(Object src, Object dst, int length) {
		getPApplet().arraycopy(src, dst, length);
	}

	default/*static*/ public void arraycopy(Object src, Object dst) {
		getPApplet().arraycopy(src, dst);
	}

	default/*static*/ public boolean[] expand(boolean list[]) {
		return getPApplet().expand(list);
	}

	default/*static*/ public boolean[] expand(boolean list[], int newSize) {
		return getPApplet().expand(list, newSize);
	}

	default/*static*/ public byte[] expand(byte list[]) {
		return getPApplet().expand(list);
	}

	default/*static*/ public byte[] expand(byte list[], int newSize) {
		return getPApplet().expand(list, newSize);
	}

	default/*static*/ public char[] expand(char list[]) {
		return getPApplet().expand(list);
	}

	default/*static*/ public char[] expand(char list[], int newSize) {
		return getPApplet().expand(list, newSize);
	}

	default/*static*/ public int[] expand(int list[]) {
		return getPApplet().expand(list);
	}

	default/*static*/ public int[] expand(int list[], int newSize) {
		return getPApplet().expand(list, newSize);
	}

	default/*static*/ public long[] expand(long list[]) {
		return getPApplet().expand(list);
	}

	default/*static*/ public long[] expand(long list[], int newSize) {
		return getPApplet().expand(list, newSize);
	}

	default/*static*/ public float[] expand(float list[]) {
		return getPApplet().expand(list);
	}

	default/*static*/ public float[] expand(float list[], int newSize) {
		return getPApplet().expand(list, newSize);
	}

	default/*static*/ public double[] expand(double list[]) {
		return getPApplet().expand(list);
	}

	default/*static*/ public double[] expand(double list[], int newSize) {
		return getPApplet().expand(list, newSize);
	}

	default/*static*/ public String[] expand(String list[]) {
		return getPApplet().expand(list);
	}

	default/*static*/ public String[] expand(String list[], int newSize) {
		return getPApplet().expand(list, newSize);
	}

	default/*static*/ public Object expand(Object array) {
		return getPApplet().expand(array);
	}

	default/*static*/ public Object expand(Object list, int newSize) {
		return getPApplet().expand(list, newSize);
	}

	default/*static*/ public byte[] append(byte array[], byte value) {
		return getPApplet().append(array, value);
	}

	default/*static*/ public char[] append(char array[], char value) {
		return getPApplet().append(array, value);
	}

	default/*static*/ public int[] append(int array[], int value) {
		return getPApplet().append(array, value);
	}

	default/*static*/ public float[] append(float array[], float value) {
		return getPApplet().append(array, value);
	}

	default/*static*/ public String[] append(String array[], String value) {
		return getPApplet().append(array, value);
	}

	default/*static*/ public Object append(Object array, Object value) {
		return getPApplet().append(array, value);
	}

	default/*static*/ public boolean[] shorten(boolean list[]) {
		return getPApplet().shorten(list);
	}

	default/*static*/ public byte[] shorten(byte list[]) {
		return getPApplet().shorten(list);
	}

	default/*static*/ public char[] shorten(char list[]) {
		return getPApplet().shorten(list);
	}

	default/*static*/ public int[] shorten(int list[]) {
		return getPApplet().shorten(list);
	}

	default/*static*/ public float[] shorten(float list[]) {
		return getPApplet().shorten(list);
	}

	default/*static*/ public String[] shorten(String list[]) {
		return getPApplet().shorten(list);
	}

	default/*static*/ public Object shorten(Object list) {
		return getPApplet().shorten(list);
	}

	default/*static*/ public boolean[] splice(boolean list[], boolean value, int index) {
		return getPApplet().splice(list, value, index);
	}

	default/*static*/ public boolean[] splice(boolean list[], boolean value[], int index) {
		return getPApplet().splice(list, value, index);
	}

	default/*static*/ public byte[] splice(byte list[], byte value, int index) {
		return getPApplet().splice(list, value, index);
	}

	default/*static*/ public byte[] splice(byte list[], byte value[], int index) {
		return getPApplet().splice(list, value, index);
	}

	default/*static*/ public char[] splice(char list[], char value, int index) {
		return getPApplet().splice(list, value, index);
	}

	default/*static*/ public char[] splice(char list[], char value[], int index) {
		return getPApplet().splice(list, value, index);
	}

	default/*static*/ public int[] splice(int list[], int value, int index) {
		return getPApplet().splice(list, value, index);
	}

	default/*static*/ public int[] splice(int list[], int value[], int index) {
		return getPApplet().splice(list, value, index);
	}

	default/*static*/ public float[] splice(float list[], float value, int index) {
		return getPApplet().splice(list, value, index);
	}

	default/*static*/ public float[] splice(float list[], float value[], int index) {
		return getPApplet().splice(list, value, index);
	}

	default/*static*/ public String[] splice(String list[], String value, int index) {
		return getPApplet().splice(list, value, index);
	}

	default/*static*/ public String[] splice(String list[], String value[], int index) {
		return getPApplet().splice(list, value, index);
	}

	default/*static*/ public Object splice(Object list, Object value, int index) {
		return getPApplet().splice(list, value, index);
	}

	default/*static*/ public boolean[] subset(boolean list[], int start) {
		return getPApplet().subset(list, start);
	}

	default/*static*/ public boolean[] subset(boolean list[], int start, int count) {
		return getPApplet().subset(list, start, count);
	}

	default/*static*/ public byte[] subset(byte list[], int start) {
		return getPApplet().subset(list, start);
	}

	default/*static*/ public byte[] subset(byte list[], int start, int count) {
		return getPApplet().subset(list, start, count);
	}

	default/*static*/ public char[] subset(char list[], int start) {
		return getPApplet().subset(list, start);
	}

	default/*static*/ public char[] subset(char list[], int start, int count) {
		return getPApplet().subset(list, start, count);
	}

	default/*static*/ public int[] subset(int list[], int start) {
		return getPApplet().subset(list, start);
	}

	default/*static*/ public int[] subset(int list[], int start, int count) {
		return getPApplet().subset(list, start, count);
	}

	default/*static*/ public float[] subset(float list[], int start) {
		return getPApplet().subset(list, start);
	}

	default/*static*/ public float[] subset(float list[], int start, int count) {
		return getPApplet().subset(list, start, count);
	}

	default/*static*/ public String[] subset(String list[], int start) {
		return getPApplet().subset(list, start);
	}

	default/*static*/ public String[] subset(String list[], int start, int count) {
		return getPApplet().subset(list, start, count);
	}

	default/*static*/ public Object subset(Object list, int start) {
		return getPApplet().subset(list, start);
	}

	default/*static*/ public Object subset(Object list, int start, int count) {
		return getPApplet().subset(list, start, count);
	}

	default/*static*/ public boolean[] concat(boolean a[], boolean b[]) {
		return getPApplet().concat(a, b);
	}

	default/*static*/ public byte[] concat(byte a[], byte b[]) {
		return getPApplet().concat(a, b);
	}

	default/*static*/ public char[] concat(char a[], char b[]) {
		return getPApplet().concat(a, b);
	}

	default/*static*/ public int[] concat(int a[], int b[]) {
		return getPApplet().concat(a, b);
	}

	default/*static*/ public float[] concat(float a[], float b[]) {
		return getPApplet().concat(a, b);
	}

	default/*static*/ public String[] concat(String a[], String b[]) {
		return getPApplet().concat(a, b);
	}

	default/*static*/ public Object concat(Object a, Object b) {
		return getPApplet().concat(a, b);
	}

	default/*static*/ public boolean[] reverse(boolean list[]) {
		return getPApplet().reverse(list);
	}

	default/*static*/ public byte[] reverse(byte list[]) {
		return getPApplet().reverse(list);
	}

	default/*static*/ public char[] reverse(char list[]) {
		return getPApplet().reverse(list);
	}

	default/*static*/ public int[] reverse(int list[]) {
		return getPApplet().reverse(list);
	}

	default/*static*/ public float[] reverse(float list[]) {
		return getPApplet().reverse(list);
	}

	default/*static*/ public String[] reverse(String list[]) {
		return getPApplet().reverse(list);
	}

	default/*static*/ public Object reverse(Object list) {
		return getPApplet().reverse(list);
	}

	default/*static*/ public String trim(String str) {
		return getPApplet().trim(str);
	}

	default/*static*/ public String[] trim(String[] array) {
		return getPApplet().trim(array);
	}

	default/*static*/ public String join(String[] list, char separator) {
		return getPApplet().join(list, separator);
	}

	default/*static*/ public String join(String[] list, String separator) {
		return getPApplet().join(list, separator);
	}

	default/*static*/ public String[] splitTokens(String value) {
		return getPApplet().splitTokens(value);
	}

	default/*static*/ public String[] splitTokens(String value, String delim) {
		return getPApplet().splitTokens(value, delim);
	}

	default/*static*/ public String[] split(String value, char delim) {
		return getPApplet().split(value, delim);
	}

	default/*static*/ public String[] split(String value, String delim) {
		return getPApplet().split(value, delim);
	}

	default/*static*/ public String[] match(String str, String regexp) {
		return getPApplet().match(str, regexp);
	}

	default/*static*/ public String[][] matchAll(String str, String regexp) {
		return getPApplet().matchAll(str, regexp);
	}

	default/*static*/ public boolean parseBoolean(int what) {
		return getPApplet().parseBoolean(what);
	}

	default/*static*/ public boolean parseBoolean(String what) {
		return getPApplet().parseBoolean(what);
	}

	default/*static*/ public boolean[] parseBoolean(int what[]) {
		return getPApplet().parseBoolean(what);
	}

	default/*static*/ public boolean[] parseBoolean(String what[]) {
		return getPApplet().parseBoolean(what);
	}

	default/*static*/ public byte parseByte(boolean what) {
		return getPApplet().parseByte(what);
	}

	default/*static*/ public byte parseByte(char what) {
		return getPApplet().parseByte(what);
	}

	default/*static*/ public byte parseByte(int what) {
		return getPApplet().parseByte(what);
	}

	default/*static*/ public byte parseByte(float what) {
		return getPApplet().parseByte(what);
	}

	default/*static*/ public byte[] parseByte(boolean what[]) {
		return getPApplet().parseByte(what);
	}

	default/*static*/ public byte[] parseByte(char what[]) {
		return getPApplet().parseByte(what);
	}

	default/*static*/ public byte[] parseByte(int what[]) {
		return getPApplet().parseByte(what);
	}

	default/*static*/ public byte[] parseByte(float what[]) {
		return getPApplet().parseByte(what);
	}

	default/*static*/ public char parseChar(byte what) {
		return getPApplet().parseChar(what);
	}

	default/*static*/ public char parseChar(int what) {
		return getPApplet().parseChar(what);
	}

	default/*static*/ public char[] parseChar(byte what[]) {
		return getPApplet().parseChar(what);
	}

	default/*static*/ public char[] parseChar(int what[]) {
		return getPApplet().parseChar(what);
	}

	default/*static*/ public int parseInt(boolean what) {
		return getPApplet().parseInt(what);
	}

	default/*static*/ public int parseInt(byte what) {
		return getPApplet().parseInt(what);
	}

	default/*static*/ public int parseInt(char what) {
		return getPApplet().parseInt(what);
	}

	default/*static*/ public int parseInt(float what) {
		return getPApplet().parseInt(what);
	}

	default/*static*/ public int parseInt(String what) {
		return getPApplet().parseInt(what);
	}

	default/*static*/ public int parseInt(String what, int otherwise) {
		return getPApplet().parseInt(what, otherwise);
	}

	default/*static*/ public int[] parseInt(boolean what[]) {
		return getPApplet().parseInt(what);
	}

	default/*static*/ public int[] parseInt(byte what[]) {
		return getPApplet().parseInt(what);
	}

	default/*static*/ public int[] parseInt(char what[]) {
		return getPApplet().parseInt(what);
	}

	default/*static*/ public int[] parseInt(float what[]) {
		return getPApplet().parseInt(what);
	}

	default/*static*/ public int[] parseInt(String what[]) {
		return getPApplet().parseInt(what);
	}

	default/*static*/ public int[] parseInt(String what[], int missing) {
		return getPApplet().parseInt(what, missing);
	}

	default/*static*/ public float parseFloat(int what) {
		return getPApplet().parseFloat(what);
	}

	default/*static*/ public float parseFloat(String what) {
		return getPApplet().parseFloat(what);
	}

	default/*static*/ public float parseFloat(String what, float otherwise) {
		return getPApplet().parseFloat(what, otherwise);
	}

	default/*static*/ public float[] parseFloat(byte what[]) {
		return getPApplet().parseFloat(what);
	}

	default/*static*/ public float[] parseFloat(int what[]) {
		return getPApplet().parseFloat(what);
	}

	default/*static*/ public float[] parseFloat(String what[]) {
		return getPApplet().parseFloat(what);
	}

	default/*static*/ public float[] parseFloat(String what[], float missing) {
		return getPApplet().parseFloat(what, missing);
	}

	default/*static*/ public String str(boolean x) {
		return getPApplet().str(x);
	}

	default/*static*/ public String str(byte x) {
		return getPApplet().str(x);
	}

	default/*static*/ public String str(char x) {
		return getPApplet().str(x);
	}

	default/*static*/ public String str(int x) {
		return getPApplet().str(x);
	}

	default/*static*/ public String str(float x) {
		return getPApplet().str(x);
	}

	default/*static*/ public String[] str(boolean x[]) {
		return getPApplet().str(x);
	}

	default/*static*/ public String[] str(byte x[]) {
		return getPApplet().str(x);
	}

	default/*static*/ public String[] str(char x[]) {
		return getPApplet().str(x);
	}

	default/*static*/ public String[] str(int x[]) {
		return getPApplet().str(x);
	}

	default/*static*/ public String[] str(float x[]) {
		return getPApplet().str(x);
	}

	default/*static*/ public String nf(float num) {
		return getPApplet().nf(num);
	}

	default/*static*/ public String[] nf(float[] num) {
		return getPApplet().nf(num);
	}

	default/*static*/ public String[] nf(int num[], int digits) {
		return getPApplet().nf(num, digits);
	}

	default/*static*/ public String nf(int num, int digits) {
		return getPApplet().nf(num, digits);
	}

	default/*static*/ public String[] nfc(int num[]) {
		return getPApplet().nfc(num);
	}

	default/*static*/ public String nfc(int num) {
		return getPApplet().nfc(num);
	}

	default/*static*/ public String nfs(int num, int digits) {
		return getPApplet().nfs(num, digits);
	}

	default/*static*/ public String[] nfs(int num[], int digits) {
		return getPApplet().nfs(num, digits);
	}

	default/*static*/ public String nfp(int num, int digits) {
		return getPApplet().nfp(num, digits);
	}

	default/*static*/ public String[] nfp(int num[], int digits) {
		return getPApplet().nfp(num, digits);
	}

	default/*static*/ public String[] nf(float num[], int left, int right) {
		return getPApplet().nf(num, left, right);
	}

	default/*static*/ public String nf(float num, int left, int right) {
		return getPApplet().nf(num, left, right);
	}

	default/*static*/ public String[] nfc(float num[], int right) {
		return getPApplet().nfc(num, right);
	}

	default/*static*/ public String nfc(float num, int right) {
		return getPApplet().nfc(num, right);
	}

	default/*static*/ public String[] nfs(float num[], int left, int right) {
		return getPApplet().nfs(num, left, right);
	}

	default/*static*/ public String nfs(float num, int left, int right) {
		return getPApplet().nfs(num, left, right);
	}

	default/*static*/ public String[] nfp(float num[], int left, int right) {
		return getPApplet().nfp(num, left, right);
	}

	default/*static*/ public String nfp(float num, int left, int right) {
		return getPApplet().nfp(num, left, right);
	}

	default/*static*/ public String hex(byte value) {
		return getPApplet().hex(value);
	}

	default/*static*/ public String hex(char value) {
		return getPApplet().hex(value);
	}

	default/*static*/ public String hex(int value) {
		return getPApplet().hex(value);
	}

	default/*static*/ public String hex(int value, int digits) {
		return getPApplet().hex(value, digits);
	}

	default/*static*/ public int unhex(String value) {
		return getPApplet().unhex(value);
	}

	default/*static*/ public String binary(byte value) {
		return getPApplet().binary(value);
	}

	default/*static*/ public String binary(char value) {
		return getPApplet().binary(value);
	}

	default/*static*/ public String binary(int value) {
		return getPApplet().binary(value);
	}

	default/*static*/ public String binary(int value, int digits) {
		return getPApplet().binary(value, digits);
	}

	default/*static*/ public int unbinary(String value) {
		return getPApplet().unbinary(value);
	}

	default public int color(int gray) {
		return getPApplet().color(gray);
	}

	default public int color(float fgray) {
		return getPApplet().color(fgray);
	}

	default public int color(int gray, int alpha) {
		return getPApplet().color(gray, alpha);
	}

	default public int color(float fgray, float falpha) {
		return getPApplet().color(fgray, falpha);
	}

	default public int color(int v1, int v2, int v3) {
		return getPApplet().color(v1, v2, v3);
	}

	default public int color(int v1, int v2, int v3, int alpha) {
		return getPApplet().color(v1, v2, v3, alpha);
	}

	default public int color(float v1, float v2, float v3) {
		return getPApplet().color(v1, v2, v3);
	}

	default public int color(float v1, float v2, float v3, float alpha) {
		return getPApplet().color(v1, v2, v3, alpha);
	}

	default public int lerpColor(int c1, int c2, float amt) {
		return getPApplet().lerpColor(c1, c2, amt);
	}

	default/*static*/ public int blendColor(int c1, int c2, int mode) {
		return getPApplet().blendColor(c1, c2, mode);
	}

	default public void frameMoved(int x, int y) {
		getPApplet().frameMoved(x, y);
	}

	default public void frameResized(int w, int h) {
		getPApplet().frameResized(w, h);
	}

	default/*static*/ public void main(String[] args) {
		getPApplet().main(args);
	}

	default/*static*/ public void main(String mainClass) {
		getPApplet().main(mainClass);
	}

	default/*static*/ public void main(String mainClass, String[] sketchArgs) {
		getPApplet().main(mainClass, sketchArgs);
	}

	default/*static*/ public void runSketch(String[] args, PApplet constructedSketch) {
		getPApplet().runSketch(args, constructedSketch);
	}

	default/*static*/ public void hideMenuBar() {
		getPApplet().hideMenuBar();
	}

	default public PGraphics beginRecord(String renderer, String filename) {
		return getPApplet().beginRecord(renderer, filename);
	}

	default public void beginRecord(PGraphics recorder) {
		getPApplet().beginRecord(recorder);
	}

	default public void endRecord() {
		getPApplet().endRecord();
	}

	default public PGraphics beginRaw(String renderer, String filename) {
		return getPApplet().beginRaw(renderer, filename);
	}

	default public void beginRaw(PGraphics rawGraphics) {
		getPApplet().beginRaw(rawGraphics);
	}

	default public void endRaw() {
		getPApplet().endRaw();
	}

	default public void loadPixels() {
		getPApplet().loadPixels();
	}

	default public void updatePixels() {
		getPApplet().updatePixels();
	}

	default public void updatePixels(int x1, int y1, int x2, int y2) {
		getPApplet().updatePixels(x1, y1, x2, y2);
	}

	default public PGL beginPGL() {
		return getPApplet().beginPGL();
	}

	default public void endPGL() {
		getPApplet().endPGL();
	}

	default public void flush() {
		getPApplet().flush();
	}

	default public void hint(int which) {
		getPApplet().hint(which);
	}

	default public void beginShape() {
		getPApplet().beginShape();
	}

	default public void beginShape(int kind) {
		getPApplet().beginShape(kind);
	}

	default public void edge(boolean edge) {
		getPApplet().edge(edge);
	}

	default public void normal(float nx, float ny, float nz) {
		getPApplet().normal(nx, ny, nz);
	}

	default public void attribPosition(String name, float x, float y, float z) {
		getPApplet().attribPosition(name, x, y, z);
	}

	default public void attribNormal(String name, float nx, float ny, float nz) {
		getPApplet().attribNormal(name, nx, ny, nz);
	}

	default public void attribColor(String name, int color) {
		getPApplet().attribColor(name, color);
	}

	default public void attrib(String name, float... values) {
		getPApplet().attrib(name, values);
	}

	default public void attrib(String name, int... values) {
		getPApplet().attrib(name, values);
	}

	default public void attrib(String name, boolean... values) {
		getPApplet().attrib(name, values);
	}

	default public void textureMode(int mode) {
		getPApplet().textureMode(mode);
	}

	default public void textureWrap(int wrap) {
		getPApplet().textureWrap(wrap);
	}

	default public void texture(PImage image) {
		getPApplet().texture(image);
	}

	default public void noTexture() {
		getPApplet().noTexture();
	}

	default public void vertex(float x, float y) {
		getPApplet().vertex(x, y);
	}

	default public void vertex(float x, float y, float z) {
		getPApplet().vertex(x, y, z);
	}

	default public void vertex(float[] v) {
		getPApplet().vertex(v);
	}

	default public void vertex(float x, float y, float u, float v) {
		getPApplet().vertex(x, y, u, v);
	}

	default public void vertex(float x, float y, float z, float u, float v) {
		getPApplet().vertex(x, y, z, u, v);
	}

	default public void beginContour() {
		getPApplet().beginContour();
	}

	default public void endContour() {
		getPApplet().endContour();
	}

	default public void endShape() {
		getPApplet().endShape();
	}

	default public void endShape(int mode) {
		getPApplet().endShape(mode);
	}

	default public PShape loadShape(String filename) {
		return getPApplet().loadShape(filename);
	}

	default public PShape loadShape(String filename, String options) {
		return getPApplet().loadShape(filename, options);
	}

	default public PShape createShape() {
		return getPApplet().createShape();
	}

	default public PShape createShape(int type) {
		return getPApplet().createShape(type);
	}

	default public PShape createShape(int kind, float... p) {
		return getPApplet().createShape(kind, p);
	}

	default public PShader loadShader(String fragFilename) {
		return getPApplet().loadShader(fragFilename);
	}

	default public PShader loadShader(String fragFilename, String vertFilename) {
		return getPApplet().loadShader(fragFilename, vertFilename);
	}

	default public void shader(PShader shader) {
		getPApplet().shader(shader);
	}

	default public void shader(PShader shader, int kind) {
		getPApplet().shader(shader, kind);
	}

	default public void resetShader() {
		getPApplet().resetShader();
	}

	default public void resetShader(int kind) {
		getPApplet().resetShader(kind);
	}

	default public void filter(PShader shader) {
		getPApplet().filter(shader);
	}

	default public void clip(float a, float b, float c, float d) {
		getPApplet().clip(a, b, c, d);
	}

	default public void noClip() {
		getPApplet().noClip();
	}

	default public void blendMode(int mode) {
		getPApplet().blendMode(mode);
	}

	default public void bezierVertex(float x2, float y2, float x3, float y3, float x4, float y4) {
		getPApplet().bezierVertex(x2, y2, x3, y3, x4, y4);
	}

	default public void bezierVertex(float x2, float y2, float z2, float x3, float y3, float z3, float x4, float y4, float z4) {
		getPApplet().bezierVertex(x2, y2, z2, x3, y3, z3, x4, y4, z4);
	}

	default public void quadraticVertex(float cx, float cy, float x3, float y3) {
		getPApplet().quadraticVertex(cx, cy, x3, y3);
	}

	default public void quadraticVertex(float cx, float cy, float cz, float x3, float y3, float z3) {
		getPApplet().quadraticVertex(cx, cy, cz, x3, y3, z3);
	}

	default public void curveVertex(float x, float y) {
		getPApplet().curveVertex(x, y);
	}

	default public void curveVertex(float x, float y, float z) {
		getPApplet().curveVertex(x, y, z);
	}

	default public void point(float x, float y) {
		getPApplet().point(x, y);
	}

	default public void point(float x, float y, float z) {
		getPApplet().point(x, y, z);
	}

	default public void line(float x1, float y1, float x2, float y2) {
		getPApplet().line(x1, y1, x2, y2);
	}

	default public void line(float x1, float y1, float z1, float x2, float y2, float z2) {
		getPApplet().line(x1, y1, z1, x2, y2, z2);
	}

	default public void triangle(float x1, float y1, float x2, float y2, float x3, float y3) {
		getPApplet().triangle(x1, y1, x2, y2, x3, y3);
	}

	default public void quad(float x1, float y1, float x2, float y2, float x3, float y3, float x4, float y4) {
		getPApplet().quad(x1, y1, x2, y2, x3, y3, x4, y4);
	}

	default public void rectMode(int mode) {
		getPApplet().rectMode(mode);
	}

	default public void rect(float a, float b, float c, float d) {
		getPApplet().rect(a, b, c, d);
	}

	default public void rect(float a, float b, float c, float d, float r) {
		getPApplet().rect(a, b, c, d, r);
	}

	default public void rect(float a, float b, float c, float d, float tl, float tr, float br, float bl) {
		getPApplet().rect(a, b, c, d, tl, tr, br, bl);
	}

	default public void ellipseMode(int mode) {
		getPApplet().ellipseMode(mode);
	}

	default public void ellipse(float a, float b, float c, float d) {
		getPApplet().ellipse(a, b, c, d);
	}

	default public void arc(float a, float b, float c, float d, float start, float stop) {
		getPApplet().arc(a, b, c, d, start, stop);
	}

	default public void arc(float a, float b, float c, float d, float start, float stop, int mode) {
		getPApplet().arc(a, b, c, d, start, stop, mode);
	}

	default public void box(float size) {
		getPApplet().box(size);
	}

	default public void box(float w, float h, float d) {
		getPApplet().box(w, h, d);
	}

	default public void sphereDetail(int res) {
		getPApplet().sphereDetail(res);
	}

	default public void sphereDetail(int ures, int vres) {
		getPApplet().sphereDetail(ures, vres);
	}

	default public void sphere(float r) {
		getPApplet().sphere(r);
	}

	default public float bezierPoint(float a, float b, float c, float d, float t) {
		return getPApplet().bezierPoint(a, b, c, d, t);
	}

	default public float bezierTangent(float a, float b, float c, float d, float t) {
		return getPApplet().bezierTangent(a, b, c, d, t);
	}

	default public void bezierDetail(int detail) {
		getPApplet().bezierDetail(detail);
	}

	default public void bezier(float x1, float y1, float x2, float y2, float x3, float y3, float x4, float y4) {
		getPApplet().bezier(x1, y1, x2, y2, x3, y3, x4, y4);
	}

	default public void bezier(float x1, float y1, float z1, float x2, float y2, float z2, float x3, float y3, float z3, float x4, float y4, float z4) {
		getPApplet().bezier(x1, y1, z1, x2, y2, z2, x3, y3, z3, x4, y4, z4);
	}

	default public float curvePoint(float a, float b, float c, float d, float t) {
		return getPApplet().curvePoint(a, b, c, d, t);
	}

	default public float curveTangent(float a, float b, float c, float d, float t) {
		return getPApplet().curveTangent(a, b, c, d, t);
	}

	default public void curveDetail(int detail) {
		getPApplet().curveDetail(detail);
	}

	default public void curveTightness(float tightness) {
		getPApplet().curveTightness(tightness);
	}

	default public void curve(float x1, float y1, float x2, float y2, float x3, float y3, float x4, float y4) {
		getPApplet().curve(x1, y1, x2, y2, x3, y3, x4, y4);
	}

	default public void curve(float x1, float y1, float z1, float x2, float y2, float z2, float x3, float y3, float z3, float x4, float y4, float z4) {
		getPApplet().curve(x1, y1, z1, x2, y2, z2, x3, y3, z3, x4, y4, z4);
	}

	default public void imageMode(int mode) {
		getPApplet().imageMode(mode);
	}

	default public void image(PImage img, float a, float b) {
		getPApplet().image(img, a, b);
	}

	default public void image(PImage img, float a, float b, float c, float d) {
		getPApplet().image(img, a, b, c, d);
	}

	default public void image(PImage img, float a, float b, float c, float d, int u1, int v1, int u2, int v2) {
		getPApplet().image(img, a, b, c, d, u1, v1, u2, v2);
	}

	default public void shapeMode(int mode) {
		getPApplet().shapeMode(mode);
	}

	default public void shape(PShape shape) {
		getPApplet().shape(shape);
	}

	default public void shape(PShape shape, float x, float y) {
		getPApplet().shape(shape, x, y);
	}

	default public void shape(PShape shape, float a, float b, float c, float d) {
		getPApplet().shape(shape, a, b, c, d);
	}

	default public void textAlign(int alignX) {
		getPApplet().textAlign(alignX);
	}

	default public void textAlign(int alignX, int alignY) {
		getPApplet().textAlign(alignX, alignY);
	}

	default public float textAscent() {
		return getPApplet().textAscent();
	}

	default public float textDescent() {
		return getPApplet().textDescent();
	}

	default public void textFont(PFont which) {
		getPApplet().textFont(which);
	}

	default public void textFont(PFont which, float size) {
		getPApplet().textFont(which, size);
	}

	default public void textLeading(float leading) {
		getPApplet().textLeading(leading);
	}

	default public void textMode(int mode) {
		getPApplet().textMode(mode);
	}

	default public void textSize(float size) {
		getPApplet().textSize(size);
	}

	default public float textWidth(char c) {
		return getPApplet().textWidth(c);
	}

	default public float textWidth(String str) {
		return getPApplet().textWidth(str);
	}

	default public float textWidth(char[] chars, int start, int length) {
		return getPApplet().textWidth(chars, start, length);
	}

	default public void text(char c, float x, float y) {
		getPApplet().text(c, x, y);
	}

	default public void text(char c, float x, float y, float z) {
		getPApplet().text(c, x, y, z);
	}

	default public void text(String str, float x, float y) {
		getPApplet().text(str, x, y);
	}

	default public void text(char[] chars, int start, int stop, float x, float y) {
		getPApplet().text(chars, start, stop, x, y);
	}

	default public void text(String str, float x, float y, float z) {
		getPApplet().text(str, x, y, z);
	}

	default public void text(char[] chars, int start, int stop, float x, float y, float z) {
		getPApplet().text(chars, start, stop, x, y, z);
	}

	default public void text(String str, float x1, float y1, float x2, float y2) {
		getPApplet().text(str, x1, y1, x2, y2);
	}

	default public void text(int num, float x, float y) {
		getPApplet().text(num, x, y);
	}

	default public void text(int num, float x, float y, float z) {
		getPApplet().text(num, x, y, z);
	}

	default public void text(float num, float x, float y) {
		getPApplet().text(num, x, y);
	}

	default public void text(float num, float x, float y, float z) {
		getPApplet().text(num, x, y, z);
	}

	default public void pushMatrix() {
		getPApplet().pushMatrix();
	}

	default public void popMatrix() {
		getPApplet().popMatrix();
	}

	default public void translate(float x, float y) {
		getPApplet().translate(x, y);
	}

	default public void translate(float x, float y, float z) {
		getPApplet().translate(x, y, z);
	}

	default public void rotate(float angle) {
		getPApplet().rotate(angle);
	}

	default public void rotateX(float angle) {
		getPApplet().rotateX(angle);
	}

	default public void rotateY(float angle) {
		getPApplet().rotateY(angle);
	}

	default public void rotateZ(float angle) {
		getPApplet().rotateZ(angle);
	}

	default public void rotate(float angle, float x, float y, float z) {
		getPApplet().rotate(angle, x, y, z);
	}

	default public void scale(float s) {
		getPApplet().scale(s);
	}

	default public void scale(float x, float y) {
		getPApplet().scale(x, y);
	}

	default public void scale(float x, float y, float z) {
		getPApplet().scale(x, y, z);
	}

	default public void shearX(float angle) {
		getPApplet().shearX(angle);
	}

	default public void shearY(float angle) {
		getPApplet().shearY(angle);
	}

	default public void resetMatrix() {
		getPApplet().resetMatrix();
	}

	default public void applyMatrix(PMatrix source) {
		getPApplet().applyMatrix(source);
	}

	default public void applyMatrix(PMatrix2D source) {
		getPApplet().applyMatrix(source);
	}

	default public void applyMatrix(float n00, float n01, float n02, float n10, float n11, float n12) {
		getPApplet().applyMatrix(n00, n01, n02, n10, n11, n12);
	}

	default public void applyMatrix(PMatrix3D source) {
		getPApplet().applyMatrix(source);
	}

	default public void applyMatrix(float n00, float n01, float n02, float n03, float n10, float n11, float n12, float n13, float n20, float n21, float n22, float n23, float n30, float n31, float n32, float n33) {
		getPApplet().applyMatrix(	n00, n01, n02, n03, n10, n11, n12, n13, n20, n21, n22, n23, n30,
									n31, n32, n33);
	}

	default public PMatrix getMatrix() {
		return getPApplet().getMatrix();
	}

	default public PMatrix2D getMatrix(PMatrix2D target) {
		return getPApplet().getMatrix(target);
	}

	default public PMatrix3D getMatrix(PMatrix3D target) {
		return getPApplet().getMatrix(target);
	}

	default public void setMatrix(PMatrix source) {
		getPApplet().setMatrix(source);
	}

	default public void setMatrix(PMatrix2D source) {
		getPApplet().setMatrix(source);
	}

	default public void setMatrix(PMatrix3D source) {
		getPApplet().setMatrix(source);
	}

	default public void printMatrix() {
		getPApplet().printMatrix();
	}

	default public void beginCamera() {
		getPApplet().beginCamera();
	}

	default public void endCamera() {
		getPApplet().endCamera();
	}

	default public void camera() {
		getPApplet().camera();
	}

	default public void camera(float eyeX, float eyeY, float eyeZ, float centerX, float centerY, float centerZ, float upX, float upY, float upZ) {
		getPApplet().camera(eyeX, eyeY, eyeZ, centerX, centerY, centerZ, upX, upY, upZ);
	}

	default public void printCamera() {
		getPApplet().printCamera();
	}

	default public void ortho() {
		getPApplet().ortho();
	}

	default public void ortho(float left, float right, float bottom, float top) {
		getPApplet().ortho(left, right, bottom, top);
	}

	default public void ortho(float left, float right, float bottom, float top, float near, float far) {
		getPApplet().ortho(left, right, bottom, top, near, far);
	}

	default public void perspective() {
		getPApplet().perspective();
	}

	default public void perspective(float fovy, float aspect, float zNear, float zFar) {
		getPApplet().perspective(fovy, aspect, zNear, zFar);
	}

	default public void frustum(float left, float right, float bottom, float top, float near, float far) {
		getPApplet().frustum(left, right, bottom, top, near, far);
	}

	default public void printProjection() {
		getPApplet().printProjection();
	}

	default public float screenX(float x, float y) {
		return getPApplet().screenX(x, y);
	}

	default public float screenY(float x, float y) {
		return getPApplet().screenY(x, y);
	}

	default public float screenX(float x, float y, float z) {
		return getPApplet().screenX(x, y, z);
	}

	default public float screenY(float x, float y, float z) {
		return getPApplet().screenY(x, y, z);
	}

	default public float screenZ(float x, float y, float z) {
		return getPApplet().screenZ(x, y, z);
	}

	default public float modelX(float x, float y, float z) {
		return getPApplet().modelX(x, y, z);
	}

	default public float modelY(float x, float y, float z) {
		return getPApplet().modelY(x, y, z);
	}

	default public float modelZ(float x, float y, float z) {
		return getPApplet().modelZ(x, y, z);
	}

	default public void pushStyle() {
		getPApplet().pushStyle();
	}

	default public void popStyle() {
		getPApplet().popStyle();
	}

	default public void style(PStyle s) {
		getPApplet().style(s);
	}

	default public void strokeWeight(float weight) {
		getPApplet().strokeWeight(weight);
	}

	default public void strokeJoin(int join) {
		getPApplet().strokeJoin(join);
	}

	default public void strokeCap(int cap) {
		getPApplet().strokeCap(cap);
	}

	default public void noStroke() {
		getPApplet().noStroke();
	}

	default public void stroke(int rgb) {
		getPApplet().stroke(rgb);
	}

	default public void stroke(int rgb, float alpha) {
		getPApplet().stroke(rgb, alpha);
	}

	default public void stroke(float gray) {
		getPApplet().stroke(gray);
	}

	default public void stroke(float gray, float alpha) {
		getPApplet().stroke(gray, alpha);
	}

	default public void stroke(float v1, float v2, float v3) {
		getPApplet().stroke(v1, v2, v3);
	}

	default public void stroke(float v1, float v2, float v3, float alpha) {
		getPApplet().stroke(v1, v2, v3, alpha);
	}

	default public void noTint() {
		getPApplet().noTint();
	}

	default public void tint(int rgb) {
		getPApplet().tint(rgb);
	}

	default public void tint(int rgb, float alpha) {
		getPApplet().tint(rgb, alpha);
	}

	default public void tint(float gray) {
		getPApplet().tint(gray);
	}

	default public void tint(float gray, float alpha) {
		getPApplet().tint(gray, alpha);
	}

	default public void tint(float v1, float v2, float v3) {
		getPApplet().tint(v1, v2, v3);
	}

	default public void tint(float v1, float v2, float v3, float alpha) {
		getPApplet().tint(v1, v2, v3, alpha);
	}

	default public void noFill() {
		getPApplet().noFill();
	}

	default public void fill(int rgb) {
		getPApplet().fill(rgb);
	}

	default public void fill(int rgb, float alpha) {
		getPApplet().fill(rgb, alpha);
	}

	default public void fill(float gray) {
		getPApplet().fill(gray);
	}

	default public void fill(float gray, float alpha) {
		getPApplet().fill(gray, alpha);
	}

	default public void fill(float v1, float v2, float v3) {
		getPApplet().fill(v1, v2, v3);
	}

	default public void fill(float v1, float v2, float v3, float alpha) {
		getPApplet().fill(v1, v2, v3, alpha);
	}

	default public void ambient(int rgb) {
		getPApplet().ambient(rgb);
	}

	default public void ambient(float gray) {
		getPApplet().ambient(gray);
	}

	default public void ambient(float v1, float v2, float v3) {
		getPApplet().ambient(v1, v2, v3);
	}

	default public void specular(int rgb) {
		getPApplet().specular(rgb);
	}

	default public void specular(float gray) {
		getPApplet().specular(gray);
	}

	default public void specular(float v1, float v2, float v3) {
		getPApplet().specular(v1, v2, v3);
	}

	default public void shininess(float shine) {
		getPApplet().shininess(shine);
	}

	default public void emissive(int rgb) {
		getPApplet().emissive(rgb);
	}

	default public void emissive(float gray) {
		getPApplet().emissive(gray);
	}

	default public void emissive(float v1, float v2, float v3) {
		getPApplet().emissive(v1, v2, v3);
	}

	default public void lights() {
		getPApplet().lights();
	}

	default public void noLights() {
		getPApplet().noLights();
	}

	default public void ambientLight(float v1, float v2, float v3) {
		getPApplet().ambientLight(v1, v2, v3);
	}

	default public void ambientLight(float v1, float v2, float v3, float x, float y, float z) {
		getPApplet().ambientLight(v1, v2, v3, x, y, z);
	}

	default public void directionalLight(float v1, float v2, float v3, float nx, float ny, float nz) {
		getPApplet().directionalLight(v1, v2, v3, nx, ny, nz);
	}

	default public void pointLight(float v1, float v2, float v3, float x, float y, float z) {
		getPApplet().pointLight(v1, v2, v3, x, y, z);
	}

	default public void spotLight(float v1, float v2, float v3, float x, float y, float z, float nx, float ny, float nz, float angle, float concentration) {
		getPApplet().spotLight(v1, v2, v3, x, y, z, nx, ny, nz, angle, concentration);
	}

	default public void lightFalloff(float constant, float linear, float quadratic) {
		getPApplet().lightFalloff(constant, linear, quadratic);
	}

	default public void lightSpecular(float v1, float v2, float v3) {
		getPApplet().lightSpecular(v1, v2, v3);
	}

	default public void background(int rgb) {
		getPApplet().background(rgb);
	}

	default public void background(int rgb, float alpha) {
		getPApplet().background(rgb, alpha);
	}

	default public void background(float gray) {
		getPApplet().background(gray);
	}

	default public void background(float gray, float alpha) {
		getPApplet().background(gray, alpha);
	}

	default public void background(float v1, float v2, float v3) {
		getPApplet().background(v1, v2, v3);
	}

	default public void background(float v1, float v2, float v3, float alpha) {
		getPApplet().background(v1, v2, v3, alpha);
	}

	default public void clear() {
		getPApplet().clear();
	}

	default public void background(PImage image) {
		getPApplet().background(image);
	}

	default public void colorMode(int mode) {
		getPApplet().colorMode(mode);
	}

	default public void colorMode(int mode, float max) {
		getPApplet().colorMode(mode, max);
	}

	default public void colorMode(int mode, float max1, float max2, float max3) {
		getPApplet().colorMode(mode, max1, max2, max3);
	}

	default public void colorMode(int mode, float max1, float max2, float max3, float maxA) {
		getPApplet().colorMode(mode, max1, max2, max3, maxA);
	}

	default public float alpha(int rgb) {
		return getPApplet().alpha(rgb);
	}

	default public float red(int rgb) {
		return getPApplet().red(rgb);
	}

	default public float green(int rgb) {
		return getPApplet().green(rgb);
	}

	default public float blue(int rgb) {
		return getPApplet().blue(rgb);
	}

	default public float hue(int rgb) {
		return getPApplet().hue(rgb);
	}

	default public float saturation(int rgb) {
		return getPApplet().saturation(rgb);
	}

	default public float brightness(int rgb) {
		return getPApplet().brightness(rgb);
	}

	default/*static*/ public int lerpColor(int c1, int c2, float amt, int mode) {
		return getPApplet().lerpColor(c1, c2, amt, mode);
	}

	default/*static*/ public void showDepthWarning(String method) {
		getPApplet().showDepthWarning(method);
	}

	default/*static*/ public void showDepthWarningXYZ(String method) {
		getPApplet().showDepthWarningXYZ(method);
	}

	default/*static*/ public void showMethodWarning(String method) {
		getPApplet().showMethodWarning(method);
	}

	default/*static*/ public void showVariationWarning(String str) {
		getPApplet().showVariationWarning(str);
	}

	default/*static*/ public void showMissingWarning(String method) {
		getPApplet().showMissingWarning(method);
	}

	default public int get(int x, int y) {
		return getPApplet().get(x, y);
	}

	default public PImage get(int x, int y, int w, int h) {
		return getPApplet().get(x, y, w, h);
	}

	default public PImage get() {
		return getPApplet().get();
	}

	default public PImage copy() {
		return getPApplet().copy();
	}

	default public void set(int x, int y, int c) {
		getPApplet().set(x, y, c);
	}

	default public void set(int x, int y, PImage img) {
		getPApplet().set(x, y, img);
	}

	default public void mask(PImage img) {
		getPApplet().mask(img);
	}

	default public void filter(int kind) {
		getPApplet().filter(kind);
	}

	default public void filter(int kind, float param) {
		getPApplet().filter(kind, param);
	}

	default public void copy(int sx, int sy, int sw, int sh, int dx, int dy, int dw, int dh) {
		getPApplet().copy(sx, sy, sw, sh, dx, dy, dw, dh);
	}

	default public void copy(PImage src, int sx, int sy, int sw, int sh, int dx, int dy, int dw, int dh) {
		getPApplet().copy(src, sx, sy, sw, sh, dx, dy, dw, dh);
	}

	default public void blend(int sx, int sy, int sw, int sh, int dx, int dy, int dw, int dh, int mode) {
		getPApplet().blend(sx, sy, sw, sh, dx, dy, dw, dh, mode);
	}

	default public void blend(PImage src, int sx, int sy, int sw, int sh, int dx, int dy, int dw, int dh, int mode) {
		getPApplet().blend(src, sx, sy, sw, sh, dx, dy, dw, dh, mode);
	}

}
