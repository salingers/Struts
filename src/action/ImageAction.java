package action;

import java.io.*;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageAction extends ActionSupport
{

	private static final long serialVersionUID = 1L;
	private ByteArrayInputStream inputStream;

	// ���ͥ|��0~9���H���ơA��b�@�Ӧr���
	public String createRandomString()
	{
		String str = "";
		for (int i = 0; i < 4; i++)
		{
			str += Integer.toString((new Double(Math.random() * 10)).intValue());
		}
		return str;
	}

	// �H�����ͤ@�ӱm��
	public Color createsRandomColor()
	{
		int r = (new Double(Math.random() * 256)).intValue();
		int g = (new Double(Math.random() * 256)).intValue();
		int b = (new Double(Math.random() * 256)).intValue();
		return new Color(r, g, b);
	}

	// ���ͤ@�ӰO����Ϥ��A�N�|���H���Ƽg�b�Ϥ��W
	public BufferedImage createImage(String str)
	{
		int width = 60;
		int height = 22;
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		// ���o�ϧΤW�U��
		Graphics g = image.getGraphics();
		// �]�w�I����
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);
		// �e���
		g.setColor(Color.black);
		g.drawRect(0, 0, width - 1, height - 1);
		// �N�{�ҽX��ܨ�϶H��
		g.setFont(new Font("Atlantic Inline", Font.PLAIN, 18));
		// �ϥ��H���m��
		g.setColor(this.createsRandomColor());
		// �N�H���r�ꪺ�C�ӼƦr���O�g��Ϥ��W
		g.drawString(Character.toString(str.charAt(0)), 8, 17);
		g.drawString(Character.toString(str.charAt(1)), 20, 17);
		g.drawString(Character.toString(str.charAt(2)), 33, 17);
		g.drawString(Character.toString(str.charAt(3)), 45, 17);
		// �϶H�ͮ�
		g.dispose();
		return image;
	}

	// �N�Ϥ����H�줸�էΦ��g��InputStream��
	public ByteArrayInputStream createInputStream() throws Exception
	{
		// ���o�H���r��
		String str = this.createRandomString();
		BufferedImage image = this.createImage(str);
		// �N���ͪ��r��g�Jsession�A�����Үɨϥ�

		ActionContext actionContext = ActionContext.getContext();

		Map session = actionContext.getSession();

		session.put("random", str);

		ByteArrayOutputStream output = new ByteArrayOutputStream();
		ImageOutputStream imageOut = ImageIO.createImageOutputStream(output);
		ImageIO.write(image, "JPEG", imageOut);
		imageOut.close();
		ByteArrayInputStream input = new ByteArrayInputStream(output.toByteArray());
		output.close();
		return input;
	}

	@Override
	public String execute() throws Exception
	{
		setInputStream(createInputStream());
		return SUCCESS;
	}

	public ByteArrayInputStream getInputStream()
	{
		return inputStream;
	}

	public void setInputStream(ByteArrayInputStream inputStream)
	{
		this.inputStream = inputStream;
	}
}
