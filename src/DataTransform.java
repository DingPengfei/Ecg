import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Administrator on 2017-4-19.
 */
public class DataTransform {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("E:/心电研究/心电与心情/数据采集/20170418/2017-04-18_11_38_46_张启飞_恐惧.hly_1.dat");
        FileOutputStream fos = new FileOutputStream("E:/心电研究/心电与心情/数据采集/20170418/2017-04-18_11_38_46_张启飞_恐惧.hly_1.txt");
        byte[] buffer = new byte[4];

        while (fis.read(buffer)!=-1) {
            String str = String.valueOf(getFloat(buffer))+'\n';
            fos.write(str.getBytes());
        }

        fis.close();
        fos.close();

    }

    public static float getFloat(byte[] b) {
        // 4 bytes
        int accum = 0;
        for ( int shiftBy = 0; shiftBy < 4; shiftBy++ ) {
            accum |= (b[shiftBy] & 0xff) << shiftBy * 8;
        }
        return Float.intBitsToFloat(accum);
    }
}