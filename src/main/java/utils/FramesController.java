package utils;

public class FramesController extends Browser{
    public FramesController() {
        super();
    }

    public void getSwitchTo(String name) {
        super.controlFrames(name);
    }

    public void getDefaultFrame() {
        super.setDefaultFrame();
    }

    public void getIndexFrame(int index) {
        super.setIndexFrame(index);
    }
}
