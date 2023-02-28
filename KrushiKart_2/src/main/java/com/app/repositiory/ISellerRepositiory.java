package com.app.repositiory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.ProductSeller;
import com.app.pojos.SellerReg;

public interface ISellerRepositiory extends JpaRepository<SellerReg, Long>{

}
