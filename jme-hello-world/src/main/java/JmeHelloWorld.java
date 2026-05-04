import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;
import com.jme3.system.AppSettings;

/**
 * A jMonkeyEngine hello world application with a multi-colored spinning cube.
 * Each face of the cube has a different color, built using 6 separate box faces.
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
        // Create a cube with per-face vertex colors
        Node cube = createColoredCube();

        // Attach the cube to the root node
        rootNode.attachChild(cube);

        // Position the camera to look at the cube
        cam.setLocation(new Vector3f(3, 3, 3));
        cam.lookAt(Vector3f.ZERO, Vector3f.UNIT_Y);

        // Disable the default fly cam so the cube stays in view
        flyCam.setEnabled(false);
    }

    /**
     * Creates a cube where each face has a distinct color.
     * Uses 6 thin box geometries positioned at each face of the cube,
     * each with its own colored material.
     */
    private Node createColoredCube() {
        Node cubeNode = new Node("Cube");

        float halfSize = 1f;
        float thickness = 0.001f; // very thin to avoid z-fighting

        // Each face: a thin box positioned at the face surface
        // Face data: {axis, sign, color}
        addFace(cubeNode, halfSize, thickness, 0, 1, ColorRGBA.Red);       // Right  (+X)
        addFace(cubeNode, halfSize, thickness, 0, -1, ColorRGBA.Orange);   // Left   (-X)
        addFace(cubeNode, halfSize, thickness, 1, 1, ColorRGBA.Green);     // Top    (+Y)
        addFace(cubeNode, halfSize, thickness, 1, -1, ColorRGBA.Yellow);   // Bottom (-Y)
        addFace(cubeNode, halfSize, thickness, 2, 1, ColorRGBA.Blue);      // Front  (+Z)
        addFace(cubeNode, halfSize, thickness, 2, -1, ColorRGBA.Magenta);  // Back   (-Z)

        return cubeNode;
    }

    /**
     * Adds a colored face to the cube node.
     *
     * @param axis      0=X, 1=Y, 2=Z
     * @param sign      +1 or -1 for direction along the axis
     */
    private void addFace(Node parent, float halfSize, float thickness, int axis, int sign, ColorRGBA color) {
        // Dimensions of the face box
        float sx = (axis == 0) ? thickness : halfSize * 2;
        float sy = (axis == 1) ? thickness : halfSize * 2;
        float sz = (axis == 2) ? thickness : halfSize * 2;

        // Position offset along the axis
        float px = (axis == 0) ? sign * halfSize : 0;
        float py = (axis == 1) ? sign * halfSize : 0;
        float pz = (axis == 2) ? sign * halfSize : 0;

        Box box = new Box(sx / 2, sy / 2, sz / 2);
        Geometry geom = new Geometry("Face", box);
        geom.setLocalTranslation(px, py, pz);

        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", color);
        geom.setMaterial(mat);

        parent.attachChild(geom);
    }

    @Override
    public void simpleUpdate(float tpf) {
        // Rotate the cube over time
        rootNode.getChild("Cube").rotate(0.0f`, tpf, 0.0f);
    }
}
