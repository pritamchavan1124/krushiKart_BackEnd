package com.app.service.DeliveryBoy;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.DeliveryBoyDto;
import com.app.pojos.DeliveryBoy;
import com.app.pojos.Role;
import com.app.repositiory.IDeliveryBoyRepositary;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class DeliveryBoyServiceImpl implements IDeliveryBoyService {
	
	@Autowired
	private IDeliveryBoyRepositary deliveryBoyRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public List<DeliveryBoyDto> getAllDeliveryBoy() {
		log.info("In DeliveryBoy service implimentation : getAllDeliveryBoy ");
		List<DeliveryBoy> deliveryBoy = deliveryBoyRepo.findByUserRole(Role.ROLE_DELIVERYBOY);
		List<DeliveryBoyDto> listDB = new ArrayList<DeliveryBoyDto>();
		for (DeliveryBoy dboy : deliveryBoy) {
			listDB.add(mapper.map(dboy, DeliveryBoyDto.class));
		}
		return listDB;
	}

}
