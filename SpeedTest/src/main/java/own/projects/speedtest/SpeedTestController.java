package own.projects.speedtest;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.bmartel.speedtest.SpeedTestReport;
import fr.bmartel.speedtest.SpeedTestSocket;
import fr.bmartel.speedtest.inter.ISpeedTestListener;
import fr.bmartel.speedtest.model.SpeedTestError;

@Controller
public class SpeedTestController implements ISpeedTestListener {
	private SpeedTestSocket speedTestSocket;
	private BigDecimal speed;

	
	@GetMapping("/downloadSpeed")
	public String getDownloadSpeed(HttpServletRequest request, Model model) {
		speedTestSocket.startDownload("https://www.eurofound.europa.eu/sites/default/files/ef_publication/field_ef_document/ef1710en.pdf");
		
		model.addAttribute("speed", this.getSpeed().floatValue()/(1024*1024)+"Mbps");
		return "home.jsp";
	}
	
	@GetMapping("/uploadSpeed")
	public String getUploadSpeed(HttpServletRequest request, Model model) {
		speedTestSocket.startUpload("https://www.eurofound.europa.eu/sites/default/files/ef_publication/field_ef_document/ef1710en.pdf", 1000000);

		model.addAttribute("speed", this.getSpeed().floatValue()/(1024*1024)+"Mbps");
		return "home.jsp";
	}
	
	@GetMapping("/home")
	public String anyMethod() {
		return "home";
	}
	public SpeedTestSocket getSpeedTestSocket() {
		return speedTestSocket;
	}

	public void setSpeedTestSocket(SpeedTestSocket speedTestSocket) {
		this.speedTestSocket = speedTestSocket;
	}

	public BigDecimal getSpeed() {
		return speed;
	}

	public void setSpeed(BigDecimal speed) {
		this.speed = speed;
	}

	SpeedTestController() {
		this.speedTestSocket = new SpeedTestSocket();
		speedTestSocket.addSpeedTestListener(this);
	}

	@Override
	public void onCompletion(SpeedTestReport report) {
		this.setSpeed(report.getTransferRateBit());
		System.out.println("[COMPLETED] rate in bit/s   : " + report.getTransferRateBit());
	}

	@Override
	public void onError(SpeedTestError speedTestError, String errorMessage) {
	}

	@Override
	public void onProgress(float percent, SpeedTestReport report) {
	}

}
