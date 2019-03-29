package seok.yun.na.model;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import seok.yun.na.dtos.MovieDto;
import seok.yun.na.dtos.SCMovieDto;

@Service
public class Dailybox_Kobis {

	@Autowired
	private SCMovie_Naver Nservice;

	// display ==> 몇개 출력
	// start==>몇번쨰부터 (item)
	 public List<MovieDto> searchMovie() throws ParserConfigurationException, SAXException{
         List<MovieDto> list = new ArrayList<MovieDto>();
         
         final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        Date date = cal.getTime();
        
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        String yesterday =  dateFormat.format(date);
         
         MovieDto b = null;
         try {
             URL url;
             url = new URL("http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.xml?"
                   +"key=2d1a872e5ba1c269e537b24681b21acb&"
                   +"targetDt="+yesterday);
             URLConnection urlConn = url.openConnection();
             
             DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
             DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
             Document doc = dBuilder.parse(urlConn.getInputStream());
             
             doc.getDocumentElement().normalize();
             System.out.println("Root element: " + doc.getDocumentElement().getNodeName()); 
            
            // 파싱할 tag
            NodeList nList = doc.getElementsByTagName("dailyBoxOffice");
            System.out.println("파싱할 리스트 수 : "+ nList.getLength());  // 파싱할 리스트 수 :  10
            
            for(int temp = 0; temp < nList.getLength(); temp++){      
               Node nNode = nList.item(temp);
               if(nNode.getNodeType() == Node.ELEMENT_NODE){
                              
                  Element eElement = (Element) nNode;
                  System.out.println("######################");
                  //System.out.println(eElement.getTextContent());
                  String rank = getTagValue("rank", eElement);
                  String moviecd = getTagValue("movieCd", eElement);
                  String movieNm =  getTagValue("movieNm", eElement);
                  String openDt = getTagValue("openDt", eElement);
                  String audicnt = getTagValue("audiCnt", eElement);
                  String img = Nservice.searchMovie(movieNm);
                        
                  System.out.println("rank  : " + getTagValue("rank", eElement));
                  System.out.println("movieCd  : " + getTagValue("movieCd", eElement));
                  System.out.println("movieNm : " + getTagValue("movieNm", eElement));
                  
                  System.out.println("openDt  : " + getTagValue("openDt", eElement));
                  System.out.println("audiCnt  : " +getTagValue("audiCnt", eElement));
                  System.out.println("img : " + Nservice.searchMovie(movieNm));
                  MovieDto MDto = new MovieDto();
                  MDto.setRank(rank);
                  MDto.setMoviecd(moviecd);
                  MDto.setMovieNm(movieNm);
                  MDto.setImage(img);
                  MDto.setOpenDt(openDt);
                  MDto.setAudicnt(audicnt);
                  
                  list.add(MDto);
                  
               }   // for end
               try {
				Thread.sleep(150);
			} catch (Exception e) {
			//	e.printStackTrace(null);
			}
            }   // if end
            
            
            
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }
    

    // tag값의 정보를 가져오는 메소드
   private static String getTagValue(String tag, Element eElement) {
       NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
       Node nValue = (Node) nlList.item(0);
       if(nValue == null) 
           return null;
       return nValue.getNodeValue();
   }
}