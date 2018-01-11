package org.test.test;

import org.test.utils.QrcodeImage;

/**
 * @author Administrator
 * @description 测试二维码生成
 * 
 */
public class TestQrcode {

	public static void main(String[] args) {
		QrcodeImage.getQrcodeImg("http://www.baidu.com", "D:/a/" + System.currentTimeMillis() + ".png");
	}

}
