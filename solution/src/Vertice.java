import java.util.HashSet;
import java.util.Set;

public class Vertice {
	private String id;
	private String fullName;
	private Double latitude;
	private Double longitude;
	
	public Vertice(Double latitude, Double longitude, String id, String fullName){
		this.latitude = latitude;
		this.longitude = longitude;
		this.id = id;
		this.fullName = fullName;
	}

	public Vertice(String input) {
		String[] info = input.split(",");
		this.id = info[0].replace("StopArea:", "");
		this.fullName = info[1].replace("\"", "");
		this.latitude = Double.parseDouble(info[3]);
		this.longitude = Double.parseDouble(info[4]);
	}

	public Double getLongitude() {
		return longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public String getFullName() {
		return fullName;
	}

	public String getId() {
		return id;
	}
}