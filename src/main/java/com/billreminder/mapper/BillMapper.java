package com.billreminder.mapper;

import com.billreminder.domain.Bill;
import com.billreminder.dto.BillDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BillMapper {

    public Bill mapToBill(BillDto billDto) {
        Bill bill = new Bill();
        bill.setName(billDto.getName());
        bill.setDescription(billDto.getDescription());
        bill.setAmount(billDto.getAmount());
        bill.setPaymentDate(billDto.getPaymentDate());
        bill.setStatus(billDto.getStatus());
        return bill;
    }

    public BillDto mapToBillDto(Bill bill) {
        return new BillDto(bill.getName(),
                bill.getDescription(),
                bill.getAmount(),
                bill.getPaymentDate(),
                bill.getStatus());
    }

    public List<BillDto> mapToBillDtoList(List<Bill> billList) {
        return billList.stream()
                .map(this::mapToBillDto)
                .collect(Collectors.toList());
    }
}
