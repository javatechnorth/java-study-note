package pdf;

import com.openhtmltopdf.outputdevice.helper.BaseRendererBuilder;
import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;
import org.jsoup.Jsoup;
import org.jsoup.helper.W3CDom;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.FileSystems;

public class HtmlToPDFOpenSource1 {
    public static void main(String[] args) throws IOException {
//
//
////        File inputHtml = new File("E:\\javaNorth\\作者_ 揽月中人 _ Java North.html");
////        File inputHtml = new File("E:\\javaNorth\\HTML to PDF Using OpenPDF _ Baeldung.html");
////        File inputHtml = new File("E:\\javaNorth\\The 8 Best Java Blogs for Programmers.html");
//        File inputHtml = new File("E:\\javaNorth\\java-study-note\\javaOpenSource\\src\\main\\resources\\test.html");
////        E:\javaNorth\java-study-note\javaOpenSource\src\main\resources\test.html
//        Document document = Jsoup.parse(inputHtml, "UTF-8");
//        document.outputSettings().syntax(Document.OutputSettings.Syntax.html);
//
//        File outputpdf = new File("testOpenLeagueoflegends.pdf");
////        try(OutputStream outputStream = new FileOutputStream(outputpdf)){
////
////            ITextRenderer render = new ITextRenderer();
////            SharedContext sharedContext = render.getSharedContext();
////            sharedContext.setPrint(true);
////            sharedContext.setInteractive(false);
////            render.setDocumentFromString(document.html());
//////            render.getFontResolver().addFont();
////            render.layout();
////            render.createPDF(outputStream);
////
////        }
//
////        File file = new File("test.pdf");
//        try (OutputStream os = new FileOutputStream(outputpdf)) {
//            PdfRendererBuilder builder = new PdfRendererBuilder();
//            builder.withUri("");
//            builder.toStream(os);
//            builder.withW3cDocument(new W3CDom().fromJsoup(document), "/");
////            builder.useFont()
//            builder.run();
//
//        }
        HtmlToPDFOpenSource1 htmlToPDFOpenSource = new HtmlToPDFOpenSource1();
        htmlToPDFOpenSource.generatePdfByOpenhtmltopdf();
    }

    private  void generatePdfByOpenhtmltopdf() throws IOException {

        File inputHtml = new File("E:\\javaNorth\\java-study-note\\javaOpenSource\\src\\main\\resources\\test.html");

        Document document = Jsoup.parse(inputHtml, "UTF-8");
        document.outputSettings().syntax(Document.OutputSettings.Syntax.html);


        String baseUri = FileSystems.getDefault().getPath("src\\main\\resources").toUri().toString();

        try (OutputStream os = new FileOutputStream("javaOpenSource\\src\\main\\resources\\testOpenLeagueoflegends1.pdf")) {
            PdfRendererBuilder builder = new PdfRendererBuilder();
            builder.withUri("javaOpenSource\\src\\main\\resources\\testOpenLeagueoflegends1.pdf");
            builder.toStream(os);
//            builder.withHtmlContent()
            builder.withW3cDocument(new W3CDom().fromJsoup(document), baseUri);
//            builder.useFont(new File (getClass().getClassLoader().getResource("fonts/msyh.ttf").getFile()),"msyh");
            builder.useFont(new File("javaOpenSource\\src\\main\\resources\\fonts\\msyh.ttf"),"msyh",1,BaseRendererBuilder.FontStyle.NORMAL, true);
//            builder.useFont(new FSSupplier<InputStream>() {
//                @Override
//                public InputStream supply() {
//                    try {
//                        return new FileInputStream("javaOpenSource\\src\\main\\resources\\fonts\\msyh.ttf");
//                    } catch (FileNotFoundException e) {
//                        e.printStackTrace();
//                    }
//                    return null;
//                }
//            },"msyh",10,BaseRendererBuilder.FontStyle.NORMAL,true);
            builder.run();

        }
    }
}


