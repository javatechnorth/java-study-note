package hutool.QRCode;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.Console;
import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.awt.*;

public class QRCodeTest {
    public static void main(String[] args) {
        QrCodeUtil.generate("http://www.itmind.net/",500,500, FileUtil.file("QRCODE1.jpg"));

        QrConfig config = new QrConfig(500, 500);
        config.setImg("java-coffe.png");
        config.setErrorCorrection(ErrorCorrectionLevel.Q);
        QrCodeUtil.generate("https://www.24kdh.com/",config, FileUtil.file("QRCODE2.jpg"));

        String decode = QrCodeUtil.decode(FileUtil.file("QRCODE1.jpg"));
        Console.log("decodeStr",decode);
    }
}
