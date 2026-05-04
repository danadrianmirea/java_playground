import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import com.jme3.system.AppSettings;

/**
 * A simple jMonkeyEngine hello world application.
 * Displays a spinning cube with a blue color on a dark background.
 */
public class JmeHelloWorld extends SimpleApplication {

    public static void main(String[] args) {
        JmeHelloWorld app = new JmeHelloWorld();

        // Configure display settings
        AppSettings settings = new AppSettings(true);
        settings.setTitle("Hello World - jMonkeyEngine");
        settings.setWidth(800);
        settings.setHeight(600);
        settings.setFrameRate(60);
        settings.setVSync(true);
        app.setSettings(settings);

        app.start();
    }

    @Override
    public void simpleInitApp() {
        // Create a blue cube
        Box box = new Box(1, 1, 1);
        Geometry cube = new Geometry("Cube", box);

        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", ColorRGBA.Blue);
        cube.setMaterial(mat);

        // Attach the cube to the root node
        rootNode.attachChild(cube);

        // Position the camera to look at the cube
        cam.setLocation(new Vector3f(3, 3, 3));
        cam.lookAt(Vector3f.ZERO, Vector3f.UNIT_Y);

        // Disable the default fly cam so the cube stays in view
        flyCam.setEnabled(false);
    }

    @Override
    public void simpleUpdate(float tpf) {
        // Rotate the cube over time
        rootNode.getChild("Cube").rotate(0, tpf, 0);
    }
}
