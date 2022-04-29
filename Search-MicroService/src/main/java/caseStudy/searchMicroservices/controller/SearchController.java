package caseStudy.searchMicroservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import caseStudy.searchMicroservices.entity.TrainDetails;
import caseStudy.searchMicroservices.service.AdminService;
import io.swagger.annotations.ApiOperation;

@CrossOrigin("*")
@Component
@RestController
@RequestMapping("/search")
public class SearchController 
{
	@Autowired
	private AdminService adminService;
	
	// This method finds the all trains in the database
	@GetMapping("/alltrains")
	@ApiOperation(value="Get all train details")
	public List<TrainDetails> getAllDetails()
	{
		return adminService.getAllDetails();
	}
	
	// This method gets status of booking by pnr no
	@GetMapping("/status/")
	@ApiOperation(value="Get status of your booking by Pnr Number")
	public String getStatus(@RequestParam long pnrNo)
	{
		return adminService.pnrStatus(pnrNo);
	}
	
	// This method finds the flight by flight no
	@GetMapping("/trainNo/")
	@ApiOperation(value="Get flight details by train Number")
	public TrainDetails getDetailsBytrainNo(@RequestParam int trainNo) 
	{
		return adminService.getDetailsByTrainNo(trainNo);
	}
	
	// This method find the flights by startpoint, endpoint and flightDate
	@GetMapping("/findBy/{startPoint}/{endPoint}/{flightDate}")
	@ApiOperation(value="Get Flight details by giving startPoint and endPoint locations and date")
	public TrainDetails[] getTrainDetailsByStartPointAndEndPointAndTrainDate(@PathVariable String startPoint,@PathVariable  String endPoint,@PathVariable String trainDate)
	{
		RestTemplate restTemplate=new RestTemplate();
		TrainDetails[] response=restTemplate.getForObject("http://localhost:8081/fare/findBy/"+startPoint +"/"+endPoint+"/"+trainDate,TrainDetails[].class);
		return response;
		
	}
}