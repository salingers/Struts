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

	// 產生四個0~9的隨機數，放在一個字串裡
	public String createRandomString()
	{
		String str = "";
		for (int i = 0; i < 4; i++)
		{
			str += Integer.toString((new Double(Math.random() * 10)).intValue());
		}
		return str;
	}

	// 隨機產生一個彩色
	public Color createsRandomColor()
	{
		int r = (new Double(Math.random() * 256)).intValue();
		int g = (new Double(Math.random() * 256)).intValue();
		int b = (new Double(Math.random() * 256)).intValue();
		return new Color(r, g, b);
	}

	// 產生一個記憶體圖片，將四個隨機數寫在圖片上
	public BufferedImage createImage(String str)
	{
		int width = 60;
		int height = 22;
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		// 取得圖形上下文
		Graphics g = image.getGraphics();
		// 設定背景色
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);
		// 畫邊框
		g.setColor(Color.black);
		g.drawRect(0, 0, width - 1, height - 1);
		// 將認證碼顯示到圖象中
		g.setFont(new Font("Atlantic Inline", Font.PLAIN, 18));
		// 使用隨機彩色
		g.setColor(this.createsRandomColor());
		// 將隨機字串的每個數字分別寫到圖片上
		g.drawString(Character.toString(str.charAt(0)), 8, 17);
		g.drawString(Character.toString(str.charAt(1)), 20, 17);
		g.drawString(Character.toString(str.charAt(2)), 33, 17);
		g.drawString(Character.toString(str.charAt(3)), 45, 17);
		// 圖象生效
		g.dispose();
		return image;
	}

	// 將圖片的以位元組形式寫到InputStream裡
	public ByteArrayInputStream createInputStream() throws Exception
	{
		// 取得隨機字串
		String str = this.createRandomString();
		BufferedImage image = this.createImage(str);
		// 將產生的字串寫入session，供驗證時使用

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
