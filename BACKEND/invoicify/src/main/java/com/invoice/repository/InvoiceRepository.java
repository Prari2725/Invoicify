package com.invoice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.invoice.entity.Invoice;
import com.invoice.entity.User;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    List<Invoice> findByUser(User user);
    boolean existsByInvoiceId(String invoiceId);
} 