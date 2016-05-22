package com.slogas.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.slogas.model.GasDAO;
import com.slogas.model.GasEntity;
import com.slogas.model.GasGetter;

@Service("gasService")
public class GasService {

	private GasGetter gasGet;
	private GasDAO gasDao;

	@Autowired
	public void setGasGetter(GasGetter gasGet) {
		this.gasGet = gasGet;
	}

	@Autowired
	public void setGasDAO(GasDAO gasDao) {
		this.gasDao = gasDao;
	}
	
	public GasEntity getCurrent(String st) {

		return gasGet.getData(st);
	}

	public String getCaption() {

		return gasGet.getCaptionString();
	}

	public List<GasEntity> getList(String startDate, String endDate) {

		List<GasEntity> temp = new ArrayList<GasEntity>();
		HtmlUnitDriver driver = gasGet.driverStarter();
		SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

		try {
			Date date1 = formatter.parse(startDate);
			Date date2 = formatter.parse(endDate);
			long dif = date2.getTime() - date1.getTime();
			dif = TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS);
			
			Calendar cal = new GregorianCalendar();
			cal.setTime(date1);
			for (int i = 0; i <= dif; i++) {
				temp.add(gasGet.instGetter(driver, formatter.format(cal.getTime())));
				cal.add(Calendar.DAY_OF_MONTH, 1);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		} catch (ParseException e) {

			e.printStackTrace();
		} finally {
			gasGet.driverCloser(driver);
		}

		return temp;
	}

	public List<GasEntity> getTen() {

		List<GasEntity> temp = new ArrayList<GasEntity>();
		HtmlUnitDriver driver = gasGet.driverStarter();
		SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

		Calendar to = new GregorianCalendar();
		to.add(Calendar.DAY_OF_MONTH, -10);
		for (int i = 0; i < 10; i++) {
			temp.add(gasGet.instGetter(driver, formatter.format(to.getTime())));
			to.add(Calendar.DAY_OF_MONTH, 1);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
		gasGet.driverCloser(driver);

		return temp;
	}

	public List<GasEntity> getRet(String startDate, String endDate) {
		
		String divS[] = startDate.split("\\.");
		String sd = divS[2] + "-" + divS[1] +"-" +divS[0];
		
		String divE[] = endDate.split("\\.");
		String ed = divE[2] + "-" + divE[1] +"-" +divE[0];
		
		gasDao.Results(sd, ed);

		return null;
	}

}
