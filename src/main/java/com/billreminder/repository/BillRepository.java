package com.billreminder.repository;

import com.billreminder.domain.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface BillRepository extends JpaRepository<Bill, Long> {

    @Override
    <S extends Bill> S save(S bill);

    @Override
    void deleteById(Long id);

    @Override
    List<Bill> findAll();

    @Override
    Optional<Bill> findById(Long id);

    Optional<Bill> findByNameAndDescriptionAndAmountAfterAndPaymentDate(String name,
                                                                        String description,
                                                                        BigDecimal amount,
                                                                        LocalDate paymentDate);
}
