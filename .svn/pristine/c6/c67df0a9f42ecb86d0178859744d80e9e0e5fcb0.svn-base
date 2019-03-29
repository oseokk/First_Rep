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
import seok.yun.na.dtos.SCMovieDto;

@Service
public class SCMovie_Kobis {

	@Autowired
	private SCMovie_Naver Nservice;

	// display ==> 몇개 출력
	// start==>몇번쨰부터 (item)
	public List<SCMovieDto> searchMovie(List<SCMovieDto> lists) throws IOException, ParserConfigurationException, SAXException {
		List<SCMovieDto> list = new ArrayList<SCMovieDto>();
		//8bebf4fe17875a37f2792e607077fcf0
		for(int i = 0; i<lists.size(); i++) {
			URL url= new URL("http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.xml?"
                    +"key=430156241533f1d058c603178cc3ca0e"
                    +"&movieCd="+lists.get(i).getMoviecd());
			URLConnection urlConn = url.openConnection();
			DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
            Document doc = dBuilder.parse(urlConn.getInputStream());
            doc.getDocumentElement().normalize();
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
            NodeList NList = doc.getElementsByTagName("movieInfo");
            Node node = NList.item(0);
            Element element = (Element) node;
            String moviecd = lists.get(i).getMoviecd();
            String movieNm =  getTagValue("movieNm", element);
            String img = Nservice.searchMovie(movieNm);
            SCMovieDto MDto = new SCMovieDto();
            MDto.setMoviecd(moviecd);
            MDto.setMovieNm(movieNm);
            MDto.setImage(img);
            list.add(i, MDto);
		}
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