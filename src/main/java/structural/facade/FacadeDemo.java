package structural.facade;

import java.util.ArrayList;
import java.util.List;

// Provides a simple, easy to understand user interface over a large and sophisticated body of code
/*  1. build a facade to provide a simplified API over a set of classes
    2. May wish to (optionally) expose internals through the facade
    3. May allow users to 'escalate' to use more complex API's if they need to
* */
class Buffer {
    private char[] characters;
    private int lineWidth;

    public Buffer(int lineHeight, int lineWidth) {
        this.lineWidth = lineWidth;
        characters = new char[lineHeight * lineWidth];
    }

    public char charAt(int x, int y) {
        return characters[y*lineWidth + x];
    }
}

class ViewPort {
    private final Buffer buffer;
    private final int x;
    private final int y;
    private final int offsetX;
    private final int offsetY;

    public ViewPort(Buffer buffer, int x, int y, int offsetX, int offsetY) {
        this.buffer = buffer;
        this.x = x;
        this.y = y;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
    }

    public char charAt(int x, int y) {
        return this.buffer.charAt(x + offsetX, y+ offsetY);
    }
}

class Console {
    private List<ViewPort> viewports = new ArrayList<>();
    public int width, height;

    public Console(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void addViewPort(ViewPort viewport) {
        this.viewports.add(viewport);
    }

    public void render() {
        for (int y = 0; y < height; ++y) {
            for (int x = 0; x < width; ++x) {
                for (ViewPort vp : viewports) {
                    System.out.print(vp.charAt(x, y));
                }
            }
            System.out.println();
        }
    }

    // 2.
    public static Console newConsole(int width, int height) {
        Buffer buffer = new Buffer(width, height);
        ViewPort viewPort = new ViewPort(buffer, width, height, 0,0);
        Console console = new Console(width, height);
        console.addViewPort(viewPort);
        return console;
    }
}

public class FacadeDemo {

    public static void main(String[] args) {
        // 1. without facade layer, client would have to create everything themselves
        Buffer buffer = new Buffer(30, 20);
        ViewPort viewport = new ViewPort(buffer, 30 ,20, 0, 0);
        Console console = new Console(30, 20);
        console.addViewPort(viewport);
        console.render();

        // 2. with this FACADE LAYER now, a factory method for Console, User/client gets everything already built in
        // and need not worry about the basic build up as 1. above
        Console console2 = Console.newConsole(30, 20);
        console2.render();
    }
}
