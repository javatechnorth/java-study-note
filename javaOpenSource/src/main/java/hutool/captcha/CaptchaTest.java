package hutool.captcha;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.GifCaptcha;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.captcha.ShearCaptcha;
import cn.hutool.captcha.generator.RandomGenerator;
import cn.hutool.core.lang.Console;

public class CaptchaTest {
    public static void main(String[] args) {

        CaptchaUtil.createLineCaptcha(300, 100,6,100).write("lineCaptcha1.png");

        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(300, 100,6,100);
        RandomGenerator randomGenerator = new RandomGenerator("0123456789", 6);
        lineCaptcha.setGenerator(randomGenerator);
        String lineCaptchaCode = lineCaptcha.getCode();
        Console.log("lineCaptchaCode",lineCaptchaCode);
        lineCaptcha.write("lineCaptcha.png");


        GifCaptcha gifCaptcha = CaptchaUtil.createGifCaptcha(500, 200, 8);
        gifCaptcha.write("gifCaptcha.gif");
        String gifCaptchaCode = gifCaptcha.getCode();
        Console.log("gifCaptchaCode", gifCaptchaCode);

        ShearCaptcha shearCaptcha = CaptchaUtil.createShearCaptcha(500, 200, 6, 20);
        shearCaptcha.write("shearCaptcha.png");
        String shearCaptchaCode = shearCaptcha.getCode();
        Console.log("shearCaptchaCode", shearCaptchaCode);


    }
}
