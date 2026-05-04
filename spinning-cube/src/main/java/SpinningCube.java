import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.math.Vector3;

/**
 * A spinning 3D cube rendered with libGDX.
 * No raw OpenGL calls - libGDX handles all the low-level rendering.
 */
public class SpinningCube extends ApplicationAdapter {

    private PerspectiveCamera camera;
    private ModelBatch modelBatch;
    private ModelInstance cubeInstance;
    private Environment environment;

    @Override
    public void create() {
        // Set up the camera
        camera = new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.position.set(3f, 3f, 3f);
        camera.lookAt(0, 0, 0);
        camera.near = 0.1f;
        camera.far = 100f;
        camera.update();

        // Set up the model batch for rendering
        modelBatch = new ModelBatch();

        // Set up lighting environment
        environment = new Environment();
        environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1f));
        environment.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, -1f, -0.8f, -0.2f));

        // Build a cube model with per-face colors using libGDX's ModelBuilder
        ModelBuilder modelBuilder = new ModelBuilder();
        modelBuilder.begin();

        // Each face is a separate box part with its own color
        // rect() takes 15 floats: 4 corners (x,y,z each) + 1 normal (x,y,z)
        // Front face (red) - normal (0,0,1)
        modelBuilder.part("front", GL20.GL_TRIANGLES,
                Usage.Position | Usage.Normal,
                new Material(ColorAttribute.createDiffuse(Color.RED)))
            .rect(
                -0.5f, -0.5f,  0.5f,  // bottom-left
                 0.5f, -0.5f,  0.5f,  // bottom-right
                 0.5f,  0.5f,  0.5f,  // top-right
                -0.5f,  0.5f,  0.5f,  // top-left
                 0, 0, 1               // normal
            );

        // Back face (green) - normal (0,0,-1)
        modelBuilder.part("back", GL20.GL_TRIANGLES,
                Usage.Position | Usage.Normal,
                new Material(ColorAttribute.createDiffuse(Color.GREEN)))
            .rect(
                 0.5f, -0.5f, -0.5f,
                -0.5f, -0.5f, -0.5f,
                -0.5f,  0.5f, -0.5f,
                 0.5f,  0.5f, -0.5f,
                 0, 0, -1
            );

        // Top face (blue) - normal (0,1,0)
        modelBuilder.part("top", GL20.GL_TRIANGLES,
                Usage.Position | Usage.Normal,
                new Material(ColorAttribute.createDiffuse(Color.BLUE)))
            .rect(
                -0.5f,  0.5f,  0.5f,
                 0.5f,  0.5f,  0.5f,
                 0.5f,  0.5f, -0.5f,
                -0.5f,  0.5f, -0.5f,
                 0, 1, 0
            );

        // Bottom face (yellow) - normal (0,-1,0)
        modelBuilder.part("bottom", GL20.GL_TRIANGLES,
                Usage.Position | Usage.Normal,
                new Material(ColorAttribute.createDiffuse(Color.YELLOW)))
            .rect(
                -0.5f, -0.5f, -0.5f,
                 0.5f, -0.5f, -0.5f,
                 0.5f, -0.5f,  0.5f,
                -0.5f, -0.5f,  0.5f,
                 0, -1, 0
            );

        // Right face (cyan) - normal (1,0,0)
        modelBuilder.part("right", GL20.GL_TRIANGLES,
                Usage.Position | Usage.Normal,
                new Material(ColorAttribute.createDiffuse(Color.CYAN)))
            .rect(
                 0.5f, -0.5f,  0.5f,
                 0.5f, -0.5f, -0.5f,
                 0.5f,  0.5f, -0.5f,
                 0.5f,  0.5f,  0.5f,
                 1, 0, 0
            );

        // Left face (magenta) - normal (-1,0,0)
        modelBuilder.part("left", GL20.GL_TRIANGLES,
                Usage.Position | Usage.Normal,
                new Material(ColorAttribute.createDiffuse(Color.MAGENTA)))
            .rect(
                -0.5f, -0.5f, -0.5f,
                -0.5f, -0.5f,  0.5f,
                -0.5f,  0.5f,  0.5f,
                -0.5f,  0.5f, -0.5f,
                -1, 0, 0
            );

        Model cubeModel = modelBuilder.end();
        cubeInstance = new ModelInstance(cubeModel);
    }

    @Override
    public void render() {
        // Clear the screen
        Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        // Rotate the cube
        cubeInstance.transform.rotate(Vector3.Y, 0.5f);
        cubeInstance.transform.rotate(Vector3.X, 0.25f);

        // Render the cube
        modelBatch.begin(camera);
        modelBatch.render(cubeInstance, environment);
        modelBatch.end();
    }

    @Override
    public void dispose() {
        modelBatch.dispose();
        cubeInstance.model.dispose();
    }

    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setTitle("Spinning Cube - libGDX");
        config.setWindowedMode(800, 600);
        config.setForegroundFPS(60);
        config.useVsync(true);
        new Lwjgl3Application(new SpinningCube(), config);
    }
}
