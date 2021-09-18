package ci.dmz.crawl.law;

public class LawParam {

	public static final String urlSearch = "http://www.law.go.kr/DRF/lawSearch.do";

	public static final String urlService = "https://www.law.go.kr/DRF/lawService.do";

	private final String OC = "dongworld";

	private final String type = "XML";

	public String getUrlSearch(String target) {
		String url = urlSearch + "?OC=" + OC + "&target=" + target + "&type=" + type + "&display=";
		return url;
	}

	public String getUrlService(String target) {
		String url = urlService + "?OC=" + OC + "&target=" + target + "&type=" + type + "&ID=";
		return url;
	}

}
