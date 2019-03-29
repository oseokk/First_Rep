package seok.yun.na.model;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
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

@Service
public class DetailMovie_Kobis {

	@Autowired
	private SCMovie_Naver Nservice;

	// display ==> 몇개 출력
	// start==>몇번쨰부터 (item)
	public List<MovieDto> searchMovie(String moviecd) throws IOException, ParserConfigurationException, SAXException {
		List<MovieDto> list = new ArrayList<MovieDto>();
			URL url= new URL("http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.xml?"
                    +"key=8bebf4fe17875a37f2792e607077fcf0&"
                    +"movieCd="+moviecd);
			URLConnection urlConn = url.openConnection();
			DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
            Document doc = dBuilder.parse(urlConn.getInputStream());
            doc.getDocumentElement().normalize();
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
            NodeList NList = doc.getElementsByTagName("movieInfo");
            Node node = NList.item(0);
            Element element = (Element) node;
            String movieNm =  getTagValue("movieNm", element);
            String movieCd =  getTagValue("movieCd", element);
            String img = Nservice.searchMovie(movieNm);
            String movieNmEn =  getTagValue("movieNmEn", element);
            String showTm = getTagValue("showTm", element);
            String prdtYear = getTagValue("prdtYear", element);
            String openDt = getTagValue("openDt", element);
            MovieDto MDto = new MovieDto();
            MDto.setMovieNm(movieNm);
            MDto.setMoviecd(movieCd);
            MDto.setImage(img);
            MDto.setMovieNmEn(movieNmEn);
            MDto.setShowTm(showTm);
            MDto.setPrdtYear(prdtYear);
            MDto.setOpenDt(openDt);
            
            list.add(MDto);
            //list.add(MDto);
		
		return list;
	}

	// tag값의 정보를 가져오는 메소드
	private static String getTagValue(String tag, Element eElement) {
		NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
		Node nValue = (Node) nlList.item(0);
		if (nValue == null)
			return null;
		return nValue.getNodeValue();
	}
}