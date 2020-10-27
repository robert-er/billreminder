package com.billreminder.service;

import com.billreminder.domain.Bill;
import com.billreminder.repository.BillRepository;
import com.billreminder.service.exception.BillExistException;
import com.billreminder.service.exception.BillNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BillService {

    private final BillRepository billRepository;

    public Bill save(Bill bill) {
        return billRepository.save(bill);
    }

    public Bill addNewBill(Bill bill) throws BillExistException {
        if (billRepository
                .findByNameAndDescriptionAndAmountAfterAndPaymentDate(bill.getName(),
                        bill.getDescription(),
                        bill.getAmount(),
                        bill.getPaymentDate())
                .isPresent()) {
            throw new BillExistException();
        }
        return save(bill);
    }

    public void deleteById(Long id) throws BillNotFoundException {
        if (findById(id).isPresent()) {
            billRepository.deleteById(id);
        } else {
            throw new BillNotFoundException();
        }
    }

    public List<Bill> getAll() {
        return billRepository.findAll();
    }

    public Optional<Bill> findById(Long id) {
        return billRepository.findById(id);
    }
}
