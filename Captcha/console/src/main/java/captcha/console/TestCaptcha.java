package captcha.console;


import cn.apiclub.captcha.Captcha;
import cn.apiclub.captcha.backgrounds.GradiatedBackgroundProducer;
import cn.apiclub.captcha.noise.StraightLineNoiseProducer;
import cn.apiclub.captcha.text.producer.FiveLetterFirstNameTextProducer;

import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestCaptcha {

    private final static Logger log = Logger.getLogger(TestCaptcha.class.getName());;

    public static Captcha createCaptcha(int width, int height){
        Captcha captcha = new Captcha.Builder(width, height)
                .addBackground(new GradiatedBackgroundProducer()) /*
                    * FlatColorBackground,
                    * GradiatedBackgroundProducer,
                    * SquigglesBackgroundProducer,
                    * TransparentBackgroundProducer
                    * */
                .addText(new FiveLetterFirstNameTextProducer())/*
                    * ArabicTextProducer
                    * NumbersAnswerProducer
                    * FiveLetterFirstNameTextProducer
                    * ChineseTextProducer
                    * DefaultTextProducer
                    * */
                .addNoise(new StraightLineNoiseProducer()) /*
                    * CurvedLineNoiseProducer
                    * StraightLineNoiseProducer
                    * */
                .build();
        log.info("Answer: " + captcha.getAnswer());
        return captcha;
    }

    public static void createImage(Captcha captcha) {
        try{
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write(captcha.getImage(), "png", os);

            String name = UUID.randomUUID().toString();
            log.info("Crated Image: " + name);
            FileOutputStream fos = new FileOutputStream("C:/Source/" + name + ".png");
            fos.write(os.toByteArray());
            fos.flush();
            fos.close();
        }
        catch (IOException ex){
            log.log(Level.SEVERE, ex.getMessage());
            ex.printStackTrace();
        }
    }

    public static void main(String[] args){
        Captcha captcha = createCaptcha(400, 160);
        createImage(captcha);
        System.out.println("MAIN => DONE");
    }
}
