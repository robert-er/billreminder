package com.billreminder.controller;

import com.billreminder.dto.BillDto;
import com.billreminder.mapper.BillMapper;
import com.billreminder.service.BillService;
import com.billreminder.service.exception.BillNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/bill")
@RequiredArgsConstructor
public class BillController {

    private final BillService billService;
    private final BillMapper billMapper;

    @PostMapping
    public Long createBill(@RequestBody BillDto billDto) {
        return billService.addNewBill(billMapper.mapToBill(billDto)).getId();
    }

    @GetMapping
    public List<BillDto> getAll() {
        return billMapper.mapToBillDtoList(billService.getAll());
    }

    @GetMapping({"id"})
    public BillDto getBill(@PathVariable Long id) {
        return billMapper.mapToBillDto(billService.findById(id).orElseThrow(BillNotFoundException::new));
    }

    @DeleteMapping({"id"})
    public void deleteBill(@PathVariable Long id) {
        billService.deleteById(id);
    }

    @PutMapping
    public BillDto updateBill(@RequestBody BillDto billDto) {
        return billService.findById(billDto.getId())
                .map(bill -> {
                    bill.setName(billDto.getName());
                    bill.setDescription(billDto.getDescription());
                    bill.setAmount(billDto.getAmount());
                    bill.setPaymentDate(billDto.getPaymentDate());
                    bill.setStatus(billDto.getStatus());
                    return billMapper.mapToBillDto(billService.save(bill));
                })
                .orElseThrow(BillNotFoundException::new);
    }
}
