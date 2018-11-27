package sample_2;

public class IhaveaCallback implements ChangeSize {

	@Override
	public void SetHeight(int h) {
		System.out.println("...ta-Da!  SetHeight called back! " + h);
	}

	@Override
	public void SetWidth(int w) {
		System.out.println("...ta-Da!  SetWidth called back! " + w);
	}

}
