package pdf;

import com.openhtmltopdf.outputdevice.helper.BaseRendererBuilder;
import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;
import org.jsoup.Jsoup;
import org.jsoup.helper.W3CDom;
import org.jsoup.nodes.Document;

import java.io.*;
import java.nio.file.FileSystems;

public class HtmlToPDFOpenSource {
    public static void main(String[] args) throws IOException {
        HtmlToPDFOpenSource htmlToPDFOpenSource = new HtmlToPDFOpenSource();
        htmlToPDFOpenSource.generatePdfByOpenhtmltopdf();
    }

    private  void generatePdfByOpenhtmltopdf() throws IOException {
        File inputHtml = new File("E:\\javaNorth\\java-study-note\\javaOpenSource\\src\\main\\resources\\test.html");

        //加载html文件
        Document document = Jsoup.parse(inputHtml, "UTF-8");
        document.outputSettings().syntax(Document.OutputSettings.Syntax.html);

        //引入资源目录，可以单独引入css，图片文件等
        String baseUri = FileSystems.getDefault().getPath("javaOpenSource\\src\\main\\resources").toUri().toString();

        try (OutputStream os = new FileOutputStream("javaOpenSource\\src\\main\\resources\\testOpenLeagueoflegends1.pdf")) {
            PdfRendererBuilder builder = new PdfRendererBuilder();
            builder.withUri("javaOpenSource\\src\\main\\resources\\testOpenLeagueoflegends1.pdf");
            builder.toStream(os);
            builder.withW3cDocument(new W3CDom().fromJsoup(document), baseUri);

            //一引入自定义字体，注意字体名需要和css样式中指定的字体名相同
            builder.useFont(new File("javaOpenSource\\src\\main\\resources\\fonts\\msyh.ttf"),"msyh",1,BaseRendererBuilder.FontStyle.NORMAL, true);
            builder.run();
        }
    }
}


