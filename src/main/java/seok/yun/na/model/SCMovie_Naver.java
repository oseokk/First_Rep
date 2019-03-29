package seok.yun.na.model;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import seok.yun.na.dtos.MovieDto;

 
@Service
public class SCMovie_Naver {
    private static String clientID = "dxm1JDzr1mrKdLT2E2FR";
    private static String clientSecret = "jAHxzc6gaM";
 
    //display ==> 몇개 출력
    //start==>몇번쨰부터 (item)
    public String searchMovie(String movieNm){
       String img = null;
        try {
            URL url;
            
            url = new URL("https://openapi.naver.com/v1/search/"
                    + "movie.xml?query="
                    + URLEncoder.encode(movieNm, "UTF-8")
                    + "&display=1&start=1");
 
            URLConnection urlConn = url.openConnection();
            urlConn.setRequestProperty("X-Naver-Client-Id", clientID);
            urlConn.setRequestProperty("X-Naver-Client-Secret", clientSecret);
            
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = factory.newPullParser();
            parser.setInput(
                    new InputStreamReader(urlConn.getInputStream())); 
            
            
            
            int eventType = parser.getEventType();
            MovieDto b = null;
            while (eventType != XmlPullParser.END_DOCUMENT) {
                switch (eventType) {
                case XmlPullParser.END_DOCUMENT: // 문서의 끝
                    break;
                case XmlPullParser.START_DOCUMENT:
                    break;
                case XmlPullParser.END_TAG: {
                    String tag = parser.getName();
                }
                case XmlPullParser.START_TAG: {
                    String tag = parser.getName();
                    switch (tag) {
                    case "image":
                       img = parser.nextText();
                        break;

                    }
                    
                }
                }
                eventType = parser.next();
            }
            
            
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return img;
    }
 
}


