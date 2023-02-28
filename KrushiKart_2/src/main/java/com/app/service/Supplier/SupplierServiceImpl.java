package com.app.service.Supplier;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.SellerDto;
import com.app.pojos.Role;
import com.app.pojos.SellerReg;
import com.app.repositiory.ISellerRepositiory;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class SupplierServiceImpl implements ISupplierService {
	
	@Autowired
	private ISellerRepositiory sellerRepo;
	
	@Autowired
	private ModelMapper mapper;
	@Override
	public SellerDto saveSupplier( SellerDto sellerobj) {
		log.info("In Supplier service implimentation : Save supplier ");
		
		SellerReg seller = mapper.map(sellerobj, SellerReg.class);
		//supplier.setPassword(encoder.encode(supplier.getPassword()));
		SellerReg persistent = sellerRepo.save(seller);

		// map entity --> dto
		return mapper.map(persistent, SellerDto.class);
		
	}
	@Override
	public List<SellerDto> getAllSelles() {
		log.info("In Supplier service implimentation : getAllSupplier ");
		List<SellerReg> sellerList = sellerRepo.findByUserRole(Role.ROLE_SELLER);
		List<SellerDto> seller = new ArrayList<>();
		for (SellerReg sell : sellerList) {
			seller.add(mapper.map(sell, SellerDto.class));
		}
		return seller;
	}
	

}
