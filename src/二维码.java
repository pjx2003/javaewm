package 草稿.习题;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class 二维码 {
    public static void main(String[] args) throws WriterException, IOException {
        //创建画者
        MultiFormatWriter mu = new MultiFormatWriter();

        //内容  类型  宽度  高度 其他信息
        String content = "夜幕有星星显得迷人，大海有涛声显得渊博，冬季有雪花倍感浪漫，亲人中有你我深感幸福！把最美好的祝福送给你，在这里祝你天天开心，加油，陌生人！";

        BarcodeFormat type = BarcodeFormat.QR_CODE;

        int width = 600;

        int height = 600;

        Map map = new HashMap();
        //处理中文编码
        map.put(EncodeHintType.CHARACTER_SET,"utf-8");
        //设置纠错等级(目前设置为高)
        map.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        //外边距留白
        map.put(EncodeHintType.MARGIN,2);

        //创建虚拟二维码对象(BitMatrix)
        BitMatrix encode = mu.encode(content,type,width,height,map);

        // I/O
        int black= Color.black.getRGB();
        int white=Color.white.getRGB();

        BufferedImage image=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);

        //画二维码
        for(int x=0;x<width;x++){
            for(int y=0;y<height;y++){
                image.setRGB(x,y,encode.get(x,y)? black:white);
            }
        }

        //图片.jpg  文件
        File file=new File("E:\\bbb\\ccc\\er.jpg");
        ImageIO.write(image,"jpg",file);
    }
}
